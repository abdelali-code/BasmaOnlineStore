package ma.youcode.basmastoreapi.controllers;

import ma.youcode.basmastoreapi.entities.PromoCodeEntity;
import ma.youcode.basmastoreapi.services.PromoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/basmastore/api/code-promos")
public class PromoCodeRestController {

    @Autowired
    private PromoCodeService promoCodeService;

    @GetMapping
    public ResponseEntity<List<PromoCodeEntity>> getAllPromoCodes() {
        return ResponseEntity.status(HttpStatus.OK).body(promoCodeService.getAll());
    }

    @GetMapping("{promoCodeId}")
    public ResponseEntity<PromoCodeEntity> getPromoCode(@PathVariable Integer promoCodeId) {
        return ResponseEntity.status(HttpStatus.OK).body(promoCodeService.getById(promoCodeId));
    }

    @PostMapping
    public ResponseEntity<PromoCodeEntity> addPromoCode(@RequestBody @Valid PromoCodeEntity promoCodeEntity) {
        promoCodeEntity.setIdPromoCode(0);
        return ResponseEntity.status(HttpStatus.CREATED).body(promoCodeService.addOrUpdate(promoCodeEntity));
    }

    @PutMapping
    public ResponseEntity<PromoCodeEntity> updatePromoCode(@RequestBody @Valid PromoCodeEntity promoCodeEntity) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(promoCodeService.addOrUpdate(promoCodeEntity));
    }

    @DeleteMapping("{promoCodeId}")
    public ResponseEntity<Object> deletePromoCode(@PathVariable Integer promoCodeId) {
        String result = "";
        if (promoCodeService.deleteById(promoCodeId)) {
            result = "Product order with id " + promoCodeId + " has deleted";
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }
}
