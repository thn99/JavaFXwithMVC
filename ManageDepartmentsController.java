import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManageDepartmentsController {

    private Department department;

    @FXML TextField txtId;
    @FXML TextField txtName;
    @FXML TextField txtBudget;
    @FXML TextField txtExpenses;

    public void setDepartment(Department department){
        this.department = department;
        txtId.setText(String.valueOf(department.getId()));
        txtName.setText(department.getName());
        txtBudget.setText(String.valueOf(department.getBudget()));
        txtExpenses.setText(String.valueOf(department.getExpenses()));

    }

    public Department getDepartment(){
        if(department == null) department = new Department();
        department.setId(Integer.parseInt(txtId.getText()));
        department.setName(txtName.getText());
        department.setBudget(Double.parseDouble(txtBudget.getText()));
        department.setExpenses(Double.parseDouble(txtExpenses.getText()));
        if(department.getBudget() > department.getExpenses()){
            department.setRentable("Profit");
        } else {
            department.setRentable("Broke");
        }
        return department;
    }

    public void disable(boolean view){
        txtId.setDisable(true);
        if(view){
            txtName.setDisable(true);
            txtBudget.setDisable(true);
            txtExpenses.setDisable(true);
        }
    }

    public void save(ActionEvent actionEvent) { ((Stage)txtId.getScene().getWindow()).close(); }
}
