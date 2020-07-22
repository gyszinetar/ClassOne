# Bevezetés az Android Layout rendszerbe

A view rendszer épp nagy átalakuláson megy át: eddig XML-ben írtuk le, most kezd bejönni a **Jetpack Compose library**, ami majd lehetővé teszi, hogy Kotlin kódból, dekleratívan írjuk le a user interface-t.

UI-t készíteni nagy kihívás a developernek mert

* számtalan gyártó készüléke van forgalomban
* eltérő képernyőmérettel (width x height)
* eltérő felbontással
* eltérő form faktorral
* ráadásul egy adott készüléket lehet `landscape` és `portrait` módban is használni

[Form factor jelentése](https://www.phonescoop.com/glossary/term.php?gid=4)

A fenti sokszínűség elnevezése: **fragmentation**.

Android Nougat-ban bejött az ún. *multi-window support*, azaz, hogy a nagyobb méretű készülékeken a képernyőt meg lehet osztani több alkalmazás között.

## Density Independent Pixel (dip vagy dp)

Mennyi pixelt tartalmaz a képernyő 1 inch x 1 inches területe. Ez az érték a **dots per inch** (dpi).
Gyártófüggő. Ha csak a képernyőméreteket tudjuk két telefonról és azok egyenlőek, az még nem jelenti azt, hogy a felbontásuk is azonos lesz. 
Nem lehet szimplán pixelben megadni a UI elemek méretét, **mert egyre nagyobb felbontásnál egyre kisebb méretű widgeteket kapnánk**.

[Magyarázó ábra ebben a cikkben](https://blog.mindorks.com/understanding-density-independent-pixel-sp-dp-dip-in-android)

Az egyszerűbb kezelhetőség és tervezhetőség érdekében megalkottál a *logical pixel density* fogalmát,  és ún. **density bucket**-eket, kitüntetett felbontás értékeket definiáltak. Kiemeltek hat értéket és elnevezték őket:

* 120 DPI: `ldpi` (low)
* 160 DPI: `mdpi` (medium)
* 240 DPI: `hdpi` (high)
* 320 DPI: `xhdpi` (extra high)
* 480 DPI: `xxhdpi` (extra-extra high)
* 640 DPI: `xxxhdpi` (extra-extra-extra high)

<ins>Mégis hány fizikai pixelt jelent egy logikai pixel?</ins>

Felbontás függő, azaz density bucket-függő.

* `mdpi` felbontásnál 1 dip egyenlő 1 fizikai pixellel
* `xhdpi` felbontásnál viszont 1 dip egyenlő 4 fizikai pixellel, azaz egy 2x2-es pixel "ráccsal"
* `xxhdpi` felbontásnál 1 dip egyenlő 9 fizikai pixellel, azaz egy 3x3-as pixel "ráccsal"
* `xxxhdpi` felbontásnál 1 dip egyenlő 16 fizikai pixellel, azaz egy 4x4-as pixel "ráccsal"

Képlet:

    px = dp * (dpi / 160)

<ins>Designereknek a képek méretezésével kapcsolatban:</ins>

A kiindulási méret (1:1 arány) az `mdpi`.

Tehát pl. ha egy 32 x 32 pixeles képet rajzol a designer, akkor a következő méreteket kell a fejlesztő rendelkezésére bocsátania:

* `mdpi`: 1x, azaz 32x32 pixel
* `hdpi`: 1.5x, azaz 48x48 pixel
* `xhdpi`: 2x, azaz 64x64 pixel
* `xxhdpi`: 3x, azaz 96x96 pixel
* `xxxhdpi`: 4x, azaz 128x128 pixel


[Magyarázó ábra itt](https://developer.android.com/training/multiscreen/screendensities)

<ins>FONTOS:</ins> 

az `mdpi` egy kitüntetett érték, ez a "baseline", itt a logikai pixel érték megegyzeik a fizikai pixel értékkel. A densitiy independent pixel bevezetésének célja, hogy eltérő készülékeken is azonosak legyenek a UI elemek az Android app-okban. Illetve hogy a designer (és a mobil app fejlesztő) dolga is egyszerűbb legyen. Onnantól kezdve, hogy elkezdjük DP egységben mérni/megadni a UI elemeink méretét, az összes készüléken (felbontástól függetlenül) azonos elrendezést fogunk kapni.

<ins>Érdekesség:</ins>

Az emberi ujj (fingertip) mérete 50dp. Ennél kisebb méretű kontrol nehezen klikkelhető.

<ins>Konklúzió</ins>

A density independent pixel (dip vagy dp) tehát egy olyan absztrakciós számítási módszer, ami eltünteti a különbözőségeket a különböző felbontású eszközök képernyője között. Nem pixellel dolgozik a fejlesztő, azaz a szélességeket/magasságokat nem pixelben, hanem dip-ben adja meg!

## Scalable pixel (sp)

Ugyanazt a szerepet tölti be, mint a dp, de ez a szöveg méretekre vonatkozik (`android:textSize` attribútum). Igazodik a felhasználó által az eszközön beállított font preference-hez.

[Hogyan támogassuk a különböző felbontású eszközöket?](https://developer.android.com/training/multiscreen/screendensities)

## View, ViewGroup, LayoutParams

`View` ősosztály a felelős egy négyzet alakú terület kirajzolásáért és az ott jelentkező események kezeléséért a képernyőn. Tőle származik az összes *widget*, de a `ViewGroup` is. A `ViewGroup` egy láthatalan konténer komponens, amely az összes layout őse. A layout-ok feladata, hogy összefogjanak több child widget-et. Egy ViewGroup-ban lehetnek további nested (beágyazott) layout-ok.

`LayoutParams`: a különböző ViewGoup-ok ezen keresztül kapnak/osztanak meg egymással property-ket, layout_width, layout_height.

A view-knak és a view group-oknak megvan az a tulajdonságuk, hogy ki tudják számítani a saját területüket, pl. egy `TextView` a benne lévő szöveg hossza és a font méret alapján tudja számolni a saját méretét. Gyakran a view-kat úgy pozicionáljuk, hogy egymáshoz képest adjuk meg az elhelyezkedésüket. Emellett az Android OS is számon tartja, "méri" az egyes komponensek képernyőn elfoglalt helyzetét, tehát az Android-ban az activity lifecycle során egy fontos futási feladat a UI-t alkotó viewk és view group-ok méretének beállítása, egymáshoz képest való pozicionálása.

A mindenkori view hierarchia lerajzolható egy fastruktúrába. Fontos, hogy minden elemnek csak egyetlen parent-je lehet az Andoid UI-ban. Minden egyes view-hoz meg kell adni két kötelező attribútumot az xml-ben:

* `layout_width`
* `layout_height`

Két beépített érték létezik erre az attribútumra:

* `match_parent`
* `wrap_content`

Fentieken túl számértékkel is meg lehet adni, ha egy fix szélességet/hosszúságot szeretnénk a view-nak.

Speciális érték a **0dp**. Ez többnyire azt jelenti, hogy a rendelkezésre álló helyet vegye fel, amit a szomszédos elemek hagynak neki az adott dimenzióban (szélesség vagy hosszúság).

## UI frissítés

Az Android rendszer 3 lépcsős folyamatban frissíti a képernyőt:
1. végigmegy a view hierarchián és meghatározza (megkérdezi) az egyes view-k méretét (szélesség/magasság)
2. újra végigmegy a view hierarchián és pozicionálja az egyes view-kat
3. újra végigmegy az egyes view-kon és mindegyikhez létrehoz egy ún. `Canvas` objektumot, amire rajzolni lehet; erre rajzolja meg a view-kat

Ez a folyamat jól működik egyszerűbb (flat) hierarchia esetén; komplex, egymásba ágyazott hierarchia esetén rossz a performanciája.

## dimens.xml

Méreteket szokás megadni ebben a resource file-ban.

	<?xml version="1.0" encoding="utf-8"?>
	<resources>
    		<dimen name="list_item_height">72dp</dimen>
	</resources>


## Margins

A `margin` (margó) egy view külső széle és a szomszédos view külső széle közötti távolság. 
Más megfogalmazásban: **a margin a view-n kívül van**.

<ins>Beállítása:</ins>
`android:layout_margin` attribútummal globálisan, vagy oldalanként.

## Paddings

A `padding` egy view külső széle és a view tartalma (pl. a renderelt szöveg) közötti távolság.
Más megfogalmazásban: **a padding a view-n belül van**.

## RelativeLayout

Relatív pozicionálás a parent-hez és a többi child-hoz képest. Erőssége ill. célja: a parent-child relationship a view-k között megörződjön, ha változik a képernyőméret vagy a felbontás (értsd: másik méretű/képernyő készüléken is azt az elrendezést mutassa, mint amelyiken terveztem/kipróbáltam). Utóbbi években háttérbe szorult, mert a ConstraintLayout ugyanezt tudja.

### Attribútumok a pozicionáláshoz

A `RelativeLayout.LayoutParams` osztály definiálja az szóba jöhető xml attribútumokat.
[Javadoc](https://developer.android.com/reference/android/widget/RelativeLayout.LayoutParams)

> Gyakorlás: hozzunk létre két fix méretű `View`-t egy `RelativeLayout`-ban és próbáljunk ki néhány pozicionáló attribútumot!
> Gyakorlás: hozzunk létre `LinearLayout`-ot néhány subview-val, majd konvertáljuk `RelativeLayout`-tá!

### Gravity

* `android:layout_gravity`: a layout-on belül pozicionálja a view-t 
* `android:gravity`: a view-on belül pozicionálja a tartalmat (pl. egy `TextView`-ban balra/jobbra/középre húzza a szöveget)


## Dependency hozzáadása (alternatív módszer)

`File > Project Structure > Dependencies > app > + > Library Dependency` majd a Search-be beírni mondjuk hogy "picasso".

## LinearLayout

Vertikális vagy horizontális; a subview-ok egymás után pakolódnak bele az `android:orientation` által kijelölt dimenzióban. Grid-szerű megjelenítés is kialakítható, LinearLayout-ok egymásba ágyazásával. A túl mély egymásba ágyazást kerülni kell, mert rossz user experience-t okozhat.

### layout_weight és 0dp

Ha specifikálni akarom, egész pontosan hány widget férjen ki a `LinearLayout` adott dimenziójában, akkor azt a `layout_weight` attribútummal tudom súlyozni. Egész pontosan azt tudom vele megadni, hogy az adott subview a teljes dimenziónak mekkora részét foglalja el.

A `0dp` hatása az adott dimenzióban gyakran az, hogy az adott view töltse ki a maradék helyet.

> Gyakorlás 1: hozzunk létre horizontális `LinearLayout`-ot először két, majd három subview-val; színezzük őket eltérően; adjunk különböző `layout_weight` értékeket (1, 2, 3)!

> Gyakorlás 2: hozzunk létre vertikális `LinearLayout`-ot; felülre tegyünk egy `TextView`-t, magassága legyen `wrap_content`, majd adjunk hozzá egy-, kettő- és végül három színes hátterű `View`-t, melyek magassága 0dp legyen! Játsszunk a `layout_weight` attribútumokkal!

## FrameLayout

Ha olyan elrendezés kell, ahol a view-k átlapolják, kitakarják egymást. 

Tipikus használati módok:

* `ProgressBar` elhelyezése egy betöltődő lista (`RecyclerView`) felett, ahol mindketten egy `FrameLayout`-ban kerülnek elhelyezésre
* "Empty view" elhelyezése egy lista felett, amennyiben a lekérdezés nulla elemet ad vissza

## Configuration changes

Itt azt vizsgáljuk, hogy kell reagálni a UI-nak a telefon elforgatására.

Lehetséges a res mappa alatt olyan almappákat felvenni, amelyek különböző qualifier-ekkel bírnak. Így például az orientation is egy qualifier. Landscape módhoz külön layout-okat hozunk létre egy megfelelő qualifier-rel ellátott mappa alatt.

> Gyakorlat 1: Hozzuk létre a layout-land mappát! (res mappán jobbklikk `New > Android resource direcotry > Resource type: layout > qualifier: Orientation > Landscape`)

> Gyakorlat 2: Egy portrait nézetű details screen-hez csináljuk meg a landscape nézetet is! A `layout-land` mappa alatt ugyanazzal a névvel kell létrehozni az xml fájlt, mint a default (portrait) verzióját!

---

[KÖVETKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/elmelet/UI-Elements.md)
