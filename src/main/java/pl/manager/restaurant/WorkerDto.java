package pl.manager.restaurant;

import pl.manager.restaurant.entity.Role;

import java.time.LocalDate;

public interface WorkerDto {

    Long getId();
    String getFirstName();
    String getLastName();
    LocalDate getBirthDay();
    int getPerHour();
    Role getRole();

}
