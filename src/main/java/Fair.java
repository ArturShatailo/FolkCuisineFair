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
    public void organizeIngredients(){
        participants.forEach( p -> recipes.add(p.getDish().getRecipe()) );
        collectIngredients();
    }

    @Override
    public void collectIngredients() {
        for(Map<Ingredient, Double> map : recipes){
            map.forEach((ingredient, amount) ->
                    ingredients.merge(ingredient, map.get(ingredient), Double::sum)
            );
        }
    }

    @Override
    public void buyIngredients(){
        organizeIngredients();
        Double sum = ingredients.values().stream().mapToDouble(p -> p).sum();
        totalBalance = totalBalance - sum;
    }

    @Override
    public void divideIngredients(){

        for(Participant participant : participants){
            participant.getDish().getRecipe().forEach((i, p) -> {
                ingredients.put(i, ingredients.get(i) - p);
                participant.getRequestedIngredient().put(i, p);
            });
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

