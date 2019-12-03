package service.impl;

import models.House;
import models.Service;
import service.ServiceInterface;
import validation.ValidationTask4;

import java.util.Scanner;
import java.util.UUID;

public class HouseServiceImpl implements ServiceInterface {
    Scanner scanner;

    @Override
    public Service addNewService() {
        scanner = new Scanner(System.in);
        Service house = new House();
        house.setId(UUID.randomUUID().toString().replace("-", ""));
        house.setNameService(ValidationTask4.inputAndCheckValidationName());
        System.out.print("Enter area use: ");
        house.setArea​​Use(ValidationTask4.inputAndCheckValidationAreaUseOrAreaPool());

        house.setRentalCosts(ValidationTask4.inputAndCheckValidationRentalCosts());

        house.setMaxNumberOfPeople(ValidationTask4.inputAndCheckValidationMaxNumberOfPeople());

        System.out.print("Enter type rent (Format: Abc Abc): ");
        house.setTypeRent(ValidationTask4.inputAndCheckValidationTypeRentOrRoomStandard());

        System.out.print("Enter room standard (Format: Abc Abc): ");
        ((House) house).setRoomStandard(ValidationTask4.inputAndCheckValidationTypeRentOrRoomStandard());

        System.out.print("Enter convenient description: ");
        ((House) house).setConvenientDescription(scanner.nextLine());

        ((House) house).setNumberOfFloors(ValidationTask4.inputAndCheckValidationNumberOfFloors());
        System.out.println("------------------------------------------------");
        return house;
    }
}
