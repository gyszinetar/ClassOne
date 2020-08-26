# Villámkérdések

## 2020. július 15.

1. Milyen programozási paradigmákat ismersz?
2. Milyen kapcsolat van a Kotlin nyelv és a Java között?
3. Mi a material design?
4. Melyik az az Android komponens, amely felelős a mobil alkalmazás egy képernyőjének kezeléséért?
5. Mi az API Level?
6. Hogyan tudjuk kipróbálni az Android Studióban történő fejlesztéskor az alkalmazásunkat?
7. Mire való a Gradle?
8. Mire való a verziókezelés?
9. Hogyan tudjuk meghatározni, hogy melyik Android verziókon futhat egy mobil alkalmazás?
10. Igaz-e az alábbi állítás: Egy Android alkalmazás csak és kizárólag a `targetSdkVersion` által kijelölt API Level-en lesz működőképes.
11. Igaz-e az alábbi állítás: Egy Android projektben a programozó használhat külső library-ket, amelyeket a Project szintű gradle fájl `dependencies` szekciójában kell felsorolnia.
12. Igaz-e az alábbi állítás: Az AppCompatActivity a `java.lang.Object` osztály leszármazottja és tőle örökli az `onCreate()`, `onStart()` stb. életciklus metódusokat.
 
---

## 2020. július 20.

1. Milyen memória területek fontosak adattárolás szempontjából a számítógépben?
2. Mi a különbség a primitív és a referencia típusok között?
3. Mi a szemétgyűjtés vagy Garbage Collection?
4. Az encapsulation (egységbezárás) alapelv mire vonatkozik?
5. Mi teszi platformfüggetlenné a Java nyelvet?
6. Sorold fel az alapvető adattípusokat a Kotlin nyelvben!
7. Mit jelent a resources fogalom egy android projektben, hogyan jelenik meg tárolási és programozási szempontból?
8. Mire valók az Intent-ek?
9. Mi a broadcasting szerepe az Android platfomban?
10. Mi a nullability fogalom a Kotlinban, milyen problémát lehet kiküszöbölni a helyes használatával?
11. Mi a val, var és const val kulcsszavak szerepe és használata a Kotlinban?
12. Mire való a let function és mi az Elvis operátor?

---

## 2020. július 22.

1. Mi a type inference? Szemléltesd példákkal!
2. Mi a not null assertion operátor?
3. Mi a range operátor?
4. Mi a változónevekre vonatkozó konvenció a Kotlinban és a Java-ban?
5. Mi a when() kifejezés a Kotlinban, hogyan működik?
6. Hogyan tudunk ciklust írni Kotlinban? Ismertess több lehetőséget is!
7. Hogyan tudunk visszafelé számláló ciklust írni?
8. Mi a konstruktor? Hányféle konstruktor van a Kotlinban? Melyikre mi jellemző?
9. Mik a getter/setter metódusok?
10. Mi az állapot és a referencia szerinti egyenlőség?
11. Mi a data class?
12. Mi a különbség az osztály és a példány között? Magyarázd meg a fogalmakat!

---

## 2020. július 27.

1. Miért került bevezetésre a logikai pixel (density independent pixel) az Android platformon?
2. Mire vonatkozik a fragmentation?
3. Sorold fel a density bucket-eket!
4. Egy `mdpi` felbontáshoz tartozó 32x32 pixeles képi erőforrást milyen egyéb méretekben kell elkérnünk a grafikustól? 
5. Sorold fel a különböző densitiy bucket-ekhez tartozó képi erőforrások méreteire vonatkozó arányszámokat!
6. Milyen mértékegységben adjuk meg a betűméreteket egy Android projektben?
7. Milyen kintüntetett szerepű erőforrás fájl generálódik a build process során?
8. Mi a UI widgetek ősosztálya?
9. Mik a Layout managerek? Mi az ősosztályuk?
10. Jellemezd a GirdLayout-ot!
11. Hogyan lehet megadni egy UI elem szélességét és magasságát xml-ben?
12. Mi a különbség a `match_parent` és a `wrap_content` között?


## 2020. július 28.

1. Milyen lehetőségeink vannak az Android platformon a user interface implementálásra?
2. Milyen nézetek vannak az Android Studio layout editorban? 
3. Mi az orientation change és miért fontos?
4. Jellemezd a LinearLayout-ot!
5. Mire való az `orientation` attribute és milyen értékeket vehet fel?
6. Mi a különbség a paddig és a margin között?
7. Jellemezd a RelativeLayout-ot!
8. Jellemezd a FrameLayout-ot!
9. Melyik attribútum segítségével lehet a FrameLayout-on belül pozicionálni a subview-kat?
10. Mi a különbség az ImageView és az image drawable között?
11. Lehetséges-e egy képernyőt több változatban is implementálni egy Android projektben?
12. Mi a styles.xml a dimens.xml és a string.xml szerepe?


## 2020. augusztus 3.

1. Mi az öröklődés az OOP-ben, miért használjuk, milyen előnyökkel jár?
2. Mi az öröklődés szintaxisa a Kotlinban?
3. Mi az init blokk?
4. Mit tudunk a konstruktorhívásokról az öröklődéskor?
5. Mi öröklődik az öröklődés során, mi kell ahhoz, hogy valami örökölhető legyen?
6. Igaz-e az alábbi állítás: a Kotlin azért is modernebb programnyelv, mint a Java, mert szakított az idejétmúlt single inheritance koncepcióval.
7. Igaz-e az alábbi állítás: Ha Animal ősosztály leszármazottja a Mammal (emlős), és a Mammal leszármazottja a Dog, akkor a Dog-ra igaz lesz az IS-A reláció, mind a Mammal, mind az Animal vonatkozásában.
8. Mit jelent az, hogy a gyermek mindig beugorhat a szülő helyett?
9. Milyen kihívások elé állítja bármilyen mobil platformon a fejlesztőket a listás adatok megjelenítésének igénye?
10. Hogyan működik a RecyclerView?
11. Mi az interfész koncepcióban a Java-ban és a Kotlinban?
12. Ha a klikkelés eseményre szeretnénk reagálni egy Android projektben, melyik interfészt kell implementálnunk?


## 2020. augusztus 12.

1. Mi a mutability/immutability fogalom?
2. Hogyan jelenik meg a mutability/immutability fogalom változók létrehozásakor?
3. Mit tudsz az Array adattípusról?
4. Mire valók a kollekciók, milyen igény hívta életre őket?
5. Milyen kollekció típusok léteznek?
6. A mutability/immutability hogyan jelenik meg a kollekciók esetében?
7. Magyarázd el az == és az === operátorokat a Kotlin nyelvben! Mi ezeknek a megfelelője Java-ban?
8. Milyen speciális tulajdonsága van a Set (halmaz) implementációnak?
9. Hogyan dönti el a halmaz implementáció, hogy beenged-e egy elemet?
10. Igaz-e az alábbi állítás: a Person nem használható Map kollekció kulcsaként csak akkor, ha felülírtam a hashCode és az equals metódusokat.
11. Igaz-e az alábbi állítás: a val-ként listOf()-fal létrehozott, elemek nélküli példány nem sok mindenre jó, 
mert sem az állapota nem mutálható (elem nem adható hozzá), sem pedig a változó referenciával nem lehet átmutatni egy másik objektumra a heap-en.
12. Igaz-e az alábbi állítás: a var-ként, listOfNulls()-szal létrehozott példánynak utólag értékül lehet adni akár Int-eket, akár String-eket tartalmazó listát.


## 2020. augusztus 24.

1. Mi a ConstraintLayout?
2. Mi a bias?
3. Mi történik egy a parent-jéhez layout_constraintStart_toStartOf és layout_constraintEnd_toEndOf constraint-ekkel hozzákötött widget-tel akkor, 
ha a szélességét wrap_content-ről átállítjuk match_constraint-re (0dp-re)?
4. Mik az enum-ok?
5. Mi az activity stack és milyen adatszerkezetet valósít meg?
6. Milyen állapotokban lehet egy activity a láthatóság szempontjából?
7. Fejlesztőként hogyan értesülünk egy activity állapotváltozásairól?
8. Mely életciklus metódusok jelölik ki az activity foreground állapotát?
9. Mely életciklus metódusok jelölik ki az activity visible állapotát?
10. Mely életciklus metódusok jelölik ki az activity teljes életciklusát?
11. Mi a dynamic state és a persistence state?
12. Mik a fragment-ek, hogyan kommunikálhatnak az activity-vel?
