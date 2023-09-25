package pl.javastart.restoffers.offer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/count")
    int countOffers() {
        return offerService.countOffers();
    }

    @GetMapping("")
    List<OfferDto> showAllOrByTitle(@RequestParam(required = false) String title) {
        if (title == null) {
            return offerService.offerList();
        } else {
            return offerService.findAllByTitle(title);
        }
    }

    @GetMapping("{id}")
    ResponseEntity<OfferDto> showOneOffer(@PathVariable Long id) {
        return offerService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    OfferDto saveOffer(@RequestBody OfferDto offerDto) {
        return offerService.saveOffer(offerDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<OfferDto> deleteOffer(@PathVariable Long id) {
        Optional<Offer> optionalOffer = offerService.deleteOffer(id);
        if (optionalOffer.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
}