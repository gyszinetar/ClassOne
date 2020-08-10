# Tömbök, kollekciók a Kotlinban

## Tömbök

* `Array<T>`
* `arrayOf<T>()`
* mindig szükség van a méret információra: vagy kitalálható a fordító számára (az átadott elemszámból, `arrayOf()`), vagy nekünk kell megadni (`Array(10){}`)
* a méret utólag **nem növelhető**, **nem csökkenthető**
* túlindexelés: `ArrayIndexOutOfBoundsException` futásidejű kivételt okoz! A fordító ettől nem véd meg!
* `plus()` metódus **új tömböt hoz létre**
* egyéb kényelmi metódusok:
    * `contains()`
    * `min()`
    * `max()`
    * `sum()`
    * `average()`
    * `reverse()`
    * `sort()`

<ins>FONTOS:</ins>

**A tömb adatszerkezet mutable!** Ez azt jelenti, hogy változhat a tömb a belső állapota, azaz

* a benne lévő elemek sorrendje
* egy adott indexen lévő elem értéke

Egyetlen dolog nem változhat: **a tömb mérete**!

## Mutability, immutability

A Kotlin erősen támogatja a **funkcionális programozást**, ahol nagy jelentősége van az immutable objektumoknak, azaz olyanoknak,
akiknek nyelvi elemeken keresztül megtiltható, hogy változzon a belső állapotuk.

Az *immutability* fogalom legalább két szinten van jelen a nyelvben

1. val és var: a referenciára vonatkozik, lehet-e vele "átmutatni"
2. tömbök és kollekciók esetén: a tömb vagy kollekció kaphat-e az **inicializálást követően** új elemet, lehet-e elemet eltávolítani, sorrendet változtatni stb.

<ins>FONTOS:</ins>

Egy `val` változó által mutatott objektum példány belső állapota minden további nélkül megváltozhat, hacsak nem immutable kollekcióról van szó.
Pl. egy `val p: Person` változó neve/kora megváltozhat a példányosítás után. Tehát a `val` csak azt tiltja meg, hogy átmutassunk a referenciával egy másik példányra.

## == és ===

Az `==` vizsgálat célja Kotlinban két objektum belső állapotának (adattagjaik egyezőségének) viszgálata. A Java-ban ezt az `equals()` metódus valósítja meg.

Az `===` vizsgálat célja Kotlinban két objektum referencia összehasonlítása, azaz hogy ugyanrra az objektumra mutatnak-e a heap-en.
**Vigyázat!** Ugyanezt Java-ban az `==` operátor valósítja meg! A két nyelv tehát eltérően használja a dupla egyenlőségjel szintaxist!

Referential equality, object (vagy state) equality.

## Kollekciók

* List: sorrend számít, lehetnek duplikátumok
* Set: nincs sorrend, nem tudjuk visszakapni a hozzáadás sorrendjét, nem őrzi meg ezt az információt! Duplikátumok nem lehetnek: eldobja!
* Map: kulcs-érték párok. A kulcs egyedi kell legyen, az érték bármi lehet, akár null is. Az értékek között lehet duplikátum.

### Mutable és immutable kollekciók

A kollekciók **alapból immutable implementációk**, azaz a létrehozáskori elemeket fogják tartalmazni örökké. Nincs lehetőség hozzáadni, eltávolítani, sorrendet megváltoztatni.
Immutable kollekciók létrehozása:
* `listOf<T>()`
* `setOf<T>()`
* `mapOf<K V>()`

Ha mutable implementációra van szükség:
* `mutableListOf<T>()`
* `mutableSetOf<T>()`
* `mutableMapOf<K V>()`

A mutable implementációkon már elérhetők az állapot megváltoztatását lehetővé tevő metódusok:
* `add()`, `addAll()`
* `remove()`, `removeAt()`, `removeAll()`
* `reverse()`, `shuffle()`

### Elemek azonosságának viszgálata kollekciókban

A halmaz implemntációnak muszáj kiszűrnie a duplikátumokat. Hogyan tudja ezt megtenni?

* `hashCode()` metódusra implementációt kell adnom
* `equals()` metódusra implementációt kell adnom
* nem adok implementációt egyikre sem, hanem `data class`-t hozzok létre

<ins>Mi történik új elem hozzáadásakor?</ins>

`List` elfogad bármilyen új elemet, mert nem törődik a duplikátumokkal. Azonban a `Set` a következőt csinálja:

* besorolja az új elemet egy ún. *bucket*-ba a hash kód alapján
* ha már létezik a bucket, azaz van már a halmazban olyan elem, akinek azonos a hash kódja, akkor végez egy *referential equality check`-et (=== vizsgálat)
* ha referencia szerint nem egyenlő az új elem a bucket-ben lévők közül egyikkel sem, akkor még elvégez egy állapot szerinti egyenlőség viszgálatot is (== vizsgálat)
* ha állapot szerint sem egyenlő senkivel az új elem a bucket-ben lévők közül, akkor beengedi a halmazba
* ha az új elem az ellenőrzésen már korábban bárhol megbukott, akkor nem engedi be, mert duplikátum

`Map`-ek esetén a kulcsok egyediségét kell biztosítani, így egy map kulcsai felfoghatók egy halmaznak is (azaz a duplikátumok a kulcsok között tiltottak).