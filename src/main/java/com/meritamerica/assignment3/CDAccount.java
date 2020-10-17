package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount{
	private CDOffering myOffering = null; 
	
	
	
	//CDAccount is a constructor. It creates the object.
	public CDAccount(CDOffering offering, double balance, long accountNumber, Date openedOn) {
	   this.myOffering = offering;
	   super.balance = balance;
	   super.accountNumber = accountNumber;
	   super.openedOn = openedOn;
	   
	}

	public  double getBalance() {
		return super.getBalance();
	}
	
	public double getInterestRate() {
		return myOffering.getInterestRate();
		
	}
	
	public int getTerm() {
		return myOffering.getTerm();
	}
	
	public Date getStartDate(){
		return super.openedOn;
	}
	
	public long getAccountNumber() {
		return super.getAccountNumber();
	}
	
	public double futureValue() {
		return super.futureValue(0);
	}
	
	public boolean withdraw(double amount, int term) {
		boolean success = false; 
		if(term >= myOffering.getTerm() ) {
			if (super.getBalance() > amount) {
				super.balance = balance - amount;
				success = true;
			}
		}
		return success;
		
	}
	
	public boolean deposit(double amount, int term) {
		boolean success = false;
		if(term >= myOffering.getTerm()) {
			if(amount < 0) {
				success = false;
				return success;
				
			} else {
				
				super.balance = balance + amount;
				success = true;
				return success;
				
			}
		}
		
		return success;
	}
		
	public static CDAccount readFromString(String accountData) throws ParseException{
		
		String delimiter = ",";
		CDAccount tempAccount = null;
		CDOffering tempOffering = null;
		try {
			String[] attributes = accountData.split(delimiter);
			
			long readNumber = Long.valueOf(attributes[0]);
			double readBalance = Double.valueOf(attributes[1]);
			double readInterestRate = Double.valueOf(attributes[2]);
			
			Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(attributes[3]);
			Date readOpenedOn = date1;
			
			int readTerm = Integer.valueOf(attributes[4]);
			
			tempOffering = new CDOffering(readTerm, readInterestRate);
			tempAccount = new CDAccount(tempOffering, readBalance, readNumber, readOpenedOn);
		}catch(java.lang.NumberFormatException e) {
			System.out.println(e);
		}
		
		return tempAccount;
	}

	@Override
	public String writeToString() {
		return accountNumber + "," + balance
				+ "," + myOffering.getInterestRate() + "," + myOffering.getTerm() + "," + openedOn;
	}
	
	
	
		
}
