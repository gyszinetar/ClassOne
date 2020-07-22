User interface elemei és layout-ok
------------------------------------

A UI ún view-kból épül fel. Egy view jellemzően egy téglalap alakú terület a képernyőn. Az android rendszer felel ennek a területnek a kirajzoltatásáért illetve az ott bekövetkező eseményekért (gesture-ök).
A kódban egy ilyen view megfelelője az `android.view.View` osztály egy példánya.

https://developer.android.com/reference/kotlin/android/view/View

A platform különböző UI komponenseit (TextView, Checkbox, Button stb.) összefoglaló néven WIDGET-eknek is nevezzük.

Egy konkrét képernyőt általában több widgetből építünk fel, amiket össze kell fogni valahogy, hogy normális elrendezést mutassanak a képernyőn. Erre valók az ún. layout managerek.

A layout managerek mind a ViewGroup nevű osztálytól öröklődnek. Amikor egy összetett, több widgetből álló view hierarchia van, azt úgy is nevezik, hogy composit layout.

#### Fontosabb layout managerek
- <ins>ConstraintLayout</ins>: ún. constraint-ekkel határozzuk meg, hogy egyes komponensek illeszkedés szempontjából milyen viszonyban vannak a parent és a sibling komponensekkel
- <ins>LinearLayout</ins>: vízszintesen vagy függőleges egymás mellett/alatt rendeződnek a komponensek; a weight attribútummal lehet súlyozni az arányokat
- <ins>TableLayout</ins>: táblázatos elrendezés, sorok és oszlopok ("cellák") alapján
- <ins>FrameLayout</ins>: a képernyő egy adott területét kipécézzük azért, hogy egyetlen view-t elhelyezzünk, vagy az adott területen belül többet, de csak egymásra helyezve (mint egy pakli kártya)
- <ins>RelativeLayout</ins>: a child view-k egymáshoz képesti helyzete relatívan van megadva, a ConstraintLayout-hoz hasonló, de régebbi megoldás
- <ins>AbsoluteLayout</ins>: konkrét X,Y koordinátára engedi elhelyezni a view-t; ne használjuk, nem jól reagál az eszköz elforgatására
- <ins>GridLayout</ins>: NxM-es méretű rácsban engedi elhelyezni a gyermekelemeket
- <ins>CoordinatorLayout</ins>: ez inkább egy top-level szintű layout, ami az alkalmazás app bar-jának a megjelenését, viselkedését határozza meg a többi komponenshez képest

#### Milyen lehetőségeink vannak a UI összerakására
- Android Studio Layout Editor tool
- "kézzel" xml-t írunk
- Kotlin kódot írunk és ott hozzuk létre a widgeteket

> Nézzük meg a __LayoutsExperience__ projektet! (LinearLayout, TableLayout, ConstraintLayout)

> Nézzük meg a __DroidGallery__ projektet! (GridLayout)

> Nézzük meg a __GroceryCards__ projektet és tekintsük át a [RecyclerView használatának](file:///home/zsolt/Munka/Projects/ProOktatas/topics/elmelet/RecyclerView_hasznalata.md) lépéseit!

---

[KÖVETKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/elmelet/ConstraintLayout.md)








