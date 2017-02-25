//Control Flow
// if, else if, and else

////////////////////////
//// OVERALL FORMAT ////
////////////////////////
//   if(boolean){
//     do something
//   }else if(boolean){
//     do something else
//   }else if(boolean){
//     do something else
//   }else{
//     do something if none of the booleans were true
//   }
//

// if
if(true){
  println("I will print if True")
}

if(3 == 3){
  println("3 is equal to 3")
}

val x = "hello"

if(x.endsWith("o")){
  println("The value x ends with o")
}

/////////////
// if else //
/////////////

if(x.endsWith("h")){
  println("The value x ends with o")
}else{
  println("The value x does not end with o")
}

if(2 > 3){
  println(" 2 is greater than 3")
}else{
  println(" 2 is not great than 3")
}

////////////////////////
// if, else if, else ///
////////////////////////

val person = "George"

if(person == "Sammy"){
    println("Welcome Sammy!")
}else if(person =="George"){
    println("Welcome George!")
}else{
    println("Welcome, what's your name?")
}

// Logical Operators

// AND &&
println((1 == 2) && (2 == 2)) // false
println((1 == 1) && (2 == 2)) // true
// OR ||
println((1 == 2) || (2 == 2)) // true
println((1 == 1) || (2 == 2)) // true
// NOT !
println(!(1==1)) // false
println(!(2==1)) // true
