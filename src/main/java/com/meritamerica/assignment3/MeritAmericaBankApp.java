package com.meritamerica.assignment3;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		
		CDOffering[] MeritCDs = new CDOffering[5];
		
		MeritCDs[0] = new CDOffering(1, 1.8 / 100.0);
		MeritCDs[1] = new CDOffering(2, 1.9 / 100.0);
		MeritCDs[2] = new CDOffering(3, 2.0 / 100.0);
		MeritCDs[3] = new CDOffering(5, 2.5 / 100.0);
		MeritCDs[4] = new CDOffering(10, 2.2 / 100.0);
			
		MeritBank.setCDOfferings(MeritCDs);

		AccountHolder ah1 = new AccountHolder("Keanu", "John", "Reeves", "111 11 1111");
		
		ah1.addCheckingAccount(1000);
		
		ah1.addSavingsAccount(10000);
		
		ah1.addCheckingAccount(5000);
		
		ah1.addSavingsAccount(50000);
		
		ah1.addCheckingAccount(50000);
		
		ah1.addSavingsAccount(500000);
		
		ah1.addCheckingAccount(5000);
		
		ah1.addSavingsAccount(50000);
		
		ah1.addCDAccount(MeritBank.getBestCDOffering(ah1.getCombinedBalance()), ah1.getCombinedBalance());
		
		MeritBank.addAccountHolder(ah1);
		

		AccountHolder ah2 = new AccountHolder("James", "007", "Bond", "222 44 8888");
		
		ah2.addCheckingAccount(1000);
		
		ah2.addSavingsAccount(10000);
		
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(ah2.getCombinedBalance()), ah2.getCombinedBalance());

		MeritBank.addAccountHolder(ah2);
		
		MeritBank.clearCDOfferings();
		
		AccountHolder ah3 = new AccountHolder ("Sponge", "Bob", "Squarepants", "574 66 8974");
		
		ah3.addCDAccount(MeritBank.getSecondBestCDOffering(ah3.getCombinedBalance()), ah3.getCombinedBalance());

		ah3.addCheckingAccount(1000);
		
		ah3.addSavingsAccount(10000);

		MeritBank.addAccountHolder(ah3);
			
		System.out.println(MeritBank.totalBalances());

	
	}
}