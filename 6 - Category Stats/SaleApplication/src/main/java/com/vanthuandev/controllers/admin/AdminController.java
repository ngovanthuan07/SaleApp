package com.vanthuandev.controllers.admin;

import com.vanthuandev.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StatsService statsService;

    @GetMapping("/category-stats")
    public String cateStats(Model model) {
        List<Object[]> obj = this.statsService.cateStats();
        obj.forEach(o ->  { System.out.println("Id " + o[0] + " - Name: " + o[1] + " - Counter: " + o[2]); });
        model.addAttribute("cateStats", this.statsService.cateStats());
        return "category-stats";
    }
}
