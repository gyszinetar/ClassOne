# Közös kódírás: Tip Calculator app

## Leírás

Borravaló kalkulátor. Egy alapösszegből kiindulva kalkulálja a fix 15%-os borravó értékét, illetve egy, a felhasználó által megadott százalékos borravaló értékét. Mindkét értékhez kiszámolja és megjeleníti a végösszeget is.

### Használt technológiák, előzetes ismeret

* Egyszerűbb layout manager-ek
* ConstraintLayout
* Activity
* Android Studio UI editor design nézetben, xml nézetben
* SeekBar widget
* EditText widget
* Widget-ek eseménykezelői
* Stílusok alkalmazása a UI-on

### UI elemek

LinearLayout-ból kiindulva egy meglévő view-t alakítunk át ConstraintLayout-tá. 

## Implementálás lépései

0. Töltsük le és importáljuk a starter projektet a GitHub-ról! 
    https://github.com/droidteacher/TipCalculator-Starter.git

1. Alakítsuk át a `activity_main.xml`-t egy olyan layout-tá, ahol a root view egy `ConstraintLayout` és a megfelelő constraint-ek beállításával definiáljuk a widget-ek közötti relációkat! (Oktató vezetésével közös implementálás.)

2. A `MainActivity`-ben implementáljuk az alábbiakat:
    * UI elemek kivezetése property-kké
    * `defaultPercent` property, kezdőértéke: 0.15
    * `customPercent` property egy getter-rel, ami visszaadja a SeekBar progress property-jét elosztva 100-zal
    * `seekBarListener` objektum, ami implementálja a `SeekBar.OnSeekBarChangeListener`-t
    * `seekBarListener` példány implementációjában írjuk felül az `onStopTrackingTouch()` metódust: hívja meg az `updateUI()` metódust
    * `amountListener` objektum, ami implementálja a `TextWatcher` interface-t
    * `onCreate()`-ben: 

            seekBar.max = 30
            seekBar.progress = 18
            seekBar.setOnSeekBarChangeListener(seekBarListener)
            amountTextView.text = "1000"
            amountTextView.addTextChangedListener(amountListener)

3. Az `updateUI()` metódust implementáljuk az alábbiak szerint:
    * a `customPercentTextView` mindig írja ki a seek bar propgress property-jének értékét %-ban
    * legyen egy `amount: Int` változó, amely az `amountTextView`-ban lévő szövegből számot konvertál
    * legyen egy `tipCustom: Double` és egy `tipDefualt: Double` változó, amelyek értéke az `amount` és a megfelelő borravaló százalékos értékek szorzatából képződik
    * `totalCustom` és `totalDefault` értékek, amelyek az alapösszeg és a default/custom borravavló értékek összeadásával képződik
    * frissítse a 4 darab kalkulált TextView értékét

### Improvements (házi feladat)

Ha megfigyeljük az alkalmazás jelenlegi működését, azt látjuk, hogy a beviteli mezőben minden egyes számjegy beírásakor vagy visszatrölésekor meghívódik az `updateUI()` és frissülnek a kalkulált értékek.

Nézőpont kérdése, hogy ez ideális (felhasználóbarát), vagy inkább zavaró.

Ezzel kapcsolatos az a javítás, amit implementálni kellene:

* további (és lehetőleg jobb) megoldás keresése, hogy csak akkor hivjuk meg az `updateUI()` metódust, ha a user befejezte a beviteli mező szerkesztését. 
* Átgondolni, mikor van az a pillanat, amikor tényleg befejezte! Tudhatjuk ezt egyáltalán? [HINT](https://stackoverflow.com/questions/3890033/how-to-remove-focus-from-single-edittext/37017712)

