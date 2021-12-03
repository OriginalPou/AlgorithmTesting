package PLSS;


public class Algorithms {
	
	public static int plsscRecursive(String X,String Y,int i, int j) {
		if (i== 0 || j== 0)
			return 0 ;
		if (X.charAt(i-1)==Y.charAt(j-1))
			return 1 + plsscRecursive(X,Y,i-1,j-1);
		
		if (X.charAt(i-1) != Y.charAt(j-1))
			return (Math.max(plsscRecursive(X,Y,i-1,j),plsscRecursive(X,Y,i,j-1)));
		return 0;
		
	}
	
	
	
	public static int plsscDynamique(String X,String Y) {
		int[][] tab=new int[X.length()+1][Y.length()+1];
		for(int i=1;i<=X.length();i++)
			tab[i][0]=0;
		for(int j=1;j<=Y.length();j++)
			tab[0][j]=0;
		
		for(int i=1;i<=X.length();i++) {
			for(int j=1;j<=Y.length();j++) {
				if (X.charAt(i-1)==Y.charAt(j-1))
	                tab[i][j]=tab[i-1][j-1]+1;
	            else
	                tab[i][j]=Math.max(tab[i-1][j],tab[i][j-1]);
			}
			
		}
				
		return tab[X.length()][Y.length()];
	}
	
	

	
	
	public static int plsscMemorization(String X, String Y, int i, int j) {
		float result=0;
		float[][] connu=new float[i+1][j+1];
		for(int k=0;k<=i;k++) 
			for(int l=0;l<=j;l++)
				connu[k][l]=-1;
		
		if (connu[i][j]!=-1)
			return (int)connu[i][j];
		else {
	
			if (i== 0 || j== 0)
				return 0 ;
			
			else if (X.charAt(i-1)==Y.charAt(j-1)) {
				result=1 + plsscMemorization(X,Y,i-1,j-1);
				connu[i][j]=result;
				return (int)result;
			}

			else {
				result= (Math.max(plsscMemorization(X,Y,i-1,j),plsscMemorization(X,Y,i,j-1)));
				connu[i][j]=result;
				return (int)result;
			}
		}
			
	}
	
	
	
	
	public static Object[] plsscMemorization_Env(Object[] data) throws Exception {
		if (data.length != 4) {
			throw new Exception ("Wrong input");
		}
		String X=(String) data[0];
	    String Y=(String) data[1];
	    int i= (int) data[2];
	    int j= (int) data[3];
	    long t0 = System.currentTimeMillis();
	    int plls=plsscMemorization(X,Y,i,j);
	    long time = System.currentTimeMillis()-t0;
	    Object[] res= new Object[3];
	    res[0]=plls;
	    res[1]=i;
	    res[2]=(int)time;
	    return res;
		
	}
	
	public static Object[] plsscDynamique_Env(Object[] data) throws Exception {
		
		if (data.length != 3) {
			throw new Exception ("Wrong input");
		}
		
		String X=(String) data[0];
	    String Y=(String) data[1];
	    int i= (int) data[2];
	    long t0 = System.currentTimeMillis();
	    int plls=plsscDynamique(X,Y);
	    long time = System.currentTimeMillis()-t0;
	    Object[] res= new Object[3];
	    res[0]=plls;
	    res[1]=i;
	    res[2]=(int)time;
	    return res;
		
	}
	
	
public static Object[] plsscRecursive_Env(Object[] data) throws Exception {
		
		if (data.length != 4) {
			throw new Exception ("Wrong input");
		}
		
		String X=(String) data[0];
	    String Y=(String) data[1];
	    int i= (int) data[2];
	    int j= (int) data[3];
	    long t0 = System.currentTimeMillis();
	    int plls=plsscRecursive(X,Y,i,j);
	    long time = System.currentTimeMillis()-t0;
	    
	    Object[] res= new Object[3];
	    res[0]=plls;
	    res[1]=i;
	    res[2]=(int)time;
	    return res;
		
	}
	
	
	
	
	
	
	


}