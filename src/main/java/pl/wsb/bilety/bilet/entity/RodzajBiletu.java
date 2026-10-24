package pl.wsb.bilety.bilet.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rodzaj_biletu")
public class RodzajBiletu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa", nullable = false, length = 40)
    private String nazwa;

    @Column(name = "cena", nullable = false, precision = 10, scale = 2)
    private BigDecimal cena;

    @Column(name = "ilosc_dostepna", nullable = false)
    private Integer iloscDostepna;

    @Column(name = "poczatek_sprzedazy", nullable = false)
    private LocalDate poczatekSprzedazy;

    @Column(name = "aktywny", nullable = false)
    private Boolean aktywny;

    protected RodzajBiletu() {
    }

    public RodzajBiletu(String nazwa, BigDecimal cena, Integer iloscDostepna, LocalDate poczatekSprzedazy, Boolean aktywny) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.iloscDostepna = iloscDostepna;
        this.poczatekSprzedazy = poczatekSprzedazy;
        this.aktywny = aktywny;
    }

    public Long getId() { return id; }
    public String getNazwa() { return nazwa; }
    public BigDecimal getCena() { return cena; }
    public Integer getIloscDostepna() { return iloscDostepna; }
    public LocalDate getPoczatekSprzedazy() { return poczatekSprzedazy; }
    public Boolean getAktywny() { return aktywny; }
}