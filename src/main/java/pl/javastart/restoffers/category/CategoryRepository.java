package pl.javastart.restoffers.category;

import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {
    Category findByTitleIgnoreCase(String title);
}
