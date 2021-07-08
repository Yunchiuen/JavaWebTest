package com.web.job;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
    //html無法取得這邊的資料只能借由jsp
    public Set<Integer> get539() {
        Set<Integer> nums = new LinkedHashSet<>();
        while (nums.size() < 5) {
            nums.add(new Random().nextInt(39) + 1);
        }
        return nums;
    }
}
