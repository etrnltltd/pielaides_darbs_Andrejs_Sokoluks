package com.example.application;

class CreateNewUser {

    private String name;
    private String surname;
    private String personalID;
    private String email;
    private String phoneNumber;

    public CreateNewUser() {

    }

    public CreateNewUser(String name, String surname, String personalID, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.personalID = personalID;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public String getUserInfo() {
        System.out.println("Full information about " + name + " " + surname + ":");
        System.out.println("Personal ID:  " + this.personalID);
        System.out.println("Email: " + this.email);
        System.out.println("Phone number: " + this.phoneNumber);
        return "Full information about " + name + " " + surname + ":" + "\n" +
            "Personal ID:  " + this.personalID + "\n" +
            "Email: " + this.email + "\n" +
            "Phone number: " + this.phoneNumber;
    }

    public void deleteUserInfo()
    {
        setName(" ");
        setSurname(" ");
        setPersonalID(" ");
        setEmail(" ");
        setPhoneNumber(" ");
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
