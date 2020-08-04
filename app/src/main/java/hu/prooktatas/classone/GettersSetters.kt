package hu.prooktatas.classone

fun main() {

//    useApply()
    useSecondaryConstructor()

}

class Task(val name: String) {
    var priority = DEFAULT_PRIORITY
        set(value) {
            println("Setter called with $value")
            field = value.coerceIn(PRIORITY_RANGE)

            // coerceIn(): https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/coerce-in.html
        }

    val lowPriority
        get() = priority < 3

    constructor(n: String, p: Int): this(n) {
        priority = p
    }
}

const val DEFAULT_PRIORITY = 3
val PRIORITY_RANGE = 1..5

fun useApply() {
    val t = Task("Image downloading").apply {
        priority = 5
    }

    println("Task: ${t.name}, ${t.priority}, ${t.lowPriority}")
}

fun useSecondaryConstructor() {
    val t = Task("Calculate primes", 20)
    println("Task: ${t.name}, ${t.priority}, ${t.lowPriority}")

}