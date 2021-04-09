import java.util.ArrayList;

/**
 * Created by lenovo on 12/07/2020.
 */
public class Rooms {
    private   int roomNumber;
    private String type;
    private int roomSize;
    private double roomPrice;


    public Rooms(int roomNumber,String type, int roomSize,double roomPrice) {
       this.roomNumber =roomNumber;
        this.type = type;
        this.roomSize = roomSize;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String toString(){
        String s="\nRoom Number: "+roomNumber+"\nType of room: "+type+
         "\nRoom Size: "+roomSize+"\nRoom price: "+roomPrice;

        return s;
    }
}
