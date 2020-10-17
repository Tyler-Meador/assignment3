package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MeritBank {
	
	
	private static int numOfferings;
	private static int numAccountHolders;
	private static AccountHolder[] MeritHolders = new AccountHolder [numAccountHolders];
	private static CDOffering[] MeritCD = new CDOffering[numOfferings];
	private static int nextAccountNum = 0;
	static double bestValue[] = new double[5];
	static double secondBestValue[] = new double[5];
	static int best = 0;
	static int second = 0;
	


	
	public static void addAccountHolder(AccountHolder accountHolder) {
		for (int i =0; i < MeritHolders.length; i++) {
			if(MeritHolders[i] == null) {
				MeritHolders[i] = accountHolder;
				break;
			}
			
		}
	}
	
	public static AccountHolder[] getAccountHolders() {
		return MeritHolders;
	}

	public static CDOffering[] getCDOfferings() {
		return MeritCD;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		
	
		
		
		for(int i = 0; i<MeritCD.length; i++) {
			
			if(MeritCD[i] != null) {
				
				bestValue[i] = futureValue(depositAmount, MeritCD[i].getInterestRate(), MeritCD[i].getTerm());		
			}
		}
		
		double tempBest;

		tempBest = bestValue[0];
		for(int i = 1; i < bestValue.length; i++) {
			if(tempBest < bestValue[i]) {
				tempBest = bestValue[i];
				best = i;
			}
		}
			return MeritCD[best];
	}
	
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		if(MeritCD == null) {
			return null;
		}
		for(int i = 0; i<MeritCD.length; i++) {
			
			if(MeritCD[i] != null) {
				
				secondBestValue[i] = futureValue(depositAmount, MeritCD[i].getInterestRate(), MeritCD[i].getTerm());		
			}

		}
		
		double tempSecond;
		tempSecond = secondBestValue[0];
		for(int i = 1; i < secondBestValue.length; i++) {
			if(tempSecond < secondBestValue[i]) {
				second = i-1;
			}
		}
		
		
		return MeritCD[second];
		
	}
	
	public static void clearCDOfferings() {
		
		MeritCD = null;
		
		}
	
	public static void setCDOfferings(CDOffering[] offerings) {
			MeritCD = offerings;

		
	}
	
	public static long getNextAccountNumber() {
		int temp = nextAccountNum;
		nextAccountNum++;
		return MeritHolders[temp].cdAccounts[temp].getAccountNumber();

	}
	 public static double totalBalances() {
		 double total = 0;
		 for(int i = 0; i < MeritHolders.length; i++) {
			 
			 if(MeritHolders[i] != null)
			 total = MeritHolders[i].getCombinedBalance();
		 }
		 return total;
	 }
	 
	 public static double futureValue(double presentValue, double interestRate, int term) {
		 double temp = 0;
		 temp = presentValue * Math.pow(1 + interestRate, term);
		 return temp;


	 }
	 
	 public static boolean readFromFile(String fileName) {
		 ArrayList<String> Lines = new ArrayList<String>();
		 String accountData;
		 try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			 while((accountData = br.readLine()) != null) {
				 Lines.add(accountData);
			 }
		 }catch(Exception e){
			 System.out.println(e);
		 }
		 
		 Iterator<String> iter = Lines.iterator();
		 int count = 0;
		 while(iter.hasNext()) {
			 switch(count) {
			 case 0: nextAccountNum = (Integer.parseInt(iter.next())) - 1;
			 		count++;
			 case 1: numOfferings = Integer.parseInt(iter.next());
			 		count++;
			 case 2: CDOffering[] tempOff = new CDOffering[numOfferings];
				 		for(int i = 0; i < numOfferings; i++) {
				 			if(iter.hasNext()) {
				 				tempOff[i] = CDOffering.readFromString(iter.next());
				 			}
				 		}
				 	count++;
			 case 3: numAccountHolders = Integer.parseInt(iter.next());
			 		count++;
			 case 4: AccountHolder[] tempAccs = new AccountHolder[numAccountHolders];
			 			for(int i = 0; i < numAccountHolders; i++) {
			 				if(iter.hasNext()) {
			 					try {
									tempAccs[i] = AccountHolder.readFromString(iter.next());
								} catch (Exception e) {
									e.printStackTrace();
								}
			 					if(iter.hasNext()) {
			 						tempAccs[i].setNumberOfCheckingAccounts( Integer.parseInt(iter.next()));
			 					}
			 					if(iter.hasNext() && tempAccs[i].getNumberOfCheckingAccounts() > 0) {
			 						for(int j = 0; j < tempAccs[i].getNumberOfCheckingAccounts(); j++) {
			 							try {
											tempAccs[i].addCheckingAccount(CheckingAccount.readFromString(iter.next()));
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
			 						}
			 						
			 					}
			 					if(iter.hasNext()) {
			 						tempAccs[i].setNumberofSavingsAccounts(Integer.parseInt(iter.next()));
			 					}
			 					if(iter.hasNext() && tempAccs[i].getNumberOfSavingsAccounts() > 0) {
			 						for(int j = 0; j < tempAccs[i].getNumberOfSavingsAccounts(); j++) {
			 							try {
			 								tempAccs[i].addSavingsAccount(SavingsAccount.readFromString(iter.next()));
			 							}catch (ParseException e) {
			 								e.printStackTrace();
			 							}
			 						}
			 					}
			 					if(iter.hasNext()) {
			 						tempAccs[i].setNumberofCDAccounts(Integer.parseInt(iter.next()));
			 					}
			 					if(iter.hasNext() && tempAccs[i].getNumberOfCDAccounts() > 0) {
			 						for(int j = 0; j < tempAccs[i].getNumberOfCDAccounts(); j++) {
			 							try {
			 								tempAccs[i].addCDAccount(CDAccount.readFromString(iter.next()));
			 							}catch (ParseException e) {
			 								e.printStackTrace();
			 							}
			 						}
			 					}
			 					
			 					
			 					
			 				}
			 			}
			 }
		 }
		 
		 
		 return true;
	 }
	 
	 static AccountHolder[] sortAccountHolders() {
		 ArrayList<AccountHolder> holderAccount = new ArrayList<AccountHolder>();
		 
		 for(int i = 0; i < MeritHolders.length; i++) {
			 holderAccount.add(MeritHolders[i]);
		 }
		 
		 Collections.sort(holderAccount);
		 
		 AccountHolder[] sortedHolder = new AccountHolder[holderAccount.size()];
		 
		 for(int i = 0; i < holderAccount.size();i++) {
			 sortedHolder[i] = holderAccount.get(i);
		 }
		 return sortedHolder;
	 }

	 static void setNextAccountNumber(long nextAccountNumber) {
		 nextAccountNum = (int)nextAccountNumber;
	 }
	


	
	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
