package poo.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import poo.accountservice.entities.BankAccount;
import poo.accountservice.entities.Customer;
import poo.accountservice.enums.AccountType;
import poo.accountservice.repositories.BankAccountRepository;
import poo.accountservice.repositories.CustomerRepository;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Said","Rachid","Brahim","Hanane").forEach(name -> {
                Customer customer = Customer.builder().name(name).build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(
                    customer -> {
                        for (int i=0; i<5;i++){
                            BankAccount bankAccount = BankAccount.builder()
                                    .id(UUID.randomUUID().toString())
                                    .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVINGS_ACCOUNT)
                                    .balance(1000+Math.random()*9000)
                                    .createdAt(new Date())
                                    .currency("MAD")
                                    .customer(customer)
                                    .build();

                            bankAccountRepository.save(bankAccount);
                        }
                    }
            );

        };
    }
}
