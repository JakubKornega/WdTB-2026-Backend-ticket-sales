package pl.wsb.bilety.zamowienie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import pl.wsb.bilety.bilet.entity.RodzajBiletu;

@Entity
@Table(name = "pozycja_zamowienia")
public class PozycjaZamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*jedno zamówienie ma wiele rodzajów biletów, a jeden rodzaj biletu jest w wielu zamówieniachś*/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zamowienie_id", nullable = false)
    private Zamowienie zamowienie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rodzaj_biletu_id", nullable = false)
    private RodzajBiletu rodzajBiletu;

    @Column(name = "ilosc", nullable = false)
    private Integer ilosc;

    @Column(name = "cena_jednostkowa", nullable = false, precision = 10, scale = 2)
    private BigDecimal cenaJednostkowa;

    protected PozycjaZamowienia() {
    }

    public PozycjaZamowienia(Zamowienie zamowienie, RodzajBiletu rodzajBiletu,
                             Integer ilosc, BigDecimal cenaJednostkowa) {
        this.zamowienie = zamowienie;
        this.rodzajBiletu = rodzajBiletu;
        this.ilosc = ilosc;
        this.cenaJednostkowa = cenaJednostkowa;
    }

    public Long getId() { return id; }
    public Zamowienie getZamowienie() { return zamowienie; }
    public RodzajBiletu getRodzajBiletu() { return rodzajBiletu; }
    public Integer getIlosc() { return ilosc; }
    public BigDecimal getCenaJednostkowa() { return cenaJednostkowa; }
}