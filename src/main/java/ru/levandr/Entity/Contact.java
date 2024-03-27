package ru.levandr.Entity;

public class Contact {

    private String fullName;

    private String phoneNumber;

    private String email;

    public Contact(String email, String fio, String phoneNumber) {
        this.fullName = fio;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return fullName + " | " + phoneNumber + " | " + email;
    }
}


