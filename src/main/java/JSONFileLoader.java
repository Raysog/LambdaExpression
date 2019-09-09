import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ivan on 27.08.2019.
 */
public class JSONFileLoader {

    private ArrayList<Company> companies = null;

    public JSONFileLoader() throws IOException, ParseException {
        this.companies = jsonArrayToList();
    }

    public ArrayList<Company> getCompanies(){
        return this.companies;
    }

    private File addFile() {
        boolean correctPathFlag = false;
        File file = null;
        Scanner scan = new Scanner(System.in);
        while (!correctPathFlag) {
            System.out.println("Enter absolute or relative file path:");
            String filePath = scan.nextLine();
            File testFile = new File(filePath);
            if (testFile.exists()) {
                System.out.println("File downloaded");
                correctPathFlag = true;
                file = testFile;
                //scan.close();
            } else {
                System.out.println("The specified file does not exist");
            }
        }
        return file;
    }

    private JSONArray readFile(File readingFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(readingFile.getPath());
        JSONArray ja = (JSONArray) parser.parse(reader);
        return ja;
    }

    private ArrayList<Company> jsonArrayToList() throws IOException, ParseException {
        ArrayList<Company> allCompanies = new ArrayList<Company>();
        JSONArray ja = readFile(addFile());
        for (int i = 0; i < ja.size(); i++) {
            JSONObject company = (JSONObject) ja.get(i);
            JSONObject companyType = (JSONObject) company.get("company_type");
            JSONObject country = (JSONObject) company.get("country");
            JSONArray securities = (JSONArray) company.get("securities");
            ArrayList<Security> allSecurities =  new ArrayList<Security>();
            for (int j = 0; j < securities.size(); j++) {
                JSONObject security = (JSONObject) securities.get(j);
                JSONObject state = (JSONObject) security.get("state");
                JSONObject currency = (JSONObject) security.get("currency");

                allSecurities.add(new Security((String) security.get("code"),
                        (String) security.get("name_full"),
                        (String) security.get("cfi"),
                        new Currency((String) currency.get("code"),
                                (String) currency.get("name_full"),
                                (Long) currency.get("id"),
                                (String) currency.get("name_short")),
                        (Long) security.get("id"),
                        (String) security.get("date_to"),
                        (String) security.get("state_reg_date"),
                        new State((String) state.get("name"),
                                (Long) state.get("id"))
                ));
            }
            allCompanies.add(new Company((String) company.get("ogrn"),
                    new CompanyType((String)companyType.get("name_full"),
                            (Long) companyType.get("id"),
                            (String)companyType.get("name_short")),
                    new Country((String) country.get("code"),
                            (String) country.get("name"),
                            (Long) country.get("id")),
                    (String) company.get("code"),
                    (String) company.get("address"),
                    (String) company.get("name_full"),
                    (String) company.get("inn"),
                    (String) company.get("fio_head"),
                    (String) company.get("egrul_date"),
                    (String) company.get("phone"),
                    (String) company.get("e_mail"),
                    (String) company.get("www"),
                    (Boolean) company.get("is_resident"),
                    (Long) company.get("id"),
                    (String) company.get("name_short"),
                    allSecurities));
        }
        return allCompanies;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Company company : companies) {
            sb.append(company.toString());
        }
        return sb.toString();
    }


}