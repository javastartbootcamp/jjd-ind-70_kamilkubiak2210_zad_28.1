package pl.javastart.restoffers;

import org.springframework.stereotype.Service;

@Service
public class OfferDtoMapper {
    private final CategoryRepository categoryRepository;

    public OfferDtoMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    OfferDto map(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setDescription(offer.getDescription());
        dto.setImgUrl(offer.getImgUrl());
        dto.setPrice(offer.getPrice());
        dto.setCategory(offer.getCategory().getTitle());
        return dto;
    }

    Offer map(OfferDto dto) {
        Offer offer = new Offer();
        offer.setId(dto.getId());
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setImgUrl(dto.getImgUrl());
        offer.setPrice(dto.getPrice());
        Category byTitleIgnoreCase = categoryRepository.findByTitleIgnoreCase(dto.getCategory());
        offer.setCategory(byTitleIgnoreCase);
        return offer;
    }
}
