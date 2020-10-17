package com.meritamerica.assignment3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CDOffering {
	
	private int loanTerm;
	private double iRate;
	
	
	public  CDOffering (int term, double interestRate){
		this.loanTerm = term;
		this.iRate = interestRate;

	}
	
	public int getTerm() {
		return loanTerm;
	}
	
	public double getInterestRate() {
		return iRate;
	}

	public static CDOffering readFromString(String cdOfferingDataString)throws java.lang.NumberFormatException{
		
		String delimiter = ",";
		CDOffering tempOffering = null;
		try {
			String[] attributes = cdOfferingDataString.split(delimiter);
			
			int readTerm = Integer.valueOf(attributes[0]);
			double readInterestRate = Double.valueOf(attributes[2]);
			
			tempOffering = new CDOffering(readTerm, readInterestRate);

		}catch(java.lang.NumberFormatException e) {
			System.out.println(e);
		}
		
		return tempOffering;
	
	}
}
