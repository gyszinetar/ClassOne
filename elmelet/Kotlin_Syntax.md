# Kotlin szintaxis

## Változo deklaráció

* Mindig kell `var` vagy `val`.
* Névkonvenció: camel case
* Elől a név, utána kettősponttal a típus.
* Általános típus az Any.
* Ha elhagyjuk a típust, akkor egyből kezdőértéket is kell adni (type inference)
* `const val`: fordítás idejű konstans

## Gyakorlás

1. Hozzunk létre konstansokat a négy alapművelethez!
2. Vegyük fel őket egy listába! (`val operands`)
3. Vegyünk fel egy `userInput` nevű nullable változót!
4. Vegyünk fel egy `currentOperand` nevű változót, adjuk neki kezdőértékül a `userInput` értékét, Elvis operaátorral adjunk meg egy default értéket!
5. Ismerjük meg a `when()` expression-t, alkalmazzuk a `currentOperand`-ra!
6. Használjuk a `when()`-t úgy, hogy visszaadjon egy balértéket!
7. Ismerjük meg a range operátort, írjunk for ciklust vele!

        val myRange = 5..10
        
8. Írjunk for ciklust az `until` használatával!
9. Ismerjük meg a `forEach()` függvényt, egy lista elemein iteráljunk vele!
10. Írjunk visszafelé számláló ciklust a `downTo` és a `step` használatával!
11. Iteráljunk egy `String` elemein egy szimpla for ciklussal (`in` szintaxis) és győződjünk meg róla, hogy valóban a tartalmazott karakteren megy végig a ciklus!