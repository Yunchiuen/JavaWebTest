package com.web.service;

import java.util.HashMap;
import java.util.Map;

public class CalcAreaService {

    private static Map<Integer, String> types = new HashMap<>();

    static {
        types.put(1, "圓面積");
        types.put(2, "球體積");
    }

    public String getNameByType(int type) {
        return types.get(type);
    }

    public double getResult(int type, int r) {
        double area = 0;
        switch (type) {
            case 1://圓面積
                area = Math.pow(r, 2) * Math.PI;
                break;
            case 2://球體積
                area = Math.pow(r, 3) * Math.PI * 4 / 3;
                break;
            default:
                area = -1;
        }
        return area;
    }
}
