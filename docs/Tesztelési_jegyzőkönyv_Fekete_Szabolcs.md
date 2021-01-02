|**Rendszer megnevezése**|Wellness badges|
| :- | :- |
|**Tesztelés várható időtartama**|3 munkanap|
|**Tesztelés erőforrás-szükséglete Vállalkozó oldalon**|szerver, terminál szimuláció,|
|**Tesztelés erőforrás-szükséglete Felhasználó oldalon**|Szerver, terminál|

Átvételi eljáráson résztvevők:

Vállalkozó részéről:

Név: Fekete Szabolcs

Beosztás: Backend Fejlesztő

Dátum: 2020.12.30

Végső kedvezményezett részéről:

Név:

Beosztás:

Dátum:


|**Sorszám**|**Funkció leírása**|**Vizsgálat módja/eszköze**|**Elvárt eredmény**|**Aktuális eredmény**|**Megfelelősség státusza**|
| :- | :- | :- | :- | :- | :- |
|Általános funkcionális teszt|
|1.|Szobafoglalás|<p>Swagger,</p><p>Chrome Böngésző</p>|Dátum és vendégek száma alapján foglalás leadása, adatbázisba felvétel|Dátum és vendégek száma alapján foglalás leadása, adatbázisba felvétel|Megfelelő|
|2.|Becsekkolás|<p>Swagger,</p><p>Chrome Böngésző</p>|Név megadása, ID megkapása, szobaszám megadásával,|Név megadása, ID megkapása, szobaszám megadásával,|Megfelelő|
|3.|Hotel Termékek hozzáadás|<p>Swagger,</p><p>Chrome Böngésző</p>|Adatbázisban új termék jelenik meg|Adatbázisban új termék jelenik meg|Megfelelő|
|4.|Vásárlás|<p>Swagger,</p><p>Chrome Böngésző</p>|Számla adatbázis táblára felveszi a vendéget, mennyiséget és terméket|Számla adatbázis táblára felveszi a vendéget, mennyiséget és terméket|Megfelelő|
|5.|Kicsekkolás|<p>Swagger,</p><p>Chrome Böngésző</p>|ID-k visszaadása, számla létrehozása szoba alapján|ID-k visszaadása, számla létrehozása szoba alapján|Megfelelő|
|6.|Vendégek lekérése|<p>Swagger,</p><p>Chrome Böngésző</p>|Visszatér az összes vendéggel|Visszatér az összes vendéggel|Megfelelő|
|7.|Termékek lekérése|<p>Swagger,</p><p>Chrome Böngésző</p>|Visszatér az összes termékkel|Visszatér az összes termékkel|Megfelelő|
|8.|Foglalások lekérése|<p>Swagger,</p><p>Chrome Böngésző</p>|Visszatér az összes szobafoglalással|Visszatér az összes szobafoglalással|Megfelelő|
|9.|Szobafoglalás|<p>Development server,</p><p>Chrome Böngésző</p>|Dátum és vendégek száma alapján foglalás leadása, adatbázisba felvétel|Nem adja vissza a szobaszámot a foglalás után.|Pótálás|
|10.|Becsekkolás|<p>Development server,</p><p>Chrome Böngésző</p>|Név megadása, ID megkapása, szobaszám megadásával,|Név megadása, ID megkapása, szobaszám megadásával,|Megfelelő|

