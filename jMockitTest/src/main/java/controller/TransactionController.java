package controller;

import domain.Account;
import domain.Person;
import repository.AccountRepository;
import repository.PersonRepository;

public class TransactionController {

    private AccountRepository accountRepository = new AccountRepository();
    private PersonRepository personRepository = new PersonRepository();

    public TransactionController(){}

    public double withdrawMoney(double amount, String CNP, int accountId) throws NotEnoughMoneyException, TheftException {

        Person person = personRepository.findOne(CNP);
        Account account = accountRepository.findAccountOfPerson(CNP, accountId);

        if(account.getAmount() < amount){
            throw new NotEnoughMoneyException("Not enough money in your account");
        }

        double newAmount = account.getAmount() - amount;

        double newAmountFromDatabase = accountRepository.update(accountId, newAmount);

        if(newAmount != newAmountFromDatabase){
            throw new TheftException("Amounts are not the same");
        }

        return newAmount;

    }

    public Person findPerson(String CNP){
        return personRepository.findOne(CNP);
    }
}
