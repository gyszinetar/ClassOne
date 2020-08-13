# ConstraintLayout használata

## Miért hozták létre?

Android 7-ben érkezett meg, célja az volt, hogy a túl mélyen egymásba ágyazott UI hierarchiákat le lehessen írni egy olyan layout mgr-rel,
 ami viszonylag "síkká" (flat) teszi az xml-t, illetve a layout hierarchiát. Ezzel növelhető a rendering performancia.
 
Hasonló a `RelativeLayout`-hoz, mert a view-k egymáshoz és a parent-jükhöz képesti **relációjára** helyezi a hangsúlyt. 
Amivel ezeket a relációkat le lehet írni, azt nevezik **constraint**-nek, magyar jelentése az hogy "kényszer".

## Constraint típusok

1. Position constraints
    * edge: a komponens valamelyik széle van illesztve valamihez
    * center: a komponens közepe van illesztve valamihez (amit úgy is fel lehet fogni, hogy a komponens két szemben lévő széle egyaránt constraint alá van helyezeve)
    * baseline: amelyik komponensen van szöveg, ott a szöveg alját hívják baselien-nak, és ez van illesztve
    
<ins>Bias:</ins> amikor center constraint-ről beszélünk, fontos fogalom a *bias*, és azt mondja meg, 
hogy az erediteleg tökéletes középre igazítás százalékosan mennyire van elhúzva az egyik irányba. (Ezért létezik horizontal és  vertical bias is.)
(Bias jelentése: eltérés az egyenes vonaltól, részrehajlás.)

2. Size constraints
    * fix: egy fix méret van megadva dp-ben
    * `wrap_content`
    * `match_parent`
    
<ins>FONTOS:</ins>
Olykor előfordul, hogy a position constraint-ek már eleve kijelölik egy komponens méretét. Mondjuk egy `ImageView` top és bottom szerint illesztve van egy lista elem row-jának a mgasságához. Ilyenkor célszerű lehet 
a komponens `layout_width` és/vagy `layout_height` értékeit 0dp-re állítani.

---
> Gyakorlás 1

    1. list_item_row.xml, root: ConstraintLayout, height 100dp 
    2. subview: ImageView, left, top, bottom constraint-ek
    3. próbálgassuk az ImageView width/height értékeket (wrap_content, 0dp, 100dp)
    
---

> Gyakorlás 2

    1. az előzőt folytatva tegyünk le egy TextView-t 
    2. állítsuk a design nézeten a left, top, bottom constraint-eket a horgonyok húzásával
    3. adjunk baloldali margót az Attributes nézetben
    4. játsszunk a TextView vertical bias csúszkájával
    5. nézzük meg a generált kódot, vessük össze a bekerült xml attribútumokat a design nézeten elvégzett beállításokkal
    
---

> Gyakorlás 3

    1. az előzőt folytatva tegyünk le egy második TextView-t 
    2. a második TextView-n állítsunk end constraint-et a parent end-hez húzva a horgonyt
    3. jobbklikk a TextView-n és tegyük láthatóvá a baseline-t
    4. a baseline-t kössük össze az előző TextView baseline-jával (a 2. textview vertikálisan cernterben van, a harmadik viszont csak látszólag, mivel ő a 2. baseline-jához igazodik innentől)
    5. módosítsuk a design nézeten 2. textview textSize property-jét 36sp-re és figyeljük meg, hogyan marad baseline-ban 3-as textview
    
---

> Gyakorlás 4: Chains

    1. csináljunk egy új layout fájlt három TextView-val
    2. jelöljük ki mind a hármat és alakítsuk chanin-né őket (jobbklikk Chains)
    3. hozzuk őket vertikálisan centrbe
    4. próbáljuk ki a 3 lehetséges chain típust (jobbklikk kontext menüből a head elemen)