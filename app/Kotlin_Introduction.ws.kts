val sentence = "The quick brown fox jumps over the lazy dog"
val pattern = "(o.)+".toRegex()
val matches = pattern.findAll(sentence)
matches.last().value

matches.forEach {
    println(it.value)
}

val doublePI = 3.14

val floatPI = 3.14f

var sum = doublePI + floatPI

//var sum: Float = doublePI + floatPI

var floatSUM: Float = doublePI.toFloat() + floatPI

// NULLABILITY

var userInput: Int? = null
userInput = 27

if (userInput != null) {
    println("$userInput négyzete ${userInput!! * userInput!!}")
} else {
    println("Nem adtak meg adatot")
}

// TODO: probaljuk meg, hogy a Not Null Assertion operatort kivesszuk a kifejezesbol!

val square = userInput?.let {
    it * it
}

println("A négyzetre emelés eredménye: $square")

var userName: String? = "John"

val message = userName?.let {
    "Helló, $it"
} ?: "Helló, ismeretlen!"

message