# Közös kódírás: DreamJobSearch app

## Leírás

Az activity lifecycle megértését szolgáló mini alkalmazás. 

## UI

Két beviteli mező és 5 checkbox.

## Használt technológiák, előfeltételek

* ConstraintLayout ismerete
* Activity lifecycle, életciklus metódusok ismerete
* SharedPreferences
* Persistent és dynamic state

## Implementálás lépései

1. `ConstraintLayout`-ba ágyazzunk be egy `TextView`-t (szöveg: "Applicant form"), két `EditText'-et `android:hint` attribútummal ("Your name", "Position to apply") és öt `CheckBox`-ot ("full time", "part time", "remote", "contractor", "freelancer")

2. A `MainActivity`-ben minden életciklus metódust implementáljunk, egyelőre üres törzzsel és helyezzünk el bennük logolást.

3. Futassuk az alkalmazást és próbáljunk ki minden lehetséges scenario-t annak ellenőrzésére, hogy a UI állapota konzisztens marad-e! (`TODO`-k a minta projektben)

4. Vegyük fel az alábbi compile time konstansokat:

    const val PREF_KEY_WORK_PREFS = "workPrefs"
    const val PREF_KEY_APPLICANT_NAME = "applicantName"
    const val PREF_KEY_PREFERRED_POSITION = "preferredPosition"

4. A `MainActivity`-ben vezessünk be egy computed property-t: `private val workPrefs: Int`. A bejelölt check boxokból kalkuláljon egy Int-et, kettő hatványait használva

5. Írjuk meg azt a logikát is, amely egy visszaolvasott workPrefs `Int` értékből a megfelelő checkbox-okat bejelöltre állítja (`private fun decodeWorkPrefs(value: Int)` metódus a minta projektben)

6. Implementáljuk a `saveAppData()` metódust: shred pref-be menti a user által megadott adatokat. Nyomatékosítsuk hogy ez ún. *persistent state*, abban a tekintetben, hogy vissza szeretnénk olvasni az app újraindításakor is!

7. Implementáljuk a `loadAppData()` metódust: a shared prefs-ből visszatölti a persistent state-et

8. Vegyük észre, hogy a save és load metódusokat meghívhatjuk két helyről is:
    * az `onStart()` - `onStop()` párosból
    * az `onRestoreInstanceState()` - `onSaveInstanceState()` párosból


### HINTS

* `SharedPreferences` editor megszerzése:

        with(getPreferences(Context.MODE_PRIVATE).edit()) { ... }

### Improvement (házi feladat)

* Cseréljük le a `decodeWorkPrefs(value: Int)` metódust egy olyan változatra, amely először egy bináris string-et készít az átvett `value` változóból, majd a bináris string-ben szerelő 0-k és 1-ek alapján dönti el, hogy melyik `CheckBox` példányokat kell bejelöltre állítani!