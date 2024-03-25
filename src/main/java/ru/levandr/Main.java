package ru.levandr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.levandr.Config.DefaultAppConfig;
import ru.levandr.LogicContact.LogicContact;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);

        context.getBean(LogicContact.class).saveContact("leva1231@gmail.com","Устименко Лев Романович","8999999999");
        context.getBean(LogicContact.class).getContactList();
    }
}