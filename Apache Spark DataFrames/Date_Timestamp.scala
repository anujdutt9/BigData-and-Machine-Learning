import org.apache.spark.sql.SparkSession

// Get current Spark Session or Create a new Spark Session
val spark = SparkSession.builder().getOrCreate()

// Create a dataframe from a .csv input file
// option("header","true"): Treats very first column as header
// option("inferSchema","true"): Prints the actual datatype of each column data
val df = spark.read.option("header","true").option("inferSchema","true").csv("CitiGroup2006_2008")

// df.printSchema()
// df.head()

// Print only Month from given dates
// df.select(month(df("Date"))).show()

// Print only Year from given dates
// df.select(year(df("Date"))).show()

// Returns Average of values each year
// val df2 = df.withColumn("Year",year(df("Date")))
// val date_avg = df2.groupBy("Year").mean()
// date_avg.select($"Year",$"avg(Close)").show()

// Returns Minimum closing values each year
val df2 = df.withColumn("Year",year(df("Date")))
val date_min = df2.groupBy("Year").min()
date_min.select($"Year",$"min(Close)").show()
