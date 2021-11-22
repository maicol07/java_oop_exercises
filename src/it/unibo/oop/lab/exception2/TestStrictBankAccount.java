package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	var account1 = new AccountHolder("A", "B", 1);
    	var account2 = new AccountHolder("C", "D", 2);
    	
    	var bank1 = new StrictBankAccount(1, 10000, 10);
    	var bank2 = new StrictBankAccount(2, 10000, 10);
    	
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	bank1.withdraw(1, 100);
    	//bank1.withdrawFromATM(1, 100);
    	
    	try {
    		bank1.withdrawFromATM(1, 100);
    	} catch (TransactionsOverQuotaException e) {
			assertNotNull(e.getMessage());
			fail(e.getMessage());
		}
    	
    	try {
    		bank2.withdrawFromATM(1, 525252);
    	} catch (WrongAccountHolderException e) {
			assertNotNull(e.getMessage());
			//fail(e.getMessage());
		}
    	
    	try {
    		bank2.withdrawFromATM(2, 525252);
    	} catch (NotEnoughFoundsException e) {
			assertNotNull(e.getMessage());
			//fail(e.getMessage());
		}
    }
}
