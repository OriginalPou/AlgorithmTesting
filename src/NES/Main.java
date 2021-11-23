package NES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	
	private static int nbop = 0;
	
	public static void main(String[] args) throws FileNotFoundException  {

		for (int i = 0; i <5 ; i ++) {
			DataGenerator data = new DataGenerator(2);
			
			int[] res= new int[2]; 
			res= mesure_tempsSansMemo(data);
			print(res, "TempsSansMemo/"+ res[0]+ ".csv");
			res[1]=nbop;
			nbop=0;
			print(res,"nbopSansMemo/"+res[0]+".csv");
			
			res= mesure_tempsAvecMemo(data);
			print(res, "TempsAvecMemo/"+ res[0]+ ".csv");
			res[1]=nbop;
			nbop=0;
			print(res,"nbopAvecMemo/"+res[0]+".csv");
		}
		
		
		
		
		
		/*System.out.println(number);
		
		for (int i=0; i<coins.length;i++) {
			System.out.println(coins[i]);
		}*/
		
		/*int number=6;
		int [] coins={1,3,4};
		int [] D={1,-1,-1,-1,-1,-1,-1};*/
		/*
		System.out.println("resultat = " + mesure_tempsAvecMemo(data)[1]+" ,temps ="+ mesure_tempsAvecMemo(data)[0]);
		System.out.println("resultat = " + mesure_tempsSansMemo(data)[1]+" ,temps ="+ mesure_tempsSansMemo(data)[0]);
		*/
		
		/*for (int i=0; i<D.length;i++) {
			System.out.println(i+" = "+D[i]);
		}*/
		
		//System.out.println("nbop = "+ nbop);
		
		
		/*
		DataGenerator N = new DataGenerator(1);
		System.out.println(N.getNumberGenerated());
		System.out.println(N.getCoinsGenerated());
		int[] Di=N.getMemorisedCases();
		for (int i=0; i<Di.length;i++) {
			System.out.print(Di[i]);
		}
		System.out.println("");
		
		int number=5;
		int[] x = {1,3,4};
		int[] D = new int[number+1];
		
		D[0]=1;
		for (int i=1; i<=number;i++) {
			D[i]=-1;
		}
		System.out.println(sumR_M(number,D,x));
		for (int i=0; i<D.length;i++) {
			System.out.print(D[i]);
		}*/
	
	}
	
	public static int sumR_M(int number, int[] D,int[] coins) {
		
		nbop++;
		
		if (number<0) {
			
			return(0);
			
		}else if (D[number]!=-1) {
			
			return(D[number]);
			
		}else {
			
			int res=0;
			for (int i=0;i<coins.length;i++) {
				res+=sumR_M(number-coins[i],D,coins);
			}
			D[number]=res;
			return(res);
			
		}
	}
	
public static int sumR(int number,int[] coins) {
		
		nbop++;
		
		if (number<0) {	
			return(0);	
		}
		else if (number==0) {
			return(1);
		}
		else {
			int res=0;
			for (int i=0;i<coins.length;i++) {
				res+=sumR(number-coins[i],coins);
			}
			return(res);	
		}
	}
	
	private static int[] mesure_tempsAvecMemo(DataGenerator data) {
			
		
		int number = data.getNumberGenerated();
		int[] coins= data.getCoinsGenerated() ;
		int[] D = data.getMemorisedCases();
		
		long t0 = System.currentTimeMillis();
		
		sumR_M(number,D,coins);

		long time= System.currentTimeMillis() - t0;
		
		int [] res = {number,(int)time};
		
		return res;
	}
	
	private static int[] mesure_tempsSansMemo(DataGenerator data) {
		
		
		int number = data.getNumberGenerated();
		int[] coins= data.getCoinsGenerated() ;
		
		long t0 = System.currentTimeMillis();
		
		sumR(number,coins);

		long time= System.currentTimeMillis() - t0;
		
		int [] res = {number,(int)time};
		
		return res;
	}
	
	private static void print(int[]res,String filename) throws FileNotFoundException {
		File csvFile = new File(filename);
		PrintWriter out = new PrintWriter(csvFile);
		out.print(res[0]);
		out.print(",");
		out.println(res[1]);
		out.close();
	}
	

}
