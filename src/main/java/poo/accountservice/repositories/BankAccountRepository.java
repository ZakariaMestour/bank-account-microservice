package poo.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import poo.accountservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
