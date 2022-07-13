import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Participant> participants = new HashSet<>();

        Set<Ingredient> a = new HashSet<>();
        a.add(new Ingredient("ingredient1", 2.0, 20.0));
        a.add(new Ingredient("ingredient2", 3.0, 30.0));
        Participant gg = new Participant("Aleck",
                "Bolduin",
                "dishname", a);


        Set<Ingredient> b = new HashSet<>();
        b.add(new Ingredient("ingredient1", 4.0, 10.0));
        b.add(new Ingredient("ingredient3", 1.0, 20.0));
        Participant gh = new Participant("Bob",
                "Marley",
                "dishname2", b);


        participants.add(gg);
        participants.add(gh);


        Fair f = new Fair(true, 3000.0, participants);
        f.buyIngredients();
        f.divideIngredients();


        System.out.println(f);
        System.out.println(Manager.ingredients);
        System.out.println(gg.getRequestedIngredient().equals(gg.getDish().getRecipe()));
    }

}
