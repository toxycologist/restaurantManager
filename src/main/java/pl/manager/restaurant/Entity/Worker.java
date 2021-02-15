package pl.manager.restaurant.Entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Pracownicy")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private int perHour;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Worker() {
    }

    public Worker(String firstName, String lastName, LocalDate birthDay, int perHour, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.perHour = perHour;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getPerHour() {
        return perHour;
    }

    public void setPerHour(int perHour) {
        this.perHour = perHour;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
