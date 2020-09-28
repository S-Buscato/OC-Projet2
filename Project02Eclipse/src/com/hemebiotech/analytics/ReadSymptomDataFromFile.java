package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * transform a list to map. This map is sorted
	 * @param sympList
	 *
	 */
	public Map<String, Integer> listToMap(List<String> sympList) {
		TreeMap<String, Integer> nbSymptoms = new TreeMap<String, Integer>();

		for (String name : sympList) {
			nbSymptoms.putIfAbsent(name, 0);
			nbSymptoms.put(name, nbSymptoms.get(name)+1);
		}
		
		nbSymptoms.subMap("a","b");
		return nbSymptoms;
	}

}
