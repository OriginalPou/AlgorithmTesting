package NES;


public class NES_Algorithms {
	
	private static int nbop = 0;
	

	public static int sumR_M(int number, int[] coins, int[] D) {
			
			nbop++;
		
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
	
	public static Object[] sumR_M_Envolope(Object[] data) throws Exception {
		
		if (data.length!=3) {
			throw new Exception("Wrong Input");
		}
		
		nbop=0;
		
		int number = (int) data[0];
		int[] coins= (int[]) data[1];
		int[] D = (int[]) data[2];
		
		Object[] res = new Object [3];
		
		res[0]=number;
		
		long t0 = System.currentTimeMillis();
		sumR_M(number,coins,D);
		long time= System.currentTimeMillis() - t0;
		
		res[1]=nbop;
		res[2]=(int)time;
		
		return (res);
		
		
	}
	
	
	
	public static Object[] sumR_Envolope(Object[] data) throws Exception {
		if (data.length!=2) {
			throw new Exception("Wrong Input");
		}
		
		nbop=0;
		
		int number = (int) data[0];
		int[] coins= (int[]) data[1];
		
		Object[] res = new Object [3];
		
		long t0 = System.currentTimeMillis();
		sumR(number,coins);
		long time= System.currentTimeMillis() - t0;
		
		res[1]=nbop;
		res[2]=(int)time;
		
		return (res);

		
	}
}
