// MAPS
// (Key,Value) Pair Storage aka Hash Table or Dictionary

val mymap = Map(("a",1),("b",2),("c",3))

// mymap: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3)

// Lookups
mymap("a")
// res12: Int = 1

// Noneif not present
mymap get "b"
// res15: Option[Int] = Some(2)

// Temp additions on immutable
mymap + ("z"->99)
// res19: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3, z -> 99)

// Mutable maps
val mymutmap = collection.mutable.Map(("x",1),("y",2),("z",3))
// mymutmap: scala.collection.mutable.Map[String,Int] = Map(z -> 3, y -> 2,x -> 1)

// Permanent Additions
mymutmap += ("new"->999)
// res29: mymutmap.type = Map(z -> 3, y -> 2, x -> 1, new -> 999)

mymutmap
// res30: scala.collection.mutable.Map[String,Int] = Map(z -> 3, y -> 2, x -> 1, new -> 999)

// A few useful methods
mymap.keys
// res34: Iterable[String] = Set(a, b, c)

mymap.values
// res35: Iterable[Int] = MapLike(1, 2, 3)
