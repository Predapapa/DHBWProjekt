package com.de.dhbw.ravensburg.myonlineshopdatabase;

import com.de.dhbw.ravensburg.myonlineshopdatabase.controller.CarController;
import com.de.dhbw.ravensburg.myonlineshopdatabase.controller.OwnerController;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.FetchProfiles;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ManualTestBean {

    CarController carController;
    OwnerController ownerController;

    public ManualTestBean(CarController carController, OwnerController ownerController) {
        this.carController = carController;
        this.ownerController = ownerController;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController() {

        OwnerDTO ownerDTO = new OwnerDTO("Hans Peter", "88214 Ravensburg, Germany");
        ownerController.addOwner(ownerDTO);

        OwnerDTO ownerDTO2 = new OwnerDTO("Jana Meier", "88214 Ravensburg, Germany");
        ownerController.addOwner(ownerDTO2);

        List<OwnerDTO> owners = ownerController.getAllOwners();

        CarDTO carDTO = new CarDTO("Volkswagen", "Amarok 3.0",30500, 2018, "Diesel", 53000f, "Euro", 2, "https://prod.pictures.autoscout24.net/listing-images/538b5c1b-c520-4979-b0f8-f8be593ecc7e_3e4ed017-5c4c-4f60-b8c2-ca2c02cea72c.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO);

        CarDTO carDTO2 = new CarDTO("Mercedes-Benz", "E 53 AMG", 5900, 2021, "Benzin", 90970f, "Euro", 3, "https://prod.pictures.autoscout24.net/listing-images/a0058692-64b6-43b2-8928-e4d1db06488a_0988402c-c015-411e-95fe-3eecb7621992.jpg/360x270.webp", owners.get(1));
        carController.addCar(carDTO2);

        CarDTO carDTO3 = new CarDTO("Mercedes-Benz", "Sprinter 316 L2H2", 135536, 2017, "Diesel", 27953f, "Euro", 7,"https://prod.pictures.autoscout24.net/listing-images/681e753d-6f97-4673-a5d5-1cb87e2099b2_8c0308ef-062a-45a2-b239-83a39b44ff5a.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO3);

        CarDTO carDTO4 = new CarDTO("Audi", "e-tron GT RS", 10, 2021, "Elektro", 160.637f, "Euro", 1,"https://prod.pictures.autoscout24.net/listing-images/6f7a1fd5-6907-4a6f-b4dc-98c4e728f3dd_6e135489-491d-436a-890f-8e9e287cf737.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO4);

        CarDTO carDTO5 = new CarDTO("Porsche", "Taycan Turbo", 12548, 2020, "Elektro", 136789f, "Euro", 2,"https://prod.pictures.autoscout24.net/listing-images/483d65c1-86a3-4e3f-a6ca-ae4c0a875ae3_08c7dd71-2ea7-41ab-b9eb-30c41c003564.jpg/360x270.webp", owners.get(1));
        carController.addCar(carDTO5);

        CarDTO carDTO6 = new CarDTO("Audi", "e-tron Advanced", 40000, 2020, "Elektro", 70990f, "Euro", 1, "https://prod.pictures.autoscout24.net/listing-images/e2516bd4-cec6-44e4-ae12-0d9940459b70_3d7f8214-4085-4030-a955-1fa293fa0c83.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO6);

        CarDTO carDTO7 = new CarDTO("Lamborghini", "Aventador", 64000, 2019, "Benzin", 449900f, "Euro", 2,"https://prod.pictures.autoscout24.net/listing-images/242347c9-bc88-42f9-980a-247addf4d87d_962c9f90-5ac9-4d2a-a434-37535e49f7e9.jpg/360x270.webp", owners.get(1));
        carController.addCar(carDTO7);

        CarDTO carDTO8 = new CarDTO("Rolls-Royce", "Phantom", 108000, 2007, "Benzin", 139900f, "Euro", 3, "https://prod.pictures.autoscout24.net/listing-images/8b5f47bc-65a7-4f94-8e58-bb230d330900_4d7fb9d3-f651-4a82-957c-35d9c72135ca.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO8);

        System.out.println(carController.getAllCars());
    }
}
