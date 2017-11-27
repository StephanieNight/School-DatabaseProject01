/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import aquiantince.IBuilding;
import aquiantince.IBuss;
import aquiantince.IReadings;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ulriksandberg
 */
public class FXMLAnalysizController implements Initializable {

    
    private IBuss business;
    private IBuilding[] listOfBuildings;
    private IBuilding selectedBuilding;
    
    private IReadings[] listOfReadings;
    
    @FXML
    private Button inspectBuilding;
    @FXML
    private Button backLabel;
    @FXML
    private ListView<String> myListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        business = UI.getInstance().getBusiness();
        
        System.out.println("Initializing");
        
        //Fetch current buildings
        listOfBuildings = business.getBuildings();
        
        //Convert objects to string for insertion in listview
        ObservableList<String> data = FXCollections.observableArrayList();
        for(IBuilding name: listOfBuildings) {
            data.add(name.toString());
        }
        
        //Set converted toString object into listView
        this.myListView.setItems(data);
        
        if(listOfBuildings.length == 0) {
            System.out.println("there are no buildings");
        } 
        
        
        
    }    

    private void setGraph() {
        
        //Get data from business
        //IReadings readings = 
        
        
        
    }
    
    
    
    
    @FXML
    private void inspectBuilding(ActionEvent event) throws IOException {
        
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLAnalysizRoom.fxml"));
        Scene newScene = new Scene(adminScene);
        
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();
        
        
    }

    @FXML
    private void backBtn(ActionEvent event) throws IOException {
        
        Parent adminScene = FXMLLoader.load(getClass().getResource("FXMLStartMenu.fxml"));
        Scene newScene = new Scene(adminScene);
        
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(newScene);
        appStage.show();
        
    }

    @FXML
    private void listChosen(MouseEvent event) {
        
        ObservableList<String> selected;
        selected = myListView.getSelectionModel().getSelectedItems();
        int IP = myListView.getSelectionModel().getSelectedIndex();
        this.selectedBuilding = this.listOfBuildings[IP];
        
        this.setGraph();
        
        
        
    }
    
}
