package poo.accountservice.services;

import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;

import java.util.List;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO accountRequestDTO);
    BankAccountResponseDTO updateAccount(BankAccountRequestDTO accountRequestDTO,String id);
    void deleteAccount(String accountId);
    BankAccountResponseDTO getAccount(String accountId);
    List<BankAccountResponseDTO> getAccounts();
}
