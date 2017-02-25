// SETS
// Set is a collection that contains no duplicate elements.
// There are two kinds of Sets, the immutable and the mutable.

val s = Set()
// s: scala.collection.immutable.Set[Nothing] = Set()

val s = Set(1,2,3)
// s: scala.collection.immutable.Set[Int] = Set(1, 2, 3)

val s = Set(1,1,2,2,2,3,3,3)
// s: scala.collection.immutable.Set[Int] = Set(1, 2, 3)

// Mutable Sets
val s = collection.mutable.Set(1,2,3)
// s: scala.collection.mutable.Set[Int] = Set(1, 2, 3)

s += 4
// res50: s.type = Set(1, 2, 3, 4)

s
// res51: scala.collection.mutable.Set[Int] = Set(1, 2, 3, 4)

s.add(5)
// res52: Boolean = true

s
// res53: scala.collection.mutable.Set[Int] = Set(1, 5, 2, 3, 4)

// Set Operations
s.max
// res54: Int = 5

s.min
// res55: Int = 1

// Cast to Set
val mylist = List(1,2,3,1,2,3)
// mylist: List[Int] = List(1, 2, 3, 1, 2, 3)

mylist.toSet
// res59: scala.collection.immutable.Set[Int] = Set(1, 2, 3)
