# FragmentDemo2 alkalmazás specifikáció

## Leírás

Az alkalmazás bemutatja a fragmentek használatát az Android rendszerben.

## Felhasználó felület (UI)

Egyetlen activity, amely két fragmentet ágyaz magába.

A képernyő felső részén lévő fragment-ben (**fragment1**) a következő elemek kerülnek elhelyezésre:
* Beviteli mező egy tetszőleges szöveg számára
* "Csúszka" (`SeekBar`) komponens

A képernyő alsó részén lévő fragment-ben (**fragment2**) egyetlen `TextView` jelenik meg.

## A működés leírása

A beviteli mezőbe a felhasználó tetszőleges szöveget gépelhet be. A `SeekBar` komponens értékét is tetszőlegesen bármikor állíthatja. Az alsó `TextView`-nak reagálnia kell a felhasználói bevitelre a következők szerint:
* mindig **ugyanazt** a szöveget kell tartalmaznia, mint a beviteli mező
* a `SeekBar` aktuális értékének arányában kell a `textSize` property értékének módosulnia

## Use cases (használati esetek)

1. A felhasználó képes bármikor megváltoztatni a beviteli mező tartalmát
2. A felhasználó szabadon állíthatja a "csúszkát". A csúszka az alkalmazás indulásakor középen helyezkedik el.
3. Az alsó `TextView` azonnal reagál mind a beviteli mező, mind a csúszka megváltoztatására

## Test cases (teszt esetek)

1. Írjuk be a beviteli mezőbe, hogy "Kotlin". Minden egyes betű beírásakor az alsó `TextView` ugyanazt a szöveget kell hogy mutassa, mint a beviteli mező!

2. Húzzuk el a csúszkát jobbra: az alsó `TextView`-ban lévő szöveg mérete meg kell hogy nőjön! (Elég csak egyszer méretet váltania, amikor a felhasználó ujja eltávolodik a touch screen-től.)

3. Húzzuk el a csúszkát balra: az alsó `TextView`-ban lévő szöveg mérete le kell hogy csökkenjen!