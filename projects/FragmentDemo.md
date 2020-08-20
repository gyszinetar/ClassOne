# Közös kódírás: FragmentDemo app

## Implementálás lépései (incrementer button example)

1. `activity_main.xml`-ben legyen két `<fragment>` elem: `ClickFragment` és `ResultFragment`
2. Fragment osztályok létrehozása: jobbklikk `New > Blank Fragment`
3. `fragment_click.xml`: egyetlen `Button` widget
4. `fragment_result.xml`: egyetlen `TextView` widget
5. Fragment-to-activity kommunikáció interfész implementáción keresztül
6. Activity-to-fragment kommunikáció a fragment egy publikus metódusán keresztül

### HINT

A fragment `onAttach(context: Context)` metódusa mindig megkapja a *hosting activity-t*. Ez használható arra, hogy az activity-t a megvalósított kommunikációs interfészre cast-oljuk.

## Implementálás lépései (tab layout example)

1. `activity_tab_hosting.xml`-ben helyezzük el a két alábbi widget-et:
    * `com.google.android.material.tabs.TabLayout`
    * `androidx.viewpager.widget.ViewPager`
2. A `TabLayout` widget a design editor használatával is elhelyezhető, ennek előnye, hogy három beágyazott `TabItem` elemet is kapunk
3. Hozzunk létre egy fragment osztályt `TabContentFragment` néven: jobbklikk `New > Blank Fragment`
4. `fragment_tab_content.xml`-ben egyetlen `TextView` widget-et helyezzünk el
5. `TabContent.newInstance()` factory metódus paraméterként a tab indexét vegye át és használja fel a `TextView` szövegében
6. Implementáljunk egy adapter osztályt (`TabContentAdapter`), aki a `FragmentStatePagerAdapter`-től származik
7. Az adapterben a kötelező metódusokon kívül írjuk felül a `getPageTitle()` metódust is, egyébként nem fognak látszani a tab item-eken a feliratok
8. A `MainActivity`-ben a view pager adaptereként inicializáljuk egy `TabContentAdapter` példányt iletve a tab layout példányon hívjuk meg a `setupWithViewPager(viewPager)` metódust
9. Nyomatékosítsuk, hogy az adapter `getItem(position: Int): Fragment` metódusában **tetszőlges** custom fragment-et visszaadhatunk, csak az egyszerűség kedvéért hozunk létre ebben a példában három ugyanattól az osztálytól származó példányt!