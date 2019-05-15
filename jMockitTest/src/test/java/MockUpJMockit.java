import controller.NotEnoughMoneyException;
import controller.TheftException;
import controller.TransactionController;
import domain.Account;
import domain.Person;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import repository.AccountRepository;
import repository.PersonRepository;


@RunWith(JMockit.class)
public class MockUpJMockit {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Mocked
    PersonRepository personRepository;
    @Mocked
    AccountRepository accountRepository;

    @Tested
    TransactionController transactionController;


    @Test
    public void withDrawAmountTestOK() throws TheftException, NotEnoughMoneyException {
        //MockUp for PersonRepository
        new MockUp<PersonRepository>() {

            @SuppressWarnings("unused")
            @Mock
            public Person findOne(String CNP){
                return new Person("197072605520","Boros Bogdan",22);
            }

        };

        //MockUp for AccountRepository
        new MockUp<AccountRepository>(){
            @SuppressWarnings("unused")
            @Mock
            public Account findAccountOfPerson(String CNP, int accountId){
                return new Account(100,1000);
            }

            @Mock
            public double update(int id, double newAmount) {
                return 750.0;
            }
        };

        transactionController = new TransactionController();

        double newValue = transactionController.withdrawMoney(250,"197072605520",100);
        assert(newValue == 750);

    }
    

    @Test
    public void withDrawAmountTestBAD() throws TheftException, NotEnoughMoneyException {
        //MockUp for PersonRepository
        new MockUp<PersonRepository>() {

            @SuppressWarnings("unused")
            @Mock
            public Person findOne(String CNP){
                return new Person("197072605520","Boros Bogdan",22);
            }

        };

        //MockUp for AccountRepository
        new MockUp<AccountRepository>(){
            @SuppressWarnings("unused")
            @Mock
            public Account findAccountOfPerson(String CNP, int accountId){
                return new Account(100,1000);
            }

        };

        transactionController = new TransactionController();

        thrown.expect(NotEnoughMoneyException.class);

        transactionController.withdrawMoney(1050,"197072605520",100);

    }
}
