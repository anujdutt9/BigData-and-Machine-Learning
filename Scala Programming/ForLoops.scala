// FOR LOOPS

//////////////////////
/// GENERAL FORMAT ///
//////////////////////
//  for(item <- iterable_sequence){
//    do something
//  }

// Lists
for(item <- List("a","b","c")){
  println(item)
}

// Range
for(num <- Range(0,3)){
  println(num)
}

for(anything <- Range(0,3)){
  println("hello")
}


// Building it up with Flow Control!
for(num <- Range(0,10)){
  if(num % 2 == 0){
    println(s"$num is even")
  }else{
    println(s"$num is odd")
  }
}

// One more example
val names = List("John","Abe","Cindy","Cat")

for(name <- names){
  if(name.startsWith("C")){
    println("$name starts with a C")
  }
}
