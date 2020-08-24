### Intent-ek használata

---

Az intent szó egyik jelentése: **szándék, cél**. Nagyon jól leírja az androidban betöltött szerepét. Komponensek közti kommunikációra, adatok átadására használjuk. Az `android.content.Intent` osztály példánya.

Amikor szerephez jut, akkor mindig két fél között zajlik egyfajta interakció: az 'A' alkalmazás komponens *szándéka* az, hogy elindítson, munkára fogjon egy 'B'-t.

[Android Developers Guide](https://developer.android.com/guide/components/intents-filters)

[Intent javadoc](https://developer.android.com/reference/android/content/Intent)

#### Intent típusai

* explicit intent
* implicit intent

Leggyakoribb felhasználási lehetősége, amikor egy alkalmazás komponensből el akarunk indítani (példányosítani) egy másikat.

<u>Explicit intent:</u><br/>
Amikor ismerjük az elindítandó komponens osztálynevét, jellemzően azért, mert azt a kódot is mi írtuk. Másképpen szólva: amikor saját alkalmazásunk egy másik komponensét akarjuk elindítani.

<u>Implicit intent:</u><br/>
Az elindítandó komponens osztálynevét (fully qualified class nevét) nem ismerjük, nem a mi alkalmazásunkban található. Egyszerűen csak annyit tudunk, hogy van egy "feladat", amit el szeretnénk végeztetni az android rendszerben valakivel. De rábízzuk az operációs rendszerre, hogy találja meg nekünk azt a komponenst, aki ért ahhoz a típusú task-hoz. A "feladat" specifikáláshoz minimálisan két dolog kell:
* action
* data (általában egy Uri-ként megadva), amire vonatkozik az elvégzendő művelet

További attribútumokkal finomítható az elvégzendő feladat specifikálása. Ezek a következők:

* category: pl. `CATEGORY_LAUNCHER` jelenti egy alkalmazáson belül a kezdő activity-t, amellyel az app elindul, és egyben azt is, hogy el kell helyezni az alkalmazás indító ikonját az ún Launcher képernyőn; azaz egy top-level activity-ről van szó
* type: gyakorlatilag egy `MIME type`-ot jelent; expliciten megadjuk, hogy olyan alkalmazás komponens indítását kérjük, aki kezelni tudja az adott `MIME type`-ot
* component: ezzel expliciten megadhatjuk az indítandó komponens nevét (gyakorlatilag az osztály nevét)
* extras: név-érték párok egy ún. `Bundle` osztályba csomagolva; ezzel tudunk adatokat küldeni az indítandó alkalmazás komponensnek

<u>Példa:</u>

    val intent = Intent()
    intent.action = Intent.ACTION_VIEW
    intent.data = Uri.parse("http://developer.android.com")
    startActivity(intent)

Azt a tevékenységet, amikor az android rendszer egy `Intent` példány alapján megkeresi azt az alkalmazáskomponenst, amit el kell indítani, **intent resolution**-nek (intent feloldásnak) nevezik.

<u>FONTOS!</u>

Elképzelhető, hogy a rendszer nem talál egyetlen olyan activity-t sem a telefonon, amely alkalmas lenne a feladat elvégézésére. Ha ezt a lehetőséget nem kezeljük le, akkor az alkalmazásunk crashel. Például egy alkalmazás, amelyben lehet fotót készíteni, csak olyan telefonra telepíthető, amely rendelkezik kamerával. Ezt előírhatjuk a `AndroidManifest.xml`-ben a következő módon:

    <uses-feature android:name="android.hardware.camera"/>

> Nézzük meg a fenti linken az Android Developers Guide Intent oldalán a példákat! Figyeljük meg az action neveket és a hozzátartozó Uri-kat!

#### Adatok küldése az elindítandó komponensnek

Amellett, hogy az intent-tel ki tudjuk jelölni az elindítandó komponenst, még adatot is tudunk küldeni a számára. 

    intent.putExtra("myString", "Some important data for the second activity")
    intent.putExtra("myInt", 108)

Az elindított alkalmazás komponens hozzá tud férni ahhoz az intent példányhoz, amivel őt létrehozták, és így ki tudja olvasni az intent-ben esetlegesen küldött extra paramétereket.


#### Sub-activity indítása

Ha `startActivity()` hívással elindítok egy másik activity-t, akkor az első activity-ből ugyan tudok adatot átadni a másodiknak, de visszafelé ez nem működik. Jó lenne, ha arra is lenne lehetőség, hogy egy activity, miután elvégezte a feladatát, vissza tudjon jelezni az őt elindító komponensnek.

Erre való az alábbi hívás:

    startActivityForResult(someIntent, SOME_REQUEST_CODE_CONSTANT)

Itt az a célunk, hogy miután 'B' activity elvégezte a feladatát, a vezérlés és az elvégzett feladat eredménye visszatérjen 'A' activity-hez. A hívó `Activity` az alábbi metóduson keresztül értesül arról, hogy a vezérlés visszatért és az elindított `Activity` által prezentált eredmény megérkezett:

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { ... }


---

[KÖVETKEZŐ TÉMA](file:///home/zsolt/Munka/Projects/ProOktatas/topics/elmelet/Fragments.md)