package acct;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author senju
 */
class User {

    private String fname;
    private String lname;
    private static String username;
    private String password;
    private String role;
    private static String Id;
    private String email;
    private String pic;
    private String gender;
    
    User(String pic, String Id, String lname,String fname, String username, String gender, String role, String email) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.Id = Id;
        this.role = role;
        this.pic = pic;
        this.email = email;
        this.gender = gender;
    }
    
    public String getgender(){
        return gender;
    }
     public String getpic() {
        return pic;
    }

    public String getUsername() {
        return username;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }
    public void setpass(String pass){
        this.password = pass;
    }
}
