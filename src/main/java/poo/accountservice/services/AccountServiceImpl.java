package poo.accountservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    BankAccountRepository accountRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO accountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(accountRequestDTO.getBalance())
                .createdAt(new Date())
                .type(accountRequestDTO.getType())
                .balance(accountRequestDTO.getBalance())
                .currency(accountRequestDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = accountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        bankAccountResponseDTO.setId(savedBankAccount.getId());
        bankAccountResponseDTO.setBalance(savedBankAccount.getBalance());
        bankAccountResponseDTO.setCreatedAt(savedBankAccount.getCreatedAt());
        bankAccountResponseDTO.setCurrency(savedBankAccount.getCurrency());
        bankAccountResponseDTO.setType(savedBankAccount.getType());

        return bankAccountResponseDTO;
    }
}
