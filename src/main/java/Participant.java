import java.util.HashMap;
import java.util.Map;

public class Participant {

    private String name;

    private String surname;

    private Dish dish;

    private Map<Ingredient, Double> requestedIngredient = new HashMap<>();

    Participant(String name, String surname, String dish, Map<Ingredient, Double> ingredients){
        this.name = name;
        this.surname = surname;
        this.dish = new Dish(dish, ingredients);
    }

    public Map<Ingredient, Double> getRequestedIngredient() {
        return requestedIngredient;
    }

    public Dish getDish() {
        return dish;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dish=" + dish +
                ", requestedIngredient=" + requestedIngredient +
                "}\n";
    }
}
