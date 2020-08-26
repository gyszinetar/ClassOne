# Közös kódírás: Prime Finder app

## Leírás, cél

AsyncTask osztály használatának elmélyítése.

## UI

Egy `RecyclerView`-ban N darab cella, mindegyikben egy véleltlen szám (1..100 intervallumból), megjelenítve egy `TextView`-n. A cella jobboldalán egy 
progress bar és egy `ImageView`. Minden cellában lévő számról kikalkulálja a program, hogy prímszám-e. Amíg a kakuláció tart, addig pörög a progress bar.

## Technológiák, új dolgok

* Szálkezelés, AsyncTask
* RecyclerView
* `View.VISIBLE`, `View.GONE`
* `DividerItemDecoration`
* varargs, [spread operátor](https://stackoverflow.com/questions/45854994/convert-kotlin-array-to-java-varargs)

## Implementálás lépései

0. Klónozzuk a starter projektet [innen](https://github.com/droidteacher/PrimeFinder-Starter)!
1. Hozzunk létre egy `async` package-t a projektben, az alatt pedig egy `AsyncTask` leszármazott osztályt `PrimeFinderTask` néven!

        class PrimeFinderTask: AsyncTask<Int, Pair<Int, Boolean>, Int>() { .. }

2. A típusparaméterek alapján beszéljük meg, hogyan fog működni a prím számok keresése, hogyan fog kinézni a metódusok szignatúrája!

3. Írjuk meg a szükséges metódusok törzsét, egyelőre csak logolást tegyünk bele.

4. Implementáljunk egy interfészt, amely definiálja az async task és az activity közötti kommunikációt az alábbiak szerint:

        interface PrimeConsumer {
            fun presentResult(someResult: Pair<Int, Boolean>)
            fun allTasksDone(count: Int)
        }

5. Implementáljuk az `isPrime()` metódust a `PrimeFinderTask` osztályban az alábbiak szerint:

        private fun isPrime(num: Int): Boolean {

            when(num) {
                in Int.MIN_VALUE..1 -> return false
                2 -> return true
                else -> {
                    for (i in 2 until num) {
                        if (num % i == 0) {
                            return false
                        }
                    }
    
                    return true
                }
            }
        }

6. Implementáljuk a logikát a `doInBackground()`-ban az alábbiak szerint:
    * egy `var numberOfPrimes = 0` kezdőértékű változóban gyűjtsük, hány prímszámot találtunk
    * iteráljuk az átvett bemeneti `varargs` paraméteren és minden iterációban nézzük meg, prím számról van-e szó
    * minden egyes iterációban a vizsgálat eredményét adjuk tovább a `publishProgress()` metódusnak egy `Pair<Int, Boolean>` típusú változó formájában

7. A `PrimeFinderTask` osztály primary konstruktorát módosítsuk úgy, hogy átvegyen egy `private val consumer: PrimeConsumer` argumentumot

8. Implementáljuk az `onProgressUpdate()` metódust: hívja meg a `consumer` megfelelő metódusát!

9. Implementáljuk az `onPostExecute()` metódust: hívja meg a `consumer` megfelelő metódusát!

10. A `MainActivity`-vel valósítsuk meg a `PrimeConsumer` interfészt és adjunk implementációt a szükséges metódusokra!

11. Kössünk egy eseménykezelőt a `MainActivity`-ben lévő gombra:

        button.setOnClickListener {

            val processor = PrimeFinderTask(this)

            val inputs = numbers.map { nwf ->
                nwf.number
            }

            processor.execute(*inputs.toTypedArray())

            it.isEnabled = false
        }

12. Teszteljük az alkalmazást! Emeljük fel a generált véletlenszámok számosságát 100-ra! Építsünk be egy `Thread.sleep()` hívást, hogy lássunk némi késleltetést a taks végrehajtásakor!

### Improvements (házi feladat)

1. Oldjuk meg, hogy a `Calculate` későbbi megnyomásai újabb véleltszám listát generáljanak, amivel befrissül a `RecyclerView` és újra elindul a prímszám keresés! 

#### Hints

1. A `PrimeListAdapter`-t ki kell emelnünk egy változóba és minden egyes új generáláskor cserélnünk kell az általa tartalmazott elemeket!

2. A `RecyclerView` úgy értesül arról, hogy elavult a tartalma, hogy az adapterén meg kell hívnunk a `notifyDataSetChanged()` metódust.

