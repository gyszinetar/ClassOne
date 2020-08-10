# Egyéni kódírás: Rendszám generálás projekt (Kotlin)

## Leírás
Írj egy Kotlin nyelvű programot, amely szabályos magyarországi rendszámokat generál (három betű, kötőjel, három számjegy)!

## Megvalósítás
Implementáld az alább felsorolásra kerülő osztályokat!
Ahol szükségét érzed, használj `data class`-t a szimpla `class` helyett!
Töltsd fel adatokkal a szükséges adatszerkezeteket!
Implementáld a `main()` metódust és hívd meg belőle a felsorolt metódusokat!
Ha kiíratást használsz, az beszédes legyen! Legyen egyértelműen azonosítható, melyik teszteset fut és arra mi a program válasza!

## A program elemei

### PlateNumber `class`
A projektben a modell szerepét tölti be. Célszerű egy ennek megfelelő csomagban elhelyezni.

* konstruktora két String-et vesz át (letters, numbers)
* legyen egy `val fullPlate: String` property-je, egy custom getter-rel; adja vissza a rendszámot "ABC-123" formátumban
* <ins>FONTOS:</ins> a `PlateNumber` a rendszámban szereplő kötőjelet **csak és kizárólag** ebben a property-ben használja. A kötőjel sehol máshol nem jelenik meg!

### Generator `class`

Rendszámokat tud generálni. Véletlenszerűen "sorsolja" a rendszámot alkotó betűket és számokat.

* legyen egy `companion object`-je
* a `companion object`-ben implemenáld a `fun randomPlateNumber(): PlateNumber` metódust
* a rendszámok hárombetűs részének összerakásához használj `StringBuilder`-t és egy karaktereket tömböt, amely tartalmazza az összes ékezet nélküli nagybetűt

### Storage `class`

Több feladatot lát el:

1. tárolja a már regisztrált rendszámokat
2. új rendszámot lehet nála regisztráltani
3. támogatja a kereséseket

Implementálás részletei:

* primary konstruktor: `class Storage(existing: List<PlateNumber>)`
* az osztály egy halmazban (`MutableSet`) tárolja a regisztrált rendszámokat; ez egy private property legyen. (A halmaz adatszerkezet automatikusan kiszűri a duplikátumokat, ha a tárolt elemek megfelelően vannak implementálva)
* a konstruktorban átvett lista elemeit helyezze el a `MutableSet`-ben
* a külvilág számára kínáljon fel egy `val registeredPlates: List<PlateNumber>` computed property-t, amely a halmazban tárolt elemeket adja vissza lista formában
* legyen egy metódusa (search), amivel keresni lehet egy rész-sztringet a meglévő rendszámok között; a metódus visszatérési értéke `List<PlateNumber>` legyen
* legyen egy metódusa (registrate), ami átvesz egy `PlateNumber` példányt, és megpróbálja hozzáadni a halmazhoz. A művelet eredményéről egy `Boolean` visszatérési érték informálja a hívót!

### Teszt metódusok

#### test1() metódus: hagyományos for ciklus range-dzsel

* első utasításként írassa ki, hogy "---------- TEST 1 -----------"
* generáljon 10 darab `PlateNumber`-t a `Generator` osztály segítségével egy olyan ciklusban, ahol egy range-dzsel van megadva a ciklusváltozó
* írassa ki minden `PlateNumber` példány `fullPlate` property-jét

#### test2() metódus: null-okat tartalmazó tömb elemeinek feltöltése

* első utasításként írassa ki, hogy "---------- TEST 2 -----------"
* hozzon létre egy 10 elemű tömböt, amely null-okkal töltődjön fel első körben, de majd `PlateNumber` példányokat fog tárolni
* iteráljon a tömbön olyan for ciklussal, amely `until`-t tartalmaz a fejlécében
* minden iterációban az aktuális indexű elemként helyezzen el a `PlateNumber` példányt a tömbben; a `PlateNumber`-t a `Generator`-ral hozza létre
* miután a tömb feltöltésre került, iteráljon ismét rajta, de most egy `forEach`-csel és írassa ki minden `PlateNumber` példány `fullPlate` property-jét

#### test3() metódus: tömb feltöltés lambda iniciaizáló blokkal

* első utasításként írassa ki, hogy "---------- TEST 3 -----------"
* töltsön fel egy 10 elemű tömböt `PlateNumber` objektumokkal, de az `Array(size:Int) { <tömb elem inicializáló kódja> }` szignatúrájú `Array` konstruktort használja
* miután a tömb feltöltésre került, iteráljon ismét rajta, de most egy `forEach`-csel és írassa ki minden `PlateNumber` példány `fullPlate` property-jét

#### test4() metódus: `Storage` példányosítás létező `PlateNumber`-ekkel

* első utasításként írassa ki, hogy "---------- TEST 4 -----------"
* tetszőleges szintaxissal hozzon létre egy 10 elemű `PlateNumber` listát
* példányosítson egy `val storage: Storage` objektumot átadva az előző lépésben létrehozott listát
* írassa ki a storage példány `registeredPlates` property-jét

#### test5() metódus: keresés a storage-ban

* első utasításként írassa ki, hogy "---------- TEST 5 -----------"
* tetszőleges szintaxissal hozzon létre egy 10 elemű `PlateNumber` listát
* példányosítson egy `val storage: Storage` objektumot átadva az előző lépésben létrehozott listát
* indítson keresést a storage példányon, a kereső metódusnak átadva az előzőleg létrehozott lista hetedik elemének `letters` property-jét
* indítson keresést a storage példányon, a kereső metódusnak átadva az előzőleg létrehozott lista nyolcadik elemének `numbers` property-jét
* írassa ki a keresések eredményét

#### test6() metódus: már regisztrált rendszám újra hozzáadása

* első utasításként írassa ki, hogy "---------- TEST 6 -----------"
* tetszőleges szintaxissal hozzon létre egy 10 elemű `PlateNumber` listát
* példányosítson egy `val storage: Storage` objektumot átadva az előző lépésben létrehozott listát
* regisztrálja a storage-ban az előzőleg létrehozott lista kilencedik elemét
* írassa ki a regisztrálás eredményét

#### test7() metódus: új, még nem létező rendszámok hozzáadása, visszakeresése

* első utasításként írassa ki, hogy "---------- TEST 7 -----------"
* tetszőleges szintaxissal hozzon létre egy 10 elemű `PlateNumber` listát
* példányosítson egy `val storage: Storage` objektumot átadva az előző lépésben létrehozott listát
* regisztrálja a storage-ban a következő két rendszámot: ABC-107, ABC-756
* írja ki a regisztrációk eredményét
* futtassa le a következő keresésket a sotrage-on: AB, BC-7
* írassa ki a keresések eredményét
* iteráljon `forEach`-csel a storage `registeredPlates` property-jén és írassa ki az egyes elemek `fullPlate` property-jét

### main() function

* sorban egymás után (vagy egyenként kikommentezve) hívja meg a test1-test7 metódusokat

