// TUPLES

// An ordered sequence of values
// Can be of multiple data types
val my_tup = (1,2,"hello",23.2,true)
// my_tup: (Int, Int, String, Double, Boolean) = (1,2,hello,23.2,true)

// Can also be nested:
(3,1,(2,3))
// res46: (Int, Int, (Int, Int)) = (3,1,(2,3))

// Accessing elements with ._n notation
// Indexing starts at 1
val greeting = my_tup._3
// greeting: String = hello

my_tup._1
// res37: Int = 1
