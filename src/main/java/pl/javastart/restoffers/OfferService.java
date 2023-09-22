package pl.javastart.restoffers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class OfferService {
    private final OfferRepository offerRepository;
    private OfferDtoMapper offerDtoMapper;

    @Autowired
    public OfferService(OfferRepository offerRepository, OfferDtoMapper offerDtoMapper) {
        this.offerRepository = offerRepository;
        this.offerDtoMapper = offerDtoMapper;
    }

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    List<OfferDto> offerList() {
        return offerRepository.findAll().stream().map(offerDtoMapper::map).toList();
    }

    int countOffers() {
        return (int) offerRepository.count();
    }

    List<OfferDto> findAllByTitle(String title) {
        return offerRepository.findAllByTitleContainingIgnoreCase(title).stream().map(offerDtoMapper::map).toList();
    }

    Optional<OfferDto> findById(Long id) {
        return offerRepository.findById(id).map(offerDtoMapper::map);
    }

    OfferDto saveOffer(OfferDto offerDto) {
        Offer savedOffer = offerRepository.save(offerDtoMapper.map(offerDto));
        return offerDtoMapper.map(savedOffer);
    }

    Optional<Offer> deleteOffer(Long id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        if (optionalOffer.isPresent()) {
            offerRepository.delete(optionalOffer.get());
        } else {
            return Optional.empty();
        }
        return optionalOffer;
    }
}