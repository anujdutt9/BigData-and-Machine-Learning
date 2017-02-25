// Import Evaluator
import org.apache.spark.ml.evaluation.RegressionEvaluator

// Import ML Model
import org.apache.spark.ml.regression.LinearRegression

// Import Tuning Objects
import org.apache.spark.ml.tuning.{ParamGridBuilder, TrainValidationSplit}

// Read input data
val data = spark.read.format("libsvm").load("sample_linear_regression_data.txt")

// Prepare training and testing data
val Array(training, testing) = data.randomSplit(Array(0.9,0.1), seed = 12345)
// data.printSchema

// Define ML Model
val lr = new LinearRegression()

// Form the Holdout Dataset
// Build the grid with different parameters for Linear Regression Model
val paramGrid = (new ParamGridBuilder().addGrid(lr.regParam,Array(0.1,0.01,1)).addGrid(lr.fitIntercept)
                .addGrid(lr.elasticNetParam,Array(0.0,0.5,1.0)).build())

// Do the train validation split
// Set the Estimator: the ML model
// set the Evaluator: must match the type of estimator
// Pass the grids created above in mapping
// Set the training dataset ratio
val trainValidationSplit = (new TrainValidationSplit().setEstimator(lr).setEvaluator(new RegressionEvaluator())
                           .setEstimatorParamMaps(paramGrid).setTrainRatio(0.8))

// Fit the Model
val model = trainValidationSplit.fit(training)

// Print out the predictions of the model
model.transform(testing).select("features","label","prediction").show()
