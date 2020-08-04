package hu.prooktatas.classone

//fun main() {
//    val a = A()
//    val b = B(17)
//    val c = C(42, "asdf")
//
//    println(a)
//    println(b)
//    println(c)
//
//}

fun main() {
    val t = Tool("any tool")
    val s = Spade(27.50)


    println(t)
    println(s)

    s.doSomeWork()





}

open class A

open class B(someValue: Int): A() {

    override fun toString(): String {
        return "An instance of B"
    }

}

class C(someInt: Int, someString: String): B(someInt) {

}

open class Tool(var name: String) {

    open var price = 0.0

    init {
        println("Tool.init(): $name, $price")
    }

    open fun doSomeWork() {
        println("TOOL doSomeWork")
    }


}

class Spade(override var price: Double): Tool("ásó") {

    init {
        println("Spade.init(): $name, $price")
    }

    override fun doSomeWork() {
        super.doSomeWork()
        println("SPADE doSomeWork")
    }
}