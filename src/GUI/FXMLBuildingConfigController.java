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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ulriksandberg
 */
public class FXMLBuildingConfigController implements Initializable {

    Stage window;
    FXMLAdminController parent;
    
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }  
    
    public void setParent(FXMLAdminController parent) {
        this.parent = parent;
    }

    @FXML
    private void createBuilding(ActionEvent event) throws IOException {
        
        if(this.nameTextField.getCharacters().length() < 1 || this.addressTextField.getCharacters().length() < 1) {
            
            errorLabel.setText("Either name or address is missing");
             
        } else {
            
            String stringValueOfName = (this.nameTextField.getCharacters()).toString();
            String stringValueOfAddres = (this.addressTextField.getCharacters()).toString();
            
            Stage stage = (Stage) errorLabel.getScene().getWindow();
            stage.close();
            
        }    
    }  
}
