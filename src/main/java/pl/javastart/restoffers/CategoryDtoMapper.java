package pl.javastart.restoffers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryDtoMapper {
    CategoryDto map(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setName(category.getTitle());
        dto.setDescription(category.getDescription());
        dto.setOffers(category.getOffers().size());
        return dto;
    }

    Category map(CategoryDto dto) {
        Category category = new Category();
        category.setTitle(dto.getName());
        category.setDescription(dto.getDescription());
        category.setOffers(new ArrayList<>());
        return category;
    }
}
