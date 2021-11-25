package NES;


public class NES_Algorithms {
	

	public static int sumR_M(int number, int[] coins, int[] D) {
			
			if (number<0) {
				
				return(0);
				
			}else if (D[number]!=-1) {
				
				return(D[number]);
				
			}else {
				
				int res=0;
				for (int i=0;i<coins.length;i++) {
					res+=sumR_M(number-coins[i],coins,D);
				}
				D[number]=res;
				return(res);
				
			}
		}
	
	public static int sumR(int number,int[] coins) {
			
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
	
	public static int sumR_M_Envolope(Object[] data) throws Exception {
		if (data.length!=3) {
			throw new Exception("Wrong Input");
		}
		
		int number = (int) data[0];
		int[] coins= (int[]) data[1];
		int[] D = (int[]) data[2];

		
		return(sumR_M(number,coins,D));
	}
	
	public static int sumR_Envolope(Object[] data) throws Exception {
		if (data.length!=2) {
			throw new Exception("Wrong Input");
		}
		
		int number = (int) data[0];
		int[] coins= (int[]) data[1];

		
		return(sumR(number,coins));
	}
}
