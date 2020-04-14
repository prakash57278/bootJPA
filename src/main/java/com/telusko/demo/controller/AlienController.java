package com.telusko.demo.controller;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.model.Alien;
import com.telusko.demo.repository.Alienrepo;

@Controller
public class AlienController {

    @Autowired
    Alienrepo repo;

    @RequestMapping("/")
    public String home() {

        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        repo.save(alien);
        return "home.jsp";

    }

//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv =new ModelAndView();
//		mv.setViewName("fetch.jsp");                                      //JPA Example
//		Alien alien =repo.findById(aid).orElse(new Alien());
//		
//		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByTechSorted("java"));
//		mv.addObject(alien);
//		return mv;
//
//	}

    @RequestMapping("/aliens")
    @ResponseBody
    public String getAliens() {

        return repo.findAll().toString();
    }


    @RequestMapping("/aliens/{aid}")
    @ResponseBody
    public String getAlien(@PathVariable("aid") int aid) {

        return repo.findById(aid).toString();
    }
}
