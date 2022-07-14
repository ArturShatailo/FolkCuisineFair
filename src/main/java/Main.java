import java.util.HashSet;
import java.util.Set;

public class Main {

    public static Fair f = new Fair(true, 3000.0);

    public static void main(String[] args) {

        addParticipant();
        f.buyIngredients();
        f.divideIngredients();
        System.out.println(f);

        Poster poster = new Poster(f.getParticipants(), "Folk Cuisine Fair", "08/08/2022", "In your town");
        f.printPoster(poster);
    }

    private static void addParticipant() {

        System.out.println("Input data of participant (enter 'exit' to complete or 'enter' to continue): ");

        if(!Tech.GetInputStringFunction().equals("exit")){
            System.out.println("Input name: ");
            String name = Tech.GetInputStringFunction();
            System.out.println("Input surname: ");
            String surname = Tech.GetInputStringFunction();
            System.out.println("Input dish name: ");
            String dishname = dishValidation(Tech.GetInputStringFunction());
            System.out.println("Now input ingredient (enter 'exit' to complete): ");
            Set<Ingredient> a = ingredientsInput(new HashSet<>());

            f.getParticipants().add(new Participant(name, surname, dishname, a));

            addParticipant();
        }
    }

    private static String dishValidation(String dishname) {
        if(f.validateDish(dishname)){
            System.out.println("This dish has been already registered. Please input another one: ");
            return dishValidation(Tech.GetInputStringFunction());
        }else{
            return dishname;
        }
    }

    private static Set<Ingredient> ingredientsInput(Set<Ingredient> a) {
        System.out.println("Input ingredient name: ");
        String ingredientName = Tech.GetInputStringFunction();
        if(!ingredientName.equals("exit")){
            System.out.println("Input ingredient amount: ");
            String amount = Tech.GetInputStringFunction();
            System.out.println("Input ingredient price: ");
            String price = Tech.GetInputStringFunction();
            a.add(new Ingredient(ingredientName, Double.parseDouble(amount), Double.parseDouble(price)));
            ingredientsInput(a);
        }
        return a;
    }

}
