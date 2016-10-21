package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zach on 10/21/16.
 */
@Controller
public class HurricaneTrackerController {
    @Autowired
    HurricaneRepository hurricanes;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        Iterable<Hurricane> hlist = hurricanes.findAll();
        model.addAttribute("hurricanes", hlist);
        return "home";
    }

    @RequestMapping(path = "/hurricane", method = RequestMethod.POST)
    public String addHurricane(String hname, String hlocation, Hurricane.Category hcategory, String himage) {
        Hurricane h = new Hurricane(hname, hlocation, hcategory, himage);
        hurricanes.save(h);
        return "redirect:/";
    }
}