// 1.) Can you figure out what method you can use to find out if the list:
// List(1,2,3,4,5) contains the number 3?

val li = List(1,2,3,4,5)
// li: List[Int] = List(1, 2, 3, 4, 5)
li.contains(3)
// res42: Boolean = true

// 2.) How can you add all the elements of the previous list?
li.sum
// res43: Int = 15

// 3.) Create an Array of all the odd numbers from 0 to 15
val odds = Array.range(1,15,2)
// odds: Array[Int] = Array(1, 3, 5, 7, 9, 11, 13)

// 4.) What are the unique elements in the list: List(2,3,1,4,5,6,6,1,2)?

val mylist = List(2,3,1,4,5,6,6,1,2)
// mylist: List[Int] = List(2, 3, 1, 4, 5, 6, 6, 1, 2)
mylist.toSet
// res68: scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)

// 5.) Create a mutable map that maps together Names to Ages.
// It should have the following key value pairs:
// Sammy, 3
// Frankie, 7
// John, 45

val names = collection.mutable.Map(("Sammy",3),("Frankie",7),("John",45))
// names: scala.collection.mutable.Map[String,Int] = Map(Sammy -> 3, Frankie -> 7, John -> 45)


// 5a) Print out all the keys
names.keys
// res44: Iterable[String] = Set(Sammy, Frankie, John)

// 5b) Add the key value pair ("Mike",27)
names += ("Mike"->27)
// res46: names.type = Map(Sammy -> 3, Mike -> 27, Frankie -> 7, John -> 45)
