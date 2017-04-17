package spring.cassandra.rest.controller;

import com.datastax.driver.core.utils.UUIDs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.cassandra.rest.entity.Customer;
import spring.cassandra.rest.repository.CustomerRepository;

/**
 *
 * @author Nataniel Paiva
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> list() {
        return (List<Customer>) customerRepository.findAll();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        customer.setId(UUIDs.timeBased().toString());
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer update(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getById(@PathVariable String id) {
        Customer customer = customerRepository.findOne(id);
        return customer;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        customerRepository.delete(id);
    }

}
