package cl.praxis.proyectohospitalpostpandemia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HPP {

    private static final Logger logger = LoggerFactory.getLogger(HPP.class);

    public static void main(String[] args) {
        SpringApplication.run(HPP.class, args);
        logger.info("Iniciando Proyecto Hospital Post Pandemia");
    }

}
