package pl.wsb.bilety.klient.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import pl.wsb.bilety.account.domain.UserAccount;

@Entity
@Table(name = "klient")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imie_nazwisko", nullable = false, length = 80)
    private String imieNazwisko;

    @Column(name = "email", nullable = false, unique = true, length = 120)
    private String email;

    @Column(name = "telefon", length = 20)
    private String telefon;

    @Column(name = "miasto", length = 40)
    private String miasto;

    @Column(name = "data_rejestracji", nullable = false)
    private LocalDate dataRejestracji;

    @OneToOne(fetch = FetchType.LAZY) /*klient ma najwyżej jedno konto użytkownika, a konto należy do najwyżej jednego klienta*/
    @JoinColumn(name = "user_account_id")
    private UserAccount konto;

    protected Klient() {
    }

    public Klient(String imieNazwisko, String email, String telefon, String miasto,
                  LocalDate dataRejestracji, UserAccount konto) {
        this.imieNazwisko = imieNazwisko;
        this.email = email;
        this.telefon = telefon;
        this.miasto = miasto;
        this.dataRejestracji = dataRejestracji;
        this.konto = konto;
    }

    public Long getId() { return id; }
    public String getImieNazwisko() { return imieNazwisko; }
    public String getEmail() { return email; }
    public String getTelefon() { return telefon; }
    public String getMiasto() { return miasto; }
    public LocalDate getDataRejestracji() { return dataRejestracji; }
    public UserAccount getKonto() { return konto; }
}