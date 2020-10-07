Wellnes Badges Software Requirements Specification

Bevezetés

A Wellnes Badges egy webes felépítésű szálloda rendszer készpénz fizetés nelküli megoldásának megvalóstása. A szálloda vendégei karórával rendelkeznek, amik azonosítják őket.
Több vendég esetén egy számlát kell fizetniük, tehát egy számlához több vendég is tartozhat. Amikor a vendégek távoznak, vissza adják a karórákat, amelyek később új vendégekhez lesznek rendelve.
A vendégek egy érintéssel fizethetnek a karórájukkal, úgy mint a PayPass. A fizetésük monitorozása állandó lenne a szállodában töltött ideő alatt, így részletes számla készítése is megoldható.
A vendégek korlátozva lennének a korosztályuk alapján, így néhány szolgáltatás nem lenne elérhető számukra. Így a 18 évnél fiatalabb gyermek nem tudna alkoholt vásárolni a karórájával. 


Jelenlegi helyzet

- Készpénzes vagy kártyás fizetés
- Nehéz átláthatóság a vendégek szokásairól
- Kevésbé automatizált szolgáltatás elérés és fizetés


Az órák és a terminálok már üzemelnek és kommunikálnak a szerverrel. Az eszközök képesek a tranzakciókat feldolgozni vagy elutasítani, néhány eszköz képes egyszerű hiba üzenetet küldeni. Például 
ha egy gyermek akarja használni a szaunát, akkor a bejárat elutasítja a kérést. Egy másik esetben pedig ha egy 17 éves gyermek akar alkoholt vásárolni, akkor az ott dolgozó felügyelő munkatárs
üzenetben kap értesítést a korlátozásról.

Vágyálom rendszer

Egy automatizált rendszer elkészítése, amely a már elérhető és újonnan telepített eszközöket képes kezelni. 
Korlátozások bevezetése és értesítések küldése. 
Fizetési rendszer kiépítése csoportokon belül.
Vendégek azonosítása karórával. 

Korlátozások
A rendszerben személyes adatokat kezelünk, így a Személyes adatok védelméről szóló törvény,
1992. évi LXIII. törvény
a személyes adatok védelméről
és a közérdekű adatok nyilvánosságáról.

Követelmény lista
Vendégek adatai karórákhoz rendelve, ezek tárolása és védése.
Korlátozások bevezetése.
Átlátható UI tervezése.
Csoportos számlák kezelése. 
Bővíthetőség az eszközök támogatottságára.




