# Projektmunka álláskereséshez

## Előszó
> Esősorban annyit szeretnék mondani hogy ez a projektmunka, elsősorban azért jött létre hogy prezentálni tudjam a jelenlegi tudásomat, 
> és ezt felhasználva el tudjak helyezkedni a magyarországi IT piacon.

## Alap információk
A webalkalmazás **alapjáraton a 9001-es portra van konfigurálva**, amennyiben változtatni szeretnénk rajta az applications.properties -ben váloztathatjuk

**Alapesetben H2(embedded) adatbázist használ az alkalmazás**, de lehetőség van átváltani MySQL szerverre, amihez profilokat hoztam létre a könnyebbség kedvéért
Váltani a applications.propertiesben: spring.profiles.active = *H2database*

Tesztek részlegesen vannak megírva, még tanulgatom a folyamatát.

**Dependency injectionok Setter alapon** vannak megoldva, mivel könnyebben tesztelhető így.

## Projekt során felhasznált technológiák
- Adatbázis (konfigurációk lejjebb)
  - JPA + Hibernate
  - H2
- Alap struktúráltsága Spring boot-nak
  - Controller
  - Service
  - Domain
  - Repository
  - Configuration
- Objektumok kezelése -> Dependency injections
- Profilok
  - Egyik profilban van megírva a H2(embedded database) konfigurációja
  - Másikban pedig egy Wampserverre csatlakozás volt írva a saját szerveremre (ddl-auto=UPDATE)
- Spring Beans
- Thymeleaf
-I18N (Internazionale)
  - Angol (default)
  - Magyar
- "Errorhandling page" egyedi oldal a kezelésére
- Frangmentek
  - Fejléce az oldalnak
  - Menüsáv
  - Header
- E-mail küldés és fogadás
- Lombok
- Mockito
- Actuator
  - nincs készítve külön weboldal neki, de a "default" /actuator/ parancsok alatt aktív  (ADMIN jogosultság only)
- Egyéb technológiák
  - HTML/CSS
  - JavaScript
  - Bootstrap
  - Devtools

## Spring boot Security
- **Thymeleaf security5** a frontenden sensitive adatok kezelésére
- Registration/Login
  - **bCryptPasswordEncoder** használ az applikáció a jelszavak mentésére és dekódolására
  - **ROLES** használata az adatbázisban kezelve és a weboldalnak tartalmainak elérhetőségének kezelésére
  - Basicauthentication használata tesztelési fázisban
  - Regisztráció:
    - Regex validálás frontend oldalon (legalább egy nagy- és egy kisbetűt kell tartalmaznia továbbá legalább 8 karakter hosszú legyen és tartalmazzon számot is)
    - Jelszó confirmálás
    - Email formátum ellenőrzés
  - Regisztráció után felkell mennie az e-mailjére a felhasználónak és az emailben megkapott **URL linkre kattintva aktiválja magát**
  - Alapértelmezett ROLE amit friss felhasználó kap: USER
  - Bejelentkezés után lehetőségünkvan egy kis egyszerű userprofil megtekintésére is

## Tervek
1. A public oldal(ak) teljes elkészítése olymódon hogy egy autókölcsönző/webáruház-ként üzemeljen
2. Teszteket rendesen megcsinálni
3. Saját profil teljes kibővítése: saját levelezések, profilkép és egyéb adatok editálása, stb...


Projektet készítette és a dokumentációt írta:
Somogyi György
![favicon](/src/main/resources/static/img/icons/favicon.jpg)
