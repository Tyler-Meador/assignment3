package com.meritamerica.assignment3;

import java.util.Arrays;
  

public class AccountHolder {
	private String firstName;
	private String middleName;
	private String lastName;
	private String SSN;
	private double openingBalance;
	private CheckingAccount[] checkingAccounts = new CheckingAccount[100];
	private int numberOfCheckingAccounts = 0;
	private int numberOfSavingsAccounts = 0;
	private SavingsAccount[] savingsAccounts = new SavingsAccount[100];
	private int numberOfCDAccounts = 0;
	public CDAccount[] cdAccounts = new CDAccount[5];
	
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.SSN = ssn;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
		
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSSN() {
		return SSN;
		
	}
	
	public void setSSN(String ssn) {
		this.SSN = ssn;
	}
	
	public CheckingAccount addCheckingAccount(double openingBalance) {
		this.openingBalance = openingBalance;
		
		if((this.openingBalance + getCheckingBalance() + getSavingsBalance()) < 250000) {
			numberOfCheckingAccounts++;
			
			if(numberOfCheckingAccounts > checkingAccounts.length) {
				CheckingAccount[] checkingAccountsTemp = Arrays.copyOf(checkingAccounts, checkingAccounts.length+5);
				checkingAccounts = checkingAccountsTemp;
			}
			
			checkingAccounts[numberOfCheckingAccounts-1] = new CheckingAccount(openingBalance);
			return checkingAccounts[numberOfCheckingAccounts-1];
			
		}
		return null;
	}
			
			//incomplete method
			public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
				if((getCheckingBalance() + getSavingsBalance()) < 250000) {
					numberOfCheckingAccounts++;
					
					
					
			
		}
				
				checkingAccounts[numberOfCheckingAccounts-1] = new CheckingAccount(checkingAccount.getBalance());
				
				return checkingAccounts [numberOfCheckingAccounts-1];
		
		
	}
	
		
	
	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
		
	}
	
	public int getNumberOfCheckingAccounts() {
		return numberOfCheckingAccounts;
		
	}
	public double getCheckingBalance() {
		
		double balance = 0;
		
		for(int i=0; i<checkingAccounts.length; i++)
		{
			
			if(checkingAccounts[i] != null)
			balance += checkingAccounts[i].getBalance(); 
		}
		
		return balance;
		
	}
	
	
	public SavingsAccount addSavingsAccount(double openingBalance) {
		this.openingBalance = openingBalance;
		
		if((openingBalance + getCheckingBalance() + getSavingsBalance()) < 250000) {
			numberOfSavingsAccounts++;
			
			if(numberOfSavingsAccounts > savingsAccounts.length) {
				SavingsAccount[] SavingsAccountsTemp = Arrays.copyOf(savingsAccounts, savingsAccounts.length+5);
				savingsAccounts = SavingsAccountsTemp;
			}
			
			savingsAccounts[numberOfSavingsAccounts-1] = new SavingsAccount(openingBalance);
			return savingsAccounts[numberOfSavingsAccounts-1];
			
		}
		return null;
	}
		
	
	
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		if((getCheckingBalance() + getSavingsBalance()) < 250000) {
			numberOfSavingsAccounts++;
					
	
}
		
		savingsAccounts[numberOfSavingsAccounts-1] = new SavingsAccount(savingsAccount.getBalance());
		
		return savingsAccounts [numberOfSavingsAccounts-1];


}
	
	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
		
	}
	
	public int getNumberOfSavingsAccounts() {
		return numberOfSavingsAccounts;
	}
	
public double getSavingsBalance() {
		
		double balance = 0;
		
		for(int i=0; i<savingsAccounts.length; i++)
		{
			if(savingsAccounts[i] != null)
			balance += savingsAccounts[i].getBalance(); 
		}
		
		return balance;
		
	}
	
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		for(int i = 0; i<cdAccounts.length; i++)
		{				
			CDAccount tempCD = new CDAccount(offering, openingBalance);

			if(cdAccounts [i] == null) {
				cdAccounts [i] = tempCD;
				numberOfCDAccounts++;
				return null;
			}
			
		}
		
		return null;
	}
	
	public CDAccount addCDAccount(CDAccount cdAccount) {
		CDAccount tempCD = cdAccount;
		for(int i = 0; i<cdAccounts.length; i++) {
			if(cdAccounts [i] == null) {
				cdAccounts [i] = tempCD;
				numberOfCDAccounts++;
				return null;
			}
		}	
		return null;
	}
	
	
	public CDAccount[] getCDAccounts() {
		return cdAccounts;
		
	}
	
	public int getNumberOfCDAccounts() {
		return numberOfCDAccounts;
		
	}
	
	public double getCDBalance() {
		double balance = 0;
		
		for(int i=0; i< numberOfCDAccounts; i++)
		{
			if( cdAccounts[i] != null)
			balance += cdAccounts[i].getBalance();
			
		}
		
		return balance;
		
	}
		
	
	public double getCombinedBalance() {
		double total = 0;
		total = getCheckingBalance() + getSavingsBalance() + getCDBalance();
		return total;
	};

	
}