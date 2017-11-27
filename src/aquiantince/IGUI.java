/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquiantince;

/**
 *
 * @author ulriksandberg
 */
public interface IGUI {
    
    void injectBusiness(IBuss businessLayer);
    void startApplication(String[] args);
    
    
}
