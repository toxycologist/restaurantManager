package pl.manager.restaurant;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.manager.restaurant.Repo.WorkerRepo;

@Route("main-menu")
public class MainMenuGui extends VerticalLayout {

    WorkerRepo workerRepo;

    @Autowired
    public MainMenuGui(WorkerRepo workerRepo){
        Text textHello = new Text("Witaj w aplikacji pomagającej zarządzać barem lub restauracją! Wybierz opcje z menu poniżej");
        Button buttonAddWorker = new Button("Dodaj pracownika");
        add(textHello, buttonAddWorker);
    }

}
