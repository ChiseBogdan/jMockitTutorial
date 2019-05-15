package controller;

import domain.Account;
import domain.Person;
import repository.AccountRepository;
import repository.PersonRepository;

public class TransactionController {

    private AccountRepository accountRepository;
    private PersonRepository personRepository;

    public TransactionController(AccountRepository accountRepository, PersonRepository personRepository){
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
    }

    public void withdrawMoney(double amount, String CNP, int accountId){

        Person person = personRepository.findOne(CNP);
        Account account = accountRepository.findAccountOfPerson(CNP, accountId);

    }
}
