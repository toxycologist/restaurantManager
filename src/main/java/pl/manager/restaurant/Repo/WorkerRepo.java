package pl.manager.restaurant.Repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.manager.restaurant.Entity.Worker;

@Repository
public interface WorkerRepo extends CrudRepository<Worker, Long> {
}
