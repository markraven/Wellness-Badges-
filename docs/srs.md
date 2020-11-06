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

Funckionális követelmények
bookRoom függvényt tartalmaz, amely mezői érkezés, távozás, vendég szám, és visszatér egy Hotelservice Reservation tipusú metódussal maely mezői azonosító, Szoba (Room-ban meghatározott mezőkkel)
vendégszám, érkezési/távozási dátum, vendég ( Guest mezői alapján), fizetés.

chekIn függvény tartalmaz egy érkezést, távozást ,szobaszámot, egy listát ami CheckInGuest típusú, mely elemeinek tulajdonságai név és születésidátum visszatér önmagával.

buy (kifizetés a végén) függvény ami egy termékazonosítót , egy vásárlóazonosítót és egy darabszámot tartalma, majd egy HotelService interfész 
buyProductOrService metúdusát visszaadja amely Purchase típusú, amelynek mezői id, mennyiség, termék (ProductsService-ben meghatározott mezőkkel), vásárlás dátum, egy vásárló a (Guest mezői alapján) és egy metódus
ami visszatér a vásárló adataivel.

getInvoice (kilépés) egy fügvény ami a fizetendő számlát tartalmazza, ami  egy reservationId, ami visszaad egy HotelSercise interfésznek getInvoiceForRoom metódusát amely paraméterben megkap egy reservationId-t,
amiből elkészül a Invoice tipusú számla, amelynek két mezője van, az összesített ár és a InvoiceItem típusú items lista, melynek elemei:
vásárló neve, termék neve, termék ára, vásárlás  időpontja.
 
addProduct (kosárba rakás) függyvény ami kap egy termék nevet, egy árat,  korlátozás leírást, minimum életkort a vásárláshoz, hiba üzenetet és vissza ad egy HotelService interfész 
addNewBillable metúdust ami egy ProductServices típusú, melynek mezői  azonosító, név, ár, korlátozás. 