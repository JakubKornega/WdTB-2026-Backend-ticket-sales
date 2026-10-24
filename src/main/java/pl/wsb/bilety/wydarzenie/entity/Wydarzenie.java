package pl.wsb.bilety.wydarzenie.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wydarzenie")
public class Wydarzenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa", nullable = false, length = 80)
    private String nazwa;

    @Column(name = "miejsce", nullable = false, length = 80)
    private String miejsce;

    @Column(name = "data_wydarzenia", nullable = false)
    private LocalDateTime dataWydarzenia;

    @Column(name = "pojemnosc", nullable = false)
    private Integer pojemnosc;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    protected Wydarzenie() {
    }

    public Wydarzenie(String nazwa, String miejsce, LocalDateTime dataWydarzenia, Integer pojemnosc, String status) {
        this.nazwa = nazwa;
        this.miejsce = miejsce;
        this.dataWydarzenia = dataWydarzenia;
        this.pojemnosc = pojemnosc;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getNazwa() { return nazwa; }
    public String getMiejsce() { return miejsce; }
    public LocalDateTime getDataWydarzenia() { return dataWydarzenia; }
    public Integer getPojemnosc() { return pojemnosc; }
    public String getStatus() { return status; }
}