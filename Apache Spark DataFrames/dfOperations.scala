import org.apache.spark.sql.SparkSession

// Get current Spark Session or Create a new Spark Session
val spark = SparkSession.builder().getOrCreate()

// Create a dataframe from a .csv input file
// option("header","true"): Treats very first column as header
// option("inferSchema","true"): Prints the actual datatype of each column data
val df = spark.read.option("header","true").option("inferSchema","true").csv("CitiGroup2006_2008")

df.printSchema()

// Filtering data
import spark.implicits._

// Filter the values according to Condition
// Only shows thee rows with Close value > 480.
df.filter($"Close" > 480).show()

// In SQL
df.filter("Close > 480").show()

// Filtering using Multiple Columns
df.filter($"Close" < 480 && $"High" < 480).show()

// SQL Syntax
df.filter($"Close < 480 AND High < 480").show()

// To collect the data
// Returns array instead of Dataframe
val CH_low = df.filter($"Close" < 480 && $"High" < 480).collect()

// Returns a count of how many results/rows are returned
val CH_low = df.filter($"Close" < 480 && $"High" < 480).count()

// Filter for equality
df.filter($"High" === 484.40).show()

// In SQL
df.filter($"High = 484.40").show()


// Pearson Correlation
// Correlation: comparison
df.select(corr("High","Low")).show()
df.select(corr(df("High"),df("Low"))).show()
