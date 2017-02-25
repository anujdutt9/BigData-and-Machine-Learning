import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics

Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()
val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("titanic.csv")

data.printSchema
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(n <- Range(1,colnames.length))
{
  println(colnames(n))
  println(firstrow(n))
  println("\n")
}

val logregdataall = (data.select(data("Survived").as("label"),
                       $"Pclass", $"Name", $"Sex", $"Age", $"SibSp",
                       $"Parch", $"Ticket", $"Fare", $"Embarked"))
val logregdata = logregdataall.na.drop()

// import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
// import org.apache.spark.ml.linalg.Vectors

// Converting strings to numerical values
val genderIndexer = new StringIndexer().setInputCol("Sex").setOutputCol("SexIndex")
val embarkIndexer = new StringIndexer().setInputCol("Embarked").setOutputCol("EmbarkedIndex")

// Converting numerical values from aabove to 0's and 1's using one-hot encoding
val genderEncoder = new OneHotEncoder().setInputCol("SexIndex").setOutputCol("SexVector")
val embarkEncoder = new OneHotEncoder().setInputCol("EmbarkedIndex").setOutputCol("EmbarkVector")

val assembler = (new VectorAssembler()
                .setInputCols(Array("Pclass", "SexVector", "Age", "SibSp", "Parch", "Fare", "EmbarkVector"))
                .setOutputCol("features"))

// Split data into training and testing set
// Taking 70% data as training and rest as testing data
val Array(training,testing) = logregdata.randomSplit(Array(0.9,0.1), seed = 20)


// Create a Pipeline
// MLlib represents a workflow of running a sequence of algorithms to process and learn from data as a Pipeline,
// which consists of a sequence of PipelineStages (Transformers and Estimators) to be run in a specific order.
// import org.apache.spark.ml.Pipeline

val lr = new LogisticRegression()
val pipeline = (new Pipeline().setStages(Array(genderIndexer, embarkIndexer, genderEncoder, embarkEncoder, assembler, lr)))
val model = pipeline.fit(training)
val results = model.transform(testing)
println("\n")
results.printSchema

// MODEL EVALUATION
// import org.apache.spark.mllib.evaluation.MulticlassMetrics

val predictionAndLabels = results.select($"prediction",$"label").as[(Double,Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)
println("Confusion Matrix:")
println(metrics.confusionMatrix)
println("\n")
println("Accuracy:")
println(metrics.accuracy)
