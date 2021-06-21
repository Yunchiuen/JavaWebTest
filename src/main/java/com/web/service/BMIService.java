package com.web.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BMIService {

    public double getResult(double height, double weight) {
        double result = weight / Math.pow(height / 100, 2);
        return result;
    }

    public List<Map> getBMIResults(String[] heights, String[] weights) {
        List<Map> list = new ArrayList();

        for (int i = 0; i < heights.length; i++) {
            if (heights[i].equals("") || heights[i] == null || weights[i].equals("") || weights[i] == null) {
                heights[i] = "0.0";
                weights[i] = "0.0";
            }
            double height = Double.parseDouble(heights[i]);
            double weight = Double.parseDouble(weights[i]);
            double result = getResult(height, weight);
            Map map = new LinkedHashMap();
            map.put("height", height);
            map.put("weight", weight);
            map.put("result", String.format("%.1f", result));

            list.add(map);
        }
        return list;
    }
}
