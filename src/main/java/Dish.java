import java.util.Set;

public class Dish {

    private String name;

    private Set<Ingredient> recipe;

    public Dish(String name, Set<Ingredient> recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public Set<Ingredient> getRecipe() {
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
