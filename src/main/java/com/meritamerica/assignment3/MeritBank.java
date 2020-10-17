package com.meritamerica.assignment3;



public class MeritBank {
	
	private static AccountHolder[] MeritHolders = new AccountHolder [100];
	private static CDOffering[] MeritCD = new CDOffering[5];
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
		//for (int i = 0; i < MeritCD.length; i++) {
		//		MeritCD[i] = null;
		//	}
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


	


	
	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
