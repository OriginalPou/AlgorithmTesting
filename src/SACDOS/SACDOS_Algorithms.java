package SACDOS;

public class SACDOS_Algorithms {
	private static int nbop=0;
	
	//Dynamique
	public static int ProfitMax_Dyn(int i, int C, int[]W, int[]P) {	
		int[][] D= new int[i+1][C+1];	//tableau de dimension N et C
	
		for(int k = 0; k <= i; k++) {
			for (int j = 0; j <= C; j++) {
				if (k == 0 || j == 0) {
					D[k][j] = 0;
					nbop++;
				}
				else {
					if (W[k-1]>j) {
						D[k][j] = D[k-1][j];
						nbop++;
					}
					else {
						D[k][j] = Math.max(D[k-1][j],D[k-1][j- W[k-1]]+ P[k-1]);
						nbop++;
					}
				}
			}
		}
		return D[i][C];
	}
	
	
	//Recursive
		public static int ProfitMax_Rec(int i, int C, int[]W,int[]P) {
			nbop++;
			if (i < 0) {
				return 0;
			}
			if (W[i] > C) {
				return ProfitMax_Rec(i-1, C, W, P);
			} 
			else {
				return Math.max(ProfitMax_Rec(i-1, C,W,P), ProfitMax_Rec(i-1, C - W[i],W,P) + P[i]);
			}
		}	

	
	//Dynamique Envelope
		public static Object[] ProfitMax_Dyn_Envolope(Object[] data) throws Exception{
			if (data.length!=4) {
				throw new Exception("Wrong Input ");
			}
			nbop=0;
			
			// Affectation data
			int i = (int) data[0];  // item = N longeur du tableau
			int C = (int) data[1];  // capacité
			int[] W = (int[]) data[2]; //weights: les poids
			int[] P = (int[]) data[3]; //profits
			
			//resultat comprenant le N: espace d'etat, nombre des items et longeur des tableaux; nbop: nbr excutions; time: temps d'excution;
			Object[] res = new Object[3];
			
			res[0]=i;
			
			long t0 = System.currentTimeMillis();
			ProfitMax_Dyn(i, C, W, P);
			long time=System.currentTimeMillis()-t0;
			
			res[1]=nbop;
			res[2]=(int) time;
			
			return (res);
			
		}
		
	//Recurive Envelope
		public static Object[] ProfitMax_Rec_Envolope(Object[] data) throws Exception{
			if (data.length!=4) {
				throw new Exception("Wrong Input ");
			}
			nbop=0;
			
			// Affectation data
			int i = (int) data[0];  // item = N longeur du tableau
			int C = (int) data[1];  // capacité
			int[] W = (int[]) data[2]; //weights: les poids
			int[] P = (int[]) data[3]; //profits
			
			
			//resultat comprenant le N: espace d'etat, nombre des items et longeur des tableaux; nbop: nbr excutions; time: temps d'excution;
			Object[] res = new Object[3];
			
			res[0]=i;
			
			long t0 = System.currentTimeMillis();
			ProfitMax_Rec(i-1, C, W, P);
			long time=System.currentTimeMillis()-t0;
			
			res[1]=nbop;
			res[2]=(int) time;
			
			return (res);
			
		}

}
