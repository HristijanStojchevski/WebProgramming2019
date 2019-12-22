package mk.finki.ukim.mk.lab.web.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000") here is React
@RequestMapping(path = "/api/Ingredients")
public class IngredientsApi {
}
