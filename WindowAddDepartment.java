import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowAddDepartment {
    private Department department;

    public void show(){
        show(null, false);
    }

    public void show(Department department, boolean view){
        this.department = department;
        FXMLLoader loader = new FXMLLoader();
        Pane sceneGraph = null;
        try{
            sceneGraph = loader.load(getClass().getResource("ManageDepartmentsView.fxml").openStream());
            Scene scene = new Scene(sceneGraph, 400, 300);
            ManageDepartmentsController controller = loader.getController();
            if(department != null){
                controller.setDepartment(department);
                controller.disable(view);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            this.department = controller.getDepartment();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Department getDepartment() {
        return department;
    }
}
