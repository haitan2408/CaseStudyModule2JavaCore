package controllers;

import models.*;
import service.*;
import service.impl.*;
import sort.NameCustomerComparator;

import java.util.*;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    private ServiceInterface villaService = new VillaServiceImpl();
    private ServiceInterface houseService = new HouseServiceImpl();
    private ServiceInterface roomService = new RoomServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private BookingCinema4DService bookingCinema4DService = new BookingCinema4DServiceImpl();
    private FilingCabinetsService filingCabinetsService = new FilingCabinetsServiceImpl();

    public void displayMainMenu() {
        int choice;
        System.out.println("1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information Customer\n" +
                "5. Add New Booking Resort\n" +
                "6. Show Information Employee\n" +
                "7. Add booking cinema 4D\n" +
                "8. Show booking cinema 4D\n" +
                "9. Search Filing Cabinets of Employee\n" +
                "10. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                menuAddNewService();
                break;
            }
            case 2: {
                menuShowService();
                break;
            }
            case 3: {
                addNewCustomer();
                break;
            }
            case 4: {
                showInfoCustomer();
                break;
            }
            case 5: {
                addNewBooking();
                break;
            }
            case 6: {
                showInformationEmployee();
                break;
            }
            case 7: {
                addBookingCinema();
                break;
            }
            case 8: {
                showBookingCinema();
                break;
            }
            case 9: {
                searchFilingCabinetsOfEmployee();
                break;
            }
            case 10: {
                System.exit(0);
            }
            default: {
                displayMainMenu();
            }
        }
    }

    private void searchFilingCabinetsOfEmployee() {
        scanner = new Scanner(System.in);
        System.out.print("Enter id of Employee: ");
        String idEmployee = scanner.nextLine();
        Employee employee = filingCabinetsService.findEmployeeById(idEmployee);
        if (employee == null) {
            System.out.println("Not found Filing Cabinets!");
        } else {
            System.out.println("----------------------------------------------------------------");
            System.out.println(employee);
            System.out.println("----------------------------------------------------------------");
        }
        displayMainMenu();
    }

    private void showBookingCinema() {
        Queue<Customer> customers = bookingCinema4DService.getAllBookingCinema();
        while (true) {
            Customer customer = customers.poll();
            if (customer == null) {
                break;
            }
            System.out.println(customer);
        }
    }

    private void addBookingCinema() {
        scanner = new Scanner(System.in);
        System.out.println("Enter number ticket: ");
        int numberTicket = scanner.nextInt();
        while (numberTicket < 1) {
            System.out.println("Số lượng vé phải là số dương");
        }
        for (int i = 0; i < numberTicket; i++) {
            Customer customer = customerService.addNewCustomer();
            bookingCinema4DService.addBookingCinema(customer);
        }
    }

    private void showInformationEmployee() {
        List<Employee> employees = employeeService.getAllListEmployee();
        for (Employee employee : employees) {
            System.out.println("---------------------------------");
            System.out.println(employee);
        }
        displayMainMenu();
    }

    private void addNewBooking() {
        scanner = new Scanner(System.in);
        List<Customer> customers;
        customers = FuncWriteAndReadFileCSV.readCsvFileCustomer();
        Collections.sort(customers, new NameCustomerComparator());
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("--------------------------------------------------");
            System.out.println((i + 1) + ". " + customers.get(i).showInfo());
        }
        System.out.print("Enter your choice: ");
        int choiceCustomer = scanner.nextInt();
        while (choiceCustomer < 1 || choiceCustomer > customers.size()) {
            System.out.println("Size of list Customer: " + customers.size() + ", choice: " + choiceCustomer);
            System.out.print("Enter your choice: ");
            choiceCustomer = scanner.nextInt();
        }
        Customer customer = customers.get(choiceCustomer - 1);
        System.out.println("1. Booking Villa\n2. Booking House \n3. Booking Room");
        int choiceBooking = scanner.nextInt();
        while (choiceBooking < 1 || choiceBooking > 3) {
            System.out.println("Error!");
            System.out.println();
            System.out.println("1. Booking Villa\n2. Booking House \n3. Booking Room");
            choiceBooking = scanner.nextInt();
        }
        switch (choiceBooking) {
            case 1: {
                List<Villa> villas;
                villas = FuncWriteAndReadFileCSV.readCsvFileVilla();
                for (int i = 0; i < villas.size(); i++) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("No" + (i + 1));
                    System.out.println(villas.get(i).showInfo());
                }
                System.out.print("Enter choice booking Villa:");
                Villa villa = villas.get(scanner.nextInt() - 1);
                customer.setService(villa);
                break;
            }
            case 2: {
                List<House> houses;
                houses = FuncWriteAndReadFileCSV.readCsvFileHouse();
                for (int i = 0; i < houses.size(); i++) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("No" + i + 1);
                    System.out.println(houses.get(i).showInfo());
                }
                System.out.print("Enter choice booking House:");
                House house = houses.get(scanner.nextInt() - 1);
                customer.setService(house);
                break;
            }
            case 3: {
                List<Room> rooms;
                rooms = FuncWriteAndReadFileCSV.readCsvFileRoom();
                for (int i = 0; i < rooms.size(); i++) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("No" + i + 1);
                    System.out.println(rooms.get(i).showInfo());
                }
                System.out.print("Enter choice booking Room: ");
                Room room = rooms.get(scanner.nextInt() - 1);
                customer.setService(room);
                break;
            }
            default: {
                displayMainMenu();
            }
        }
        List<Customer> listBooking = FuncWriteAndReadFileCSV.readCsvFileBooking();
        listBooking.add(customer);
        FuncWriteAndReadFileCSV.writeCsvFileBooking(listBooking);
        displayMainMenu();
    }

    private void showInfoCustomer() {
        List<Customer> customers;
        customers = FuncWriteAndReadFileCSV.readCsvFileCustomer();
        Collections.sort(customers, new NameCustomerComparator());
        for (Customer customer : customers) {
            System.out.println("--------------------------------------------------");
            System.out.println(customer.showInfo());
        }
        displayMainMenu();
    }

    private void addNewCustomer() {
        scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        customers = FuncWriteAndReadFileCSV.readCsvFileCustomer();
        System.out.print("Enter number list customer you want: ");
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            Customer customer = customerService.addNewCustomer();
            customers.add(customer);
        }

        FuncWriteAndReadFileCSV.writeCsvFileCustomer(customers);
        displayMainMenu();
    }

    private void menuShowService() {
        scanner = new Scanner(System.in);
        int choice;
        System.out.println("1. Show All Villa\n" +
                "2. Show All House\n" +
                "3. Show All Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Room Not Duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                showVillaService();
                break;
            }
            case 2: {
                showHouseService();
                break;
            }
            case 3: {
                showRoomService();
                break;
            }
            case 4: {
                showAllNameVillaNotDuplicate();
                break;
            }
            case 5: {
                showAllNameHouseNotDuplicate();
                break;
            }
            case 6: {
                showAllNameRoomNotDuplicate();
                break;
            }

            case 7: {
                displayMainMenu();
                break;
            }
            default: {
                System.exit(0);
            }
        }
    }

    private void showAllNameVillaNotDuplicate() {
        String pathFileVilla = "src/data/Villa.csv";
        Set<String> setNameVilla = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(pathFileVilla);
        for (String name : setNameVilla) {
            System.out.println("-----------------------");
            System.out.println(name);
        }
        displayMainMenu();
    }

    private void showAllNameHouseNotDuplicate() {
        String pathFileHouse = "src/data/House.csv";
        Set<String> setNameVilla = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(pathFileHouse);
        for (String name : setNameVilla) {
            System.out.println("-----------------------");
            System.out.println(name);
        }
        displayMainMenu();
    }

    private void showAllNameRoomNotDuplicate() {
        String pathFileRoom = "src/data/Room.csv";
        Set<String> setNameVilla = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(pathFileRoom);
        for (String name : setNameVilla) {
            System.out.println("-----------------------");
            System.out.println(name);
        }
        displayMainMenu();
    }

    private void showRoomService() {
        List<Room> rooms;
        rooms = FuncWriteAndReadFileCSV.readCsvFileRoom();
        for (Room room : rooms) {
            System.out.println("--------------------------------------------------");
            System.out.println(room.showInfo());
        }
        displayMainMenu();
    }

    private void showHouseService() {
        List<House> houses;
        houses = FuncWriteAndReadFileCSV.readCsvFileHouse();
        for (House house : houses) {
            System.out.println("--------------------------------------------------");
            System.out.println(house.showInfo());
        }
        displayMainMenu();
    }

    private void showVillaService() {
        List<Villa> villas;
        villas = FuncWriteAndReadFileCSV.readCsvFileVilla();
        for (Villa villa : villas) {
            System.out.println("--------------------------------------------------");
            System.out.println(villa.showInfo());
        }
        displayMainMenu();
    }

    private void menuAddNewService() {
        scanner = new Scanner(System.in);
        int choice;
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit");
        System.out.print("Input your choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                addListVillaService();
                break;
            }
            case 2: {
                addListHouseService();
                break;
            }
            case 3: {
                addListRoomService();
                break;
            }

            case 4: {
                displayMainMenu();
                break;
            }
            default: {
                System.exit(0);
            }
        }
    }

    public void addListVillaService() {
        scanner = new Scanner(System.in);
        List<Villa> villas = new ArrayList<>();
        villas = FuncWriteAndReadFileCSV.readCsvFileVilla();
        System.out.println("Enter number list villa you want: ");
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            Villa villa = (Villa) villaService.addNewService();
            villas.add(villa);
        }
        FuncWriteAndReadFileCSV.writeCsvFileVilla(villas);
        menuAddNewService();
    }

    public void addListHouseService() {
        scanner = new Scanner(System.in);
        List<House> houses = new ArrayList<>();
        houses = FuncWriteAndReadFileCSV.readCsvFileHouse();
        System.out.println("Enter number list house you want: ");
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            House house = (House) houseService.addNewService();
            houses.add(house);
        }
        FuncWriteAndReadFileCSV.writeCsvFileHouse(houses);
        menuAddNewService();
    }

    public void addListRoomService() {
        scanner = new Scanner(System.in);
        List<Room> rooms = new ArrayList<>();
        rooms = FuncWriteAndReadFileCSV.readCsvFileRoom();
        System.out.println("Enter number list villa you want: ");
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            Room room = (Room) roomService.addNewService();
            rooms.add(room);
        }
        FuncWriteAndReadFileCSV.writeCsvFileRoom(rooms);
        menuAddNewService();
    }


    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }


}
