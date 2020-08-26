# Thread-ek, AsyncTask

## Thread modell, main thread, background threads

Az OS process-eket indít, amiken belül ún. szálak végzik a végrehajtást.

Kitüntetett szál a **main thread**. Feladata:

* UI update
* Felhasználó interakció kezelése (a UI elemein esemény figyelés és azok kezelése)

A user experience érdekében a felhasználói interakciónak zökkenőmentesnek kell lennie. El kell kerülni az **Application Not Responding** hibát. Ez néhány egyszerű szabály betartásával elkerülhető:

* Soha ne indítsunk idő- és erőforrás igényes műveletet a main thread-en!
* Idő- és erőforrás igényes műveletek számára mindig hozzunk létre ún. háttérszálakat
* Háttérszálon futó kódban soha ne végezzünk a user interfésszel kapcsolatos műveletet, ne frissítsük háttrészálból a UI-t!
* Minden UI operációt végző kódot kizárólag a main thread-en végezzünk!

<ins>Hogyan lehet akkor idő- és erőforrás igényes feladat végzésekor frissíteni a UI-t?</ins>

* AsnycTask (egyszerűbb, rövidebb ideig tartó task-ok implementálására)
* `java.util.concurrent package` használata (komolyabb, robusztusabb API ezért komolyabb aszinkron feladatok elvégzésére alkalmas; `Executor`, `ThreadPoolExecutor` és `FutureTask` osztályok)
* valamilyen 3rd-party library használata

## AsyncTask

Aszinkron jelentése: a main thread-hez képest párhuzamosan futó, a main thread-et nem blokkoló. Aszinkron módon futó kód "majd valamikor" véget ér, elvégzi a feladatát és értesíti a befejezésről a main thread-et. Erre való az `AsycTask` osztály. 

A szálkezelési alapok a Java-ban vannak lefektetve (`Thread` és `Runnable` osztályok), de ezek az Android programozó számára *black box*-ként jelennek az `AsyncTask` használatakor. (Persze idővel célszerű Android programozóként beleásnunk magunkat a Java szálkezelésbe, de ez egy nagyon komoly és összetett témakör.)

Az `AsyncTask` az Android platform **legfontosabb osztálya** a szálkezelés témakörében, amelynek a működésével minden Android fejlesztőnek tisztában kell lennie!

> Gyakorlás: AsyncDemo