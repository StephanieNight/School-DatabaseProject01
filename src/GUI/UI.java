/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import aquiantince.IBuilding;
import aquiantince.IBuss;
import aquiantince.IGUI;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ulriksandberg
 */
public class UI extends Application implements IGUI  {

    private static UI ui;
    private IBuss business;
    
    public static UI getInstance() {
        return ui;
    }
    
    Stage window;
    Parent parent1, parent2;
    Scene scene1, scene2;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        window = primaryStage;
        
        //Scene1
        parent1 = FXMLLoader.load(getClass().getResource("FXMLStartMenu.fxml"));
        scene1 = new Scene(parent1);
        primaryStage.setScene(scene1);
        primaryStage.show();
        
   
    }
 
    public void startApplication(String[] args) {
        System.out.println("UI initializing");
        ui = this;
        launch(args);
    }

    @Override
    public void injectBusiness(IBuss businessLayer) {
        this.business = businessLayer;
    }

    public IBuss getBusiness() {
        return business;
    }
    
    
    
    
    
      
    
    
    
    
}
