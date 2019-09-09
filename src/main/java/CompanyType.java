/**
 * Created by Ivan on 09.09.2019.
 */
public class CompanyType {
    private String nameFull = null;
    private Long id;
    private String nameShort = null;

    public CompanyType(String nameFull, Long id, String nameShort) {
        this.nameFull = nameFull;
        this.id = id;
        this.nameShort = nameShort;
    }

    @Override
    public String toString() {
        return "COMPANYTYPE: " + "\n" +
                "\t" + "nameFull = " + nameFull + "\n" +
                "\t" + "id = " + id.toString() + "\n" +
                "\t" + "nameShort = " + nameShort + "\n";
    }
}
