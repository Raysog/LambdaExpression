/**
 * Created by Ivan on 09.09.2019.
 */
public class State {
    private String name = null;
    private Long id = null;

    public State(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "STATE: " + "\n" +
                "\t\t" + "name = " + name + "\n" +
                "\t\t" + "id = " + id.toString() + "\n";
    }
}