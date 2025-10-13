package poo.accountservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import poo.accountservice.dtos.BankAccountRequestDTO;
import poo.accountservice.dtos.BankAccountResponseDTO;
import poo.accountservice.entities.BankAccount;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
    public BankAccount toBankAccount(BankAccountRequestDTO accountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(accountRequestDTO, bankAccount);

        bankAccount.setCreatedAt(new Date());
        return bankAccount;
    }
}
