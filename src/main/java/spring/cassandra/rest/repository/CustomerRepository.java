
package spring.cassandra.rest.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.cassandra.rest.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	@Query("Select * from customer where firstname=?0")
	public Customer findByFirstName(String firstName);

	@Query("Select * from customer where lastname=?0")
	public List<Customer> findByLastName(String lastName);
	
        @Query("Select * from customer where id=?0")
	public Customer findById(String id);
        

}
