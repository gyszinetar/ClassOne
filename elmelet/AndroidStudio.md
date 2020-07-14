# Bevezetés az Android Studio használatába

## Telepítés

[Letöltés innen](https://developer.android.com/studio)

> Windows alatt válasszuk az `.exe` formátumot a `Download Options` alól és kövessük a telepítő wizard utasításait!

## Milyen komponensek kerültek telepítésre?

* Java
* Android Studio IDE
* Default Android SDK (aktuális API Levelhez illeszkedő build tools)

> Ellenőrizzük, mi települt a Welcome screen alján a fogaskerék ikon mellett a `Configure` menü használátával!

* SDK Manager
* AVD Manager
* Settings
* Plugins

## A komponensek update-je

Az alábbiak közül ha bármelyik mellett azt látjuk, hogy Not Installed vagy Update available, akkor azokat nyugodtan **jelöljük ki és frissítsük** az `Apply` gombra való klikkeléssel!

* Android SDK Build-tools
* Android Emulator
* Android SDK Platform-tools
* Android SDK Tools
* Google Play Services 
* Intel x86 Emulator Accelerator (HAXM Installer)
* Google USB Driver (csak Windows-on)

> Azonosítsuk az `Android SDK Location` elérési utat!

> Adjuk hozzá a PATH környzeti változóhoz az alábbiakat:

* __PATH_TO_ANDROID_SDK__/tools
* __PATH_TO_ANDROID_SDK__/tools/bin
* __PATH_TO_ANDROID_SDK__/platform-tools

> Ellenőrizzük parancssorból az ADB programot!

    adb version

> Kössük rá a telefonunkat a számítógépre egy USD kábellel és ellenőrizzük parancssorból!

    adb devices

## Google USB Driver probléma esetén

* [Windows USB Driver letöltése az ADB használatához](http://adb.clockworkmod.com/)
* A `Letöltések` alatt a driver megkeresése és installálása (`UniversalAdbDriverSetup.msi`)
* [Stackoverflow issue](https://stackoverflow.com/questions/15721778/adb-no-devices-found)

## Android Studio memória használat

Az Android Studio olykor több háttérfolyamatot is futtat, ami memória igényes lehet. Beállíthatjuk, hogy az operációs rendszerünk mekkora memóriáterületet engedélyezzen az IDE számára.

> Ellenőrizzük az IDE memória beállításait!


    Settings > Appearance and Behavior > System Settings > Memory Settings
    
    
> Hozzuk létre a ClassOne projektet, ha eddig még nem tettük meg!    
    
---

[KÖVETKEZŐ TÉMA](https://github.com/droidteacher/ClassOne/blob/master/elmelet/AVD_es_Emulator.md)
