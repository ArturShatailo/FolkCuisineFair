import java.util.Set;

public class Poster {

    private final Set<Participant> participants;

    private final String name;

    private final String date;

    private final String place;

    public Poster(Set<Participant> participants, String name, String date, String place) {
        this.participants = participants;
        this.name = name;
        this.date = date;
        this.place = place;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        String b = name.toLowerCase() + "\n" + date + "\n" + place + "\n";
        s.append(b);
        participants.forEach( p -> s.append(p.posterView()) );
        return s.toString();
    }
}
