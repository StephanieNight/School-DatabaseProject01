/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import GUI.UI;
import aquiantince.*;
import buiss.BusinessFacade;
import buiss.BusinessFacade;
import data.DataFacade;
/**
 *
 * @author Stephanie
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        IData data = new DataFacade();
        IBuss business = new BusinessFacade();
        business.injectData(data);
        IGUI ui = new UI();
        ui.injectBusiness(business);
        
        System.out.println("Ready to launch system");
        ui.startApplication(args);
        
        
    }
    
}
