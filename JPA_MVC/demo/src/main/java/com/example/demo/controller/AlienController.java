package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.example.demo.model.Alien;
import com.example.demo.dao.AlienRepo;
@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;
    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home.jsp";
    }
    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid)
    {
        ModelAndView mv  = new ModelAndView("showAlien.jsp");
        Alien a = repo.findById(aid).orElse(new Alien());
        mv.addObject(a);
        return mv;
    }

    @RequestMapping("/getAllinListFormat")
    @ResponseBody
    public String getAllAlien()
    {
        return repo.findAll().toString();
    }
    @RequestMapping("/getAllinJSON")
    @ResponseBody
    public List<Alien> getAllAlieninJSON()
    {
        return repo.findAll();
    }

}
