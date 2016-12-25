package com.tpokora.mailservice.home.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pokor on 16.12.2016.
 */
@RestController
@RequestMapping(value = "/rest")
@PropertySource("classpath:properties/${env:app}.properties")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private Environment env;

    private class HomeElement {
        private String title;
        private String header;
        private Object content;

        public HomeElement() {
            this.title = env.getProperty("home.page.title");
            this.header = env.getProperty("home.page.header");
        }

        public String getTitle() {
            return title;
        }

        public String getHeader() {
            return header;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ResponseEntity<HomeElement> getHome() {
        logger.info(this.getClass().getSimpleName() + " retrieves data");
        HomeElement homeElement = new HomeElement();
        return new ResponseEntity<HomeElement>(homeElement, HttpStatus.OK);
    }

}
