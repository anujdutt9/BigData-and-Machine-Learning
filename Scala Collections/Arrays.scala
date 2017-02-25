// ARRAYS
// Collection of variables

// Examples
val arr = Array(1,2,3)
// arr: Array[Int] = Array(1, 2, 3)

val arr = Array("a","b","c")
// arr: Array[String] = Array(a, b, c)

// Range
// Use of range() method to generate an array containing
// a sequence of increasing integers in a given range.
Array.range(0,10)
// res64: Array[Int] = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

Array.range(0,10,2)
// res65: Array[Int] = Array(0, 2, 4, 6, 8)

// Or just call Range with a capital R
Range(0,5)
// res1: scala.collection.immutable.Range = Range(0, 1, 2, 3, 4)

Range(0,10,2)
// res2: scala.collection.immutable.Range = Range(0, 2, 4, 6, 8)
