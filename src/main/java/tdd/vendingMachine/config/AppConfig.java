package tdd.vendingMachine.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import tdd.vendingMachine.VendingMachine;
import tdd.vendingMachine.display.Display;
import tdd.vendingMachine.impl.VendingMachineImplementation;
import tdd.vendingMachine.transaction.Transaction;

@Configuration
@ComponentScan(basePackages = {"tdd.vendingMachine"})
public class AppConfig {

	@Bean
	@Qualifier("machine")
	public VendingMachineImplementation vendingMachineBean(){
		return new VendingMachineImplementation(new Display());
	}
	@Bean
	@Qualifier("display")
	public Display displayBean(){
		return new Display();
	}
	@Bean
	@Qualifier("transaction")
	public Transaction transactionBean(){
		return new Transaction(5, 1.50);
	}
	
	
}
