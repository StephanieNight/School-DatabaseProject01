/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquiantince;

import java.util.UUID;

/**
 *
 * @author Stephanie
 */
public interface ISensor {
    
    void setValue(double value);
    double getValue();
    SensorType getType();
    UUID getId();
    IReadings[] getReadings();
    void makeReading(int id);
    void addReading(IReadings reading);
    String toString();
    
    
}
