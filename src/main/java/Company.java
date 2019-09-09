import java.io.BufferedReader;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Ivan on 27.08.2019.
 */
public class Company {
    private String ogrn = null;
    private CompanyType companyType = null;
    private Country country = null;
    private String code = null;
    private String address = null;
    private String nameFull = null;
    private String inn = null;
    private String fioHead = null;
    private LocalDate egrulDate = null;
    private String phone = null;
    private String eMail = null;
    private String www = null;
    private Boolean isResident = null;
    private Long id = null;
    private String nameShort = null;
    private ArrayList<Security> securities = null;


    public Company(String ogrn, CompanyType companyType, Country country, String code, String address, String nameFull, String inn, String fioHead, String egrulDate, String phone, String eMail, String www, boolean isResident, Long id, String nameShort, ArrayList<Security> securities) {
        this.ogrn = ogrn;
        this.companyType = companyType;
        this.country = country;
        this.code = code;
        this.address = address;
        this.nameFull = nameFull;
        this.inn = inn;
        this.fioHead = fioHead;
        this.egrulDate = LocalDate.parse(egrulDate);
        this.phone = phone;
        this.eMail = eMail;
        this.www = www;
        this.isResident = isResident;
        this.id = id;
        this.nameShort = nameShort;
        this.securities = securities;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getNameShort() {
        return this.nameShort;
    }

    public LocalDate getEgrulDate() {
        return this.egrulDate;
    }



    public ArrayList<Security> getSecurities(){
        return this.securities;
    }

    @Override
    public String toString() {

        return "COMPANY: " + "\n" +
                "ogrn = " + ogrn + "\n" +
                "companyType = " + companyType.toString() +
                "country = " + country.toString() +
                "code = " + code + "\n" +
                "address = " + address + "\n" +
                "nameFull = " + nameFull + "\n" +
                "inn = " + inn + "\n" +
                "fioHead = " + fioHead + "\n" +
                "egrulDate = " + egrulDate + "\n" +
                "phone = " + phone + "\n" +
                "eMail = " + eMail + "\n" +
                "www = " + www + "\n" +
                "isResident = " + isResident.toString() + "\n" +
                "id = " + id.toString() + "\n" +
                "nameShort = " + nameShort + "\n" +
                "securities: \n" + printSecurities() + "\n";
    }

    private String printSecurities() {
        StringBuilder sb = new StringBuilder();
        for (Security security : securities) {
            sb.append(security.toString());
        }
        return sb.toString();
    }

}