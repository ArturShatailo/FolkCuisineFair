import java.util.HashSet;
import java.util.Set;

public class Main {

    //New Fair object
    public static Fair f = new Fair(true, 3000.0);

    public static void main(String[] args) {

        addParticipant();

        f.buyIngredients();
        f.divideIngredients();

        //Display full information about Fair object
        System.out.println(f);

        //Create and form a Poster object that will be displayed in console
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

            //Add new Participant object into 'participants' field of Fair object
            f.getParticipants().add(new Participant(name, surname, dishname, a));

            //Call recursion to check if 'exit' will be inputted or new Participant should be created
            addParticipant();
        }
    }

    /*
    * Checks if validateDish() method of Fair object returns true when receives @param String 'dishname'.
    * Suggests input value again if validateDish() method returns true
    * Start recursion to check inputted value again by validateDish() method.
    * if validateDish() returns false, the method returns @param 'dishname' without any mutations.
    */
    private static String dishValidation(String dishname) {
        if(f.validateDish(dishname)){
            System.out.println("This dish has been already registered. Please input another one: ");
            return dishValidation(Tech.GetInputStringFunction());
        }else{
            return dishname;
        }
    }

    /*
    * Allows input several ingredients and their values and stop input when 'exit' value requested
    */
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
