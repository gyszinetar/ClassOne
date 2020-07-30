package hu.prooktatas.classone

open class Person(val firstName: String, lastName: String) {
    val  fullName = "$firstName $lastName"

    open fun doWork() {
        println("An arbitrary work of any person")
    }
}

class Programmer(firstName: String, lastName: String): Person(firstName, lastName) {
    val languages = mutableSetOf<String>()

    fun addLanguage(lang: String) {
        languages.add(lang)
    }

    fun hireForProject(someLanguage: String): Boolean = languages.contains(someLanguage)

    override fun doWork() {
        println("$fullName: Coding, compiling, investigating bugs... The day in the life of any programmer")
    }
}

class Housewife(firstName: String, lastName: String, var numberOfChildren: Int = 0): Person(firstName, lastName) {

    override fun doWork() {
        println("$fullName: This housewife keeps cleaning the house all day...")
    }
}



fun main() {
    val p0 = Person("Lajos", "Olajos")

    val johnDoe = Programmer("John", "Doe")
    johnDoe.addLanguage("Python")

    val janeDoe = Housewife("Jane", "Doe", 2)
    val w2 = Housewife("Alice", "Pinkerton", 3)

    val jamesGosling = Programmer("James", "Gosling")
    jamesGosling.addLanguage("Java")

    val swift = "Swift"

    for (p in listOf(johnDoe, janeDoe, p0, jamesGosling, w2)) {
        if (p is Programmer) {
            println("Can I hire ${p.fullName} for a $swift project? ${p.hireForProject(swift)}")
        } else {
            p.doWork()
        }


    }
}