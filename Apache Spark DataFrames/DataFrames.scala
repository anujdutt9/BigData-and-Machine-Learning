import org.apache.spark.sql.SparkSession

// Get current Spark Session or Create a new Spark Session
val spark = SparkSession.builder().getOrCreate()

// Create a dataframe from a .csv input file
// option("header","true"): Treats very first column as header
// option("inferSchema","true"): Prints the actual datatype of each column data
val df = spark.read.option("header","true").option("inferSchema","true").csv("CitiGroup2006_2008")

// Show first five rows of data
df.show(5)

for(row <- df.head(5))
{
  println(row)
}

// Return Names of all Columns
/
// Count, Mean, SD, Min, Max values of all data in dataframe
df.describe().show()

// Select a particular column
df.select("Volume").show()

// TO select multiple columns
df.select($"Date",$"Close").show()


// To create a new column using old columns
// Adds values of high and low columns and adds to new column
val df2 = df.withColumn("HighPlusLow",df("High")+df("Low"))
df2.show(5)


// Rename a column
df2.select(df2("HighPlusLow").as("HPL"),df2("Close"))
df2.show(5)
