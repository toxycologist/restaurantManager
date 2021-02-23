package pl.manager.restaurant.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.manager.restaurant.WorkerDto;
import pl.manager.restaurant.entity.Worker;

import java.util.List;

@Repository
public interface WorkerRepo extends CrudRepository<Worker, Long> {

    @Query(value = "SELECT id as Id, first_name as firstName, last_name as lastName, birth_day as birthDay, per_hour as perHour, role as Role FROM pracownicy", nativeQuery = true)
    List<WorkerDto> getWorkers();
}
