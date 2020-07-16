# Bevezetés a Kotlin programozásba

2011 óta fejlesztik.

JetBrains prágai cég, ismert a remek fejlesztő eszközeiről, mint az IntelliJ IDEA vagy az Android Studio.

2017-ben a Google IO-n jelentették be, hogy a nyelv használható Android fejlesztésre innentől és first class supportot kap az Android Studioban. Az Android Studio-ba pedig bekerült egy Kotlin plugin ami értelmezi a Kotlin szintaxist illetve képes Java kódot Kotlin kódra konvertálni.

2019 május 7-én a Google bejelentette, hogy a Kotlin az első számú programozási nyelv az Android platformon.

Jelenlegi verzió: 1.4 Preview

A Kotlin szó egy balti tengeri szigetnek a neve. Próbáltak a névvel is arra utalni, hogy Java közeli nyelv (Java is egy sziget).

<u>JVM nyelvek:</u>

* Java
* Scala
* Groovy
* Kotlin

<u>Minek kellett egy új programnyelv?</u>

* Null safety (fordítás idejű ellenőrzés amennyire csak lehetséges)
* Tömörebb, rövidebb
* Funkcionális programozás lehetősége
* Primitív típusok eliminálása
* First class citizen a function
* Data class
* Java interoperability, a lefordított Kotlin program ugyanolyan bytekódot generál, mintha Java kód lenne lefordítva

> [kotlinlang.org](https://kotlinlang.org)

## A Java nyelvről röviden

* 1995 Sun Microsystems, James Gosling
* JVM, JRE (Write once run everywhere)
* Alapvető célok
    - Minden platformon fusson
    - Hálózati programozás
    - Objektum orientált
    - Távoli gépeken is lehessen bizonságos kódot futtatni (sandbox model, applet)
* Bytekódra fordul
* Statikusan típusos
* Primitívek és objektum példányok vegyesen
* Egyetlen belépési pont a main() metódus
* SDK/JDK vs. Enterprise Edition
* javac, java, jar
* elosztott alkalmazások készítésében, szerver oldalon nagyon erős
* 2010-ben az Oracle felvásárolta a céget és így a Java nyelv is az ő tulajdonába került

## OOP alapelvek

* abstraction (a gyakorlati probléma leegyszerűsítése, lényegtelen dolgok kizárása a megoldásból, absztrakció)
* encapsulation (adatok és az adatokon végezhető műveletek egységbe zárása, adatelrejtés)
* inheritence (ősosztályok minimális/alap logikával, leszármazott osztályok a speciális dolgok hozzáadása végett)
* polymorphism (a leszármazási lánc illetve az implementált interfészek révén több alakú viselkedés, "hol ilyen vagyok, hol olyan...")

## Adattípusok

Minden visszavezethető numerikus típusra. Emberi gondolkodás vs. számítógép. Elektronikai alkatrészek bináris logikával működnek.

* Byte (8 bit)
* Short (16 bit)
* Int (32 bit)
* Long (64 bit)
* Float (32 bit)
* Double (64 bit)
* Booelan
* Character
* String

## Fontosabb fogalmak

* val és var különbsége
* is és as
* type inference
* nullability
* Not Null Assertion operátor
* let (null check és visszaadhat bármit, amire kiértékelődik a lambda belseje)
* Elvis operátor



---

[KÖVETEKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/elmelet/Bevezetes_REPL.md)

