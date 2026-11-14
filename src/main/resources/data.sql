-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('jakub.kornega@student.merito.pl','Kuba','USER',current_timestamp),
    ('natalia.krekora@student.merito.pl','Natalia','USER',current_timestamp),
    ('test@student.merito.pl','test','USER',current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);


-- ===== LAB 02 · wydarzenie =====
insert into wydarzenie (nazwa, miejsce, data_wydarzenia, pojemnosc, status) values
    ('Koncert Rockowy',   'Hala Orbita, Wrocław',  '2026-11-14 19:00:00', 4500, 'W SPRZEDAŻY'),
    ('Stand-up: Wieczór', 'Impart, Wrocław',       '2026-11-28 20:00:00',  600, 'WYPRZEDANE'),
    ('Festiwal Jazzowy',  'Narodowe Forum Muzyki', '2027-01-23 18:00:00', 1800, 'PLANOWANE');

-- ===== LAB 02 · rodzaj_biletu ===== (wydarzenie_id wskazuje wiersze z tabeli wydarzenie)
insert into rodzaj_biletu (nazwa, cena, ilosc_dostepna, poczatek_sprzedazy, aktywny, wydarzenie_id) values
    ('Normalny',   89.00, 2000, '2026-10-01', true,  1),
    ('Ulgowy',     59.00,  800, '2026-10-01', true,  1),
    ('VIP',       249.99,   50, '2026-11-01', false, 3);

-- ===== LAB 02 · klient ===== (user_account_id wskazuje konta z user_account)
insert into klient (imie_nazwisko, email, telefon, miasto, data_rejestracji, user_account_id) values
     ('Anna Kowalska',  'anna.kowalska@example.com',  '600100200', 'Wrocław', '2026-10-01', 1),
     ('Jan Nowak',      'jan.nowak@example.com',      null,        'Opole',   '2026-10-12', 2),
     ('Ewa Wiśniewska', 'ewa.wisniewska@example.com', '600500600', null,      '2026-10-20', null);

-- ===== LAB 03 · zamowienie =====
insert into zamowienie (klient_id, data_zamowienia, status, laczna_kwota) values
    (1, '2026-11-01 10:15:00', 'OPLACONE', 237.00),
    (2, '2026-11-05 18:40:00', 'NOWE',      89.00),
    (1, '2026-11-08 09:05:00', 'OPLACONE',  59.00);

-- ===== LAB 03 · pozycja_zamowienia =====
insert into pozycja_zamowienia (zamowienie_id, rodzaj_biletu_id, ilosc, cena_jednostkowa) values
      (1, 1, 2, 89.00),
      (1, 2, 1, 59.00),
      (2, 1, 1, 89.00),
      (3, 2, 1, 59.00);