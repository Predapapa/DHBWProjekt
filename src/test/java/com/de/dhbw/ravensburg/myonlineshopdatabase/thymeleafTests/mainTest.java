package com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class mainTest {

    @LocalServerPort
    private Integer port;

    @BeforeClass
    public void init() {
        Configuration.remote = "http://localhost:" + port + "/main";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    //Nr.2
    @Test
    @Order(1)
    public void mainHTMLShouldBeOpenable() {
        open("http://localhost:" + port +"/main");
        $(By.cssSelector("main")).should(Condition.exist);
        $(By.cssSelector("main")).should(Condition.visible);
    }

    //Nr.2 b)
    @Test
    @Order(2)
    public void navbarFragmentShouldBeIncluded() {
        open("http://localhost:" + port +"/main");
        $(By.id("navbar")).should(Condition.exist);
        $(By.id("navbar")).shouldBe(Condition.visible);

        $(By.id("nav_text")).should(Condition.exist);
        $(By.id("nav_text")).shouldBe(Condition.visible);
        $(By.id("nav_text")).shouldHave(exactText("Thymeleaf Aufgabe - Online Shop"));

        $$(By.cssSelector("section")).shouldHave(CollectionCondition.size(2));
    }
}
