import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface Manager {

    ArrayList<Map<Ingredient, Double>> recipes = new ArrayList<>();

    Map<Ingredient, Double> ingredients = new HashMap<>();

    void buyIngredients();

    void organizeIngredients();

    void divideIngredients();

    void collectIngredients();

}
