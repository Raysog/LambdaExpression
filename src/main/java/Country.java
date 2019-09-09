/**
 * Created by Ivan on 09.09.2019.
 */
public class Country {
    private String code = null;
    private String name = null;
    private Long id = null;

    public Country(String code, String name, Long id) {
        this.code = code;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "COUNTRY: " + "\n" +
                "\t" + "code = " + code + "\n" +
                "\t" + "name = " + name + "\n" +
                "\t" + "id = " + id.toString() + "\n";
    }
}