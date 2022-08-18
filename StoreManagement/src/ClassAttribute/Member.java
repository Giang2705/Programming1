package ClassAttribute;

public class Member {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String phone;

    private String membership;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getFullname(){
        return fullname;
    }
    public void setFullname(String fullname){
        this.fullname = fullname;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getMembership(){
        return membership;
    }
    public void setMembership(String membership){
        this.membership = membership;
    }
}


