# Közös kódírás: PlayerProfiles app

### Leírás

Football játékosok adatlapját megjelenítő alkalmazás.
Megjeleníti a játékos arcképét és különböző adatait.

## UI

ImageView egy fényképpel, alatta elrendezve a játékos különböző adatai.

## Használt technológiák, cél

* Layout manager-ek gyakorlása (LinearLayout, RelativeLayout és FrameLayout)
* Orientation change-re reagálás
* Gyakorlat összetett UI felépítésében egymásba ágyazott layout manager-ekkel, layout manager-ek konvertálása 

## Implementálás lépései

1. Projekt létrehozása, image resource-ok elhelyezése
2. activity_main.xml-ben cseréljük ki az eredeti `ConstraintLayout`-ot `RelativeLayout`-ra! (Convert view menüpont a Design nézeten)
3. Ismerjük meg a `Component Tree` nézetet!
4. Töröljük a "Hello World" `TextView`-t!
5. Drag-n-droppal húzzunk egy `ImageView`-t a layout-ra, állítsunk be egy képet rajta!
6. Nézzük meg, hogy milyen kezdeti pozicionáló attribútumokat helyezett el az editor az xml nézetben (layout_alignParentStart, margók stb.)! Nézzük meg a `RelativeLayout` lehetséges attribútumait itt: [ReleativeLayout paraméterek](https://developer.android.com/reference/android/widget/RelativeLayout.LayoutParams)
7. Állítsuk be a center horizontal attribútumot és adjunk hozzá top margin-t is! Dolgozzunk a design nézeten!
8. Tegyünk le egy name `TextView`-t, írjuk bele a játékos nevét, állítsuk be a font méretet és bold stílust! Pozicionáljuk középre a kép alá!
9. Adjunk ID attribútumot a képnek és a TextVew-nak is!
10. Helyezzünk el egy `LinearLayout`-ot 30dp-vel a név alatt, teljes szélességre állítsuk be! Állítsuk az ID-ját row1-re!
11. A row1 layout-hoz adjunk két TextView-t (ID-k: ageLabel és ageValue). A row1 layout-nak adjunk left és right padding-et!
12. A row1 layout-hoz hasonlóan hozzunk létre további sorokat (row2-row6) a következő adatokhoz: *height, citizenship, position, current club, market value*. A másoláshoz **célszerű átváltani** az xml nézetre.
13. Használjuk a `dimens.xmlt`-t, a `styles.xml`-t és a `strings.xml`-t az egységes stílusok kialakítására és hogy eltüntessük a beégetett szövegeket! Ha a `dimens.xml` nem létezik, hozzuk létre a `res/values` alatt!
14. A név/magasság stb. értékeként a layout-ba égetett szöveget NE vezessük át a strings.xml-be, hanem az attribútomot állítsuk át `tools:text`-re!
14. Az ageLabel, heightLabel stb. `TextView`-knál a szöveget igazítsuk jobbra az `andorid:gravity` attribútum használatával, majd ezekre a komponensekre is csináljunk egyedi stílust!
15. A design nézeten keressük meg az ikont, amivel `landscape mode`-ba át lehet forgatni az előnézetet! Gondoljuk át, mi lenne az ideális layout `landscape mode`-ban!
16. Hozzuk létre a `layout-land` mappát! (A res mappán jobbklikk és new android resource directory, majd válasszuk az orientation qualifier-t, aztán a landscape orientációt!)
17. A `layout-land` mappában a `portrait` képernyőt leíró nézet nevével azonos névvel hozzuk létre az xml-t fájlt és implementáljuk a képernyőt `landscape` nézetben! 
(Először csak egy dummy szöveget tegyünk bele és újra próbáljuk ki a preview elforgatását!)
18. Landscape nézetben konvertáljuk a root view-t egy horizontális `LinearLayout`-tá! Tegyünk bele két konténert 1:2 arányban! A baloldali egy `FrameLayout` legyen, a jobboldali egy `RelativeLayout`!
19. A FrameLayout-ban korlátozott pozicionálási lehetőségeink vannak, csak a `layout_gravity` használatával. 
Másoljuk a portrait nézetből ide a képet és a játékos nevét. A `layout_gravity`-vel pozicionáljunk és adjunk hozzá margókat! Figyeljük meg, hogy a két konténert arányaiban hogyan jeleníti meg a design nézet!
20. Nézzük meg, nem maradt-e az átmasolt widget-ekben olyan attribútum, ami csak a RelativeLayout-ban értelmezhető, de itt a FrameLayout-ban már nem! Ezeket töröljük ki!
21. Másoljuk át a portrait nézetből az *age, height, citizenship, position, current club, market value* property-ket! 
Ezek gyakorlatilag változtatás nélkül átvehetők, mert a portrait nézeten ugyanúgy `ReletiveLayout` volt a parent-jük, mint itt, a landscape nézetben.
22. Váltsunk vissza a portrait nézetre, azon belül a Design tab-re! Az `Orientation for Preview` ikon használatával váltogassunk a nézetek között és jegyezzük meg, 
hogy így mindig lehetőségünk van egy képernyő mindkét orientációját ellenőrizni szerkesztés közben!

### HINTS

* Hardcoded text átalakítása: a szöveget az Android Studio maga is kijelöli eltérő hátérrel, jelezve, hogy tennivalónk van vele! 
Az egérrel álljunk az ilyen  szöveg fölé az xml nézeten és kövessük a buborékban megjelenő utasításokat!

* A styles.xml-be célszerű csak a méretekkel, margókkal, padding-ekkel kapcsolatos dolgokat kivinni, illetve a szélesség/magasság értékeket és a szöveg stílusát. 
A `RelativeLayout` szerinti pozicionálást ebben a gyakorlatban **inkább ne** vezessük ki a stílusokba.

* Logolás:
    Log.d("Some arbitraty ID", "This is a debug log message")

### HÁZI FELADATOK (amennyiben az órán nem jutottunk el idáig)

* Landscape nézetben a UI-t befejezni!
* Futassuk emulátorban a projektet és vegyük észre, hogy a `tools:text`-ként megadott szövegek nem jelennek meg! Ez természetes, mert azok csak design-time információk! 
Állítsuk be az `Activity` kódjából ezeket az információkat!
* További hibákat is tapasztalhatunk a futtató készülék vagy emulátor típusától függően! Például egy 480x800 pixeles Nexus S-en futtatva nem fér ki az összes adat a képernyőre! 
Javítsuk úgy, hogy az age propertytől kezdve mindent beágyazunk egy vertikális `LinearLayout`-ba, majd azt egy `ScrollView`-ba!
* Cseréljük le a citizenship mezőben az országnevet Emoji Flagre! [Emoji Flags](https://emojipedia.org/flags/)
* Írjunk egy modell osztályt, ami egy focista adatait tudja tárolni, és amelyet majd fel tudunk használni a képernyő háttéradatokkal való töltéséhez! 
Gondolkodjunk el azon, hogy az egyes property-khez milyen adattípust célszerű használni!
* Hozzunk létre az Activity-ben két modell objektumot (`player1`, `player2`), majd egy `currentPlayer: Player`-t is! 
Az ImageView és a szövegek tartalmát a `currentPlayer` szerint állítsuk be! Váltogassuk kommentezéssel, melyik játékos a `currentPlayer`! 
Futtassuk az alkalmazást és ellenőrizzük, hogy korrekten megjeleni-e az adott játékos fényképes és adatai!
* Írjunk logolást az `onStart()` metódusba és figyeljük meg, hogy az orientation changed esemény bekövetkeztekor mindig újraindul az Activity!
