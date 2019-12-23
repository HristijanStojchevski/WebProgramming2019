package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;


@RestController
//@CrossOrigin(origins = "http://localhost:3000") here is React
@RequestMapping(path = "/api/ingredients",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class IngredientsApi {
    private final IngredientService ingredientService;

    public IngredientsApi(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public Page<Ingredient> getAllIngredients(@RequestHeader(name = "page",defaultValue = "0",required = false) int page,
                                              @RequestHeader(name="size",defaultValue = "5",required = false) int size){
        return  ingredientService.getAllIngredients(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestHeader("name") String name,
                                       @RequestHeader("spicy") boolean spicy,
                                       @RequestHeader("ammount") float ammount,
                                       @RequestHeader("veggie") boolean veggie,
                                       HttpServletResponse response,
                                       UriComponentsBuilder builder){
        Ingredient result = this.ingredientService.createIngredient(name,spicy,ammount,veggie);
        response.setHeader("Location",builder.path("/api/ingredients/{id}").buildAndExpand(result.getName()).toUriString());
        return result;
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable String id){
        return this.ingredientService.getIngredient(id);
    }
}
