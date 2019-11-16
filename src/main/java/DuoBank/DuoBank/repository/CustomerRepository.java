package DuoBank.DuoBank.repository;

import DuoBank.DuoBank.domains.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
