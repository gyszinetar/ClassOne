package hu.prooktatas.classone

class Empty

//class Person {
//    var firstName = ""
//        private set
//
//    var lastName = ""
//        private set
//
//    var age: Int? = null
//
//
//    constructor(fn: String, ln: String, a: Int) {
//        firstName = fn
//        lastName = ln
//        age = a
//    }
//
//    constructor(fn: String, ln: String) {
//        firstName = fn
//        lastName = ln
//    }
//}

//class Person(val name: String, age: Int) {
//    var age: Int = age
//        private set
//
//    var retired: Boolean = false
//        private set
//        get() = age > 65
//}

//class Person(private val firstName: String, private val lastName: String) {
//    var age: Int? = null
//
//    constructor(s1: String, s2: String, i: Int) : this(s1, s2) {
//        age = i
//    }
//}

//data class Person(val firstName: String, val lastName: String, var age: Int? = null)

fun main() {

//    var counter = 0
//
//    val incrementingLambda = {
//        counter += 1
//    }
//
//    for (i in 0 until 5) {
//        incrementingLambda()
//    }
//
//    println(counter)



//    fun idGenerator(startValue: Int): () -> Int {
//        var currentId = startValue
//
//        val incrementer: () -> Int = {
//            currentId += 1
//            currentId
//        }
//
//        return  incrementer
//    }
//
//    val customerIdGen = idGenerator(1027)
//    val cartIdGen = idGenerator(23401)
//
//    for (i in 0..5) {
//        println("next ID in CUSTOMER table is: ${customerIdGen()}")
//    }
//
//    for (i in 0..5) {
//        println("next ID in CART table is: ${cartIdGen()}")
//    }


    val fruits = listOf("banana", "apple", "pear", "plum", "orange", "melon")
    val prices = listOf(330.0, 450.0, 850.0, 500.0, 500.0, 250.0)

//    for (element in fruits) {
//        println(element)
//    }

//    fruits.forEach {
//        println(it)
//    }

//    fruits.forEach(::println)

//    fruits.forEach(::reversePrinter)

//    val salesPrices = mutableListOf<Double>()
//    for (aPrice in prices) {
//        salesPrices.add(aPrice * 0.9)
//    }

    val salesPrices = prices.map {
        it * 0.9
    }

//    println(salesPrices)

    val userInput = listOf("7", "seven", "kutya", "33.3", "108")

    val numbers = userInput.map {
        it.toIntOrNull()
    }

    val validInputs = userInput.mapNotNull {
        it.toIntOrNull()
    }

    println(numbers)
    println(validInputs)

}

fun reversePrinter(value: String) {
    println(StringBuffer(value).reverse())
}

