package DuoBank.DuoBank.controller;


import DuoBank.DuoBank.domains.Customer;
import DuoBank.DuoBank.domains.response.ResponseReturn;
import DuoBank.DuoBank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST, value = "/customers/{id}")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer, @PathVariable Long id){
        Customer a = customerService.addCustomer(customer);
        ResponseReturn responseReturn = new ResponseReturn();
        ResponseReturn responseReturn1 = new ResponseReturn();
        if (a != null){
            responseReturn.setCode(HttpStatus.OK.value());
            responseReturn.setCustomMessage("Customer Added");
            responseReturn.setData(a);

            return new ResponseEntity<>(responseReturn,HttpStatus.CREATED);
        }else {
            responseReturn1.setCode(HttpStatus.EXPECTATION_FAILED.value());
            responseReturn1.setCustomMessage("Task Failed No Customer Added");
            return new ResponseEntity<>(responseReturn1,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public ResponseEntity<?> listCustomers(){
        ResponseReturn responseReturn = new ResponseReturn();
        ResponseReturn responseReturn1 = new ResponseReturn();
        List<Customer> allCustomers = customerService.getCustomers();
        if (!allCustomers.isEmpty()){
            responseReturn.setCode(HttpStatus.OK.value());
            responseReturn.setCustomMessage("Here Are The Current Customers");
            responseReturn.setData(allCustomers);
            return new ResponseEntity<>(responseReturn,HttpStatus.OK);
        }else {
            responseReturn1.setCode(HttpStatus.NOT_FOUND.value());
            responseReturn1.setCustomMessage("No Customers Found");
            return new ResponseEntity<>(responseReturn1,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public ResponseEntity<?> updateInfo(@PathVariable Long id, @RequestBody Customer customer){
        ResponseReturn responseReturn = new ResponseReturn();
        Customer updateInfo = customerService.updateInfo(customer);
        responseReturn.setCode(HttpStatus.OK.value());
        responseReturn.setCustomMessage("Customer Info Updated Successfully");
        responseReturn.setData(updateInfo);
        return new ResponseEntity<>(responseReturn,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "customers/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id, @RequestBody Customer customer){
        ResponseReturn responseReturn = new ResponseReturn();
        Customer delete = customerService.deleteCustomer(id,customer);
        responseReturn.setCode(HttpStatus.OK.value());
        responseReturn.setCustomMessage("Customer Deleted From System");
        responseReturn.setData(delete);

        return new ResponseEntity<>(responseReturn, HttpStatus.OK);
    }

}
