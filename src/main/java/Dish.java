import java.util.HashMap;
import java.util.Map;

public class Dish {

    private String name;

    private Map<Ingredient, Double> recipe;

    public Dish(String name, Map<Ingredient, Double> recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public Map<Ingredient, Double> getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
