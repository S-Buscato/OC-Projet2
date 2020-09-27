package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Open and read symptoms.txt file. Each line will be add in a List. Then, each item
 * will be count and sort by alphabetical order. In the last step, every symptoms will be write in
 * an ouput file named result.out.
 *
 */
public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		try {
			// read source file 
			ReadSymptomDataFromFile read = new ReadSymptomDataFromFile("symptoms.txt");
			List<String> sympList = read.GetSymptoms();

			// transform list to Map 
			Map<String, Integer> symptoms = new TransformListToMap().listToMap(sympList);
			
			// create the result file from map 
			List<String> lst = new ArrayList<String>();		
			FileWriter writer = new FileWriter("result.out");

			for (Map.Entry<String, Integer> entry : symptoms.entrySet() ) {
				lst.add((entry.getKey() + " : " + entry.getValue()));
			}

			Collections.sort(lst);
			for (String ls : lst) {
				writer.write(ls + "\n");
			}

			writer.close();

		} catch (Exception e) {
			System.out.println("exception : " + e);

		}
	}

}