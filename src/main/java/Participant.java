import java.util.HashSet;
import java.util.Set;

public class Participant {

    private final String name;

    private final String surname;

    private final Dish dish;

    private final Set<Ingredient> requestedIngredient = new HashSet<>();

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
        return  "\n\n"+"Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Dish: " + dish + "\n" +
                "Requested ingredient: " + requestedIngredient;
    }


    //Returns String for Poster display view.
    public String posterView() {
        return  "\n"+name + " " + surname + " (Dish: " + dish + ")"+"\n";
    }

}
