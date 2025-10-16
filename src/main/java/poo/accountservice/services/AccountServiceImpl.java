package poo.accountservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.mappers.AccountMapper;
import poo.accountservice.repositories.BankAccountRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    BankAccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO accountRequestDTO) {
        BankAccount bankAccount = accountMapper.toBankAccount(accountRequestDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount savedBankAccount = accountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(BankAccountRequestDTO accountRequestDTO,String id) {
        BankAccount bankAccount = accountMapper.toBankAccount(accountRequestDTO);
        bankAccount.setId(id);
        BankAccount savedBankAccount = accountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public void deleteAccount(String accountId) {
        bankAccountRepository.deleteById(accountId);
    }

    @Override
    public BankAccountResponseDTO getAccount(String accountId) {
        BankAccount bankAccount = accountRepository.findById(accountId).orElseThrow(()->new RuntimeException(String.format("Account %s not found",accountId)));
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(bankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public List<BankAccountResponseDTO> getAccounts() {
        BankAccountResponseDTO accountResponseDTO = new BankAccountResponseDTO();
        List<BankAccount> bankAccounts = accountRepository.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOs = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(bankAccount);
            bankAccountResponseDTOs.add(bankAccountResponseDTO);
        }
        return bankAccountResponseDTOs;
    }
}
