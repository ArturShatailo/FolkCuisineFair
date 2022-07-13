import java.util.*;

public interface Manager {

    List<Ingredient> ingredientsList = new ArrayList<>();

    void buyIngredients();

    void divideIngredients();

    void collectIngredients();

}
