package pl.wsb.bilety.zamowienie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import pl.wsb.bilety.klient.entity.Klient;

@Entity
@Table(name = "zamowienie")
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "klient_id", nullable = false)
    private Klient klient;

    @Column(name = "data_zamowienia", nullable = false)
    private LocalDateTime dataZamowienia;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "laczna_kwota", nullable = false, precision = 10, scale = 2)
    private BigDecimal lacznaKwota;

    protected Zamowienie() {
    }

    public Zamowienie(Klient klient, LocalDateTime dataZamowienia, String status, BigDecimal lacznaKwota) {
        this.klient = klient;
        this.dataZamowienia = dataZamowienia;
        this.status = status;
        this.lacznaKwota = lacznaKwota;
    }

    public Long getId() { return id; }
    public Klient getKlient() { return klient; }
    public LocalDateTime getDataZamowienia() { return dataZamowienia; }
    public String getStatus() { return status; }
    public BigDecimal getLacznaKwota() { return lacznaKwota; }
}