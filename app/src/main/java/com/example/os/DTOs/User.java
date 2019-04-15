package com.example.os.DTOs;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone_number;
    private String ssn;
    private String type;
    private String gender;


    public User(Integer id, String name, String email,String phone_number, String SSN, String type, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ssn = SSN;
        this.phone_number = phone_number;
        this.type = type;
        this.gender = gender;
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

    public String getPhoneNumber(){
        return phone_number;
    }

    public String getSSN(){
        return ssn;
    }

    public String getGender(){
        return gender;
    }

    public boolean isManager()
    {
        return this.type.equals("MANAGER");
    }

    public boolean isHR()
    {
        return this.type.equals("HR");
    }

    public boolean isRegularEmployee(){
        return this.type.equals("EMPLOYEE");
    }

}
