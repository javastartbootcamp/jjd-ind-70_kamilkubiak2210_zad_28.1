package pl.javastart.restoffers.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.offer.OfferDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/names")
    List<String> allCategoriesNames() {
        return categoryService.findAll().stream().map(CategoryDto::getName).toList();
    }

    @GetMapping("")
    List<CategoryDto> allCategories() {
        return categoryService.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<OfferDto> deleteCategory(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryService.deleteCategory(id);
        if (optionalCategory.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
}