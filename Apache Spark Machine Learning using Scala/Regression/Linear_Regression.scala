import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

def main(): Unit = {
  // Get or Create Spark session
  val spark = SparkSession.builder().appName("LinearRegressionExample").getOrCreate()
  // Path of dataset
  val path = "sample_linear_regression_data.txt"
  // Training Data
  val training = spark.read.format("libsvm").load(path)
  training.printSchema()

  // Create Linear Regression Object
  val lr = new LinearRegression().setMaxIter(100).setRegParam(0.3).setElasticNetParam(0.8)

  // Fit the Model
  val lrModel = lr.fit(training)

  // Print coefficients and intercept for Linear regression
  println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

  // Summarize the model over training set and print out some metrics
  val trainingSummary = lrModel.summary
  println(s"numIterations: ${trainingSummary.totalIterations}")
  println(s"objectiveHitory: ${trainingSummary.objectiveHistory.toList}")
  // Residuals: Difference betwee Predicted and Actual Value (y - y^)
  trainingSummary.residuals.show()

  // Root Mean Square Error:  sqrt((1/n)*summation((y-y^)^2)) 
  println(s"RootMeanSquareError: ${trainingSummary.rootMeanSquaredError}")
  println(s"R^2 Vallue: ${trainingSummary.r2}")
  spark.stop()
}

main()
