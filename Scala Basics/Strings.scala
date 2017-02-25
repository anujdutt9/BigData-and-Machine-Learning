// STRINGS AND BASIC REGEX

// Printing
println("hello")

// Concatenation
val fairwell = "Good" + "Bye"
// fairwell: String = GoodBye

// Repeating
val repeat = "Dance!"*5
// repeat: String = Dance!Dance!Dance!Dance!Dance!

// String Length
val st = "hello"
// st: String = hello

st.length()
// res14: Int = 5

// Inserting Objects
val name = "Jose"
// name: String = Jose
// String Interploation
val greet = s"Hello ${name}"
// greet: String = Hello Jose
// printf
printf("A string: %s , an integer %d, a float %f","hi",10,2.5)
// A string: hi , an integer 10, a float 2.500000

printf("A string: %s , an integer %d, a float %1.2f","hi",10,2.5)
// A string: hi , an integer 10, a float 2.50

// 'f' Interploation
val greet = f"Hello ${name}"
// greet: String = Hello Jose

val greet = f"Hello $name"
// greet: String = Hello Jose

// String Indexing
f"First letter of name is $name%.1s"
// res8: String = First letter of name is J

///////////////////////////
/// Regular Expressions ///
///////////////////////////

// Index Location
val st = "This is a long string"
// st: String = This is a long string

st.charAt(0)
// res18: Char = T

st.indexOf("a")
// res19: Int = 8

// Pattern matching
val st = "term1 term2 term3"
// st: String = term1 term2 term3

st contains "term1"
// res20: Boolean = true

st matches "term1"
// res11: Boolean = false

st matches "term1 term2 term3"
// res12: Boolean = true

// Slicing
val st = "hello"
// st: String = hello

st slice (0,2)
// res2: String = he

st slice (2,st.length)
// res4: String = llo
