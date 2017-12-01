/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquiantince;
import java.util.Date;
import java.util.UUID;
/**
 *
 * @author Stephanie
 */
public interface IReadings {
    
    int getTime();
    Double getValue();
    UUID getId();
    SensorType getType(); 
}
