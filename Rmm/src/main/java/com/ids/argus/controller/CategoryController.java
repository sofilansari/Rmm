package com.ids.argus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ids.argus.dto.CategoryDto;
import com.ids.argus.services.CategoryServices;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	private final CategoryServices categoryServices;

	public CategoryController(CategoryServices categoryServices) {
		super();
		this.categoryServices = categoryServices;
	}
	
	@GetMapping()
	public List<CategoryDto>getAllCategory(){
		return categoryServices.getAllCategory();
		
	}
	
	@GetMapping("/{id}")
	public CategoryDto findById(@PathVariable Long id) {
		return categoryServices.findById(id);
		
	}
	
	@PostMapping("/")
	public CategoryDto create(@RequestBody CategoryDto categoryDto) {
		return categoryServices.create(categoryDto);
		
	}
	
	@PutMapping("/{id}")
	public CategoryDto update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
		return categoryServices.update(id,categoryDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		
		categoryServices.delete(id);
	}

}
