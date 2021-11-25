package TP_Algo;

import NES.NES_DataGenerator;
import NES.NES_Algorithms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AlgorithmTester {
	

	public static void main(String[] args) throws Exception {
		
		Method sumR_M_Envolope = NES_Algorithms.class.getMethod("sumR_M_Envolope", Object[].class);
		System.out.println(sumR_M_Envolope);
		Constructor constructor = NES_DataGenerator.class.getConstructor(int.class);
		System.out.println(constructor);
		
		System.out.println(testAlgorithm(NES_DataGenerator.class, 0, sumR_M_Envolope));
		
		
	}
	
	public static  int testAlgorithm (Class DataGenerator,int complexity, Method algorithm) throws Exception, IllegalArgumentException, InvocationTargetException {
		
		Constructor constructor = DataGenerator.getConstructor(int.class);
		DataGenerator data =(DataGenerator) constructor.newInstance(complexity);;
		Object[] data_generated = data.generateData();
		
		System.out.println(data_generated[0]);
		int[] coins = (int[])data_generated[1];
		System.out.println(coins.length);
		for (int i=0; i<coins.length;i++) {
			System.out.println(coins[i]);
		}
		
		int index=1;
		
		while (true) {
			try {
				Object[] needed_data = Arrays.copyOfRange(data_generated, 0, index);
				return (int) (algorithm.invoke(null, new Object[]{needed_data}));
			}
			catch (Exception e) {
				index++;
			}
		}		
	}
	
}
