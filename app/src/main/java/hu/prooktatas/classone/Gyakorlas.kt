package hu.prooktatas.classone

data class Szemely(val fn: String, val ln: String, val age: Int)

// toString, hashCode, equals, getter/setter



// PRIMARY CONSTR.
//class Szemely(var firstName: String, val lastName: String) {
//
//    var age: Int? = null
//
//    // Access modifier: private, protected, internal, public
////    private var firstName: String = ""
////    private var lastName: String = ""
//
//    // Secondary konstruktor
////    constructor(fn: String, ln: String) {
////        this.firstName = fn
////        this.lastName = fn
////    }
//
//    // SECONDARY
//    constructor(fn: String, ln: String, a: Int) : this(fn, ln) {
//        age = a
//    }
//
//}

fun main() {

//    val sz = Szemely("Zsolt", "Kiss", 42)
////    val sz2 = Szemely("Tibor", "Tóth", 33)
//    println(sz)
////    println(sz2)
//
//    val refEq = sz
//
//    val szCopy = sz.copy()
//    println(szCopy)
//
//    // ref szerinti egyenloseg: ===
//    // allapot szerinti egyenloseg ==
//    if (sz == szCopy) {
//        println("Állapot szerint egyenlőek")
//    } else {
//        println("Állapot szerint NEM egyenlőek")
//    }
//
//    if (sz === szCopy) {
//        println("Referencia szerint egyenlőek")
//    } else {
//        println("Referencia szerint NEM egyenlőek")
//    }

    // 0, 1, 2
    val myRange = 1..10

//    for (i in 0 until 2) {
//        println(i)
//    }

    for (i in 0 .. myRange.last) {
        println(i)
    }


//    val emptyList = listOf<Int>()
//    emptyList.toIntArray()[0] = 1
//    emptyList.add(20)
//    emptyList = listOf(1, 2, 3)

//    var test1 = arrayOfNulls<String>(5)
//    test1 = arrayOf(1, 2, 3)
//    test1 = arrayOf("egy", "2", "három")


}





