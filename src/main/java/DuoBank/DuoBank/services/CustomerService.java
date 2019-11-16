package DuoBank.DuoBank.services;

import DuoBank.DuoBank.domains.Customer;
import DuoBank.DuoBank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomers(){
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }

    public Optional<Customer> getCustomerById(long id) {
        return customerRepository.findById(id);
    }
    public Customer addCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }
    public Customer updateInfo(Customer customer){
        customerRepository.save(customer);
        return customer;
    }
    public Customer deleteCustomer(long id, Customer customer){
        customerRepository.deleteById(id);
        return customer;
    }

}
