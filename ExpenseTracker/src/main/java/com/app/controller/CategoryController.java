package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Category;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {


	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Category category) {
		categoryService.saveCategory(category);
        return ResponseEntity.ok("Category registered successfully.");
    }
}
