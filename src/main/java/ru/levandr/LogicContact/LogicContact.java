package ru.levandr.LogicContact;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.levandr.LogicContact.Entity.Contact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


@Component
public class LogicContact {
    @Value("${file.path}")
    String filePath;
    @Value("${file.name}")
    String fileName;


    public void getContactList() {
        Path path = Paths.get(filePath, fileName);
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveContact(String email, String fio, String phoneNumber) {
        Contact contact = new Contact(email, fio, phoneNumber);
        String contactInfo = contact.toString();
        Path path = Paths.get(filePath, fileName);
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                writer.write(contactInfo);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
