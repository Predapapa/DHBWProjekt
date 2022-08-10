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

        CarDTO carDTO = new CarDTO("Volkswagen", "Amarok 3.0",30500, 2018, "Diesel", 53000f, "Euro", 2, "https://prod.pictures.autoscout24.net/listing-images/d90fb020-1ed9-4151-9308-7bcb3a53060f_c65f25a2-6976-412b-8996-c7331383c97e.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO);

        CarDTO carDTO2 = new CarDTO("Mercedes-Benz", "E 53 AMG", 5900, 2021, "Benzin", 90970f, "Euro", 3, "https://prod.pictures.autoscout24.net/listing-images/0d7efe67-61fc-41ad-9886-26f4fc45fb24_38fb3f50-a277-4c9b-b218-803c5c3edd1f.jpg/360x270.webp", owners.get(1));
        carController.addCar(carDTO2);

        CarDTO carDTO3 = new CarDTO("Mercedes-Benz", "Sprinter 316 L2H2", 135536, 2017, "Diesel", 27953f, "Euro", 7,"https://prod.pictures.autoscout24.net/listing-images/37aca373-baeb-4714-84e1-241393477ce9_57cf5c4c-e715-43b5-96cd-de4931943b3b.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO3);

        CarDTO carDTO4 = new CarDTO("Audi", "e-tron GT RS", 10, 2021, "Elektro", 160.637f, "Euro", 1,"https://prod.pictures.autoscout24.net/listing-images/04457bb4-5b60-4685-b77c-828693747dcd_019cc062-d43b-4f93-be3f-64350c5a7128.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO4);

        CarDTO carDTO5 = new CarDTO("Porsche", "Taycan Turbo", 12548, 2020, "Elektro", 136789f, "Euro", 2,"https://prod.pictures.autoscout24.net/listing-images/dd657339-6d8d-4796-a651-257a6b5f14aa_881c373a-014f-4fd3-b0a2-86342de160fc.jpg/360x270.webp", owners.get(1));
        carController.addCar(carDTO5);

        CarDTO carDTO6 = new CarDTO("Audi", "e-tron Advanced", 40000, 2020, "Elektro", 70990f, "Euro", 1, "https://prod.pictures.autoscout24.net/listing-images/50acf847-f52c-40ec-aa86-6d03656829c5_ff6fee83-140a-4a11-9384-22d74a3dcce7.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO6);

        CarDTO carDTO7 = new CarDTO("Lamborghini", "Aventador", 64000, 2019, "Benzin", 449900f, "Euro", 2,"https://prod.pictures.autoscout24.net/listing-images/cc25fc76-902a-4b79-9050-ad6a1decc6a7_68369b23-79a2-42ad-a900-2d44b1f870f7.jpg/360x270.webp", owners.get(1));
        carController.addCar(carDTO7);

        CarDTO carDTO8 = new CarDTO("Rolls-Royce", "Phantom", 108000, 2007, "Benzin", 139900f, "Euro", 3, "https://prod.pictures.autoscout24.net/listing-images/b33484d9-d554-4d93-8527-69089b77d253_75094be4-6c58-41a4-a96c-8547ae6eef7d.jpg/360x270.webp", owners.get(0));
        carController.addCar(carDTO8);

        System.out.println(carController.getAllCars());
    }
}
