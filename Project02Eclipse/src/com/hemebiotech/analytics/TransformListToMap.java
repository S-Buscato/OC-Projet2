package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * transform list to map count the frequency of each symptoms and save it in the
 * map
 *
 */

public class TransformListToMap implements ITransformListToMap {


	@Override
	public Map<String, Integer> listToMap(List<String> sympList) {
		Map<String, Integer> nbSymptoms = new HashMap<String, Integer>();

		String n = null;
		int count = 0;

		for (String name : sympList) {
			n = name;
			count = Collections.frequency(sympList, name);
			nbSymptoms.put(n, count);
		}
		return nbSymptoms;
	}

}
