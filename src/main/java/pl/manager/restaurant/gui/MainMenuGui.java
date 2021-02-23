package pl.manager.restaurant.gui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.manager.restaurant.WorkerApi;
import pl.manager.restaurant.WorkerManager;
import pl.manager.restaurant.gui.AddWorkerGui;
import pl.manager.restaurant.repo.WorkerRepo;

@Route("main-menu")
public class MainMenuGui extends VerticalLayout {

    WorkerRepo workerRepo;
    AddWorkerGui addWorkerGUI;
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
