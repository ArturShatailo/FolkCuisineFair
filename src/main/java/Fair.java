import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fair implements Manager{

    private boolean registrationStatus;

    private Double totalBalance;

    private Set<Participant> participants;

    public Fair(boolean registrationStatus, Double totalBalance, Set<Participant> participants) {
        this.registrationStatus = registrationStatus;
        this.totalBalance = totalBalance;
        this.participants = participants;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    @Override
    public void collectIngredients() {

        participants.forEach( p -> ingredients.addAll(p.getDish().getRecipe()));

//        for(Set<Ingredient> set : recipes){
//            map.forEach((ingredient, amount) ->
//                    ingredients.merge(ingredient, map.get(ingredient), Double::sum)
//            );
//        }
    }

    @Override
    public void buyIngredients(){
        collectIngredients();

        Double sum = ingredients.stream().mapToDouble(Ingredient::getFullPrice).sum();

        System.out.println(sum);

        totalBalance = totalBalance - sum;
    }

    @Override
    public void divideIngredients(){

        for(Participant participant : participants){
            for(Ingredient ingredient : participant.getDish().getRecipe()){
                if(ingredients.contains(ingredient)){
                    participant.getRequestedIngredient().add(ingredient);
                    ingredients.remove(ingredient);
                }
            }
        }



    }

    @Override
    public String toString() {
        return "Fair{" +
                "registrationStatus=" + registrationStatus +
                ", totalBalance=" + totalBalance +
                ", participants=" + participants +
                "}";
    }
}

