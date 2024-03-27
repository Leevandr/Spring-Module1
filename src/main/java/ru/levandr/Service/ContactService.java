package ru.levandr.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.levandr.Entity.Contact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ContactService {

    @Value("${file.path}")
    private String filePath;

    @Value("${file.name}")
    private String fileName;


    List<Contact> contactList = new ArrayList<>();

    @PostConstruct
    @Profile("init")
    public void initContacts() {
        try (Stream<String> stream = Files.lines(Paths.get(filePath + fileName))) {
            stream.forEach(line -> {
                String[] parts = line.split(";");
                if (parts.length < 3) {
                    System.out.println("Пропущена строка, тк ввод неверный: " + line);
                } else {
                    contactList.add(new Contact(parts[0], parts[1], parts[2]));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addContact(String fullName, String phoneNumber, String email) {

        if (!phoneNumber.matches("\\d+") || !email.contains("@")) {
            System.out.println("Неверный формат ввода. Пожалуйста, введите данные снова.");
            return;
        }

        for (Contact contact : contactList) {
            if (contact.getFullName().equals(fullName)) {
                System.out.println("Фио: " + fullName + " уже занято");
                return;
            }
            if (contact.getEmail().equals(email)) {
                System.out.println("Почта: " + email + " уже занята");
                return;
            }
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Номер телефона: " + phoneNumber + " уже занят");
                return;
            }
        }

        contactList.add(new Contact(fullName,phoneNumber,email));
    }

    public void deleteContact(String email) {
        contactList.removeIf(contact -> contact.getEmail().equals(email));
    }

    public void printContacts() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    public void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileName))) {
            for (Contact contact : contactList) {
                writer.write(contact.getFullName() + ";" + contact.getPhoneNumber() + ";" + contact.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
