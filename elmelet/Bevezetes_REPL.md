# Ismerkedés a Kotlin nyelvvel

<u>Előfeltételek:</u>

* Kotlin plugin legyen az IDEA-ban. Pluginok: File/Settings/Plugins
* Kotlin parancssori program telepítve legyen, rajta legyen a PATH-on 

[Working with command line compiler](https://kotlinlang.org/docs/tutorials/command-line.html)

[Command Line Compiler Windows](https://downlinko.com/download-install-kotlin-windows.html)

[Rendszerkövetelmények IDEA](https://www.jetbrains.com/help/idea/installation-guide.html)


Kotlin meglétének ellenőrzése: 

    kotlinc -version

Help: 

    kotlinc -help


Ha nincs Kotlin a gépen, így kell telepíteni:

    zsolt@inspiron:~$ sudo snap install --classic kotlin
    kotlin 1.3.61 from jetbrains✓ installed


## REPL (Read-Eval-Print-Loop)

IntelliJ IDEA és Android Studio alatt is van REPL!
> Tools/Kotlin/Kotlin REPL


<u>Parancssorból indítása:</u>

    zsolt@inspiron:~$ kotlinc-jvm
    Welcome to Kotlin version 1.3.61 (JRE 11.0.4+11-post-Ubuntu-1ubuntu218.04.3)
    Type :help for help, :quit for quit


<u>VAGY csak simán:</u>

    kotlinc


### REPL gyakorlás 1, function

    2+3 ENTER
    fun welcome() { System.out.println("Helló, Kotlin!") }
    fun add(n1: Int, n2: Int) = n1 + n2
    welcome() ENTER
    add(9, 7) ENTER


### REPL gyakorlás 2, osztály

    class Calculator() {
    fun add(n1: Int, n2: Int): Int = n1 + n2
    fun subtract(n1: Int, n2: Int): Int = n1 - n2
    fun multiply(n1: Int, n2: Int): Int = n1 * n2
    fun divide(n1: Int, n2: Int): Int = n1 / n2
    }
    val c = Calculator()
    c
    c.add(3, 5)
    c.subtract(11, 7)
    c.multiply(7, 6)
    c.divide(71, 8)
    c.divide(72, 8)
    c.divide(11, 3)

---

### REPL gyakorlás 3, Regex 1

    val entry = "The quick brown fox jump over the lazy dog"
    val pattern = "(o.)+".toRegex()
    val matches = pattern.findAll(entry)
    println(matches)

A kiírásból látszik, hogy a matches típusa valami "sequence".
Több elemű "dolog". Lehet első és utolsó eleme:

    println(matches.first().value)
    println(matches.last().value)

---

### REPL gyakorlás, Regex 2, váltás Kotlin playgroundra

[Kotlin playground](https://play.kotlinlang.org)

Gépeljük be a Kotlin Playgroundba az előző példát, kiegészítve azzal, hogy a "sequence" minden elemét írassuk ki, ne csak az első és az utolsót.

    val entry = "The quick brown fox jump over the lazy dog"
    val pattern = "(o.)+".toRegex()
    val matches = pattern.findAll(entry)
    println(matches)
    println(matches.first().value)
    println(matches.last().value)
        
    matches.forEach() {
        println(it.value)
    }

---

## Scratches

Az Android Studio-ban lehet a projekttől függetlenül "játszós" Kotlin fájlokat létrehozni, amiben gyakorolni lehet, vagy ki lehet próbálni forráskód darabkákat.

<u>Létrehozás:</u>

> jobb klikk, New > Scratch File

A létrehozott scratch fájlok nem projekthez kötődnek, ezért nem is a projekt mappájában tárolódnak, hanem az Android Studio telepítési könyvtárában a *config/scratches* mappában.

## Kotlin Worksheet

Hasonló a scatches-hez, de ez hozzátartozik a konkrét projekthez, a projekt mappája alatt jön létre. .kts kiterjesztésű (kotlinscript) fájl. Futtatásához szükséges a kotlin-script-runtime modul hozzáaádsa a dependencies-hez:

    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-script-runtime
    compile group: 'org.jetbrains.kotlin', name: 'kotlin-script-runtime', version: '1.3.72'

> Nézzük meg a ClassOne projektben a Kotlin Worksheet-eket és gyakoroljuk a Kotlin szintaxist és koncepciókat!

---

[KÖVETKEZŐ TÉMA](file:///home/zsolt/Munka/Projects/ProOktatas/topics/elmelet/Kotlin_OOP.md)

