import java.util.*;

public interface Manager {

    List<Ingredient> ingredients = new ArrayList<>();

    void buyIngredients();

    void divideIngredients();

    void collectIngredients();

}
