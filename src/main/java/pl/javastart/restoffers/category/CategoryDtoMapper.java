package pl.javastart.restoffers.category;

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

    void fillFields(Category entity, CategoryDto dto) {
        entity.setTitle(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setOffers(new ArrayList<>());
    }
}
