# Inheritance - Öröklődés

## Fogalmak, koncepciók

* super class, subclass, base class, leszármazott osztály, ősosztály
* class header (primary konstruktorral vagy anélkül)
* open class, open function: pont ellentéte annak, ami a Java-ban van! Ott minden osztály alapértelmezetten kiterjeszthető. Kotlinban csak az, amit expliciten elláttunk az `open` kulcsszóval!
* overridden function
* "A gyermek mindig beugorhat a szülő helyett"
* IS-A
* Single inheritence

<ins>FONTOS!</ins>

* Minden Java class ősosztálya az `Object`. [Object Javadoc](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)
* DE! Minden Kotlin class ősosztálya az Any!!! [Any Kotlindoc](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/)

## Gyakorlás: Inheritance

1. Hozzunk létre egy "minimal" A osztályt
2. B osztály legyen A leszármazottja, konstruktorában vegyen át egy paramétert! Vegyük észre a szintaxisban az ősosztály konstruktorának meghívását! Vegyük észre, hogy A-t open-ként kell deklarálni, egyébként hibaüzenet kapunk!
3. A B osztályban írjuk felül a `toString()` metódust! Kérdés: Kitől örökli a B osztály a `toString()` metódust?
4. C osztály legyen B leszármazottja, konstruktorában vegyen át egy Int és egy String paramétert!
5. Írjunk egy Tool osztályt, ami a konstruktorban átvesz egy `var name:String` paramétert! Az osztály blokkjában deklaráljunk egy `var price: Double` változót!
6. Ismerjük meg az `init { ... }` blokkot! Implementáljunk egyet a Tool osztályban, ami kiírja a paraméterek értékét!
7. Írjunk egy Spade osztályt, ami a Tool leszármazottja és átvesz egy `var price: Double` paramétert! Milyen fordítási hibába ütközünk? Hogyan tudjuk javítani?
8. Implementáljunk `init { ... }` blokkot a Spade osztályban is! Figyeljük meg és elemezzük ki az init blokkok lefutását!
9. Adjunk a Tool és a Spade osztályhoz is egy `fun doSomeWork()` metódust! 
Van köze így a két metódusnak egymáshoz? Mit kell tennünk, hogy a a Spade osztály metódusa örökölt és felülírt metódusa legyen a Tool osztálybelinek?
10. Hívjuk meg egy Spade példányon a `doSomeWork()` metódust! Adjunk a metódushoz egy `super.doSomeWork()` hívást is!

## Gyakorlás: Polimorfizmus

1. Hozzunk létre egy Person osztályt (first name, last name)! Tőle származzon a Programmer és a Housewife osztály is!
2. A Housewife osztály konstruktora vegyen át egy `var numberOfChildren: Int` paramétert is, aminek a default értéke 0 legyen!
3. A Person osztályba vegyünk fel egy `computed property`-t, ami visszaadja a teljes nevet (fullName)!
4. A Person osztályba vegyünk fel egy `doWork()` metódust, amit a leszármazottak majd felülírnak!
5. A Programmer osztályt bővítsük az alábbiak szerint:
    * Adjunk saját implementációt a doWork()-re!
    * Tartson nyilván egy halmazt, amely a programozó által ismert programnyelveket tartalmazza!
    * Legyen egy `fun addLanguage(lang: String)` metódusa, amivel hozzá lehet adni programnyelvet!
    * Legyen egy `fun hireForProject(someLanguage: String): Boolean` metódusa, mivel meg lehet kérdezni, hogy az adott programozó el tud-e végezni egy adott munkát!
6. A Housewife osztályt bővítsük az alábbiak szerint:
    * Adjunk saját implementációt a doWork()-re!
7. Írjunk egy `main()` metódust az alábbiak szerint és futtassuk!
    * Példányosítsunk egy Person-t, két Programmer-t és két Housewife-ot!
    * A Programmer példányokon állítsunk be egy-egy eltérő programnyelvet!
    * Vegyünk fel egy `val project: String` változóba egy olyan programnyelvet, amit egyik programozó sem ismer!
    * A Person leszármazottakat fogjuk össze egy listába, iteráljunk a listán!
    * Ha az aktuális elem a ciklusban Programmer, kérdezzük meg, elvállalja-e a `project` változóban lévő munkát!
    * Ha az aktuális elem a ciklusban nem Programmer, akkor hívjuk meg a `doWork()` metódusát!
    * Gondoljuk végig, vagy próbáljuk ki, mi történik, ha nem vizsgáljuk le, hogy az aktuális elem Programmer példány-e!