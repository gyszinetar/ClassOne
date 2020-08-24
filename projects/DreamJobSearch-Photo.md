# Közös kódítás: DreamJobSearch app refaktor, kamera kezelés hozzáadása

## Leírás

Egy [Starter projektből](https://github.com/droidteacher/DreamJobSearch) indulunk ki, ami fel van töltve a GitHubra.

Az előző alkalmak egyikén a DJS projektet már elkezdtük implementálni. Akkor egyetlen képernyőből állt, amit a MainActivity jelenített meg.

A Starter projektben az alkalmazás 3 tabulátorral rendelkező UI-t tartalmaz. Az első tab-on helyezzük el azt a tartalmat, amit régebben már implementáltunk. 

Ezen a gyakorlaton a második tab-on fogjuk implementálni 
* meglévő fotók közül egy kép kiválasztását az eszközön
* új fénykép készítését az eszköz kamerájával

## UI

Három tabos alkalamzás:
* work preferences fragment (előzőleg már implementáltuk)
* photo fragment (ezt implementáljuk most)
* locations fragment (következő alkalommal implementáljuk)

A fragmenteket tartalmazó központi `ViewPager` alatt egy `Button`, amivel http kéréseket fogunk majd indítani a GitHub-os Jobs API felé.

## Használt technológiák, előfeltételek

* `TabLayout`
* `ViewPager`
* Intent-ek
* `startActivityForResult(intent, requestCode)`
* `onActivityResult(requestCode, resultCode, data)`
* try-catch-finally
* Camera API

## Implementálás lépései

1. Helyezzünk el egy `ImageView` widget-et a `fragment_photo.xml` nézeten és adjunk neki ID-t is!
2. Az `ImageView`-t úgy pozicionáljuk, hogy a FAB felett legyen és a lehető legnagyobb helyet töltse ki!
3. Szerezzük meg az `ImageView`-ra mutató referenciát a fragment osztályban!
4. Vegyünk fel egy request code-ot: `private val requestCodePickExistingImage = 101`
5. Implementáljuk a `pickAnExistingImage()` metódust az alábbiak szerint:

        val intent =  Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(intent, requestCodePickExistingImage);



6. Teszteljük a funkciót valódi eszközön!
7. Csak olyan eszközön engedélyezzük az alkalmazást, ahol rendelkezésre áll kamera! A Google Play Store ki tudja szűrni, hogy csak olyan eszközre engedje a telepítést, ami megfelel a manifest fájlban felsorolt feature specifikációnak!
        
        <uses-feature android:name="android.hardware.camera"/>

8. Vegyünk fel egy újabb request kódot: `private val requestCodeTakePictureBitmap = 102`

9. Implementáljuk a Camera app meghívását a mi alkalmazásunkból:

        private fun takePictureAndGetThumbnail() {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, requestCodeTakePictureBitmap)
        }

10. Refaktoráljuk az `onActivityResult()` metódust úgy, hogy válasszuk szét egy `when()` kifejezéssel a logikát a `requestCode` szerint!

11. Hívjuk meg a FAB `onClick` eseményére a `takePictureAndGetThumbnail()` metódust!
12. Helyezzünk el a `RadioButtonGroup` widget-et a FAB-tól balra, az `ImageView` alatt! Két bejelölhető állapot: 
    * kiválasztás a meglévő fotók közül ("*Existing*")
    * új fotó készítése ("*New*")
13. A FAB eseménykezelőt módosítsuk úgy, hogy az aktuális radio button beállításoktól függjön az activity elindításához használt `Intent` action property-je! (`Intent.ACTION_GET_CONTENT` vagy `MediaStore.ACTION_IMAGE_CAPTURE`) 
14. Teszteljük a funkciót valódi eszközön!


### Linkek

[Kamera kezelés](https://developer.android.com/training/camera/photobasics)

[Rotating a bitmap](https://stackoverflow.com/questions/14066038/why-does-an-image-captured-using-camera-intent-gets-rotated-on-some-devices-on-a)

[Uses permission és uses feature különbsége](https://stackoverflow.com/questions/28079449/uses-permission-vs-uses-feature)
