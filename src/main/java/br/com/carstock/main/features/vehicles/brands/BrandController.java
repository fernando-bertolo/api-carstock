package br.com.carstock.main.features.vehicles.brands;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    @GetMapping
    public String brands() {
        return "Carstock";
    }
}
