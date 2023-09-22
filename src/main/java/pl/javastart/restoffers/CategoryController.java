package pl.javastart.restoffers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<List<String>> allCategoriesNames() {
        return ResponseEntity.ok(categoryService.findAll().stream().map(CategoryDto::getName).toList());
    }

    @GetMapping()
    ResponseEntity<List<CategoryDto>> allCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping()
    ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
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