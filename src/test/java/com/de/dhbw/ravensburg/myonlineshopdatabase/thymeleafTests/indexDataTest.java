package com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.CarService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class indexDataTest {

    @LocalServerPort
    private Integer port;

    private List<CarDTO> carDTOS = new ArrayList<>();

    @BeforeEach()
    public void setUp() {
        OwnerDTO hans = new OwnerDTO("Hans", "Beispielstraße 12, 53174 Bonn");
        OwnerDTO jana = new OwnerDTO("Jana", "Musterstraße 17, 12345 Musterstadt");

        CarDTO carDTO = new CarDTO("Volkswagen", "Amarok 3.0",30500, 2018, "Diesel", 53000f, "Euro", 2, "https://prod.pictures.autoscout24.net/listing-images/538b5c1b-c520-4979-b0f8-f8be593ecc7e_3e4ed017-5c4c-4f60-b8c2-ca2c02cea72c.jpg/360x270.webp", hans);
        CarDTO carDTO2 = new CarDTO("Mercedes-Benz", "E 53 AMG", 5900, 2021, "Benzin", 90970f, "Euro", 3, "https://prod.pictures.autoscout24.net/listing-images/a0058692-64b6-43b2-8928-e4d1db06488a_0988402c-c015-411e-95fe-3eecb7621992.jpg/360x270.webp", jana);
        CarDTO carDTO3 = new CarDTO("Mercedes-Benz", "Sprinter 316 L2H2", 135536, 2017, "Diesel", 27953f, "Euro", 7, "https://prod.pictures.autoscout24.net/listing-images/681e753d-6f97-4673-a5d5-1cb87e2099b2_8c0308ef-062a-45a2-b239-83a39b44ff5a.jpg/360x270.webp", hans);
        CarDTO carDTO4 = new CarDTO("Audi", "e-tron GT RS", 10, 2021, "Elektro", 160.637f, "Euro", 1, "https://prod.pictures.autoscout24.net/listing-images/6f7a1fd5-6907-4a6f-b4dc-98c4e728f3dd_6e135489-491d-436a-890f-8e9e287cf737.jpg/360x270.webp", hans);
        CarDTO carDTO5 = new CarDTO("Porsche", "Taycan Turbo", 12548, 2020, "Elektro", 136789f, "Euro", 2, "https://prod.pictures.autoscout24.net/listing-images/483d65c1-86a3-4e3f-a6ca-ae4c0a875ae3_08c7dd71-2ea7-41ab-b9eb-30c41c003564.jpg/360x270.webp", jana);
        CarDTO carDTO6 = new CarDTO("Audi", "e-tron Advanced", 40000, 2020, "Elektro", 70990f, "Euro", 1, "https://prod.pictures.autoscout24.net/listing-images/e2516bd4-cec6-44e4-ae12-0d9940459b70_3d7f8214-4085-4030-a955-1fa293fa0c83.jpg/360x270.webp", hans);
        CarDTO carDTO7 = new CarDTO("Lamborghini", "Aventador", 64000, 2019, "Benzin", 449900f, "Euro", 2, "https://prod.pictures.autoscout24.net/listing-images/242347c9-bc88-42f9-980a-247addf4d87d_962c9f90-5ac9-4d2a-a434-37535e49f7e9.jpg/360x270.webp", jana);
        CarDTO carDTO8 = new CarDTO("Rolls-Royce", "Phantom", 108000, 2007, "Benzin", 139900f, "Euro", 3, "https://prod.pictures.autoscout24.net/listing-images/8b5f47bc-65a7-4f94-8e58-bb230d330900_4d7fb9d3-f651-4a82-957c-35d9c72135ca.jpg/360x270.webp", hans);

        this.carDTOS.add(carDTO);
        this.carDTOS.add(carDTO2);
        this.carDTOS.add(carDTO3);
        this.carDTOS.add(carDTO4);
        this.carDTOS.add(carDTO5);
        this.carDTOS.add(carDTO6);
        this.carDTOS.add(carDTO7);
        this.carDTOS.add(carDTO8);
    }

    //Nr.1
    @Test
    public void gridElementShouldContainCorrectData() {
        open("http:/localhost:" + port +"/index");

        String title = "";
        String price = "";
        String km = "";
        String year = "";
        String img = "";

        for (int i = 0; i < this.carDTOS.size(); i++) {
            img = this.carDTOS.get(i).getImg_src();
            title = this.carDTOS.get(i).getBrand() + " " + this.carDTOS.get(i).getModel();
            price = this.carDTOS.get(i).getPrice() + " " + this.carDTOS.get(i).getCurrency();
            km = this.carDTOS.get(i).getKm() + " km";
            year = this.carDTOS.get(i).getYear_of_production() + " hergestellt";

            $$(By.id("img_prev")).get(i).shouldHave(attribute("src",img));
            $$(By.id("title")).get(i).shouldHave(exactText(title));
            $$(By.id("price")).get(i).shouldHave(exactText(price));
            $$(By.id("mileage")).get(i).shouldHave(exactText(km));
            $$(By.id("p_year")).get(i).shouldHave(exactText(year));
        }
    }


}
