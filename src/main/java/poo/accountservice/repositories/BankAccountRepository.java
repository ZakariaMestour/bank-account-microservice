package poo.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.enums.AccountType;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
