package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.ids.argus.dto.CategoryDto;
import com.ids.argus.model.Category;
import com.ids.argus.repo.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServicesImpl implements CategoryServices{
	
	private final CategoryRepository categoryRepository;

	public CategoryServicesImpl(CategoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category>categoryOfList=categoryRepository.findAll();
		return categoryOfList.stream().map(category -> new CategoryDto().toDo(category)).
				collect(Collectors.toList());
	}

	@Override
	public CategoryDto findById(Long id) {
		Category category=categoryRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Category not found with id "+id));
		return new CategoryDto().toDo(category);
	}

	@Override
	public CategoryDto create(CategoryDto categoryDto) {
		Category saveCategory=new Category();
		saveCategory.setName(categoryDto.getName());
		saveCategory.setType(categoryDto.getType());
		saveCategory.setStats(categoryDto.getStats());
		saveCategory.setDeleted(categoryDto.isDeleted());
		
		Category savedCategory=categoryRepository.save(saveCategory);
		
		return new CategoryDto().toDo(savedCategory);
	}

	@Override
	public CategoryDto update(Long id, CategoryDto categoryDto) {
		Category existingCategory=categoryRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Category not found with id"+ id));
		existingCategory.setName(categoryDto.getName());
		existingCategory.setStats(categoryDto.getStats());
		existingCategory.setStats(categoryDto.getStats());
		existingCategory.setDeleted(categoryDto.isDeleted());
		
		Category savedCategory=categoryRepository.save(existingCategory);
		return new CategoryDto().toDo(savedCategory);
	}

	@Override
	public void delete(Long id) {
		Category deleteCategory=categoryRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Category not found with id"+ id));
		categoryRepository.delete(deleteCategory);
	}
	

}
