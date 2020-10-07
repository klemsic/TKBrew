package cz.klemsa.tkbrew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    // --------------------------------------------------
    // - LOG
    // --------------------------------------------------
    // TODO: Špatně... Když to někde zawiruju, bude dávat log třídu Config a ne od kud je log zavolán...
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    public Logger getLog() {
        return log;
    }
}
