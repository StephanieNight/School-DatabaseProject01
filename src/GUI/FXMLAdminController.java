/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import aquiantince.IBuilding;
import aquiantince.IBuss;
import aquiantince.IRoom;
import aquiantince.ISensor;
import aquiantince.SensorType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static sun.net.www.http.HttpClient.New;


/**
 * FXML Controller class
 *
 * @author ulriksandberg
 */
public class FXMLAdminController implements Initializable {

    
    IBuss business;
    FXMLBuildingConfigController popWindow;
    private IBuilding[] listOfBuildings;
    private IBuilding selectedBuilding;
    
    private IRoom[] listOfRooms;
    private IRoom selectedRoom;
    
    private ISensor[] listOfSensors;
    private ISensor selectedSensor;
    
    
    @FXML
    private Label currentBuilding;
    @FXML
    private Label currentRoom;
    @FXML
    private Label currentSensor;
    @FXML
    private ListView<String> buildingList;
    @FXML
    private ListView<String> roomList;
    @FXML
    private ListView<String> sensorList;
    
    //Set observers
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        business = UI.getInstance().getBusiness();
        
        this.setBuildingList();
        
    }    

    
    private void setBuildingList() {
        
         //Fetch current buildings
        listOfBuildings = business.getBuildings();
        
        //Convert objects to string for insertion in listview
        ObservableList<String> data = FXCollections.observableArrayList();
        for(IBuilding name: listOfBuildings) {
            data.add(name.toString());
        }
        
        //Set converted toString object into listView
        this.buildingList.setItems(data);
        
        if(listOfBuildings.length == 0) {
            currentBuilding.setText("There are no buildings yet");
        }    
    }
    
    private void setRoomList() {
        
        System.out.println("Set room list");
        
        //Fetch current rooms
        listOfRooms = business.getRoomsForCurrentBuilding(selectedBuilding);
        
        //Convert objects to string for insertion in listview
        ObservableList<String> data = FXCollections.observableArrayList();
        for(IRoom room: listOfRooms) {
            System.out.println(room.getName());
            data.add(room.getName());
        }
        
        //Set convered toString object into listVIew
        this.roomList.setItems(data);
        
        if(listOfRooms.length == 0) {
            currentRoom.setText("There are no rooms yet");
        }    
    }
    
    private void setSensorList() {
        
        System.out.println("Set sensor list");
        
        //Fetch current sensors
        listOfSensors = business.getSensorsForCurrentRoom(selectedRoom);
        
        //Convert objects to string for insertion in listview
        ObservableList<String> data = FXCollections.observableArrayList();
        for(ISensor sensor: listOfSensors) {
            System.out.println(sensor.getType());
            data.add(sensor.toString());
        }
        
        //Set converted toString object into listView
        this.sensorList.setItems(data);
        
        if(listOfSensors.length == 0) {
            currentSensor.setText("There are no sensors yet");
        }       
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
    private void addBuilding(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBuildingConfig.fxml")); 
        Scene scene = new Scene(root);
       
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        business.addBuilding("SDU", "Niels Bohrs Allé 150");
        this.setBuildingList();
        
    }
    
    
    @FXML
    private void removeBuilding(ActionEvent event) {
        
        if(this.selectedBuilding != null) {
            System.out.println("Should remove");
            business.removeBuilding(this.selectedBuilding);
            this.setBuildingList();
        } else {
            System.out.println("Not removing");
        }    
    }

    @FXML
    private void addRoom(ActionEvent event) {
        
        System.out.println("Pressed btn");
        business.addRoom(selectedBuilding, "Nyt Rum");
        
        this.setRoomList();
        
    }

    @FXML
    private void removeRoom(ActionEvent event) {
        
        if(this.selectedRoom != null) {
            System.out.println("Should remove");
            business.removeRoom(selectedBuilding, selectedRoom);
            this.setRoomList();
        } else {
            System.out.println("Not removing");
        }   
    }

    @FXML
    private void addTemp(ActionEvent event) {
        
        System.out.println("Adding temp sensor");
        business.addSensor(selectedRoom, SensorType.Temp);
        this.setSensorList();
        
    }

    @FXML
    private void addAir(ActionEvent event) {
        
        System.out.println("Adding air sensor");
        business.addSensor(selectedRoom, SensorType.Air);
        this.setSensorList();
           
    }

    @FXML
    private void removeSensor(ActionEvent event) {
        
        System.out.println("Remove senser");
        business.removeSensor(selectedRoom, selectedSensor);
        this.setSensorList();
        
        
        
    }

    @FXML
    private void mouseClickedBuilding(MouseEvent event) {
        ObservableList<String> selected;
        selected = buildingList.getSelectionModel().getSelectedItems();
        int IP = buildingList.getSelectionModel().getSelectedIndex();
        this.selectedBuilding = this.listOfBuildings[IP];
        currentBuilding.setText("Current Building: "+selected.get(0));
        
        //Set roomLisst to the respective building
        this.setRoomList();
        
        
    }

    @FXML
    private void mouseClickedRoom(MouseEvent event) {
        System.out.println("Room selections");
        
        ObservableList<String> selected;
        selected = roomList.getSelectionModel().getSelectedItems();
        int IP = roomList.getSelectionModel().getSelectedIndex();
        currentRoom.setText("Current Room: " + selected.get(0));
        this.selectedRoom = this.listOfRooms[IP];
        
        //Set sensorList to the respective room
        this.setSensorList();
        
    }

    @FXML
    private void mouseClickedSensor(MouseEvent event) {
        System.out.println("Sensor selection");
        
        ObservableList<String> selected;
        selected = sensorList.getSelectionModel().getSelectedItems();
        int IP = sensorList.getSelectionModel().getSelectedIndex();
        currentSensor.setText("Current sensor: " + selected.get(0));
        this.selectedSensor = this.listOfSensors[IP];
        
        //Set sensorList to the respectibe room
        this.setSensorList();
        
        
        
    }
    
    
    
    
}
