import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Participant> participants = new HashSet<>();

        Map<Ingredient, Double> a = new HashMap<>();
        a.put(new Ingredient("ingredient1"), 10.0);
        a.put(new Ingredient("ingredient2"), 20.0);
        Participant gg = new Participant("Aleck",
                "Bolduin",
                "dishname", a);


        Map<Ingredient, Double> b = new HashMap<>();
        b.put(new Ingredient("ingredient1"), 10.0);
        b.put(new Ingredient("ingredient3"), 20.0);
        Participant gh = new Participant("Aleck",
                "Bolduin",
                "dishname", b);


        participants.add(gg);
        participants.add(gh);


        Fair f = new Fair(true, 3000.0, participants);
        f.buyIngredients();
        f.divideIngredients();


        System.out.println(f);
        System.out.println(Manager.ingredients);
    }

}
