package poo.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.enums.AccountType;
import poo.accountservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository) {
        return args -> {
          for (int i=0; i<10;i++){
              BankAccount bankAccount = BankAccount.builder()
                      .id(UUID.randomUUID().toString())
                      .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVINGS_ACCOUNT)
                      .balance(1000+Math.random()*9000)
                      .createdAt(new Date())
                      .currency("MAD")
                      .build();

              bankAccountRepository.save(bankAccount);
          }
        };
    }
}
