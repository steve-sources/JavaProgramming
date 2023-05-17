package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.exception.PriceTooLowException;

public class Service {
    public Service() {
    }

    public double calculatePrice() throws PriceTooHighException, PriceTooLowException {
        return 500.00;
    }
}
