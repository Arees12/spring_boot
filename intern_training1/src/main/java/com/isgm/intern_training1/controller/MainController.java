package com.isgm.intern_training1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import com.isgm.intern_training1.entities.City;
import com.isgm.intern_training1.entities.User;
import com.isgm.intern_training1.repositories.CityRepository;
import com.isgm.intern_training1.repositories.UserRepository;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CityRepository cityRepo;
	
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","Thiha Oo");
		model.addAttribute("yine","Hello bitch!");
		return "hello";	//view's name
	}
	
	@GetMapping("/city")
	public String cityList(Model model) {
		model.addAttribute("cityList",cityRepo.findAll());
		return "cityList";
	}
	
	@GetMapping("/user")
	public String userList(Model model) {
		model.addAttribute("userList",userRepo.findAll());
		return "userList";
	}
	
	@GetMapping("/city/{cityId}")
	public String getCity(Model model ,@PathVariable int cityId) {
		model.addAttribute("city",cityRepo.findById(cityId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
		return "city";
	}
	
	@GetMapping("/user/{userId}")
	public String getUser(Model model ,@PathVariable int userId) {
		model.addAttribute("cityList",cityRepo.findAll());
		model.addAttribute("user",userRepo.findById(userId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));//java lumbda function
		return "user";
	}
	
	@GetMapping("/user/add")
	public String addUser(Model model) {
		model.addAttribute("cityList",cityRepo.findAll());
		model.addAttribute("user",new User());
		
		return "user";
	}
	
	@GetMapping("/city/add")
	public String addCity(Model model) {
		model.addAttribute("city",new City());
		return "city";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(User user) {
		userRepo.save(user);
		return "redirect:/user";
	}
	
	@PostMapping("/saveCity")
	public String saveCity(City city) {
		cityRepo.save(city);
		return "redirect:/city";
	}
	
	@GetMapping("/user/delete/{userId}")
	public String deleteUser(Model model, @PathVariable int userId) {
		userRepo.deleteById(userId);
		model.addAttribute("userList",userRepo.findAll());
		return "redirect:/user";
	}
	
	@GetMapping("/city/delete/{cityId}")
	public String deleteCity(Model model, @PathVariable int cityId) {
		cityRepo.deleteById(cityId);
		model.addAttribute("cityList",cityRepo.findAll());
		return "redirect:/city";
	}
	
	@GetMapping("/user/deleteall")
	public String deleeteAll(Model model) {
		userRepo.deleteAll();
		return "redirect:/user";
	}
}
