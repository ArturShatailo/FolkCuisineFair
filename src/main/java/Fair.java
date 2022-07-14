import java.util.*;

public class Fair implements Manager{

    private boolean registrationStatus;

    private Double totalBalance;

    private final Set<Participant> participants = new HashSet<>();


    public Fair(boolean registrationStatus, Double totalBalance) {
        this.registrationStatus = registrationStatus;
        this.totalBalance = totalBalance;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public boolean validateDish(String dishname) {
        return participants.stream().anyMatch(p -> p.getDish().name().equals(dishname));
    }

    @Override
    public void collectIngredients() {
        participants.forEach( p -> ingredientsList.addAll(p.getDish().recipe()));
    }

    @Override
    public void buyIngredients(){
        collectIngredients();
        double sum = ingredientsList.stream().mapToDouble(Ingredient::getFullPrice).sum();
        totalBalance = totalBalance - sum;
    }

    @Override
    public void divideIngredients(){

        for(Participant participant : participants){

            List<Ingredient> in =
                    ingredientsList.stream()
                            .filter(i -> participant
                                    .getDish()
                                    .recipe()
                                    .contains(i))
                            .toList();

            participant.getRequestedIngredient().addAll(in);
            ingredientsList.removeAll(in);

        }
    }

    public void printPoster(Poster poster){
        System.out.println("\n\n\n");
        System.out.println("----------------------------------\n");
        System.out.println(poster);
        System.out.println("----------------------------------");
    }

    @Override
    public String toString() {
        String a = "Fair balance: " + totalBalance + " " + participants;
        return  a.replaceAll("\\[", "").replaceAll("]", "");
    }
}

