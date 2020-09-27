package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ITransformListToMap {
	
	/**
	 * @param symptoms list from source file 
	 * @return each symptoms in a map
	 */
	Map<String, Integer> listToMap(List<String> sympList);
}
