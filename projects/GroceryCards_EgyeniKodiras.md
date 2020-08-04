# Egyéni kódírás: GroceryCards app

## Leírás

Egy `RecyclerView`-ban jelenítünk meg zölségeket és gyümölcsöket.

### Használt technológiák

* Különböző layout manegerek, widget-ek: `RecyclerView`, `FrameLayout`, `LinerarLayout`
* `companion object` fogalma, használata
* Dialog-ok fogalma, `AlertDialog`, `DialogBuilder`

### Menetrend, célok

* A tanulók egyénileg írjanak kódot, a tanár csak segítő szerepkört tölt be. 
* Az egyes lépéseket kivetítéssel más és más tanuló implementálja, a többiek folyamatosan segítsék, javítsák őt!
* Cél 1: A tanulók gyakorolják az előző órákon tanultakat, hogy elmélyüljön a tudásuk.
* Cél 2: A tanulók képesek legyenek önálló döntéseket hozni egy alkalmazás implementálása közben, legyen szó akár architekturális vagy OOP problémáról, UI-ról.
* Cél 3: A tanulók gyakorolják a fejlesztő eszköz használatát és szerezzenek jártasságot a kódolás közben fellépő **bármilyen** természetű hiba/akadály elhárításában
* Cél 4: Fejlődjön a tanulók analitikus képessége azáltal, hogy tapasztalják, egy projekt szöveges, vagy szóbeli definiálása még ideális esetben sem tisztáz minden felmerülő kérdést; egyéni döntésekre vagy további tisztázásra is szükség van.
* Cél 5: A tanulók gyakorolják a *pair vagy team programming*-ot, adott esetben legyenek képesek közösen megvitatni egy problémát és döntést hozni a követendő irányról

## Az implementálás lépései

1. Helyezzük el az image resource-okat a res/drawable-xxhdpi mappában!
2. Implementáljuk a modell osztályt: 
    * Név: GroceryItem
    * Paraméterek: name: String, imgRes: Int
3. Implementáljunk egy `fun createItems(): List<GroceryItem>` metódust a modell osztályon belül egy `companion object`-ben
4. Implementáljuk a lista nézet egy sorát megjelenítő layout fájlt!
5. Implementáljuk az adaptert és a view holdert!
6. Implementáljuk az activity layout-ot!
7. Implementáljuk azt a kódot, ami az activity osztályban a recycler view kezeléséhez szükséges!
8. Implementáljuk az egyes cellákon való klikkelést!
9. Implementáljunk egy alert dialog-ot, ami megkérdezi a felhasználótól, hogy a kosarába szeretné-e tenni a kiválasztott terméket! A kiválasztott termék neve jelenjen meg a dialógusban!
