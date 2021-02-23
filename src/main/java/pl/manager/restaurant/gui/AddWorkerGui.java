package pl.manager.restaurant.gui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.manager.restaurant.entity.Role;
import pl.manager.restaurant.entity.Worker;
import pl.manager.restaurant.repo.WorkerRepo;

import java.time.LocalDate;

@Route("add-worker")
public class AddWorkerGui extends VerticalLayout {

    private WorkerRepo workerRepo;




    @Autowired
    public AddWorkerGui(WorkerRepo workerRepo){
        this.workerRepo = workerRepo;
        Text textAdd = new Text("Wprowadź proszę dane pracownika, którego chesz dodać do bazy danych");
        TextField textFieldFirstName = new TextField("Imię:");
        TextField textFieldLastName = new TextField("Nazwisko:");
        DatePicker datePickerBirthday = new DatePicker("Data urodzenia");
        IntegerField integerFieldPerHour = new IntegerField("Stawka [zł/h]");
        ComboBox<Role> comboBoxRole = new ComboBox<>();

        Dialog dialogAddedWorker = new Dialog();
        dialogAddedWorker.setCloseOnEsc(false);
        dialogAddedWorker.setCloseOnOutsideClick(false);
        Span messageOK = new Span("Dodano nowego pracownika!   ");
        Button confirmButton = new Button("Ok najs!", event -> {
                        dialogAddedWorker.close();
        });
        dialogAddedWorker.add(messageOK, confirmButton);



        comboBoxRole.setItems(Role.MANAGER, Role.BARMAN, Role.LIDER);
        comboBoxRole.setLabel("Wybierz rolę");

        Button buttonMainMenu = new Button("Powrót do menu głównego");
        buttonMainMenu.addClickListener(e ->
                buttonMainMenu.getUI().ifPresent(ui ->
                        ui.navigate("main-menu")));

        Button buttonSaveWorker = new Button("Dodaj pracownika", new Icon(VaadinIcon.THUMBS_UP));
        buttonSaveWorker.setIconAfterText(true);
        buttonSaveWorker.addClickListener(ClickEvent -> {
            addWorker(textFieldFirstName, textFieldLastName, datePickerBirthday,
                    integerFieldPerHour, comboBoxRole);
            textFieldFirstName.clear();
            textFieldLastName.clear();
            datePickerBirthday.clear();
            integerFieldPerHour.clear();
            comboBoxRole.clear();
            dialogAddedWorker.open();
        });




        add(textAdd, textFieldFirstName, textFieldLastName,
                datePickerBirthday, integerFieldPerHour, comboBoxRole, buttonSaveWorker,
                buttonMainMenu, dialogAddedWorker);
    }




    public void addWorker(TextField textFieldName, TextField textFieldLastName,DatePicker datePickerBirthday,
                          IntegerField integerFieldPerHour, ComboBox<Role> comboBoxRole){
        Worker worker = new Worker();
        worker.setFirstName(String.valueOf(textFieldName.getValue()));
        worker.setLastName(String.valueOf(textFieldLastName.getValue()));
        worker.setBirthDay(LocalDate.from(datePickerBirthday.getValue()));
        worker.setPerHour(Integer.parseInt(String.valueOf(integerFieldPerHour.getValue())));
        worker.setRole(comboBoxRole.getValue());
        workerRepo.save(worker);

    }



}
