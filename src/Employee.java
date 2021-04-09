/**
 * Created by lenovo on 12/07/2020.
 */
public class Employee  {
    private String userName;
    private int password;

    public Employee(String userName,int password) {
        this.userName = userName;
        this.password= password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String toString(){
        String s= "\nUser name: "+userName
                +"\nPassward: "+password;
        return s;
    }
}
