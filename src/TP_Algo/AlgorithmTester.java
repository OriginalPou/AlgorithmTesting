package TP_Algo;

import NES.NES_DataGenerator;
import NES.NES_Algorithms;

import SACDOS.SACDOS_Algorithms;
import SACDOS.SACDOS_DataGenerator;

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
		
		/*Method sumR_M_Envolope = NES_Algorithms.class.getMethod("sumR_M_Envolope", Object[].class);
		
		Object[] res =testAlgorithm(NES_DataGenerator.class, 0, sumR_M_Envolope);
		
		print(res, "BOOM/"+ res[0]+ ".csv");*/
		
		//test sacados
		
		Method ProfitMax_Rec_Envolope = SACDOS_Algorithms.class.getMethod("ProfitMax_Rec_Envolope", Object[].class);
		
		Object[] res2=testAlgorithm(SACDOS_DataGenerator.class,4, ProfitMax_Rec_Envolope); //4 is N
		
		print(res2, "BOOM_SACDOS/"+ res2[0]+".csv");
		
		
	}
	
	public static  Object[] testAlgorithm (Class DataGenerator,int complexity, Method algorithm) throws Exception, IllegalArgumentException, InvocationTargetException {
		
		Constructor constructor = DataGenerator.getConstructor(int.class);
		DataGenerator data =(DataGenerator) constructor.newInstance(complexity);;
		Object[] data_generated = data.generateData();
		
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
