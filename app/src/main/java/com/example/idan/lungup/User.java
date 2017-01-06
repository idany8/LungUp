package com.example.idan.lungup;

/**
 * Created by Idan on 31/12/2016.
 */
public class User {
    String name;
    String email;

    public User(){

    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "User -> \nname: "+ name + "\nemail: " + email;
    }

}
