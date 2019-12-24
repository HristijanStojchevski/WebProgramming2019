package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidPizzaException;
import mk.finki.ukim.mk.lab.model.exceptions.NotVeggieIngredientFoundException;
import mk.finki.ukim.mk.lab.service.IngredientService;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "http://localhost:3000") here is React
@RequestMapping(path = "/api/pizzas",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class PizzasApi {
    private final PizzaService pizzaService;
    private final IngredientService ingredientService;

    public PizzasApi(PizzaService pizzaService, IngredientService ingredientService) {
        this.pizzaService = pizzaService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Pizza> getAll(@RequestParam(name="totalIngredients",required = false,defaultValue = "100") int totalIngredients){
        return this.pizzaService.listPizzas(totalIngredients);
    }

    @GetMapping("/{id}")
    public Pizza getById(@PathVariable String id){ return this.pizzaService.getPizza(id);  }

    @PostMapping
    public Pizza create(@RequestHeader("name") String name,
                        @RequestParam("description") String desc,
                        @RequestParam("ingredients") String ingredients,
                        @RequestParam(name ="veggie",defaultValue = "false",required = false) boolean veggie,
                        HttpServletResponse response,
                        UriComponentsBuilder builder){
        if(this.pizzaService.existsById(name)) return this.pizzaService.getPizza(name);
        boolean isVeggie = veggie;
        String[] splitIngredients = ingredients.split(",");
        List<Ingredient> ingredientList = null;
        Arrays.stream(splitIngredients).forEach(i -> {
            if(this.ingredientService.existsById(i)) {
                Ingredient moment = this.ingredientService.getIngredient(i);
                ingredientList.add(moment);
            }
        });
        if(isVeggie){
            for(int i=0;i<ingredientList.size();i++){
                if(!ingredientList.get(i).isVeggie()){
                    isVeggie = false;
                    //throw new NotVeggieIngredientFoundException(); posledni dve baranja se ne razbirlivi
                }
            }
        }
        Pizza result = this.pizzaService.createPizza(name,desc,ingredientList,isVeggie);
        response.setHeader("Location",builder.path("/api/pizzas/{id}").buildAndExpand(result.getName()).toUriString());
        return result;
    }

    @PutMapping("/{id}")
    public Pizza edit(@PathVariable String id,
                      @RequestParam("description") String desc,
                      @RequestParam("ingredients") String ingredients,
                      @RequestParam("veggie") boolean veggie) {
        if (!this.pizzaService.existsById(id)) {
            throw new InvalidPizzaException();
        }
        boolean isVeggie = veggie;
        String[] splitIngredients = ingredients.split(",");
        List<Ingredient> ingredientList = null;
        Arrays.stream(splitIngredients).forEach(i -> {
            if (this.ingredientService.existsById(i)) {
                Ingredient moment = this.ingredientService.getIngredient(i);
                ingredientList.add(moment);
            }
        });
        if (isVeggie) {
            for (int i = 0; i < ingredientList.size(); i++) {
                if (!ingredientList.get(i).isVeggie()) {
                    isVeggie = false;
                    //throw new NotVeggieIngredientFoundException(); posledni dve baranja se ne razbirlivi
                }
            }
        }
        return this.pizzaService.editPizza(id, desc, ingredientList, veggie);
    }
    @DeleteMapping("/{id}")
    public void deletePizza(@RequestHeader String id){ this.pizzaService.deletePizza(id);   }

}
