package controllers;

import models.House;
import models.Room;
import models.Service;
import models.Villa;

import java.util.Scanner;
import java.util.UUID;

public class MainDay1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        Service villa=new Villa();
//        villa.setId(UUID.randomUUID().toString().replace("-", ""));
//        System.out.println("Enter name villa: ");
//        villa.setNameService(scanner.nextLine());
//        System.out.println("Enter area use: ");
//        villa.setArea​​Use(scanner.nextDouble());
//        System.out.println("Enter rental costs: ");
//        villa.setRentalCosts(scanner.nextDouble());
//        System.out.println("Enter max number of people: ");
//        villa.setMaxNumberOfPeople(scanner.nextInt());
//        scanner.nextLine();
//        System.out.println("Enter type rent: ");
//        villa.setTypeRent(scanner.nextLine());
//        System.out.println("Enter room standard: ");
//        ((Villa) villa).setRoomStandard(scanner.nextLine());
//        System.out.println("Enter convenient description: ");
//        ((Villa) villa).setConvenientDescription(scanner.nextLine());
//        System.out.println("Enter area pool: ");
//        ((Villa) villa).setAreaPool(scanner.nextDouble());
//        System.out.println("Enter number of floors: ");
//        ((Villa) villa).setNumberOfFloors(scanner.nextInt());
//        System.out.println(villa.showInfo());

//        Service house=new House();
//        house.setId(UUID.randomUUID().toString().replace("-", ""));
//        System.out.println("Enter name house: ");
//        house.setNameService(scanner.nextLine());
//        System.out.println("Enter area use: ");
//        house.setArea​​Use(scanner.nextDouble());
//        System.out.println("Enter rental costs: ");
//        house.setRentalCosts(scanner.nextDouble());
//        System.out.println("Enter max number of people: ");
//        house.setMaxNumberOfPeople(scanner.nextInt());
//        scanner.nextLine();
//        System.out.println("Enter type rent: ");
//        house.setTypeRent(scanner.nextLine());
//        System.out.println("Enter room standard: ");
//        ((House) house).setRoomStandard(scanner.nextLine());
//        System.out.println("Enter convenient description: ");
//        ((House) house).setConvenientDescription(scanner.nextLine());
//        System.out.println("Enter number of floors: ");
//        ((House) house).setNumberOfFloors(scanner.nextInt());
//        System.out.println(house.showInfo());

        Service room=new Room();
        room.setId(UUID.randomUUID().toString().replace("-", ""));
        System.out.println("Enter name house: ");
        room.setNameService(scanner.nextLine());
        System.out.println("Enter area use: ");
        room.setArea​​Use(scanner.nextDouble());
        System.out.println("Enter rental costs: ");
        room.setRentalCosts(scanner.nextDouble());
        System.out.println("Enter max number of people: ");
        room.setMaxNumberOfPeople(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter type rent: ");
        room.setTypeRent(scanner.nextLine());
        System.out.println("Enter free service: ");
        ((Room) room).setFreeService(scanner.nextLine());
    }
}
