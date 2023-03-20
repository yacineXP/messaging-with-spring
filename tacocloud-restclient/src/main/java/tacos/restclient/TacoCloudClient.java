package tacos.restclient;

import java.util.Collection;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Taco;

@Service
@Slf4j
public class TacoCloudClient {

  private RestTemplate rest;

  public TacoCloudClient(RestTemplate rest) {
    this.rest = rest;
  }

  //
  // GET examples
  //

  public Ingredient getIngredientById(String ingredientId) {
    return rest.getForObject("http://localhost:8080/api/ingredients/{id}",
                             Ingredient.class, ingredientId);
  }

  public List<Ingredient> getAllIngredients() {
    return rest.exchange("http://localhost:8080/api/ingredients",
            HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>() {})
        .getBody();
  }

  //
  // PUT examples
  //

  public void updateIngredient(Ingredient ingredient) {
    rest.put("http://localhost:8080/api/ingredients/{id}",
          ingredient, ingredient.getId());
  }

  //
  // POST examples
  //
  public Ingredient createIngredient(Ingredient ingredient) {
    return rest.postForObject("http://localhost:8080/api/ingredients",
        ingredient, Ingredient.class);
  }

  public void deleteIngredient(Ingredient ingredient) {
    rest.delete("http://localhost:8080/api/ingredients/{id}",
        ingredient.getId());
  }


}
