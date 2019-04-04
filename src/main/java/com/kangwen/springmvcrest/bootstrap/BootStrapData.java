package com.kangwen.springmvcrest.bootstrap;

import com.kangwen.springmvcrest.domain.Customer;
import com.kangwen.springmvcrest.respositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Customer Data");

        Customer c1 = new Customer();
        c1.setFirstName("Micheale");
        c1.setLastName("Weston");
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstName("Sam");
        c2.setLastName("Axe");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setLastName("Gleanann");
        c3.setFirstName("Fionna");
        customerRepository.save(c3);

        System.out.println("Customers Saved: " + customerRepository.count());

    }
}
