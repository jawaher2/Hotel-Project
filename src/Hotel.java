import java.util.ArrayList;

/**
 * Created by lenovo on 12/06/2020.
 */
public class Hotel {

    private String hotelName;
    private String location;
    private String apprizing;
    private int countRoom;
    private int countSuite;

    public Hotel(String hotelName, String location,String apprizing,int countRoom, int countSuite) {
        this.hotelName = hotelName;
        this.location = location;
        this.apprizing = apprizing;
        this.countRoom = countRoom;
        this.countSuite = countSuite;
    }

    public int getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(int countRoom) {
        this.countRoom = countRoom;
    }

    public int getCountSuite() {
        return countSuite;
    }

    public void setCountSuite(int countSuite) {
        this.countSuite = countSuite;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getApprizing() {
        return apprizing;
    }

    public void setApprizing(String apprizing) {
        this.apprizing = apprizing;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String toString()
    {
        String s="Hotel-Name: "+hotelName+"Location: "+location+"Apprizing: "+apprizing;
        return s;
    }

}
