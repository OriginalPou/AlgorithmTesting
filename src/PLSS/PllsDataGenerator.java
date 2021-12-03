package PLSS;
import java.util.Random;
import TP_Algo.DataGenerator;

public class PllsDataGenerator extends DataGenerator {
	
	private int n;

	public PllsDataGenerator(int n) {
		this.n=n;
	}
	
	
	public Object[] generateData() {
		int n = this.n;
		String X;
		String Y;
		int lenY=0;
		String Alphabets;
        StringBuilder builder;
        Random rand = new Random();
        Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                                    

        // Generer la chaine X
        
        builder = new StringBuilder(n); 

        for (int m = 0; m < n; m++) { 

            int myindex= (int)(Alphabets.length()* Math.random());
            builder.append(Alphabets.charAt(myindex)); 
                       
        } 
        X=builder.toString();
        
        // Generer la chaine Y qui derive de X
        lenY=(int)(n*Math.random());
        builder = new StringBuilder(lenY);
        for (int m = 0; m < lenY; m++) { 
            int myindex= (int)(rand.nextInt(n));
            builder.append(X.charAt(myindex)); 
   
        } 
        // Renvoie des deux chaines
        Y=builder.toString();        
        Object [] res = {X,Y,X.length(),Y.length()};
        return res;
    } 
		

}
