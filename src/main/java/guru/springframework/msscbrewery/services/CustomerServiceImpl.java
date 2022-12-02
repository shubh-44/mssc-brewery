package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID custId) {
        return CustomerDto.builder().uuid(UUID.randomUUID())
                .name("Shubham")
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        // ToDo
    }

}
