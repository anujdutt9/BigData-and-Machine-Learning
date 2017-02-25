import org.apache.spark.sql.SparkSession

// Get current Spark Session or Create a new Spark Session
val spark = SparkSession.builder().getOrCreate()

// Create a dataframe from a .csv input file
// option("header","true"): Treats very first column as header
// option("inferSchema","true"): Prints the actual datatype of each column data
val df = spark.read.option("header","true").option("inferSchema","true").csv("Sales.csv")

df.printSchema()
df.show()

df.groupBy("Company").mean().show()

df.groupBy("Company").max().show()
df.groupBy("Company").min().show()
df.groupBy("Company").sum().show()
df.select(sum("Sales")).show()

df.select(countDistinct("Sales")).show()        // Total number of sales
df.select(sumDistinct("Sales")).show()          // Sum of all sales
df.select(stddev("Sales")).show()               // Standard Deviation
df.select(collect_set("Sales")).show()
df.select(avg("Sales")).show()                  // Returns Average Sales

// Returns sales column as sorted; by default it is in ascending order
df.orderBy("Sales").show()

// Returns sales column in descending order sorting.
df.orderBy($"Sales".desc).show()
