package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoMapper categoryDtoMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoMapper categoryDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoMapper = categoryDtoMapper;
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(categoryDtoMapper::map).toList();
    }

    CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        categoryDtoMapper.fillFields(category, categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryDtoMapper.map(savedCategory);
    }

    Optional<Category> deleteCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            categoryRepository.delete(optionalCategory.get());
        } else {
            return Optional.empty();
        }
        return optionalCategory;
    }
}