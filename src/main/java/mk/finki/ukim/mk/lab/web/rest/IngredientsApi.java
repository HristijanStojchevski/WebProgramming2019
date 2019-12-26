package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.IllegalSpicyIngredientException;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidIngredientException;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidPizzaException;
import mk.finki.ukim.mk.lab.model.vm.Page;
import mk.finki.ukim.mk.lab.service.IngredientService;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;


@RestController
//@CrossOrigin(origins = "http://localhost:3000") here is React
@RequestMapping(path = "/api/ingredients",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class IngredientsApi {
    private final IngredientService ingredientService;
    private final PizzaService pizzaService;
    public IngredientsApi(IngredientService ingredientService, PizzaService pizzaService) {
        this.ingredientService = ingredientService;
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public Page<Ingredient> getAllIngredients(@RequestHeader(name = "page",defaultValue = "0",required = false) int page,
                                              @RequestHeader(name="size",defaultValue = "5",required = false) int size,
                                              @RequestParam(name="spicy",defaultValue = "false",required = false) boolean spicy){
        if(spicy) {
            List<Ingredient> spicyIngredients = ingredientService.getAllIngredients(page, size).getContent()
                    .stream().filter(ingredient -> ingredient.isSpicy()).collect(Collectors.toList());
            return new Page<>(page,spicyIngredients.size(),size,spicyIngredients);
        }
        return  ingredientService.getAllIngredients(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestParam("name") String name,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam("amount") float amount,
                                       @RequestParam("veggie") boolean veggie,
                                       HttpServletResponse response,
                                       UriComponentsBuilder builder){

        try {
            if(this.ingredientService.existsById(name))throw new InvalidPizzaException("A pizza with the same name already exists !");
            if (spicy && areThere3Spicy()) throw new IllegalSpicyIngredientException();
            Ingredient result = this.ingredientService.createIngredient(name,spicy,amount,veggie);
            response.setHeader("Location",builder.path("/api/ingredients/{id}").buildAndExpand(result.getName()).toUriString());
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            if(e.getMessage().compareTo("A pizza with the same name already exists !")==0){
                return this.ingredientService.getIngredient(name);
            }
        }
        finally {
            response.setHeader("Location",builder.path("/").toUriString());
            return new Ingredient(name,spicy,amount,veggie);
        }

    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable String id){
        if(this.ingredientService.existsById(id)) throw new InvalidIngredientException();
        return this.ingredientService.getIngredient(id);
    }

    @PatchMapping("/{id}")
    public Ingredient editIngredient(@PathVariable String id,
                                     @RequestParam("spicy") boolean spicy,
                                     @RequestParam("amount") float amount,
                                     @RequestParam("veggie") boolean veggie){
        if(!this.ingredientService.existsById(id)) throw new InvalidIngredientException();
        try {
            if (spicy && areThere3Spicy()) throw new IllegalSpicyIngredientException();
            return this.ingredientService.editIngredient(id, spicy, amount, veggie);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            //redirect to main page without changes
            return new Ingredient(id,spicy,amount,veggie);
        }
    }

    @GetMapping("/{id}/pizzas")
    public List<Pizza> getPizzasWithIngredient(@PathVariable String id){
        return this.pizzaService.listPizzas(100).stream().filter(pizza ->
                pizza.getIngredients().stream()
                        .anyMatch(ingredient -> ingredient.getName().equals(id)))
                .collect(Collectors.toList());
    }

    private boolean areThere3Spicy(){
        int numberOfSpicyIngredients = this.ingredientService.getAllIngredients(0,500).getContent().stream()
                .filter(ingredient -> ingredient.isSpicy()).collect(Collectors.toList()).size();
        if(numberOfSpicyIngredients==3) return true;
        return false;
    }
}
