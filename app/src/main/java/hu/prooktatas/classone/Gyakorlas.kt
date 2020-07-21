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

    val sz = Szemely("Zsolt", "Kiss", 42)
//    val sz2 = Szemely("Tibor", "Tóth", 33)
    println(sz)
//    println(sz2)

    val refEq = sz

    val szCopy = sz.copy()
    println(szCopy)

    // ref szerinti egyenloseg: ===
    // allapot szerinti egyenloseg ==
    if (sz == szCopy) {
        println("Állapot szerint egyenlőek")
    } else {
        println("Állapot szerint NEM egyenlőek")
    }

    if (sz === szCopy) {
        println("Referencia szerint egyenlőek")
    } else {
        println("Referencia szerint NEM egyenlőek")
    }






}





