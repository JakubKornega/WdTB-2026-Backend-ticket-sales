package pl.wsb.bilety.bilet.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import pl.wsb.bilety.wydarzenie.entity.Wydarzenie;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false) /*rodzaj biletu należy do jednego wydarzenia*/
    @JoinColumn(name = "wydarzenie_id", nullable = false)
    private Wydarzenie wydarzenie;

    protected RodzajBiletu() {
    }

    public RodzajBiletu(String nazwa, BigDecimal cena, Integer iloscDostepna,
                        LocalDate poczatekSprzedazy, Boolean aktywny, Wydarzenie wydarzenie) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.iloscDostepna = iloscDostepna;
        this.poczatekSprzedazy = poczatekSprzedazy;
        this.aktywny = aktywny;
        this.wydarzenie = wydarzenie;
    }

    public Long getId() { return id; }
    public String getNazwa() { return nazwa; }
    public BigDecimal getCena() { return cena; }
    public Integer getIloscDostepna() { return iloscDostepna; }
    public LocalDate getPoczatekSprzedazy() { return poczatekSprzedazy; }
    public Boolean getAktywny() { return aktywny; }
    public Wydarzenie getWydarzenie() { return wydarzenie; }
}