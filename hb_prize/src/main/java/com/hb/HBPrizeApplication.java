package com.hb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Description:
 */
@SpringBootApplication
@EnableScheduling
public class HBPrizeApplication implements WebApplicationInitializer{

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HBPrizeApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HBPrizeApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }

}
