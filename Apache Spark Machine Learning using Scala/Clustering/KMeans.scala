import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.log4j._

Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.format("libsvm").load("sample_kmeans_data.txt")

val kmeans = new KMeans().setK(2).setSeed(1L)

val model = kmeans.fit(data)

val WSSE = model.computeCost(data)
println(s"Within Set Sum Of Squared Errors: $WSSE")

println("Cluster Centers")
model.clusterCenters.foreach(println)
