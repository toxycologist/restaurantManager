package pl.manager.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.manager.restaurant.Entity.Worker;
import java.util.Optional;

@RestController
@RequestMapping("/api/workers")
public class WorkerApi {


    private WorkerManager workers;

    @Autowired
    public WorkerApi(WorkerManager workers) {
        this.workers = workers;
    }

    @GetMapping("/all")
    public Iterable<Worker> getAll() {
        return workers.findAll();
    }

    @GetMapping
    public Optional<Worker> getById(@RequestParam Long index) {
        return workers.findById(index);
    }

    @PostMapping
    public Worker addWorker(@RequestBody Worker worker) {
        return workers.save(worker);
    }

    @PutMapping
    public Worker updateWorker(@RequestBody Worker worker) {
        return workers.save(worker);
    }

    @DeleteMapping
    public void deleteWorker(@RequestParam Long index) {
        workers.deleteById(index);
    }
}
