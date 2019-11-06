import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WindowDepartmentController {
    @FXML private TableView<Department> table;
    @FXML private TableColumn<Department, Integer> colId;
    @FXML private TableColumn<Department, String> colName;
    @FXML private TableColumn<Department, Double> colBudget;
    @FXML private TableColumn<Department, Double> colExpenses;
    @FXML private TableColumn<Department, String> colRentable;
    private ObservableList<Department> departments = FXCollections.observableArrayList();


    public void fill(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        colExpenses.setCellValueFactory(new PropertyValueFactory<>("expenses"));
        colRentable.setCellValueFactory(new PropertyValueFactory<>("rentable"));
        loadValues();
        table.setItems(departments);

    }

    public void loadValues(){
        departments = FXCollections.observableArrayList();
        departments.add(new Department(123, "A", 12,3,"Profit"));


    }

    @FXML public void initialize(){
        fill();
    }

    public void add(ActionEvent actionEvent) {
        WindowAddDepartment window = new WindowAddDepartment();
        window.show();
        Department department = window.getDepartment();
        departments.add(department);
    }

    public void edit(ActionEvent actionEvent) {
        Department department = table.getSelectionModel().getSelectedItem();
        int index = table.getSelectionModel().getSelectedIndex();
        if(department != null){
            WindowAddDepartment window = new WindowAddDepartment();
            window.show(department, false);
            departments.set(index, window.getDepartment());
            table.refresh();
        }
    }

    public void view(ActionEvent actionEvent) {
        Department department = table.getSelectionModel().getSelectedItem();
        if(department != null){
            WindowAddDepartment window = new WindowAddDepartment();
            window.show(department, true);
        }
    }

    public void delete(ActionEvent actionEvent) {
        departments.remove(table.getSelectionModel().getSelectedItem());
    }
}
