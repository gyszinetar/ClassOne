# Fragmentek

Újrafelhasználható részek a UI-ban, user interface "darabkák".
Önállóan nem állja meg a helyét, csakis egy `Activity`-be ágyazva.

## A fragment alkotórészei
* layout file (resource)
* Kotlin osztály, mely az `android.app.Fragment` vagy a `androidx.fragment.app.Fragment` osztályok valamelyikétől származik és legalább az `onCreateView() : View` metódusra implementációt ad 

## Életciklus
Hasonló életciklusa van, mint az `Activity`-nek. [Ábra](https://developer.android.com/guide/components/fragments)


## Hosting activity

A **backward compatibility** érdekében egy fragment-et használó activity-nek a `FragmentActivity`-től kell származnia.

### Elhelyezési módszerek

#### Layout-ba beágyazva (statikus)
Az activity layout-jában a `<fragment>` elemmel hivatkozhatunk egy beágyazott fragment-re. Ennek a megadási módnak a hátránya, hogy az így beágyazott fragment futásidőben nem távolítható el. 

#### Kódból hozzáadva (dinamikus)

Ha ennél dinamikusabb viselkedés szükséges, akkor a fragment-nek csak egy *placeholder*-t  helyezünk el az activity layout-jában (ami valamilyen konténert, layout manager-t jelent), majd kódból hozzuk létre a fragment-et és a `supportFragmentManager` segítségével adjuk hozzá futásidőben a layout-hoz.

Hasonló módon el is lehet távoítani fragment-et futásidőben, vagy kicserélni egy másikra. 

<ins>FONTOS:</ins>
Az eltávolított fragment rátehető egy back stack-re, ahonnan később esetleg visszahozható.

## Fragment-to-activity kommunikáció

A best practice szerint ez interfészen keresztül zajlik. Létre kell hoznunk egy interfészt a szükséges metódusokkal, amelyek definiálják azokat a use case-eket, amikor a fragment értesíteni akarja valamiről az activity-t. Az activity-nek implementálnia kell az interfész metódusait. 

A fragment az `onAttach(ctx: Context)` életciklus metódusában mindig megkapja hosting activity-t. Itt ellenőrizheti, hogy az activity IS-A relációban van-e a fent említett interfész típussal és elmenthet egy refereciát az activity-re.

## Activity-to-fragment kommunikáció

Az activity hívhatja a fragment publikus metódusait.

## Több fragment, egy hosting activity

Ez egy nagyon gyakori architektúrális minta. A fragment-ek egymással direktben sosem kommunikálhatnak, csak az activity-n keresztül!
