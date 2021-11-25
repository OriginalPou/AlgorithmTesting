package NES;

import java.util.ArrayList;
import java.util.Random;
import TP_Algo.DataGenerator;

public class NES_DataGenerator extends DataGenerator {
	
	private int complexity;
	private int numberGenerated;
	private int[] coinsGenerated;
	private int[] memorisedCases;
	
	
	public NES_DataGenerator(int N) {
		this.complexity=N;
		this.generateNumber();
		this.generateCoins();
		this.generateTrivial();
	}
	
	private void generateNumber() {
		Random rand = new Random();
		this.numberGenerated=5;
		if (this.complexity==0) {
			this.numberGenerated+=rand.nextInt(10);
		}else {
			this.numberGenerated+=100*(this.complexity-1)+rand.nextInt(100);
		}
	}
	
	private void generateCoins() {
		Random rand = new Random();
		
		ArrayList<Integer> coins= new ArrayList<Integer>();
		
		int numberOfCoins;
		
		numberOfCoins=2+this.complexity;
		//int numberOfCoins=3+this.complexity;
		coins.add(1);
		for (int i=0; i<numberOfCoins;i++) {
			int coin = rand.nextInt(this.numberGenerated);
			if ((coin != 0)&&(!coins.contains(coin))) {
				coins.add(coin);
			}else {
				i--;
			}
		}
		coins.sort(null);
		
		this.coinsGenerated= new int[coins.size()];
		for (int i=0; i < this.coinsGenerated.length; i++)
	    {
	        this.coinsGenerated[i] = coins.get(i).intValue();
	    }
	}
	
	private void generateTrivial() {
		this.memorisedCases= new int[this.numberGenerated+1];
		this.memorisedCases[0]=1;
		for (int i=1; i<this.memorisedCases.length;i++) {
			this.memorisedCases[i]=-1;
		}
	}

	public int getNumberGenerated() {
		return numberGenerated;
	}

	public int[] getCoinsGenerated() {
		return coinsGenerated;
	}

	public int[] getMemorisedCases() {
		return memorisedCases;
	}

	@Override
	public Object[] generateData() {
		// TODO Auto-generated method stub
		Object [] data = new Object[3];
		data[0]=this.getNumberGenerated();
		data[1]=this.getCoinsGenerated();
		data[2]=this.getMemorisedCases();
		return data;
	}	
}
