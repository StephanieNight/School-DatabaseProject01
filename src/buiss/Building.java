/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buiss;
import aquiantince.IBuilding;
import aquiantince.IReadings;
import aquiantince.IRoom;
import aquiantince.ISensor;
import java.util.ArrayList;
import java.util.UUID;


/**
 *
 * @author Stephanie
 */
public class Building implements IBuilding  {

    private String name;
    private String address;
    private ArrayList<IRoom> rooms = new ArrayList<IRoom>();
    
    
    Building(String name, String address) {
        
        this.name = name;
        this.address = address;
        
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
    
    

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Override
    public String toString() {
        
        
        
        return this.name;
        
        
    }

    public IReadings[] getAllReadings() {
        
        IReadings[] allReadings = null;
        /*
        for(IRoom readings: this.rooms) {
            
            for(ISensors[] readingsForRoom: readings.getSensors())
            
        }
     */
        return allReadings;
    }

    
    @Override
    public Boolean removeRoom(IRoom room) {
        
        if(rooms.contains(room)) {
            if(rooms.remove(room)) {
            return true;
            } else {
                return false;
            }
        }
        
        return false;
        
    }

    @Override
    public IRoom[] getRooms() {
        
        IRoom[] roomList = new IRoom[this.rooms.size()];
        return this.rooms.toArray(roomList);
    }

    @Override
    public Boolean addRoom(String name) {
        
        
        System.out.println("Adding room");
        IRoom newRoom = new Room(name);
        this.rooms.add(newRoom);
        
        return true;
        
    }

    
    

    
    

   
    
}
