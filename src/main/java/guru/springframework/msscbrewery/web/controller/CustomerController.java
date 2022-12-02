package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getBeer(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedDto = customerService.createCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/customer"+savedDto.getUuid().toString());
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity updateCustomer(@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
