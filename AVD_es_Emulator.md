# AVD virtuális eszköz létrehozása és az Emulator használata

## Kód futtatása, tesztelése

* Fizikai eszközön
* Emulátorban

## Emulátor pro és kontra

* Konfigurálható, ha nincs adott képernyő felbontású/méretű eszközünk, vagy pl. ha egy másik Android verzióval akarjuk a tesztelni a kódot, mint ami a telefonunkon van
* Van ami csak valódi eszközzel tesztelhető teljeskörűen illetve kényelmesen (pl. egy térképes vagy GPS alapú alkalmazás)


## Új virtuális eszköz létrehozása

* AVD Manager &gt; `Create Virtual Device`
* Válasszunk kategóriát: `Phone`
* Válasszuk a Pixel3-at és `Next`
* A `System Image` képernyőn válasszuk a legújabb API Level verziót és ha szükséges, kattintsuk a `Download` linken. Szükséges elfogadnunk a Terms and Conditions-t, majd letöltődik a választott image.
* Ha a választott image letöltődött, akkor klikklejünk a `Next` gombon.
* Adjunk egy tetszőleges nevet az új virtuális eszköznek, lehetőleg olyat, amiben benne van az API Level is.
* Beállíthatjuk az eszköz induláskori orientációját is, majd `Finish`.
* Az új eszköz (és az eddigiek) egy listában kerülnek megjelenítésra. Az Actions oszlopban néhány hasznos akció elérhető, többek között innen **rögtön el is indíthatjuk** az emulátort úgy, hogy ezt az AVD-t emulálja!
* Actions &gt; Edit alatt állítsuk át Landscape orientation-re a konfigurációt, majd zárjuk be az AVD-t és  indítsuk újra!
* Bezárhatjuk az AVD Manager-t és futassuk a ClassOne Projektet az Emulátoron.

## Emulátor toolbar

* Exit, minimize
* Power: röviden megnyomva zárolja a képernyőt, hosszan nyomva kikapcsol
* Volume Up/Down
* Rotate left/right
* Take screenshot: képernyő fotót csinál és elmenti arra a helyre, amit az `Extended Controls` &gt; `Settings` szekcióban beállítottunk
* Zoom mode: ki/bekapcsolja a zoom-olást a képernyőn. Egér bal és jobb gomb nagyít/kicsinyít; vagy egy négyzet alakú területet kijelölve abba zoom-ol bele
* Back, Home, Overview
* Fold device: szimulálja egy becsukható készülék esetén az összecsukást

## Extended Controls

* Location: egy single location, amivel szimuláljuk, hol van éppen az eszköz; vagy egy route (több location), amivel szimuláljuk, hogy az eszköz mozog
* Camera: egy hipotetikus szoba belsőben lehet mozogni, az Alt + egér scroll, illetve az Alt + QWEASD billentyűkkel
* Fingerprint: 10 szimulált ujjlenyomatot biztosít. A Settings app-ban hozzá kell adni őket, plusz fallback-nek beállítani PIN feloldást. Az Extended Controls panelen a Touch the sensor gombon való klikk szimulálja, hogy odatettem az ujjam az ujjlenyomat olvasóra. A 10 teszt ujjlenyomat közül a Security Settings alatt beállítottal kell próbálkozni értelemszerűen, mert másikkal nem enged be.
* Snapshots: az AVD session mentését teszi lehetővé egy adott ponton, majd később az ide való visszatérést. (Cold boot vs. quick boot.) Több snapshot is menthető. A mentettek egy listából választhatók ki. A listából kiválasztott azonnal futtatható.

---

[KÖVETKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/Bevezetes_Kotlin.md)