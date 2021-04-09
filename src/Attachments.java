import java.util.ArrayList;

/**
 * Created by lenovo on 12/07/2020.
 */
public class Attachments {
    private int attachmentNumber;
   private String attachmentType;
    private double price;
    private int hours;

    public Attachments(int attachmentNumber, String attachmentType, int hours,double price) {
        this.attachmentNumber = attachmentNumber;
        this.attachmentType = attachmentType;
        this.hours = hours;
        this.price= price;
    }


    public int getAttachmentNumber() {
        return attachmentNumber;
    }

    public void setAttachmentNumber(int attachmentNumber) {
        this.attachmentNumber = attachmentNumber;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public double getPrice() {
        return price*hours;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    public String toString(){
        String s="\nNumber of attachment: "+attachmentNumber+
                 "\nName of attachment: "+attachmentType+
                 "\nHours: "+hours+ "\nHour price:  "+price;
        return s;
    }

}
