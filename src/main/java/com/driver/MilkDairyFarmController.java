package com.driver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/milkfarm")
public class MilkDairyFarmController {
    private final MilkDairyFarmService milkDairyFarmService;

    public MilkDairyFarmController(MilkDairyFarmService milkDairyFarmService) {
        this.milkDairyFarmService = milkDairyFarmService;
    }

    @PostMapping("/addcow")
    public Cow addCow(@RequestBody Cow cow) {
        return milkDairyFarmService.addCow(cow);
    }

    @GetMapping("/milkproduction/{cowId}")
    public Cow getMilkProduction(@PathVariable int cowId) {
        return milkDairyFarmService.getMilkProduction(cowId);
    }

    @GetMapping("/totalmilkproduction")
    public double getTotalMilkProduction() {
        return milkDairyFarmService.getTotalMilkProduction();
    }
}