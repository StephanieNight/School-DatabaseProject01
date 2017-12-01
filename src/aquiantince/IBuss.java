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
public interface IBuss {
    
    void addBuilding(String name, String address);
    void addRoom(IBuilding building, String name);
    void removeRoom(IBuilding building, IRoom room);
    Boolean removeBuilding(IBuilding building);
    IBuilding[] getBuildings();
    void injectData(IData dataLayer);
    IRoom[] getRoomsForCurrentBuilding(IBuilding building);
    ISensor[] getSensorsForCurrentRoom(IRoom room);
    void addSensor(IRoom room, SensorType type);
    void removeSensor(IRoom room, ISensor sensor);
    void startMonitoring();
    void pauseTimer();
    
    
}
