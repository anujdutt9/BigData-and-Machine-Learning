// Answer the following questions using your Scala Basics Knowledge!

// 1. What is 2 to the power of 5 ?

math.pow(2,5)
// res39: Double = 32.0

// 2. What is the remainder of 180 divided by 7?

180%7
// res40: Int = 5

// 3. Given variable pet_name = "Sammy", use string interpolation to print out
// "My dog's name is Sammy."

s"My dog's name is ${pet_name}"
// res42: String = My dog's name is Sammy

f"My dog's name is $pet_name"
// res43: String = My dog's name is Sammy

// 4. Use scala to find out if the letter sequence "xyz" is contained in:
// "sadfjshfjyuyxyzjkfuidkjklhasyysdfk"

val s = "sadfjshfjyuyxyzjkfuidkjklhasyysdfk"
// s: String = sadfjshfjyuyxyzjkfuidkjklhasyysdfk

s contains "xyz"
// res45: Boolean = true

// 5. What is the difference between a value and a variable?

// A value is an immutable storage unit, it can be assigned data when defined but
// can not be reassigned.

// A variable is a mutable storage unit, data can be assigned at definition and
// reassigned later on.

// 6. Given the tuple (1,2,3,(4,5,6)) retrieve the number 6.

// val t = (1,2,3,(4,5,6))
// t: (Int, Int, Int, (Int, Int, Int)) = (1,2,3,(4,5,6))

t._4
// res49: (Int, Int, Int) = (4,5,6)

t._4._3
// res50: Int = 6
