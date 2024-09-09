package org.recipemlker.dockercomposejava;


import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class MathController {

    @PostMapping("/calculate")
    public Map<String, Double> calculate(@RequestBody Map<String, Object> payload) {

        double sum = 0;
        double product = 1;

        for (String key : payload.keySet()) {
            sum += Double.parseDouble(payload.get(key).toString());
            product *= Double.parseDouble(payload.get(key).toString());
        }
        return Map.of(
                "sum", sum,
                "product", product
        );
    }
}