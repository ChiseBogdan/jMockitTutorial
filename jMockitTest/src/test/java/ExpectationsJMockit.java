import controller.NotEnoughMoneyException;
import controller.TheftException;
import controller.TransactionController;
import domain.Account;
import domain.Person;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;
import repository.AccountRepository;
import repository.PersonRepository;
import static org.junit.Assert.assertTrue;

@RunWith(JMockit.class)
public class ExpectationsJMockit {

    @Mocked
    private PersonRepository personRepository;

    @Mocked
    private AccountRepository accountRepository;


    @Test
    public void withdrawAmountTest(){

        TransactionController transactionController = new TransactionController();

        new Expectations(){

            {
                personRepository.findOne("1970726055020");
                returns(new Person("19707260055020", "Boros Bogdan", 22));

                accountRepository.findAccountOfPerson("1970726055020", 100);
                returns(new Account(100, 1000));

                accountRepository.update(100, 750);
                returns(750.0);
            }

        };

        try {

            double amountToWithdraw = 250;
            int accountId = 100;
            double newAmmount = transactionController.withdrawMoney(amountToWithdraw, "1970726055020", accountId);

            assertTrue(newAmmount == 750);

        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        } catch (TheftException e) {
            e.printStackTrace();
        }

    }

}
