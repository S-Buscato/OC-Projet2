package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Open and read symptoms.txt file. Each line will be added in a List. Then, each
 * item will be counted and sorted by alphabetical order. In the last step, every
 * symptoms will be writed in an ouput file named result.out.
 *
 */
public class AnalyticsCounter {

	/**
	 * read the source file, this add each symptoms in a list then this list will be
	 * transformed on map. The last step call the saving data
	 * 
	 * @param symptoms
	 */
	public void process() {

		// read source file
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile("symptoms.txt");

		// transform list to Map
		Map<String, Integer> symptoms = read.listToMap(read.getSymptoms());

		// create the result file from map
		this.saveData(symptoms);
	}

	/**
	 * Save data with fileWriter. Then each item will be added in an output file.
	 * 
	 * @param symptoms
	 */
	public void saveData(Map<String, Integer> symptoms) {
		try {
			FileWriter writer = new FileWriter("result.out");

			for (Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
			}

			writer.close();

		} catch (Exception e) {
			System.out.println("exception : " + e);
		}
	}

	public static void main(String args[]) {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.process();
	}

}