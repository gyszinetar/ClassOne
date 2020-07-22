# Objektum orientált programozás Kotlinban

## OOP alapelvek

* inheritance
* abstraction
* polymorphism
* encapsulation

## Kulcsszavak, fogalmak

* Objektum
* Példány
* Osztály
* Csomag
* Öröklődés, leszármazott, ős
* Blueprint vagy "tervrajz"
* Metódus
* Adattag, property, változó, példány változó
* Hozzáférési kategória
* Getter/Setter
* Példányosítás, konstruktor
* Referencia
* Heap, stack
* Mutable, immutable
* super és this

---

## Gyakorlás

1. Hozzunk létre egy `Practing.kt` fájlt a `MainActivity` mellett! Helyezzünk el egy `main()` function-t, abban pedig egy szimpla kiíratást, majd próbáljuk futtatni!

2. Minimális class: elég csak a név!

        class Empty

3. Ennél egy fokkal "komolyabb" class, aminek már vannak adattagjai. Csináljunk `Person` class-t!
4. Csináljunk a `Person` class-hoz egy secondary konstruktort! 
5. Csináljunk a `Person` class-hoz primary konstruktort és a secondary-t `this()` hívással láncoljuk a primary-hez!

        class Person(val firstName: String, var lastName: String) {
            var age: Int? = null

            constructor(s1: String, s2: String, i: Int) : this(s1, s2) {
                age = i
            }
        }

6. Vezessünk be access modifier-eket az adattagokhoz! (public, private, protected, internal (modulon belüli teljes láthatóság))
7. Vezessünk be private setter és publikus getter metódusokat!

        class Person {
            var firstName = ""
                private set

            var lastName = ""
                private set

            var age: Int? = null

            constructor(fn: String, ln: String, a: Int) {
                firstName = fn
                lastName = ln
                age = a
            }
            
            constructor(fn: String, ln: String) {
                firstName = fn
                lastName = ln
            }
        }

8. Vezessünk be egy **csak olvasható** computed property-t (`var retired: Boolean`), ami az age-től függ!
9. Hozzunk létre data class-t! (Csak `val` property-k, `copy`, `toString`, `hashCode`, `equals` "ingyen" jön.) (Immutability fontossága!) Vegyük észre, hogy a formázott kiíratáshoz nem kell semmilyen kódot írnunk!
10. Próbáljuk ki a `copy()` function-t a data class példányon!
10. Próbáljuk ki a deconstructiong feature-t a data class példányon!

        val p1 = Person("John", "Doe", 35)
        val (keresztnev: String, csaladnev: String, kor: Int?) = p1

11. Ismerkedjünk meg a `structural equality` (==) és a `referential equality` (===) fogalmával példákon keresztül! [Kotlin Equality](https://kotlinlang.org/docs/reference/equality.html)
12. Ismerkedjünk meg a `component function` fogalommal: egy `Person` példányon nézzük meg a component1...componentN function-öket!

---

> Nézzük meg a Kotlin_OOP.ws.kts worksheet-et és gyakoroljuk a különböző OOP scenariokat!

---

[KÖVETKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/elmelet/Beginning_Android_Layouts.md)













