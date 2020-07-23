# Közös kódírás: Droid Images app

## Leírás

Egy `GridLayout`-ban elhelyezzük az összes eddig Android verzió ikonját.

## UI elemek

Kétféleképpen hozzuk létre a UI-t:

* kódból populálva a képeket
* xml fáljban az összes komponens (activity_main.xml)

## Implementálás lépései

1. A `drawable` mappába bontsuk ki az ikonokat
2. Hozzunk létre egy új layout fájlt (layout_2.xml)
3. Hozzunk létre egy FrameLayout-ot (width/height: match_parent) és abban egy GridLayout-ot (w/h: wrap_content)
4. A GridLayout-nak adjunk ID-t
5. A MainActivity-ben cseréljük ki a layout-ra való hívatkozást (az activity_main.xml-t NE töröljük, később kelleni fog)
7. Hozzunk létre egy listát az ikon nevekkel
8. Hozzunk létre 2 konstanst:

        const val TAG = "dg"
        const val IMAGE_DIMENSION = 100

9. Vezessük be a GridLayout-ra vonatkozó változót az osztályban! A `columnCount` és a `rowCount` értékét állítsuk be (3 és 5)
10. Írjunk egy `loadImages()` metódust, ami létrehozza és elhelyzei a képeket a GridLayout-ban!

### HINTS

* Resource ID megszerzése:

        val resId = resources.getIdentifier("cupcake", "drawable", packageName)

* `ImageView` méretének beállítása:

        val params = LinearLayout.LayoutParams(IMAGE_DIMENSION, IMAGE_DIMENSION)
        iv.layoutParams = params

