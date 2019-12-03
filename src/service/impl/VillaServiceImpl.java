package service.impl;

import models.Service;
import models.Villa;
import service.ServiceInterface;
import validation.ValidationTask4;

import java.util.Scanner;
import java.util.UUID;

public class VillaServiceImpl implements ServiceInterface {
    Scanner scanner;
    @Override
    public Service addNewService() {
        scanner=new Scanner(System.in);
        Service villa = new Villa();
        villa.setId(UUID.randomUUID().toString().replace("-", ""));

        villa.setNameService( ValidationTask4.inputAndCheckValidationName());
        System.out.print("Enter area use: ");
        villa.setArea​​Use(ValidationTask4.inputAndCheckValidationAreaUseOrAreaPool());

        villa.setRentalCosts(ValidationTask4.inputAndCheckValidationRentalCosts());

        villa.setMaxNumberOfPeople(ValidationTask4.inputAndCheckValidationMaxNumberOfPeople());

        System.out.print("Enter type rent (Format: Abc Abc): ");
        villa.setTypeRent(ValidationTask4.inputAndCheckValidationTypeRentOrRoomStandard());

        System.out.print("Enter room standard (Format: Abc Abc): ");
        ((Villa) villa).setRoomStandard(ValidationTask4.inputAndCheckValidationTypeRentOrRoomStandard());

        System.out.print("Enter convenient description: ");
        ((Villa) villa).setConvenientDescription(scanner.nextLine());

        System.out.print("Enter area pool: ");
        ((Villa) villa).setAreaPool(ValidationTask4.inputAndCheckValidationAreaUseOrAreaPool());

        ((Villa) villa).setNumberOfFloors(ValidationTask4.inputAndCheckValidationNumberOfFloors());
        System.out.println("------------------------------------------------");
        return villa;
    }
}
