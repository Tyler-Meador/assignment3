package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BankAccount {
	
	public long accountNumber;
	public double balance;
	public double interestRate = .01;
	double futureValue;
    Date openedOn;
    
    public BankAccount() {
    	
    }
	
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.openedOn = accountOpenedOn;
		
	}
	

	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public boolean withdraw(double amount) {
		boolean success = false; 
		if (this.balance > amount) {
			balance = balance - amount;
			success = true;
		}
		return success;
		
	}
	
	public boolean deposit(double amount) {
		if(amount<0.0) {
			//System.out.println("Cannot deposit a negative amount.");
			return false;
			
		} else {
			balance = balance + amount;
			return true;
		}
		
		
	}
	
	public double futureValue(int years) {
		System.out.println(balance);
		System.out.println(interestRate);
		futureValue = balance * (Math.pow((1 + interestRate),years));
		return futureValue;
	}
	
	public Date getOpenedOn() {
		return openedOn;
	}
	
	public static BankAccount readFromString(String accountData) throws ParseException{
		
		String delimiter = ",";
		BankAccount tempAccount = null;

			String[] attributes = accountData.split(delimiter);
			
			long readNumber = Long.valueOf(attributes[0]);
			double readBalance = Double.valueOf(attributes[1]);
			double readInterestRate = Double.valueOf(attributes[2]);
			
			
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(attributes[3]);
			Date readOpenedOn = date1;
			
			tempAccount = new BankAccount(readNumber, readBalance, readInterestRate, readOpenedOn);
			

		
		return tempAccount;
	}
	

	public String writeToString() {
		return accountNumber + "," + balance + "," + interestRate + "," + openedOn;
	}

}
