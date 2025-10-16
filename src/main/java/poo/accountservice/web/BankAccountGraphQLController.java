package poo.accountservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.repositories.BankAccountRepository;
import poo.accountservice.services.AccountService;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList() {
        return accountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }
    @MutationMapping
    public BankAccountResponseDTO addBankAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument BankAccountRequestDTO bankAccount, @Argument String id) {
        return accountService.updateAccount(bankAccount, id);
    }
    @MutationMapping
    public void deleteBankAccount(@Argument String id) {
        accountService.deleteAccount(id);
    }
}

