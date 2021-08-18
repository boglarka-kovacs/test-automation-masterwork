# test-automation-masterwork

## A Projekt áttekintése
Az Automata tesztelő képzéshez készült projekt, mely egy Webáruház tesztelését tartalmazza.

### A választott rendszer leírása:
A Webalkalmazás egy olyan nyílt forráskódú Webáruház, amely az OpenCart a GNU GPL v3.0 licenc alatt kiadott PHP alapú e-kereskedelmi rendszert használja.
Az alkalmazásban lehet regisztrálni, különböző elektronikai termékek között keresgélni, azokat megvásárolni, illetve a már korsárba tett termékeket módosítani.
Ezen túlmenően lehetőség van a termékek értékelésére, azok szöveges véleményezésére.

### A Webshop elérhetősége:
Az alkalmazás az alábbi linkre kattintva érhető el: [link](http://test-automation-shop2.greenfox.academy/)

### A manuális tesztesetek elérhetősége:
A tesztesetek az alábbi linkre kattintva érhetőek el: [link](https://drive.google.com/file/d/1h8_F5-aK1iq7LAbE5NyNG9O1qWU6J2-E/view?usp=sharing)

### Tesztelt funkciók:

  * Regisztráció
  * Bejelentkezés
  * Adatok listázása
  * Adatok bevitele
  * Adatok módosítása
  * Adatok törlése
  * Adatok mentése
  * Kiejelentkezés

### Tesztek futtatása:

Gradle projektben allure report generálásával Windows-on: gradlew clean test

Allure report megnyitása terminálban Windows-on: gradlew allureServe

Allure report megnyitása projektben: build/reports/allureReport/index.html

Allure repot online elérhetősége az allábbi linkre kattintva érhető el: [link](http://192.168.0.94:63180/index.html)
