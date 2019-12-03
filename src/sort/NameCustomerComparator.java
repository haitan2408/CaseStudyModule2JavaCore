package sort;

import models.Customer;

import java.util.Comparator;

public class NameCustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if(o1.getNameCustomer().compareTo(o2.getNameCustomer())==0) {
            return o1.getYearBirthday()-o2.getYearBirthday();
        }
        return o1.getNameCustomer().compareTo(o2.getNameCustomer());
    }
}
