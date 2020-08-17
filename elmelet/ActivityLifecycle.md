# Activity életciklus, perzisztens és dinamikus állapot

Egy Activity több állapotban lehet az Android rendszerben.

* Aktív (fut): az ún. *activity stack* legtetején van, ő az, akivel a felahsználó foglalkozik éppen
* Szüneteltetve van (paused): látható, de nem bizos, hogy teljes egészében, lehet, hogy egy másik activity részben kitakarja. 
Az viszont biztos, hogy nincs fókuszban, a felhasználói interakciónak nem tárgya jelenleg. Nagyon könnyen vissza tud kerülni az activity stack tetejére.
* Megállított: az activity teljes egészében takarva van, nem látható és nem is tud fogadni felhasználói bevitelt. Többnyire megőrzi ebben az állapotában 
az összes információt, amire szüksége lesz majd, amikor újra az activity stack tetejére kerül, **de** nagy esélye van arra, hogy ha a rendszer erőforrás
szűkébe kerül, akkor végleg megszünteti az Android a példányt.
* Elpusztított, halott: a rendszer megszüntette, vagy az Activity saját maga hívta meg önmagán a `finish()` metódust, mert befejezte a feladatát.


## Lifecycle metódusok

* onCreate
* onRestart
* *onRestoreInstanceState*
* onStart
* onResume
* *onSaveInstanceState*
* onPause
* onStop
* onDestroy

<ins>FONTOS:</ins>
Minden életciklus metódusban hívjuk meg az ősosztály implementációját az adott metódusra a `super`-en!

## Lifecycle a láthatóság szempontjából

* teljes életciklus: onCreate-től onDestroy-ig
* az activity látható: onStart-tól onStop-ig (előtérben van, de nem feltétlenül ő van az activity stack legtetején)
* az activity látható **és a felhasználó elsődlegesen vele van interakcióban**: onResume-tól onPause-ig

## Persistent és dynamic state

Az Activity-nek gyakran szüksége van tárolt adatra, illetve a felhasználó által elvégzett módosításokat általában szükséges perzisztensen tárolni.
Jellemzően a perzisztens adatok (az adatmodell) beolvasása/visszaírása alkalmazás indításonként egyszer történik meg. 
Más szavakkal ezen adatok írásának/olvasásának peridikussága többnyire az alkalmazás indítások gyakoriságával egyezik meg.

Nem szabad elfeledkeznünk arról, hogy a UI-nak is van állapota! Ezt nevezzük *dynamic state*-nek.

Az alkalmazás élete során egy Activity akár többször is végigmehet az onStart-onStop ciklusokon, 
sőt, ha az Android rendszer úgy dönt, egy háttérben lévő activity-t tetszése szerint kidobhat, megszüntethet. 

Egy háttérbe került, majd onnan visszatérő alkalmazás képernyőjén a felhasználó jogosan várja el, hogy a beviteli mezők, rádió gopmbok stb. abban az állapotban legyenek, 
mint amikor félretette az alkalmazást. A widget-ek általában gondoskodnak az állapotuk megőrzéséről, de mégis **lehet olyan eset, amikor azt tapasztaljuk, hogy ez nem történik meg**.

**A fejlesztőnek fel kell készülnie arra, hogy a következő futáshoz szükséges adatokat a megfelelő időben kimentse.** 

**Olykor még a user interface állapotára vonatkozó információt is mentenünk kell!**

A layout xml-ben meg lehet adni widget-enként, ha nem szeretnénk, hogy a komponens állapota mentésre kerüljön:
    `android:saveEnabled="false`
    
A widget-ek automatikus állapotmentése nem mindig működik. Előfordulhat, hogy ha nem írjuk felül az `onSaveInstanceState()` 
és az `onRestoreInstanceState()` metódusokat, akkor a háttérből visszatérve a widget elfelejti az állapotát.

A mentést és visszaolvasást végző lifecycle metódusok `Bundle` objektumot vesznek át. A Bundle objektum példány tárolásáról arra az időre, 
míg az alkalmazás a háttérben van az Android rendszer gondoskodik. Nekünk nincs más dolgunk, mint a mentést és visszaolvasást végző metódusokat
üres törzzsel implementálni (`super` hívás ajánlott!), és innentől minden automatikusan megtörténik.

## `onConfigurationChanged()` metódus

Az eszköz elforgatásakor az éppen aktív Activity-t az operációs rendszer **elpusztítja és újra példányosítja**! Ez azt jelenti, hogy az életciklusa 
 az `onCreate()`-től kezdve újraindul. Ezt a viselkedést az `AndroidManifest.xml`-ben ki lehet kapcsolni, minden egyes Activity-nél egyenként: 
 
    android:configChanges="orientation|fontScale"
    
A fenti kódrészlet a manifest fájlban úgy konfigurálja az Activity-t, hogy **ne induljon újra** amennyiben elforgatják az eszközt vagy a rendszerben a felhasználó
átskálázza a betűméretet. (Mind a betűméret állítás, mind az eszköz elforgatása az Androidban "konfiguráció változást" jelent.)
 
 Ha szeretnénk kódból is reagálni a "konfguráció változás" eseményére, akkor felül kell írnunk az onConfigurationChanged()` metódust.