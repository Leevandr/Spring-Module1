package ru.levandr.Entity;

public class Contact {

    private final String fullName;

    private final String phoneNumber;

    private final String email;

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


