package poo.accountservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.repositories.BankAccountRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount) {
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        bankAccount.setId(id);
        return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}

