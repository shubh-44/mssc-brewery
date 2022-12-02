package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID custId);

    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);
}
