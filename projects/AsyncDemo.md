# Közös kódírás: AsyncDemo app

## Leírás

Az `AsyncTask` megismerését szolgáló mini alkalmazás.

## UI

Egyetlen gomb és egy szöveg.

## Használt technológiák, előfeltételek

* Szálak, szálkezelés 
* `android:onClick` szintaxis
* AsyncTask osztály és belső működése
* `try-catch` blokk szintaxis

## Implementálás lépései

1. Hozzuk létre a projektet az Android Studioban, válasszuk az "Empty Activity" opciót
2. `activity_main.xml`: egy `TextView` és alatta egy `Button`
3. Kössünk egy eseménykezelőt a `Button`-ra az `android:onClick` attribútum használatával
4. Az eseménykezelő kódjában írassunk ki egy szöveget a `TextView`-ra (pl. "Processing..."), majd altassuk el a fő szálat 20-40 másodpercre, végül írassuk ki a `TextView`-ra, hogy "Task done"
5. Futtassuk az app-ot, klikklejünk a gombon, figyeljük meg, hogy a gomb más háttérszínt vesz fel, és többé nem lehet rajta klikkelni, amíg az altatás tart
6. Nyomatékosítsuk, hogy ANR-t okozhat a fő szál felfüggesztése, blokkolása (ha elég sokáig altatjuk a szálat, itt is tapasztalni fogjuk a problémát)
7. Nyomatékosítsuk, hogy **bármilyen egyéb idő- vagy erőforrás igényes kód** az eseménykezelőben ugyanígy ANR-t okozhat! Tehát pl. egy képletöltés az internetről.
8. Nézzük meg az `AsyncTask` *absztrakt* osztály [dokumentációját](https://developer.android.com/reference/android/os/AsyncTask)
    * nézzük meg a három típusparamétert és a szerepüket (Params, Progress, Result)
    * nézzük meg a végrehajtás négy lépését (onPreExecute, doInBackground, onProgressUpdate, onPostExecute)
    * "does not constitute a generic threading framework..."

9. Hozzunk létre egy új osztályt a következő header-rel:

        class TimeConsumingTask: AsyncTask<String, Void, String>() { ... }

10. Implementáljuk az `AsyncTask` egyetlen kötelezően felülírandó metódusát, majd még a 3 másik életciklus metódust is

11. Nyomatékosítsuk, hogy az `onPreExecute()` a *main thread-en fut*! Implementáljunk itt olyan kódot, ami módosítja a `TextView` szövegét!

12. Implementáljuk a `doInBackground()` metódust, szakaszosan altassuk a szálat, és minden egyes szakaszban küldjünk progress információt a `publishProgress()` meghívásával!

13. Implementáljuk az `onProgressUpdate()` és `onPostExecute()` metódusokat

14. Üzenjünk a main thread-nek (`MainActivity`-nek) a végrehatás különböző életciklus pontjain! (Lásd a Hints-ben.)


### HINTS

* Hozzunk létre egy interfészt, amit implementáltatunk a `MainActivity`-vel és amit arra használunk, hogy fogadjuk az async task végrehajtásakor fellépő különböző állapotokat. Update-eljük a UI-t a különböző állapot információkkal!