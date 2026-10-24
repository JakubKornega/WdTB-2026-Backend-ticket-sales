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
    ('Stand-up: Wieczór', 'Impart, Wrocław', '2026-11-28 20:00:00', 600, 'WYPRZEDANE'),
    ('Festiwal Jazzowy',  'Narodowe Forum Muzyki', '2027-01-23 18:00:00', 1800, 'PLANOWANE');

-- ===== LAB 02 · rodzaj_biletu =====
insert into rodzaj_biletu (nazwa, cena, ilosc_dostepna, poczatek_sprzedazy, aktywny) values
    ('Normalny',89.00, 2000, '2026-10-01', true),
    ('Ulgowy',59.00,  800, '2026-10-01', true),
    ('VIP',249.99,   50, '2026-11-01', false);

-- ===== LAB 02 · klient =====
insert into klient (imie_nazwisko, email, telefon, miasto, data_rejestracji) values
    ('Anna Kowalska',  'anna.kowalska@przyklad.com',  '600100200', 'Wrocław', '2026-10-01'),
    ('Jan Nowak','jan.nowak@przyklad.com',null,'Opole','2026-10-12'),
    ('Ewa Wiśniewska', 'ewa.wisniewska@przyklad.com', '600500600', null,'2026-10-20');