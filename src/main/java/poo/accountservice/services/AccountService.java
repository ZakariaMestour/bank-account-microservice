package poo.accountservice.services;

import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;

import java.util.List;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO accountRequestDTO);
    public BankAccountResponseDTO updateAccount(BankAccountRequestDTO accountRequestDTO);
    public void deleteAccount(String accountId);
    public BankAccountResponseDTO getAccount(String accountId);
    public List<BankAccountResponseDTO> getAccounts();
}
