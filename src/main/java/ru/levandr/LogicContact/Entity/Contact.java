package ru.levandr.LogicContact.Entity;

public class Contact {

    private String fio;

    private String phoneNumber;

    private String email;

    public Contact(String email, String fio, String phoneNumber) {
        this.email = email;
        this.fio = fio;
        this.phoneNumber = phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(fio).append(";")
                .append(phoneNumber).append(";")
                .append(email);
        return sb.toString();
    }
}


