package SACDOS;

import TP_Algo.DataGenerator;

public class SACDOS_DataGenerator extends DataGenerator {

	private int i_Generated;	//nbr des items et longeur des tableaux
	private int C_Generated;	//capacité
	private int[] W_Generated;	//weights
	private int[] P_Generated;	//profits
	
	
	public SACDOS_DataGenerator(int i) {		
		this.i_Generated=i;		//i est la longeur des tablaux et le nbr des items
		this.generateC(); //generate capacity
		this.generateW(); //generate weights
		this.generateP(); //generate profits
	}
	
	protected void generateC() {
		this.C_Generated=(int) (Math.random() * (500 + 1)) ; // (max-min+1) + min ; 500
	}
	
	protected void generateW() {
		this.W_Generated = new int [i_Generated]; //i= N longeur du tab
		for (int k=0; k< i_Generated; k++) {
			this.W_Generated[k]= (int)(Math.random()*(600+1));
		}
	}
	
	protected void generateP() {
		this.P_Generated = new int [i_Generated];
		for (int k=0; k< i_Generated; k++) {
			this.P_Generated[k]= (int)(Math.random()*(100+1));
		}
	}
	
	protected int getC_Generated() {
		return C_Generated;
	}
	
	protected int[] getW_Generated() {
		return W_Generated;
	}
	
	protected int[] getP_Generated() {
		return P_Generated;
	}
	
	//generateData returns an Object "data" contains the random generated data
	public Object[] generateData() {
		Object[] data = new Object[4];
		data[0]=this.i_Generated;
		data[1]=this.getC_Generated();
		data[2]=this.getW_Generated();
		data[3]=this.getP_Generated();
		return data;	
	}

}
