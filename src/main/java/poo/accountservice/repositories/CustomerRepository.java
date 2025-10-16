package poo.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poo.accountservice.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
