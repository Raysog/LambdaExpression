/**
 * Created by Ivan on 09.09.2019.
 */
public class Currency {
    private String code = null;
    private String nameFull = null;
    private Long id = null;
    private String nameShort = null;

    public Currency(String code, String nameFull, Long id, String nameShort) {
        this.code = code;
        this.nameFull = nameFull;
        this.id = id;
        this.nameShort = nameShort;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "CURRENCY: " + "\n" +
                "\t\t" + "code = " + code + "\n" +
                "\t\t" + "nameFull = " + nameFull + "\n" +
                "\t\t" + "id = " + id.toString() + "\n" +
                "\t\t" + "nameShort = " + nameShort + "\n";
    }
}