package service;

import models.Customer;

import java.util.List;
import java.util.Queue;

public interface BookingCinema4DService {
    void addBookingCinema(Customer customer);

    Queue<Customer> getAllBookingCinema();
}
