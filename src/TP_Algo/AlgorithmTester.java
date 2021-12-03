package TP_Algo;

import PLSS.Algorithms;
import PLSS.PllsDataGenerator;
import NES.NES_DataGenerator;
import NES.NES_Algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AlgorithmTester {
	

	public static void main(String[] args) throws Exception {
		/*
		System.out.println(sumR_M_Envolope);
		Constructor constructor = NES_DataGenerator.class.getConstructor(int.class);
		System.out.println(constructor);
		*/
		
		Method plsscDynamique_Env= Algorithms.class.getMethod("plsscDynamique_Env", Object[].class);
		
		Object[] res_PLSS = testAlgorithm(PllsDataGenerator.class,5,plsscDynamique_Env);
		
		print(res_PLSS,"BOOM_PLSS/"+res_PLSS[0]+".csv");
		
		
		Method sumR_M_Envolope = NES_Algorithms.class.getMethod("sumR_M_Envolope", Object[].class);
		
		Object[] res =testAlgorithm(NES_DataGenerator.class, 0, sumR_M_Envolope);
		
		print(res, "BOOM/"+ res[0]+ ".csv");
		
		
	}
	
	public static  Object[] testAlgorithm (Class DataGenerator,int complexity, Method algorithm) throws Exception, IllegalArgumentException, InvocationTargetException {
		
		Constructor constructor = DataGenerator.getConstructor(int.class);
		DataGenerator data =(DataGenerator) constructor.newInstance(complexity);;
		Object[] data_generated = data.generateData();
		
		System.out.println(constructor);
		System.out.println(algorithm);
		
		int index=1;
		
		while (true) {
			try {
				Object[] needed_data = Arrays.copyOfRange(data_generated, 0, index);
				return (Object[]) (algorithm.invoke(null, new Object[]{needed_data}));
			}
			catch (Exception e) {
				System.out.println(e.getCause());
				if(index < data_generated.length) {
					index++;
				}else {
					throw new Exception("Algorithm does not match data generator");
				}
					
			}
		}		
	}
	
	private static void print(Object[]res, String filename) throws FileNotFoundException {
		File csvFile = new File(filename);
		PrintWriter out = new PrintWriter(csvFile);
		out.print((int)res[0]);
		out.print(",");
		out.print((int)res[1]);
		out.print(",");
		out.println((int)res[2]);
		out.close();
	}
	
}
