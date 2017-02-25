//LISTS
// Lists are an immutable sequence of elements (singly linked list)

// Basic List of Numbers
val evens = List(2,4,6,8,10,12)
// evens: List[Int] = List(2, 4, 6, 8, 10, 12)

// Indexing Items (Starts at zero)
evens(0)
// res0: Int = 2

evens(1)
// res1: Int = 4

// Head and Tail
evens.head
// res3: Int = 2

evens.tail
// res4: List[Int] = List(4, 6, 8, 10, 12)

evens
// res5: List[Int] = List(2, 4, 6, 8, 10, 12)

// Element Types

//Any
val my_list = List("a",2,true)
// my_list: List[Any] = List(a, 2, true)

// Nested
val my_list = List(List(1,2,3),List(4,5,6))
// my_list: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))

// Double and Int
val my_list = List(1,2,3.0)
// my_list: List[Double] = List(1.0, 2.0, 3.0)

// List of Tuple Pairs
val my_list = List(("a",1),("b",2),("c",3))
// my_list: List[(String, Int)] = List((a,1), (b,2), (c,3))

// List Operations
val my_list = List(3,6,1,7,10)
// my_list: List[Int] = List(3, 6, 1, 7, 10)

my_list.sorted
// res7: List[Int] = List(1, 3, 6, 7, 10)

my_list.size
// res8: Int = 5

my_list.max
// res9: Int = 10

my_list.min
// res39: Int = 1

my_list.sum
// res40: Int = 27

my_list.product
// res41: Int = 1260

// Using drop for slicing:
val x = List(1,2,3,4)
// x: List[Int] = List(1, 2, 3, 4)

x.drop(2)
// res3: List[Int] = List(3, 4)

x.takeRight(3)
// res4: List[Int] = List(2, 3, 4)
// Use Tab to explore the other methods!
