Funkcionális Specifikáció

Rendszer célja: 
A Wellnes Badges egy HTTP felépítésű szálloda rendszer fizetés készpénz nélküli megoldásának megvalóstása. A vendégek egy érintéssel fizethetnek a karórájukkal, úgy mint a PayPass
A szálloda vendégei karórával rendelkeznek, amik azonosítják őket. 
Több vendég esetén egy számlát kell fizetniük, tehát egy számlához több vendég is tartozhat. 
Amikor a vendégek távoznak, vissza adják a karórákat, amelyek később új vendégekhez lesznek rendelve.  
A fizetésük monitorozása állandó lenne a szállodában töltött idő alatt, így részletes számla készítése is megoldható. 
A vendégek korlátozva lennének a korosztályuk alapján, így néhány szolgáltatás nem lenne elérhető számukra. Így a 18 évnél fiatalabb gyermek nem tudna alkoholt vásárolni a karórájával.

Jelenlegi helyzet:

    Készpénzes vagy kártyás fizetés
    Nehéz átláthatóság a vendégek szokásairól
    Kevésbé automatizált szolgáltatás elérés és fizetés

Az órák és a terminálok már üzemelnek és kommunikálnak a szerverrel. 


Vágyálom redszer:
Egy automatizált rendszer elkészítése, amely a már elérhető és újonnan telepített eszközöket képes kezelni. 
Korlátozások bevezetése és értesítések küldése. 
Fizetési rendszer kiépítése csoportokon belül. 
Vendégek azonosítása karórával.

Korlátozások 
A rendszerben személyes adatokat kezelünk, így a Személyes adatok védelméről szóló törvény, 1992. évi LXIII. törvény a személyes adatok védelméről és a közérdekű adatok nyilvánosságáról.
Igényelt üzleti folyamatok modellje:
Vendég->foglalás->becsekkolás->Egyedi azonosítás->vásárlás terminálokon keresztül
Hotel->Egyedi azonosítók kiosztása->számlához tartozó azonosítók csoportosítása->Vendégek nyomon követése->számlák kiállítása->azonosítók visszavétele

Követelménylista:
Vendégek adatai karórákhoz rendelve, ezek tárolása és védése.
Korlátozások bevezetése: korhatár
Átlátható UI tervezése, órák szimulálása
Csoportos számlák kezelése.
Bővíthetőség az eszközök támogatottságára.
Minimális erőforrás igényre való törekvés
Hiba mentes futtatás

Használati esetek[Use cases]:

actor "Vendég"

 usecase "Foglalás"
 usecase "ID visszaadás"
 usecase "ID kapás"
 usecase "Fizetés"
 usecase "Vásárlás"
 usecase "Számlázás"

Actor "Alkalmazott"

 Vendég --> ID visszaadás
 ID visszaadás --> Alkalmazott

 Alkalmazott--> ID kapás
 ID kapás --> Vendég

 ID visszaadás --> Fizetés 

 Vendég --> Vásárlás

 ID visszaadás --> Számlázás



Megfeleltetés: Egyszerű rendszer a szolgáltatások kihasználtságának követésére, autómata számla összeállítás, egyszerűbb kezelés


Fogalomszótár:
bug-hiba
platform - szoftverkörnyezet