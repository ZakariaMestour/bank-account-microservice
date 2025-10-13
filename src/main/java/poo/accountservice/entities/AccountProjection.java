package poo.accountservice.entities;

import org.springframework.data.rest.core.config.Projection;
import poo.accountservice.enums.AccountType;

@Projection(name = "p1", types = BankAccount.class)
public interface AccountProjection {
    public String getId();
    public AccountType getType();

}
