# Közös kódírás: Huszonegy app

## Leírás

A magyar kártyával játszott "huszonegyezés" játék jelentősen leegyszerűsített változta.

### Előfeltételek

* enum-ok ismerete
* FrameLayout ismerete
* a 32 kártyalap fényképének elhelyezése a res/drawable-xxhdpi mappában

### UI elemek

ConstraintLayout közepére pozicionálva egy üres FrameLayout, amibe majd programozottan helyezzük el a kártyalapokat.

A kártyalapokat UI szinten ImageView példányok reprezentálják, de modell szinten létrehozunk majd egy Card osztályt is.

Alul egy "Lapot kérek!" gomb, feleatte egy TextView, amelyben kiírjuk, mennyi az emelt lapok összértéke.

## Implementálás lépései

0. Helyezzük el az image-ek resource-okat a `drawable-xxhdpi` mappában!

1. A layout-ot így építsük fel:
    * Root: `LinerarLayout` vertical, match_parent, match_parent
    * `FrameLayout` a kártyapaklinak: match_parent, 0dp, layout_weight: 2, top margin: 20dp
    * `TextView` a lapok összértékének megjelenítésére: match_parent, wrap_content, top/bottom margin: 20dp, gravity: center
    * `Button` amivel lapot lehet kérni: wrap_content, wrap_content, bottom margin: 20dp, layout_gravity: center

2. Modell:  
    class Card(val color: Color, val value: NumericValue)

3. Implementáljuk a `Color` és a `NumericValue` enum-okat a Card osztályon belül! Ehhez figyeljük meg az image resource-ok névkonvencióját! Mindkét enum-nak legyen `toString()` metódusa és egy `val imageNamePart: String` property-je custom getter-rel!

4. Implementáljunk egy `companion object`-et a `Card` osztályon belül, abban pedig egy `fun buildDeck(): List<Card>` metódust!

5. A `MainActivity`-ben helyezzünk el egy változót (deck), amit a `Card.buildDeck()` metódussal példányosítunk!

6. A `MainActivity`-ben helyezzünk egy `private var sum = 0` változót, amelyben a pakliról levett lapok összértékét tartjuk nyilván!

7. A `MainActivity`-ben helyezzünk egy `private var popCount = 0` változót, amellyel a pakliban indexeljük majd az aktuális lapot! (A játék úgy indul, hogy a legfelső lap felfedődik, de ekkor a popCount értéke még nulla. Innentől kezdve minden egyes lap kéréskor fogjuk növelni a popCount-ot.)

8. Implementáljunk egy `private fun loadCards()` metódust, amely a következőket végzi el:
    * Megkeveri a kártyákat
    * Iterál a paklin és minden egyes kártyához megszerez egy resource ID-t, ami egy image drawable-re mutat
    * A cikluson belül létrehoz egy `ImageView`-t és beállítja rajta az image resource-ot
    * Hozzáadja a `FrameLayout`-hoz az `ImageView`-t
    * A ciklust követően megnézi a pakli **legfelső** lapjának az értékét és erre állítja be a `sum` változó értékét. (A legfelső lap egy `Card` példány, annak a `value` property-je a `NumericValue` enum egy példánya, és ennek az enum példánynak van `num` property-je.)
    * A lapok összértékét megjelenítő `TextView`-n megjeleníti `sum` értékét.

9. A `loadCards()` metódust hívjuk meg az `onCreate()` utolsó sorában!

10. Implementáljunk további három metódust, amelyekre szükségünk lesz:
    * `private fun popView()`: leemel egy lapot, azaz eltávolítja a `FrameLayout`-ból a legfelső subview-t
    * `private fun peek()`: index alapján megkeresi a pakliban a legfelső lapot (FONTOS: csak a FrameLayout-ról távolítunk el subview-kat, a paklit reprezentáló modellből, ami egy `List<Card>` típusú lista, nem vesszük ki az elemeket, hanem ott index alapján keresünk!)
    * `private fun hasEnded(message: String)`: ezt a metódust a `peek()`-ből fogjuk meghíni, amennyiben a húzott lapok összértéke eléri vagy meghaladja a 21-et. A két esetben eltérő üzenettel hívjuk meg a metódust. A `hasEnded()` megjeleníti az üzenetet és letiltja a gombot, a játék véget ér.

11. Implementáljuk a gomb eseménykezelőjét! Hívjuk meg benne a `popView()` és a `peek()` metódusokat!

12. Futtassuk az alkalmazást, teszteljük a működést!



### Hints

A játék kezdetén a decket keverjük meg: `Collections.shuffle()`

A FrameLayout-hoz kódból adjuk hozzá a 32 lapot:

    for(c: Card in deck) {
        val resourceId = resources.getIdentifier(c.imageName, "drawable", packageName)
        val image = ImageView(this)
        image.setImageResource(resourceId)
        frameLayout.addView(image)
    }

Amikor leemelünk egy kártyát, meg kell határoznunk a felfedett lap értékét. Az nem elég, hogy a UI-on látjuk az ImageView-t. A pakli mögött lévő modell objektum egy `List<Card>` példány. Az újonnan felfedett lapot ebben a listában is azonosítanunk kell. A lap emelésekor fusson egy `peek()` metódus a következők szerint:

    private fun peek() {
        val revealedCard = deck.get(deck.size - popCount -1)
        sum += revealedCard.value.num
        tvSum.text = sum.toString()

        if (sum >= 21) {
            hasEnded()
        }
    }

Írjunk egy hasEnded() metódust, amely kezeli azt a helyzetet, amikor a lapok összeértéke eléri vagy meghaladja a 21-et. Tiltani kell a gombot és a TextView-ra kiírni egy infót, hogy vége a játéknak, az elért érték ennyi és ennyi.

A modellben egyrészt fel kell vennünk a színekre és a kártyalapok értékeire is egy-egy enumot:

    enum class Color(val title: String) {
        PIROS("Piros"),
        ZOLD("Zöld"),
        TOK("Tök"),
        MAKK("Makk")
    }

    enum class NumericValue(val num: Int) {
        ALSO(2),
        FELSO(3),
        KIRALY(4),
        ASZ(11),
        HETES(7),
        NYOLCAS(8),
        KILENCES(9),
        TIZES(10)
    }

Másrészt szükség lesz a kártyalapot szimbolázáló osztályra, amely a fenti két enumból építkezik:

    class Card(val color: Color, val value: NumericValue) { ... }

A `Card` osztályban egy `companion object` blokkban csináljunk egy metódust, amely összerak egy pakli kártyát. A logika annyi, hogy két egymásba ágyazott for ciklussal végigmegyünk a `Color` és a `NumericValue` enum-okon és képezzük az összes lehetséges szín-érték kombinációt.

     companion object {
        fun buildDeck(): List<Card> {
            ...
        }
    }

### Improvements (házi feladat)

1. A pakliról levett lapok elhelyezése a screen alján kicsiben, egy sorban, scrollozhatóan.

2. A pakli reprezentálása hátlappal felfelé, azaz csak egyetlen ImageView legyen a FrameLayoutban, amit a layout xml-be be is lehet égetni. A "lapot kérek" gomb eseménykezelője így jelentősen módosul. A konkrét lap/lapok, amik a játékosnál vannak, innentől már csak az alsó scrollozható listában látszódnak.

3. "Megállok" gomb hozzáadása a layout-hoz, amennyiben a játékos nem kér több lapot.

4. Játék újrakezdhető legyen anélkül, hogy újraindítjuk az app-ot.

5. A valódi játékszabályokhoz történő bármilyen közelítés. [Játékszabály](https://www.kartya-jatek.hu/huszonegy/)