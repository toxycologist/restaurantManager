package pl.manager.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.manager.restaurant.entity.Role;
import pl.manager.restaurant.entity.Worker;
import pl.manager.restaurant.repo.WorkerRepo;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class WorkerManager {

    private WorkerRepo workerRepo;

    @Autowired
    public WorkerManager(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
    }

    public Optional<Worker> findById(Long id) {
        return workerRepo.findById(id);
    }

    public Iterable<Worker> findAll() {
        return workerRepo.findAll();
    }

    public Worker save(Worker worker) {
        return workerRepo.save(worker);
    }

    public void deleteById(Long id) {
        workerRepo.deleteById(id);
    }



/*    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Worker(1L, "Marcin", "Kiepura", LocalDate.of(1994, 6, 1), 21, Role.LIDER));
        save(new Worker(2L, "Piotr", "Wierzbicki", LocalDate.of(1974, 1, 9), 25, Role.MANAGER));
        save(new Worker(3L, "Piotr", "Broniszewski", LocalDate.of(1992, 11, 21), 22, Role.LIDER));
        save(new Worker(4L, "Damian", "Dawiskiba", LocalDate.of(1995, 3, 12), 23, Role.LIDER));
        save(new Worker(5L, "Karolina", "Skalik", LocalDate.of(1993, 5, 12), 20, Role.BARMAN));
    }*/


}
