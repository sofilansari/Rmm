package com.ids.argus.services;

import java.util.List;
import com.ids.argus.dto.CategoryDto;

public interface CategoryServices {

	public List<CategoryDto> getAllCategory();

	public CategoryDto findById(Long id);

	public CategoryDto create(CategoryDto categoryDto);

	public CategoryDto update(Long id, CategoryDto categoryDto);

	public void delete(Long id);


}
