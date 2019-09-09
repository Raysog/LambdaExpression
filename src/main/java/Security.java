import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Locale;

/**
 * Created by Ivan on 27.08.2019.
 */
public class Security {
    private String code = null;
    private String nameFull = null;
    private String cfi = null;
    private Currency currency = null;
    private Long id = null;
    private LocalDate dateTo = null;
    private String stateRegDate = null;
    private State state = null;

    public Security(String code, String nameFull, String cfi, Currency currency, Long id, String dateTo, String stateRegDate, State state) {
        this.code = code;
        this.nameFull = nameFull;
        this.cfi = cfi;
        this.currency = currency;
        this.id = id;
        this.dateTo = LocalDate.parse(dateTo);
        this.stateRegDate = stateRegDate;
        this.state = state;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Long getId() {
        return id;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return "SECURITY: " + "\n" +
                "\t" + "code = " + code + "\n" +
                "\t" + "nameFull = " + nameFull + "\n" +
                "\t" + "cfi = " + cfi + "\n" +
                "\t" + "currency = " + currency.toString() +
                "\t" + "id = " + id.toString() + "\n" +
                "\t" + "dateTo = " + dateTo + "\n" +
                "\t" + "stateRegDate = " + stateRegDate + "\n" +
                "\t" + "state = " + state.toString();
    }
}