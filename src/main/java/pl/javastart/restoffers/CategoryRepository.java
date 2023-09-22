package pl.javastart.restoffers;

import org.springframework.data.repository.ListCrudRepository;

interface CategoryRepository extends ListCrudRepository<Category, Long> {
    Category findByTitleIgnoreCase(String title);
}
