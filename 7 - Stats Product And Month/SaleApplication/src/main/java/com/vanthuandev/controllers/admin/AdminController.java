package com.vanthuandev.controllers.admin;

import com.vanthuandev.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.ParseException;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StatsService statsService;

    @GetMapping("/category-stats")
    public String cateStats(Model model) {
        List<Object[]> obj = this.statsService.cateStats();
        obj.forEach(o -> {
            System.out.println("Id " + o[0] + " - Name: " + o[1] + " - Counter: " + o[2]);
        });
        model.addAttribute("cateStats", this.statsService.cateStats());
        return "category-stats";
    }

    @GetMapping("/product-stats")
    public String productStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;

        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null)
                fromDate = f.parse(from);


            String to = params.getOrDefault("toDate", null);
            if (to != null)
                toDate = f.parse(to);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }


        model.addAttribute("productStats", this.statsService.productStats(kw, fromDate, toDate));

        return "product-stats";
    }

    @GetMapping("/product-month-stats")
    public String productMonthStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;

        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null)
                fromDate = f.parse(from);


            String to = params.getOrDefault("toDate", null);
            if (to != null)
                toDate = f.parse(to);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        model.addAttribute("productMonthStats", this.statsService.productMonthStats(kw, fromDate, toDate));

        return "product-month-stats";
    }

}
