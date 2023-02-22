package com.zhaowei.genshin.utils;

import java.util.HashMap;
import java.util.Map;

public class LevelMap {
	public static Map<Integer, Integer> levelMap = new HashMap<>();
	static {
		levelMap.put(0, 0);
		levelMap.put(1, 40);
		levelMap.put(2, 50);
		levelMap.put(3, 60);
		levelMap.put(4, 70);
		levelMap.put(5, 80);
		levelMap.put(6, 90);
	}
}
