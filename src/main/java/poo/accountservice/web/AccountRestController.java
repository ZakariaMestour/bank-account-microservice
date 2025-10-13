package poo.accountservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.repositories.BankAccountRepository;
import poo.accountservice.services.AccountService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts() {
        return accountService.getAccounts();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO bankAccount(@PathVariable String id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO createBankAccount(@RequestBody BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }
    @PutMapping("/bankAccounts")
    public BankAccountResponseDTO updateBankAccount( @RequestBody BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(bankAccount);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
            accountService.deleteAccount(id);
    }
}

