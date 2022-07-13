import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Participant {

    private String name;

    private String surname;

    private Dish dish;

    private Set<Ingredient> requestedIngredient = new HashSet<>();

    Participant(String name, String surname, String dish, Set<Ingredient> ingredients){
        this.name = name;
        this.surname = surname;
        this.dish = new Dish(dish, ingredients);
    }

    public Set<Ingredient> getRequestedIngredient() {
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
