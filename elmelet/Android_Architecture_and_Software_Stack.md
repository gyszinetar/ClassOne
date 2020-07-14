# Android architektúra és software stack

## Rendszer követelmények

- minimum 4GB RAM, ajánlott 8GB (de jobb a minél több!)
- 4GB üres hely a  háttértáron
- 32 vagy 64 bites op. rendszer, emulátor 64 bites op. rendszeren fut csak
- Android SDK, Android Development Tools, AVD Manager

## Jellemzők

Eredeti fejlesztő cég az `Android Inc.`, amelyet 2005-ben megvásárolt a Google, majd 2007-ben több cég részvételével létrejött az `Open Handset Alliance` nevű szervezet, amely összefogja és irányt szab az Android fejlesztésnek.

Első Androidos eszköz 2008-ban jött ki.

[Market share worldwide](https://www.kantarworldpanel.com/global/smartphone-os-market-share/)

[Open source és ingyenes](https://source.android.com/)

[Verziók](https://hu.wikipedia.org/wiki/Android-verzi%C3%B3k)

A felhasználók bug riportokat küldhetnek be.

Rengeteg gyártó eszközén fut egy **sajátos üzleti modellben** (nem úgy, mint pl. az iOS, ami csak Apple eszközökön fut). Pl. a Samsung telepíti az eszközeire az Androidot és úgy árulja a hardvert. Ebben az üzleti modellben az Android operációs rendszer egy ún. `OEM - Original Equipment Manufacturers - komponens`, a végterméket előállító céget pedig `Value Added Reseller`-nek nevezik. Mindez javítja és felgyorsítja a termék innovációjátt.

[Google Play](https://play.google.com/store)

Java, Kotlin.

Multitouch screen, gestures.

Szenzorok, speciális hardverek és technológiák az eszközben (BT, NFC, GPS, accelerometer, gyroscope stb.)

[Android Studio](https://developer.android.com/studio)

## Mi az Android platform és hogy épül fel?

- Linux alapú operációs rendszer
- Runtime environment, azaz futási környzet mobil alkalmazások számára
- Middleware (a hardware és a software között egy köztes réteg, ami közvetít)
- Különböző library-k és rendszerszolgáltatások
- Gyári alkalmazások
- Felhasználó által telepített alkalmazások

> [Platform architektúra](https://developer.android.com/guide/platform)

<ins>Linux Kernel</ins>
A kernel egy operációs rendszer mag, azaz nem egy teljes értékű operációs rendszer. Preemptiv multitaskingot használ arra, 
hogy egyszerre (vagy kvázi egyszerre) több folyamat és alkalmazás is futhasson. Az operációs rendszer feladata az erőforrások való hozzáférés menedzselése,
(pl. memória vagy tárhely); továbbá a hardver vezérlése (képernyő, billentyűzet, mikrofon, GPS, WiFi stb.); hálózati kapcsolatok menedzselése, telefónia (hívás indítás, fogadás).

<ins>Android Runtime (ART)</ins>
A futtató környezet azon része, amely a store-ból letöltött alkalmazást tovább transzformálja olyan formátumra, 
amely az eszköz processzora által értelmezhető utasítások sorozatából áll.
Amikor buildeljük a kódot az Android Studióban, a végső formátum egy .apk file, ami egy ún. intermediate bytecode formáttum. 
Erre is van egy betűszó, a `DEX (Dalvik Executable)`.

Régebben az Android Runtime ezt a DEX formátumot közvetlenül futtatta. Aztán ezt továbbfejlesztették, és létrejött az ún. `Ahead-of-Time (AOT)` 
fordítási/transzformálási technológia, 
ami tovább processzálja a DEX formátumot. Ennek az új formátumnak a neve `Executable and Linkable Format (ELF)`. A lényeg, hogy végül egy 
olyan natív kód, gépi kód jöjjön létre, amit az adott hardver processzora értelmezni tud.  
 
Az AOT fázis csak a legelső futtatáskor kell hogy megtörténjen, minden további futtatás már gyorsabb, mert a végleges ELF verziót használja már. 
Régebben az Android rendszer az ún. `JIT compilation` technológiát használta az alkalmazás kódjának futtatására, 
ami egy külön virtuális gépet indított el, ami értelmezte a bytekódot.

<ins>Application Framework (Java API Framework)</ins>
Ez már egy mélyebb absztakciós szint, ami tükrözi a komponens alapú Android technológiát. Vannak az "Android programozás" néven ismert puzzle-nak
 olyan alap építőkövei amelyek minden (vagy a legtöbb) alkalmazásban megtalálhatók. 
Ezek újrafelhasználható szoftver darabkák, vagy koncepciók; újrafelhasználhatók legalábbis az adott app-on belül, de vlmilyen általános paradigmát, megoldást képviselnek. 
Ezek létéhez, működéséhez kell egy "kiszolgáló személyzet", vagy futási környezet, ami szabályozza és keretbefoglalja ezeknek a komponensek a működését.

Hogy mik ezek a puzzle darabok, azt mindjárt megnézzük a következő alfejezetben. 
Hogy mik azok a "szolgáltatások", amik ezeknek a működését lehetővé teszik, arra itt az alábbi felsorolás:
 
- Activity Manager (application és activity lifecycle biztosítása)
- Content Provider (alkalmazások saját adatainak megosztása más alkalmazásokkal egy szabványos felületen keresztül, pl. a névjegyek, kontaktok adatainak felkínálása más app-oknak)
- Resource Manager (színek, képek, layout-ok, képernyő leírók, nyelvi fordítások kezelése; minden ami nem forráskód az app-ban)
- Notification Manager (push üzenetek, különböző alert-ek megjelenítésére szolgáló alrendszer)
- View System (szabványos android kontrollok, widget-ek)
- Package Manager (a telefonra feltelepített minden app azonosítható egy egyedi package-dzsel; a package nevek alapján tudja felmérni, ellenőrizni a rendszer, hogy egy adott alkalmazás telepítve van-e vagy sem)
- Telephony Manager (a telefon szolgáltatóval való kapcsolatért felelős alrendszer, jelerősség, adott frekvenciájú vivőjelre kapcsolódás stb.)
- Location Manager

## Az Android "puzzle" elemei programozási szempontból

- <ins>Activity</ins>: általában megfelel az alkalmazás egyetlen képernyőjét leíró logikának. 
Képernyőnként egy-egy activity-t szokás írni, de ez nincs kőbe vésve, vannak más technikák is. 
Az actiivty életciklusa során betölti az adott képernyő tartalmát és kezeli az ott történő felhasználói bevitelt. 
Egy ős Activity osztálytól származik minden activity. Újrafelhasználható komponens. Az Android rendszer jellegzetessége, 
hogy elvben megvan az a lehetőség, hogy egy mobil app belépési pontja egy tetszőleges activity legyen. 
Tehát elvben elindulhat egyszer mondjuk az A activity-n keresztül, mint belépési pont, másszor meg mondjuk a B activity-n keresztül. 
Persze az alkalmazás üzleti logikájának olyannak kell lennie, hogy ennek legyen értelme és ne történjen hiba egyik esetben sem. 
Még tovább menve az Android app-ok publikussá tehetik egyes activity-jeiket más app-ok számára, akik használnák az adott funkcionalitást. Például ha írok 
egy teljesen átlagos, bármilyen app-ot, és abban szükség van email küldésre, akkor a megfelelő programozói ismeret birtokában meg tudom hívni a rendszer 
alapértelmezett email küldő alkalmazását az én alkalmazásomból. Tehát az én alkalmazásomban nem kell külön fejlesztenem egy email küldő modult, hanem egy 
másik app megfelelő activity-jét használhatom erre.

- <ins>Intents</ins>: Olyan mechanizmus, amellyel az activity-k elindíthatók. Azáltal pl. hogy egy activity egy Intent segítségével el tud indítani 
egy másikat, máris lehetővé válik a képernyőről-képernyőre, vagy activity-ről activity-re való navigálás lehetősége. Szintén ez az a mechanizmus, ami a fent 
említett scenariot - miszerint a saját alkalmazásomból indítom egy másik alkalmazást egy konkrét activity-jét - lehetővé teszi. Maga az Intent lehetővé teszi
azt is, hogy az indítandó activity-nek adatokat tudak átadni, amikkel majd dolgozni fog.

- <ins>Broadcast Intent</ins>: egy speciális intent, amellyel bele lehet "kiáltani az éterbe", minden alkalmazás számára aki jelen van az eszközön. Az egyes
alkalmazások a puzzle egy másik darabkájával, egy Broadcast Receiver-rel jelzik a feliratkozásukat erre a speciális broadcast Intent-re. Amikor életre kel 
az Intent, akkor a feliratkozott receiverek erről értesítést kapnak és kedvük szerint reagálhatnak. Tipikusan maga az Android rendszer (is) küldhet ilyen 
broadcast üzeneteket pl. arról, amikor a készüléket elfordították a portrait és a landscape orientációk között, vagy amikor ki/be kapcsolaták a wifit és 
rácsatlakozott/lecsatlakozott az internetre stb. Van lehetőség a broadcast-ot kiküldeni minden érdekeltnek, vagy valamiféle láncolt processzálást
alkalmazni, ahol a receiver-ek sorban egymás után kapják a feldolgozás lehetőségét majd döntenek arról, hogy a következő receiver is megkapja az üzenetet, 
vagy hogy itt véget érjen a lánc.

- <ins>Broadcast Receivers</ins>: ők azok a komponensek, akikben megírhatom azt a logikát, amit egy adott Broadcast Intent beérkezésekor futtatni akarok. 
A broadcast receivert alkalmazás szinten regisztrálni kell, és `Intent Filter`-rel lehet konfigurálni, hogy milyen típusú intent-ek kezelője szeretne 
lenni ez a receiver. Amikor az adott típusú Intent kiküldésre kerül az Android rendszer, vagy valamely app által, akkor minden egyes receiver, aki arra az Intent
típusra feliratkozott értesítésre kerül, függetlenül attól, hogy az az alkalmazás amelyben be lett regisztrálva, fut-e éppen. 
Magyarul a receiver "felébresztésre kerül", mint egy önálló, a saját alkalmazásától akár függetlennek is tekinthető komponens. Természetesen a recevier
kódjában aztán írhatok olyan utasításokat, ami az adott alkalmazás más részeit is felébreszti, de akár csendben a háttérben is csinálhatok valamit, anélkül
hogy a többieket "zavarnám".

- <ins>Services</ins>: ez a komponens jellemzően a háttérben szokott futni és ott csinál valami feladatot, aminek többnyire nincs user interface vonzata. 
Tipikusan service-ként szokás megírni olyat, amikor pl. zenét kell lejátszani a hattérben, tehát audio streaming, aminek folytatódnia kell akkor is, 
amikor az eszköz alvó állapotba megy. Egy másik példa, amikor az alkalmazásnak gyűjtögetnie kell a GPS adatokat arról, hogy merre jár az eszköz.

- <ins>Content Providers</ins>: olyan mechanizmus, vagy komponens, amely szabványos megoldást kínál arra, amikor egy alkalmazás az általa kezelt adatokat,
adatstruktúrákat meg akarja osztani másik alkalmazásokkal. Pl. amikor a média lejátszó felkínálja az audió listát lekérdezésre másik app-oknak, vagy a
kontaktokat kezelő gyári app felkínálja a kontaktok listáját.

- <ins>Manifest XML fájl</ins>: ez egy "ragasztó", vagy nevezhetem egy adminisztrációs fájlnak is, amiben az alkalmazás összes komponensét fel kell sorolnom
megadott szabályok, szintaxis szerint (activity-k, broadcast receiver-ek, engedélyek, amikre az app-nak szüksége van a működéshez stb.)

- <ins>Resources</ins>: az alkalmazás nem csak forráskódból áll. Lehetnek képek, hangfájlok, különböző nyelvekre lefordított szövegek, amiket összességében
resource-oknak nevezünk. Szintén egy nagy és fontos csoport a resource-ok között a képernyő leíró fájlok, amelyek most még jelen állás szerint XML fájlok
formájában léteznek egy android app-ban. Fontkészletek illetve különféle stílus leíró fájlok, ún. theme-ek is ide tartoznak.

- <ins>Application Context</ins>: az előző pontban, a resource-ok között elég sok dolgot megemlítettünk, ezekre mind szükség lehet a kódban is. Tehát kell
lennie valami mechanizmusnak arra, hogy a Kotlin kódból tudjunk hivatkozni pl. egy képfájlra, vagy egy színre, vagy egy fontkészletre. Ezt úgy oldja meg az 
Android rendszer, hogy az összes resource-hoz képződik egy egyedi azonosító, egy Integer számérték, illetve egy szöveges resource lokáció, 
ami egy névkonvenció. A forráskód fordításakor generálódik egy R nevű osztály, ebben kerülnek bele a resource-oknak ezek a hivatkozásai. Illetve még fontos
infók tárhelye a manifest xml. Ezekhez így együtt egy ún. application context objektumon keresztül lehet hozzáférni kódból. Az `android.content.Context` osztály
egy példányát kell megszerezni és akkor minden ilyen resource-hoz hozzá tudunk férni a kódból.

---

[KÖVETKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/elmelet/AndroidStudio.md)