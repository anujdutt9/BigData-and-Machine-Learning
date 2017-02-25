import org.apache.spark.sql.SparkSession
import spark.implicits._

// Get current Spark Session or Create a new Spark Session
val spark = SparkSession.builder().getOrCreate()

// Create a dataframe from a .csv input file
// option("header","true"): Treats very first column as header
// option("inferSchema","true"): Prints the actual datatype of each column data
val df = spark.read.option("header","true").option("inferSchema","true").csv("Netflix_2011_2016.csv")

// Q1: What are column names ?
df.columns

// Q2: What des the Schema Look Like ?
df.printSchema()

// Q3. Print out first 5 rows
df.show(0)              // Print first 5 columns
df.show(5)              //Print first 5 rows

// Q4. Use describe to learn about a dataframe
df.describe().show()      // Returns the mean, median, sd

// Create a new dataframe with column HV ratio
val df2 = df.withColumn("HV Ratio",df("High")/df("Volume"))
df2.show(5)

// Q5. What day had Peak High in Price ?
df.orderBy($"High".desc).show(1)

// Q6. Mean of close column
df.select(mean("Close")).show()

// Q7. Find max and min of Volume column.
df.select(max("Volume")).show()
df.select(min("Volume")).show()

// Q8. How mny days was Close lower than $600
df.filter($"Close" < 600).count()

// Q9.What percentage of time High was > $500
Multiply the High count by 1.0 as it is divided by a double(float)
(df.filter($"High" > 500).count()*1.0 / df.count()) * 100

// Q10. What is the correlation between High and Volume ?
df.select(corr("High","Volume")).show()

// Q11. What is Max High per Year ?
val yeardf = df.withColumn("Year",year(df("Date")))
val yearmax = yeardf.select($"Year",$"High").groupBy("Year").max()
yearmax.select($"Year",$"max(High)").orderBy($"Year".desc).show()

// Q12. What is average close for each month
val monthdf = df.withColumn("Month",month(df("Date")))
val monthavg = monthdf.select($"Month",$"Close").groupBy("Month").mean()
monthavg.select($"Month",$"avg(Close)").orderBy("Month").show()
