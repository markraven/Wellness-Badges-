|**Rendszer megnevezése**|Wellness badges|
| :- | :- |
|**Tesztelés várható időtartama**|4 munkanap|
|**Tesztelés erőforrás-szükséglete Vállalkozó oldalon**|Szerver, terminál szimuláció, foglalás szimuláció|
|**Tesztelés erőforrás-szükséglete Felhasználó oldalon**|Szerver, terminál, szoba foglalási rendszer|

Átvételi eljáráson résztvevő:

Vállalkozó részéről:

Név: Nagy Szabolcs Máté

Beosztás: Fejlesztő

Dátum: 2020.12.30


|**Sorszám**|**Funkció leírása**|**Vizsgálat módja/eszköze**|**Elvárt eredmény**|**Aktuális eredmény**|**Megfelelősség státusza**|
| :- | :- | :- | :- | :- | :- |
|Általános funkcionális teszt|
|1.|Hotel Termékek hozzáadás|<p>Swagger,</p><p>Opera GX Böngésző</p>|<p>Adatbázisban új termék jelenik meg</p><p></p>|<p>Adatbázisban új termék jelenik meg</p><p></p>|Megfelelő|
|2.|Termékek lekérése|<p>Swagger,</p><p>Mozzilla Böngésző</p>|Visszatér az összes termékkel|Visszatér az összes termékkel|Megfelelő|
|3.|Szobafoglalás|<p>Swagger,</p><p>Opera GX Böngésző</p>|Dátum és vendégek száma alapján foglalás leadása, adatbázisba felvétel|Dátum és vendégek száma alapján foglalás leadása, adatbázisba felvétel|Megfelelő|
|4.|Foglalások lekérése|<p>Swagger,</p><p>Opera GX Böngésző</p>|Visszatér az összes szobafoglalással|Visszatér az összes szobafoglalással|Megfelelő|
|5.|Becsekkolás|<p>Swagger,</p><p>Opera GX Böngésző</p>|ID megkapása, szobaszám megadásával,|ID megkapása, szobaszám megadásával,|Megfelelő|
|6.|Vásárlás|<p>Swagger,</p><p>Opera GX Böngésző</p>|Számla adatbázis táblára felveszi a vendéget, mennyiséget és terméket|Számla adatbázis táblára felveszi a vendéget, mennyiséget és terméket|Megfelelő|
|7.|Vendégek lekérése|<p>Swagger,</p><p>Opera GX Böngésző</p>|Visszatér az összes vendéggel|Visszatér az összes vendéggel|Megfelelő|
|8.|Kicsekkolás|<p>Swagger,</p><p>Opera GX Böngésző</p>|ID-k visszaadása, számla létrehozása szoba alapján|ID-k visszaadása, számla létrehozása szoba alapján|Megfelelő|
|9.|Termék felvétel|Development szerver, Opera GX böngésző|A kor és árhoz csak számok írhatók, a termék névhez és leíráshoz szöveges tartalom kerülhet. A Submit gomb lenyomására az adatot elküldi a szervernek és a szerver az adatbázisba feltölti.|A kor és árhoz csak számok írhatók, a termék névhez és leíráshoz szöveges tartalom kerülhet. A Submit gomb lenyomására az adatot elküldi a szervernek és a szerver az adatbázisba feltölti.|Megfelelő|
|10.|Szoba foglalás|Development szerver, Opera GX böngésző|A vendég számhoz csak számot lehet írni, Az érkezés és távozási dátumhoz csak dátumot lehet megadni. Az érkezés dátuma nem lehet később, mint a távozás dátuma. Az aktuális dátumhoz képest korábban ne lehessen foglalni. A lefoglalás után egy viszajelzést kapjunk, hogy melyik szoba került lefoglalásra.|A vendég számhoz csak számot lehet írni, Az érkezés és távozási dátumhoz csak dátumot lehet megadni. Az érkezés dátuma nem lehet később, mint a távozás dátuma.Az aktuális dátumhoz képest korábban is lehet lefoglalni szobát. A lefoglalás „megtörténik” azonban nem kapunk visszajelzést arról, melyik számú szoba került megkapásra.|Pótlás|
|11.|Becsekkolás|Development szerver, Opera GX böngésző|Vendégeket lehet név és születési dátum szerint felvinni, amiket egyszerre tudunk elküldeni a szervernek. Az eddig beírt vendég adatai az add new guest gomb hatására megjelenik, mint visszajelzés. Esetleges elírás esetén modosítható vagy törölhető a bevitt adat(ok).  A dátumok beállításával és a korábban megkapott szobaszámmal, ellenőrizni tudjuk, hogy elférnek e a szobáknál, illetve megtörténik-e a tényleges csekkolás.|A vendégek születési dátumát csak dátumként tudjuk megadni, a nevet pedig szöveg típusként. Az add new guest gomb hatására megjelenik a bevitt adat(ok), azonban a törlés és modosítás gomb hiányos. A dátumok beállításával és a korábban megkapott szobaszámmal, ellenőrizni tudjuk, hogy elférnek-e a szobáknál, illetve megtörténik-e a tényleges csekkolás.|Pótlás|

