package poo.accountservice.services;

import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO accountRequestDTO);
}
