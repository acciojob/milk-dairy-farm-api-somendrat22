package com.driver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MilkDairyFarmService {
    private Map<Integer, Cow> cowDatabase;
    private int nextCowId;

    public MilkDairyFarmService() {
        cowDatabase = new HashMap<>();
        nextCowId = 1;
    }

    public Cow addCow(Cow cow) {
        cow.setId(nextCowId++);
        cow.setMilkProduction(0);
        cowDatabase.put(cow.getId(), cow);
        return cow;
    }

    public Cow getMilkProduction(int cowId) {
        return cowDatabase.get(cowId);
    }

    public double getTotalMilkProduction() {
        return cowDatabase.values().stream().mapToDouble(Cow::getMilkProduction).sum();
    }
}