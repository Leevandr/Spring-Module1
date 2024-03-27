package ru.levandr.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("ru.levandr")
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultAppConfig {

}
