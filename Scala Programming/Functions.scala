// FUNCTIONS

////////////////////
// GENERAL FORMAT //
////////////////////

// def functionName(input1:type,intput2:type): return type = {
//    do stuff
//                     }

// Examples

def simple(): Unit = {
  println("Simple Print")
}
simple()

// Adding two inputs
def adder(num1:Int,num2:Int): Int = {
  return num1 + num2
}

val x = adder(2,3)
println(x)

// Greeting Someone
def greetName(name:String): String = {
  return s"Hello $name"
}
val fullgreet = greetName("Jose")
println(fullgreet)

// Check if a number is prime
def isPrime(numcheck:Int): Boolean = {
  for(n <- Range(2,numcheck)){
    if(numcheck%n == 0){
      return false
    }
    }
    return true
}


println(isPrime(10))
println(isPrime(23))

// Using Collections

val numbers = List(1,2,3,7)
def check(nums:List[Int]): List[Int]={
  return nums
}

println(check(numbers))

// "One Line Functions"
def quickgreet(name:String) = s"Hello $name"
println(quickgreet("Sammy"))
