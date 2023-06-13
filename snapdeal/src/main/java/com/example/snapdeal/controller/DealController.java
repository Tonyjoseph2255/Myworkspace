package com.example.snapdeal.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.snapdeal.entity.DealEntity;
import com.example.snapdeal.services.DealServices;
@CrossOrigin(origins = "http://localhost:3006", allowedHeaders={"Accept"})
@RestController
@RequestMapping
public class DealController {
	@Autowired
	public DealServices dealServices;

	@PostMapping("/data")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
			throws IOException, ParseException {
		dealServices.toStore(file);
		return "posted";
	}
	@GetMapping("/orders")
	public List<DealEntity>getAllOrders(){
		return dealServices.getOrders();
		
	}

}
