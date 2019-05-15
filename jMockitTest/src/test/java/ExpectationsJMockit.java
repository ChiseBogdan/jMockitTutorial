import controller.NotEnoughMoneyException;
import controller.TheftException;
import controller.TransactionController;
import domain.Account;
import domain.Person;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void withdrawAmountTest() throws TheftException, NotEnoughMoneyException {

        final TransactionController transactionController = new TransactionController();

        new Expectations() {

            {
                personRepository.findOne("1970726055020");
                returns(new Person("19707260055020", "Boros Bogdan", 22));

                accountRepository.findAccountOfPerson("1970726055020", 100);
                returns(new Account(100, 1000));

                accountRepository.update(100, 750);
                returns(750.0);
            }

        };


        double amountToWithdraw = 250;
        int accountId = 100;
        double newAmmount = transactionController.withdrawMoney(amountToWithdraw, "1970726055020", accountId);

        assertTrue(newAmmount == 750);


    }

    @Test
    public void getCurrentTime(){

        final TransactionController transactionController = new TransactionController();

        transactionController.getOnePearson("1970726055080");

        new Verifications(){

            {
                personRepository.findOne(anyString); times=1;
            }

        };

    }

    @Test
    public void withdrawAmountTestWithException() throws TheftException, NotEnoughMoneyException {

        final TransactionController transactionController = new TransactionController();

        new Expectations() {

            {
                personRepository.findOne("1970726055020");
                returns(new Person("19707260055020", "Boros Bogdan", 22));

                accountRepository.findAccountOfPerson("1970726055020", 100);
                returns(new Account(100, 1000));
            }

        };


        double amountToWithdraw = 1050;
        int accountId = 100;

        thrown.expect(NotEnoughMoneyException.class);
        transactionController.withdrawMoney(amountToWithdraw, "1970726055020", accountId);

    }

}
