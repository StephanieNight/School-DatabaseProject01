/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ulriksandberg
 */
public class FXMLStartMenuController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Button adminBtn;
    @FXML
    private Button AnalysizBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void segueAdmin(ActionEvent event) throws IOException {
        
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLAdmin.fxml"));
        Scene newScene = new Scene(adminScene);
        
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();
        
    }

    @FXML
    private void segueAnalysiz(ActionEvent event) throws IOException {
        
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLAnalysiz.fxml"));
        Scene newScene = new Scene(adminScene);
        
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();
    
    }
    
}
