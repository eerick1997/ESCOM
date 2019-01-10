package micronapster.MyObject;

import java.io.Serializable;

public class User implements Serializable {

    private String name, user, password, ipAddress;

    public User(String name, String user, String password, String ipAddress) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUser() {
        return user;
    }
    
    public void setIpAddress(String string){
        this.ipAddress = string;
    }
}
