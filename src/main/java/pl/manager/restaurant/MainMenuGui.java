package pl.manager.restaurant;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import pl.manager.restaurant.Entity.Worker;
import pl.manager.restaurant.Repo.WorkerRepo;

import java.util.List;

@Route("main-menu")
public class MainMenuGui extends VerticalLayout {

    WorkerRepo workerRepo;
    AddWorkerGUI addWorkerGUI;
    WorkerApi workerApi;
    WorkerManager workers;



    @Autowired
    public MainMenuGui(WorkerRepo workerRepo){
        Text textHello = new Text("Witaj w aplikacji pomagającej zarządzać barem lub restauracją! Wybierz opcje z menu poniżej");

        Button buttonAddWorker = new Button("Dodaj pracownika", new Icon(VaadinIcon.ARROW_RIGHT));
        buttonAddWorker.setIconAfterText(true);
        buttonAddWorker.addClickListener(e ->
                        buttonAddWorker.getUI().ifPresent(ui ->
                                ui.navigate("add-worker")));


        Button buttonShowWorkers = new Button("Pokaż wszystkich pracowników", new Icon(VaadinIcon.ARROW_RIGHT));
        buttonShowWorkers.setIconAfterText(true);
        buttonShowWorkers.addClickListener(e ->
                buttonShowWorkers.getUI().ifPresent(ui ->
                        ui.navigate("show-workers")));




        add(textHello, buttonAddWorker, buttonShowWorkers);
    }





}
