package ClassAttribute;

public class Admin {
    private String id;
    private String username;
    private String password;

    public Admin() {}

//    public Admin (String id, String username, String password) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String displayAdminInfo() { return this.toString();}


    public String getAdminId() {
        return id;
    }

    public void setAdminId(String id) {
        this.id = id;
    }

    public String getAdminUsername() {
        return username;
    }

    public void setAdminUsername(String username) {
        this.username = username;
    }

    public String getAdminPassword() {
        return password;
    }

    public void setAdminPassword(String password) {
        this.password = password;
    }

}


