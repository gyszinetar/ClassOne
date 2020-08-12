# Egyéni kódírás: Olimpics projekt (Kotlin)

## Leírás
Írj egy Kotlin nyelvű programot, amely tárol és kereshetővé tesz egy adatszerkezetet az olimpiákról.
Az adatok kigyűjthetőek [innen](https://hu.wikipedia.org/wiki/Olimpiai_j%C3%A1t%C3%A9kok).

**Legalább 1960-tól kezdve** tartalmazza az implementált adatmdell az olimpiákat!

## Megvalósítás
Implementáld az alább felsorolásra kerülő osztályokat és enum-okat!
Ahol szükségét érzed, használj `data class`-t a szimpla `class` helyett!
Töltsd fel adatokkal a szükséges adatszerkezeteket!
Implementáld a `main()` metódust és hívd meg belőle a felsorolt metódusokat!
Ha kiíratást használsz, az beszédes legyen! Legyen egyértelműen azonosítható, melyik teszteset fut és arra mi a program válasza!

## A program elemei

### Continent `enum`

* A földrészek felsorolva egy `enum`-ban

### Country `class`

Egy tetszőleges országot reprezentáló osztály. Két property-je legyen:

* `name: String`
* `continent: Continent`

### HostCountry `enum`

Az összes eddigi olimpiát rendező országot leíró `enum`.
Két property-je legyen:

* `country: Country`
* `years: List<Int>`

A `years` property-ben az `enum` példány tárolja azokat az évszámokat, amikor az adott ország olimpiát rendezett!

### Adatmodell

Egy globális névtérben (csomagszinten) deklarált változó:

    val games = mapOf<Int, String>( ... )

A map kulcsai azok az évszámok, amikor rendeztek (vagy rendezni fognak) olimpiát, az értékek pedig a rendező városok nevei legyenek.


### Teszt metódusok, amelyek különböző kérésekre válaszolnak

#### test1() metódus

* Kérdés: "Hány különböző város rendezhetett eddig olimpiát?"
* Visszatérési érték: `Int`

#### test2() metódus

* Kérdés: "Hány különböző ország rendezhetett eddig olimpiát?"
* Visszatérési érték: `Int`

#### test3() metódus

* Kérdés: "Kontinensenként hány olimpai volt?"
* Visszatérési érték: `Map<Continent, Int>`

#### test4() metódus

* Kérdés: "Melyik kontinenseken nem volt eddig olimpia?"
* Visszatérési érték: `List<Continent>`

#### test5() metódus

* Kérdés: "Melyik ország rendezhette eddig a legtöbb olimpiát?"
* Visszatérési érték: `Pair<String, Int>` (az első típusparaméter tárolja a legtöbb olimpiát rendező ország nevét, a második pedig az ország által rendezett olimpiák számát)

#### gameInfo() metódus

* Szignatúrája: `fun gameInfo(year: Int): String`
* Kérdés: "Mit tudunk az yyyy-es olimpiáról?" (yyyy egy tetszőleges évszámot jelez)
* `String`-et ad vissza, amely egy értelmes magyar (vagy angol) mondat, pl.: "Az 1992-es olimpiát Barcelona-ban tartották, a rendező ország Spain, amely ezen a kontinensen található: EUROPA"
* A metódus értelmes mondattal válaszoljon abban az esetben is, ha olyan évszámmal hívják meg, amikor nem rendeztek olimpiát!