# Közös kódírás: PlayerProfiles app továbbfejlesztése

## Leírás

A játékosokat egy scrollozható listanézeten jelenítjük meg.

## UI

RecyclerView és a hozzátartozó adapter.

## Használt technológiák, cél

* RecyclerView, ViewHolder, RecyclerView.Adaper megismerése
* List adatszerkezet használata
* Leszármazott osztályok, interfészek

> Nézzük át az öröklődéssel kapcsolatos elméleti anyagot! [Inheritance](https://github.com/droidteacher/ClassOne/blob/master/elmelet/Kotlin_Inheritance.md)

## Implementálás lépései

1. Írjuk meg a `data class Player` osztályt, ha még nem tettük meg korábban!
2. Vegyünk fel egy `List<Player>` típusú listát, amely adatmodellként szolgál majd!
3. Adjuk hozzá a szükséges képeket a `res/drawable` mappához!
4. Hozzunk létre egy `PlayerListActivity` osztályt és a hozzátartozó layout fájlt!
5. Hozzunk létre egy `adapter` csomagot és abba vegyük fel az adapter és view holder osztályokat (`PlayerListAdapter` és `PlayerViewHolder`)!
6. Az adapter metódusainak implementálásához szükség lesz a listanézet egy sorát reprezentáló layout fájlra, így készítsük el azt is!
7. Implementáljuk az adapter három kötelező metódusát!
8. A ViewHolder-ben vegyük fel a layout row UI elemet (a root view-n keresztül `findViewById()`-val referenciát szerezhetünk rájuk)!
9. A `PlayerListActivity' layout-jába vegyünk fel egyetlen `RecyclerView`-t! A root view lehet egy `FrameLayout`.
10. Példányosítsuk az Activity-ben az adaptert és kössük rá a recycler view-ra!

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PlayerListAdapter(allPlayers)

11. Az `AndroidManifest.xml`-ben állítsuk át az alkalmazás belépési pontját!
12. Futtassuk az alkalmazást, nézzük meg `landscape` nézetben is!
13. Implementáljunk eseménykezelőt a listaelemeken való klikkelés lekezelésére!
14. A listaelemen való klikkelés hatására induljon el a múlt órán megírt Activity, mely megjeleníti a player profile-t! Az activity kapja meg az `Intent` példányban azt a Player példányt, akin a klikkelés történt!

### HINTS

* Egy layout xml fájl betöltése és `View` objektum példánnyá alakítása így történhet:

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)


### Házi feladat

* Befejezni a fenti lépéseket, amelyekre nem maradt idő az órán!