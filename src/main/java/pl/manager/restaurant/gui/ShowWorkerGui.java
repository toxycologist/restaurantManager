package pl.manager.restaurant.gui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.manager.restaurant.WorkerDto;
import pl.manager.restaurant.repo.WorkerRepo;

import java.util.List;

@Route("show-workers")
public class ShowWorkerGui extends VerticalLayout {

    private WorkerRepo workerRepo;



    public ShowWorkerGui(WorkerRepo workerRepo) {
        Button buttonMainMenu = new Button("Powrót do menu głównego");
        buttonMainMenu.addClickListener(e ->
                buttonMainMenu.getUI().ifPresent(ui ->
                        ui.navigate("main-menu")));


        Text textWorkers = new Text("Lista obecnych pracowników");



        this.workerRepo = workerRepo;
        List<WorkerDto> workerList = workerRepo.getWorkers();
        Grid<WorkerDto> grid = new Grid<>(WorkerDto.class);
        grid.setItems(workerList);
        grid.removeAllColumns();

        grid.addColumn(WorkerDto::getId).setHeader("#").setSortable(true);
        grid.addColumn(WorkerDto::getFirstName).setHeader("Imię").setSortable(true);
        grid.addColumn(WorkerDto::getLastName).setHeader("Nazwisko").setSortable(true);
        grid.addColumn(WorkerDto::getBirthDay).setHeader("Data urodzenia").setSortable(true);
        grid.addColumn(WorkerDto::getPerHour).setHeader("Stawka [zł/h]").setSortable(true);
        grid.addColumn(WorkerDto::getRole).setHeader("Stanowisko").setSortable(true);

        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);


        Dialog dialogDeletedWorker = new Dialog();
        dialogDeletedWorker.setCloseOnEsc(false);
        dialogDeletedWorker.setCloseOnOutsideClick(false);
        Span messageOK = new Span("Usunięto pracownika!");
        Button confirmButton = new Button("OK!", event -> {
            UI.getCurrent().getPage().reload();
            dialogDeletedWorker.close();
        });
        dialogDeletedWorker.add(messageOK, confirmButton);

        TextField textFieldDeleteWorker = new TextField("Wpisz ID pracowika, którego chcesz usunąć");
        textFieldDeleteWorker.setWidth("300px");

        Button buttonDeleteWorker = new Button("Usuń pracownika!   ");
        buttonDeleteWorker.addClickListener(ClickEvent ->  {
            deleteWorker(textFieldDeleteWorker);
            textFieldDeleteWorker.clear();
            dialogDeletedWorker.open();
                                });





        add(textWorkers, grid, buttonMainMenu, textFieldDeleteWorker, buttonDeleteWorker, dialogDeletedWorker);

    }

    public void deleteWorker(TextField textFieldDeleteWorker){
        workerRepo.deleteById(Long.parseLong(textFieldDeleteWorker.getValue()));
                    }


}
