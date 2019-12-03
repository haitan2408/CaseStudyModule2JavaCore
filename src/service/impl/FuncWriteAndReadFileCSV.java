package service.impl;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FuncWriteAndReadFileCSV {
    private static final char COMMA_DELIMITER = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int NUM_OF_LINE_SKIP = 1;
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/data/Room.csv";
    private static final String PATH_FILE_BOOKING = "src/data/Booking.csv";
    private static final String PATH_FILE_CUSTOMER = "src/data/Customer.csv";
    private static final String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "areaUse", "rentalCost", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_HOUSE = {" id", " nameService", "areaUse", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "numberOfFloors"};
    private static final String[] FILE_HEADER_OF_ROOM = {" id", " nameService", "areaUse", "rentalCosts", "maxNumberOfPeople", "typeRent", "freeService"};
    private static final String[] FILE_HEADER_OF_CUSTOMER = {" id", " nameCustomer", "idCard", " birthday", " gender", " phoneNumber", " email", " typeCustomer", " address"};
    private static final String[] FILE_HEADER_OF_BOOKING = {" id", " nameCustomer", "idCard", " birthday", " gender", " phoneNumber", " email", " typeCustomer", " address", "idService", "nameService", "areaUse", "rentalCost", "maxNumberOfPeople", "typeRent",};

    public static Set<String> getNameServiceFromFileCSV(String path) {
        String line = "";
        Set<String> setNameVilla = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arrVilla = line.split(String.valueOf(COMMA_DELIMITER));
                setNameVilla.add(arrVilla[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return setNameVilla;

    }

    public static void writeCsvFileVilla(List<Villa> villas) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(PATH_FILE_VILLA);

            fileWriter.append(Arrays.toString(FILE_HEADER_OF_VILLA));

            fileWriter.append(NEW_LINE_SEPARATOR);


            for (Villa villaCSV : villas) {
                fileWriter.append(villaCSV.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villaCSV.getNameService());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villaCSV.getArea​​Use()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villaCSV.getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villaCSV.getMaxNumberOfPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villaCSV.getTypeRent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villaCSV.getRoomStandard()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villaCSV.getConvenientDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villaCSV.getAreaPool()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villaCSV.getNumberOfFloors()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public static void writeCsvFileHouse(List<House> houses) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(PATH_FILE_HOUSE);

            fileWriter.append(Arrays.toString(FILE_HEADER_OF_HOUSE));


            fileWriter.append(NEW_LINE_SEPARATOR);

            for (House houseCSV : houses) {
                fileWriter.append(houseCSV.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(houseCSV.getNameService());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(houseCSV.getArea​​Use()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(houseCSV.getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(houseCSV.getMaxNumberOfPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(houseCSV.getTypeRent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(houseCSV.getRoomStandard()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(houseCSV.getConvenientDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(houseCSV.getNumberOfFloors()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public static void writeCsvFileRoom(List<Room> rooms) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(PATH_FILE_ROOM);

            fileWriter.append(Arrays.toString(FILE_HEADER_OF_ROOM));


            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Room roomCSV : rooms) {
                fileWriter.append(roomCSV.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(roomCSV.getNameService());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(roomCSV.getArea​​Use()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(roomCSV.getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(roomCSV.getMaxNumberOfPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(roomCSV.getTypeRent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(roomCSV.getFreeService());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public static void writeCsvFileCustomer(List<Customer> customers) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(PATH_FILE_CUSTOMER);

            fileWriter.append(Arrays.toString(FILE_HEADER_OF_CUSTOMER));


            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Customer customerCSV : customers) {
                fileWriter.append(customerCSV.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getNameCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getIdCard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getBirthday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getTypeCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public static List<Villa> readCsvFileVilla() {
        Path path = Paths.get(PATH_FILE_VILLA);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH_FILE_VILLA);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(FILE_HEADER_OF_VILLA);

        CsvToBean<Villa> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(PATH_FILE_VILLA))
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return csvToBean.parse();
    }

    public static List<House> readCsvFileHouse() {
        Path path = Paths.get(PATH_FILE_HOUSE);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH_FILE_HOUSE);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<House> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(House.class);
        strategy.setColumnMapping(FILE_HEADER_OF_HOUSE);

        CsvToBean<House> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(PATH_FILE_HOUSE))
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return csvToBean.parse();
    }

    public static List<Room> readCsvFileRoom() {
        Path path = Paths.get(PATH_FILE_ROOM);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH_FILE_ROOM);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(FILE_HEADER_OF_ROOM);

        CsvToBean<Room> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(PATH_FILE_ROOM))
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return csvToBean.parse();
    }

    public static List<Customer> readCsvFileCustomer() {
        Path path = Paths.get(PATH_FILE_CUSTOMER);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH_FILE_CUSTOMER);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(FILE_HEADER_OF_CUSTOMER);

        CsvToBean<Customer> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(PATH_FILE_CUSTOMER))
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return csvToBean.parse();
    }

    public static List<Customer> readCsvFileBooking() {
        String line = "";
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_FILE_BOOKING))) {
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arrCustomer = line.split(String.valueOf(COMMA_DELIMITER));
                Customer customer = new Customer(arrCustomer[0], arrCustomer[1], arrCustomer[2], arrCustomer[3], arrCustomer[4], arrCustomer[5], arrCustomer[6], arrCustomer[7],arrCustomer[8]);
                customer.setVilla(arrCustomer[9], arrCustomer[10], Double.parseDouble(arrCustomer[11]), Double.parseDouble(arrCustomer[12]), Integer.parseInt(arrCustomer[13]), arrCustomer[14]);

                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void writeCsvFileBooking(List<Customer> listBooking) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(PATH_FILE_BOOKING);

            fileWriter.append(Arrays.toString(FILE_HEADER_OF_BOOKING));


            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Customer customerCSV : listBooking) {
                fileWriter.append(customerCSV.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getNameCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getIdCard());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getBirthday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getTypeCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getService().getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getService().getNameService());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customerCSV.getService().getArea​​Use()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customerCSV.getService().getRentalCosts()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customerCSV.getService().getMaxNumberOfPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customerCSV.getService().getTypeRent());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}
