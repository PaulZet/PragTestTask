package tdd.vendingMachine;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tdd.vendingMachine.config.AppConfig;
import tdd.vendingMachine.display.Display;
import tdd.vendingMachine.impl.VendingMachineImplementation;
import tdd.vendingMachine.transaction.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class VendingMachineTest {

	@Autowired
	VendingMachineImplementation machine;
	@Autowired
	Display display;
	@Autowired
	Transaction transaction;
	

	/*
	 * @Test public void
	 * just_a_stupid_passing_test_to_ensure_that_tests_are_run() {
	 * Assertions.assertThat(new VendingMachine()).isNotNull(); }
	 */

	@Test
	public void shouldCalculateTransaction() {
		// given

		// when
		double result = this.transaction.calculateChangeToPayBack();
		// then
		Assert.assertEquals(3.5, this.transaction.calculateChangeToPayBack(), 0);
	}
	@Test
	public void shouldValidateCoinDenomination(){
		//given
		double inserted = 0.5;
		//when
		boolean result = this.machine.validateCoinDenomintation(inserted);
		//then
		Assert.assertEquals(true, result);
	}
	@Test
	public void shouldNotValidateCoinDenomination(){
		//given
		double inserted = 0.6;
		//when
		boolean result = this.machine.validateCoinDenomintation(inserted);
		//then
		Assert.assertEquals(false, result);
	}
	

}
