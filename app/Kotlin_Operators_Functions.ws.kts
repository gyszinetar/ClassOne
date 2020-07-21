// Csak az altalanos programozasi gyakorlattol eltero koncepciokat es szintaxist nezzuk meg

// Compile time konstans (globalis)
//const val ADD = "+"
//const val SUBTRACT = "-"
//const val MULTIPLY = "*"
//const val DIVIDE = "/"

val ADD = "+"
val SUBTRACT = "-"
val MULTIPLY = "*"
val DIVIDE = "/"

// lista
val operands = listOf(ADD, SUBTRACT, MULTIPLY, DIVIDE)

// Nullable value
var userInput: String? = null

// Elvis operator
var currentOperand = userInput ?: ADD

var op1 = 2.0
var op2 = 3.0

currentOperand = "^"
currentOperand = DIVIDE

// switch-case helyett: when
when(currentOperand) {
    ADD -> {
        println("$op1 $ADD $op2 = ${op1 + op2}")
    }

    SUBTRACT -> {
        println("$op1 $SUBTRACT $op2 = ${op1 - op2}")
    }

    MULTIPLY -> {
        println("$op1 $MULTIPLY $op2 = ${op1 * op2}")
    }

    DIVIDE -> {
        println("$op1 $DIVIDE $op2 = ${op1 / op2}")
    }

    else -> println("Operand not valid")
}

currentOperand

val result = when(currentOperand) {
    ADD -> op1 + op2
    SUBTRACT -> op1 - op2
    MULTIPLY -> op1 * op2
    DIVIDE -> op1 / op2
    else -> null
}

result

// Range (alul/felul zart)
val myRange = 5..10


for(i in myRange) {
    println(i)
}

// for loop alul zart, felul nyitott
for (i in 0 until 5) {
    println(i)
}

for (i in 0 until operands.size) {
    println(operands[i])
}

// for-each lambda
listOf(1, 3, 5, 7, 9).forEach {
    println(it)
}

// iteralas egy string elemein, minden egyes iteracioban egy Char peldanyt kapunk
for (someLetter in "helló kotlin") {
    println(someLetter.toUpperCase())
}

for (i in 10 downTo 0 step 2) {
    println(i)
}

