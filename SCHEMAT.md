# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 6 · kolumny: 35 · relacje: 4 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| klient | Klient | 7 | user_account_id |
| pozycja_zamowienia | PozycjaZamowienia | 5 | rodzaj_biletu_id, zamowienie_id |
| rodzaj_biletu | RodzajBiletu | 7 | wydarzenie_id |
| user_account | UserAccount | 5 | — |
| wydarzenie | Wydarzenie | 6 | — |
| zamowienie | Zamowienie | 5 | klient_id |

```mermaid
erDiagram
    klient {
        Long id PK
        LocalDate data_rejestracji
        String email
        String imie_nazwisko
        String miasto
        String telefon
        Long user_account_id FK
    }
    pozycja_zamowienia {
        Long id PK
        BigDecimal cena_jednostkowa
        Integer ilosc
        Long rodzaj_biletu_id FK
        Long zamowienie_id FK
    }
    rodzaj_biletu {
        Long id PK
        Boolean aktywny
        BigDecimal cena
        Integer ilosc_dostepna
        String nazwa
        LocalDate poczatek_sprzedazy
        Long wydarzenie_id FK
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    wydarzenie {
        Long id PK
        LocalDateTime data_wydarzenia
        String miejsce
        String nazwa
        Integer pojemnosc
        String status
    }
    zamowienie {
        Long id PK
        LocalDateTime data_zamowienia
        Long klient_id FK
        BigDecimal laczna_kwota
        String status
    }
    klient ||--o{ zamowienie : "klient_id"
    rodzaj_biletu ||--o{ pozycja_zamowienia : "rodzaj_biletu_id"
    user_account |o--o| klient : "user_account_id"
    wydarzenie ||--o{ rodzaj_biletu : "wydarzenie_id"
    zamowienie ||--o{ pozycja_zamowienia : "zamowienie_id"
```
