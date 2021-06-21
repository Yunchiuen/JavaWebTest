package com.web.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class RegisterService {
    Map<Integer,String> map =new LinkedHashMap<>();
    {
        map.put(1, "上午");
        map.put(2, "下午");
        map.put(3, "晚上");
    }
    public List<String> getTimeNamesById(List<Integer> times){
        
        return times.stream().map(t -> map.get(t)).collect(toList());
    }
}
