package com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.CarService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class indexTest {
    @LocalServerPort
    private Integer port;

    private final Integer COUNTS_OF_ELEMENTS = 8;


    //Nr.1 Test, ob die index.html erreichbar ist
    @Test
    @Order(1)
    public void shouldSuccessfullyReturnIndexView() {
        open("http:/localhost:" + port +"/index");
        $(By.cssSelector("main")).should(Condition.exist);
        $(By.cssSelector("main")).should(Condition.visible);
    }

    //Nr.1 a)
    @Test
    @Order(2)
    public void gridShouldContainBootstrap5CardElements() {
        open("http:/localhost:" + port +"/index");

        $$(".card").shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
        $$(".card-img-top").shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
        $$(".card-body").shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
        $$(".card-title").shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
    }

    //Nr.1 a) Test, ob alle Ids vergeben wurden + die Anzhal an vorhanden Elementen
    @Test
    @Order(3)
    public void gridElementShouldHaveSpecifiedCard() {
        open("http:/localhost:" + port +"/index");

        $(By.id("img_prev")).should(Condition.exist);
        $(By.id("img_prev")).shouldBe(Condition.visible);

        $(By.id("title")).should(Condition.exist);
        $(By.id("title")).shouldBe(Condition.visible);

        $(By.id("price")).should(Condition.exist);
        $(By.id("price")).shouldBe(Condition.visible);

        $(By.id("mileage")).should(Condition.exist);
        $(By.id("mileage")).shouldBe(Condition.visible);

        $(By.id("p_year")).should(Condition.exist);
        $(By.id("p_year")).shouldBe(Condition.visible);

        $$(By.cssSelector("img")).shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
        $$(By.cssSelector("h5")).shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
        $$(By.cssSelector("h6")).shouldHave(CollectionCondition.size(3 * COUNTS_OF_ELEMENTS));
    }

    //Nr.1 a)
    @Test
    @Order(4)
    public void gridShouldOnlyDisplayThreeCardsNextToEachOther(){
        open("http:/localhost:" + port +"/index");

        $(By.className("col-md-4")).should(Condition.exist);
        $$("body main .container section .album .container .row .col-md-4").shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
    }

    //Nr.1 b)
    @Test
    @Order(5)
    public void gridH6ElementsShouldContainTextMutedClass() {
        open("http:/localhost:" + port +"/index");

        for (int i = 0; i < COUNTS_OF_ELEMENTS*3; i++) {
            $$(By.cssSelector("h6")).get(i).shouldHave(cssClass("text-muted"));
        }
    }

    //Nr.1 b)
    @Test
    @Order(6)
    public void gridElementsShouldHaveMarginBottom4() {
        open("http:/localhost:" + port +"/index");

        $(By.className("mb-4")).should(Condition.exist);
        $$("body main .container section .album .container .row div .mb-4").shouldHave(CollectionCondition.size(COUNTS_OF_ELEMENTS));
    }
}
