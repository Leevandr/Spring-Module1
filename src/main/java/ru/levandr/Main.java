package ru.levandr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.levandr.Config.DefaultAppConfig;
import ru.levandr.Service.ContactService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);

        context.getBean(ContactService.class).addContact("Lev", "8999234123", "leva@example.com");
        context.getBean(ContactService.class).addContact("Lev1", "89992341", "leva1@example.com");
        context.getBean(ContactService.class).addContact("Lev2", "899923413", "leva2@example.com");
        context.getBean(ContactService.class).saveContacts();

        context.getBean(ContactService.class).printContacts();

    }
}