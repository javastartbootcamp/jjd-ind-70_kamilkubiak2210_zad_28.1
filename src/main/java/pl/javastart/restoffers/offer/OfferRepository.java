package pl.javastart.restoffers.offer;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OfferRepository extends ListCrudRepository<Offer, Long> {
    List<Offer> findAllByTitleContainingIgnoreCase(String title);
}
