package com.example.os.DTOs;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String type;


    public User(Integer id, String name, String email, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public boolean isManager()
    {
        return this.type.equals("MANAGER");
    }

    public boolean isHR()
    {
        return this.type.equals("HR");
    }

}
