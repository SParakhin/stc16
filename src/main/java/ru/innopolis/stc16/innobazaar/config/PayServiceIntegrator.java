package ru.innopolis.stc16.innobazaar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.innopolis.stc16.innobazaar.dto.Store;

@Configuration
@PropertySource("classpath:payservice.properties")
public class PayServiceIntegrator {

    private final String payServiceURL;

    private final Store store;

    @Autowired
    public PayServiceIntegrator(Environment environment) {
        payServiceURL = environment.getRequiredProperty("payservice.url");
        store = new Store();
        store.setName(environment.getRequiredProperty("store.name"));
        store.setSecretKey(environment.getRequiredProperty("store.secretKey"));
    }

    public String getPayServiceURL() {
        return payServiceURL;
    }

    public Store getStore() {
        return store;
    }
}
