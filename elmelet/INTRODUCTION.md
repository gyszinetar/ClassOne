# Android és Kotlin programozás tanfolyam - 2020

## Bevezetés

### Mit fogunk tanulni? Mennyire szerteágazó tudásra van szükség programozóként?

- Kotlin nyelvet
- Objektum orientált programozási paradigmát
- Android platformot
- Programozói gondolkodásmódot
- Saját kódunk tesztelését

<ins>Gondolkodásmód miért fontos, miben más, hol használom?</ins>

Egy szoftverfejlesztési projektet analitikusan kell megközelíteni; részekre kell szedni a problémát és lépésről lépésre megoldani. 
A mindennapi életben nem feltétlenül így gondolkodunk. Ezt a gondolkodásmódot el kell sajátítani. 

Programozóként megrendelőink lesznek, legegyszerűbb esetben is lesz egy másik fél az asztal túloldalán, hiszen nem saját magunknak fejlesztünk.
**Kommunikálni kell tudni, tisztán, egyértelműen.** Ehhez világosan kell tudnunk gondolkodni, fel kell építenünk egy logikus gondolatmenetet.

A programozás egy nagyon egzakt tevékenység, mindent pontosan definálni kell.
Konkrét kérdéseink lesznek az ügyfél felé és egyértelmű válaszokat várunk. A **"lehet hogy így, lehet, hogy úgy"** típusú válaszokkal nem tudunk mit kezdeni.

Előbb-utóbb elérünk a kódírásban egy olyan pontig, ahol már **szükség lesz a konkrétumokra**.
Az ügyféllel való kommunikációban fel kell tudni tárni, hogy tulajdonképpen mit szeretne elkészíttetni, 
észre kell tudni venni a gyenge pontokat, a logikátlanságot, az esetlegesen homályban maradó, az ügyfél által nem átgondolt részeket.

<ins>Tesztelés miért fontos?</ins>
Nem vákumban dolgozunk, legtöbbször lesznek más programozók, akikkel együtt készítjük el a projektet. Ha az én kódom hibás,
nem fordul, azzal problémát okozok a csapat más tagjainak is. Nem beszélve arról, hogy az ügyfél sem azért fizet, hogy hibás szoftvert kapjon.
Ezért mindig éreznünk kell, mi az a minimum, amit egy adott feature, vagy akár egy teljes szoftver fejlesztése során
mindenképpen saját magunknak le kell ellenőrizni a saját munkánkban, mielőtt bárkinek továbbadjuk. Nem lehetünk lusták, végig kell nyomogassuk a felületet, 
amit írtunk, ki kell próbálnunk minden lehetséges esetet, ami megtörénhet. Szándékosan ki kell próbálnunk a programot rossz bemenő adatokkal is, 
hogy lássuk, arra hogyan viselkedik.

Ez a tesztelés is a programozói munka része. Továbbá **nagyon komoly etikai és emberi/jellembeli kérdés is egyben**, hogy milyen munkát adok ki a kezemből.

#### Milyen tudás kell az Android platformon a programozáshoz?

Összetett, szerteágazó. Pontokba szedve:

- Kotlin vagy Java
- Android Studio használata
- Xml
- GUI elemek ismerete a platformon: https://material.io/components
- Minimális UI esztétika, material design
- Hálózati kérések indításához szükséges ismeret (minimális http és REST ismeret)
- Android app/activity lifecycle
- Fő Android komponensek (service, activity, broadcast receiver stb.)
- Segítő tool-ok (buildelés, verzió kezelés)
- Publikálás a store-okban

> Roadmap: https://www.androidelements.com/

---

[KÖVETKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/elmelet/Android_Architecture_and_Software_Stack.md)