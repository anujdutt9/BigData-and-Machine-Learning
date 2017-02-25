import org.apache.spark.sql.SparkSession

// Get current Spark Session or Create a new Spark Session
val spark = SparkSession.builder().getOrCreate()

// Create a dataframe from a .csv input file
// option("header","true"): Treats very first column as header
// option("inferSchema","true"): Prints the actual datatype of each column data
val df = spark.read.option("header","true").option("inferSchema","true").csv("ContainsNull.csv")

// df.printSchema()
// df.show()
// df.na.drop(2).show()          // drops the rows with null values
// df.na.fill(100).show()          // Fills NUll vlues with 100 at places that match the type of data
val df2 = df.na.fill(400.5,Array("Sales"))   // Fill data into a paticular column
df2.na.fill("New Name",Array("Name")).show()   // Fill data into a paticular column
