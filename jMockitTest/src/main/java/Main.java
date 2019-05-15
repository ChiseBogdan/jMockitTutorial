import controller.TransactionController;
import repository.AccountRepository;
import repository.PersonRepository;

public class Main {

    public static void main(String[] args){

        AccountRepository accountRepository = new AccountRepository();
        PersonRepository personRepository = new PersonRepository();

        TransactionController transactionController = new TransactionController();



    }

}
