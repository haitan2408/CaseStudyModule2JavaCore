package service.impl;

import exception.*;
import models.Customer;
import service.CustomerService;

import java.util.Scanner;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    Scanner scanner;
    String regex = "";

    @Override
    public Customer addNewCustomer() {
        scanner = new Scanner(System.in);
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString().replace("-", ""));
        while (true) {
            try {
                System.out.print("Enter Name Customer (Format Abc Abc): ");
                String nameCustomer = NameException.nameException(scanner.nextLine());
                customer.setNameCustomer(nameCustomer);
                break;
            } catch (Exception m) {
                System.out.println(m);
            }
        }

        while (true) {
            try {
                System.out.print("Enter Id Card (Format XXX XXX XXX): ");
                String idCard = IDCardException.idCardException(scanner.nextLine());
                customer.setIdCard(idCard);
                break;
            } catch (Exception m) {
                System.out.println(m);
            }
        }
        while (true) {
            try {
                System.out.print("Enter Birthday Customer (Format dd/MM/yyyy): ");
                String birthdayCustomer = BirthdayException.birthdayException(scanner.nextLine());
                customer.setBirthday(birthdayCustomer);
                break;
            } catch (Exception m) {
                System.out.println(m);
            }
        }

        while (true) {
            try {
                System.out.print("Enter Gender (male, female, unknown): ");
                String genderCustomer = GenderException.genderException(scanner.nextLine());
                customer.setGender(genderCustomer);
                break;
            } catch (Exception m) {
                System.out.println(m);
            }
        }


        System.out.print("Enter Phone: ");
        customer.setPhoneNumber(scanner.nextLine());

        while (true) {
            try {
                System.out.print("Enter Email (Format abc@abc.abc): ");
                String emailCustomer = EmailException.emailException(scanner.nextLine());
                customer.setEmail(emailCustomer);
                break;
            } catch (Exception m) {
                System.out.println(m);
            }
        }


        System.out.print("Enter Type Customer: ");
        customer.setTypeCustomer(scanner.nextLine());

        System.out.print("Enter Address: ");
        customer.setAddress(scanner.nextLine());
        System.out.println("------------------------------------------------");

        return customer;
    }

}

