/**
 * Created by Ivan on 09.09.2019.
 */
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 27.08.2019.
 * test.json
 */
public class Tester {

    private static int count = 0;
    private static boolean flagDate = true;

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(new File("").getAbsoluteFile());
        System.out.println(new File("").getPath());
        System.out.println(new File("").getCanonicalPath());
        JSONFileLoader jfl = new JSONFileLoader();

        ShortPrintable shortPrint = (c) -> System.out.println("Краткое название: " + c.getNameShort() + "\nДата основания:  " + c.getEgrulDate().format(DateTimeFormatter.ofPattern("d/MM/uuuu")));
        jfl.getCompanies().forEach(shortPrint::shortPrint);
        System.out.println();

        jfl.getCompanies().stream().forEach(company -> {
            count = 0;
            company.getSecurities().stream().filter(security ->
                    security.getDateTo().isBefore(LocalDate.now())).forEach(security -> {
                System.out.println("code: " + security.getCode() + "\n" +
                        "dateTo: " + security.getDateTo() + "\n" +
                        "companyFullName: " + company.getNameFull() + "\n");
                count++;
            });
            System.out.println("Количество просроченных ценных бумаг: " + count);
        });




        DateTimeFormatter f = DateTimeFormatter.ofPattern("d/uuuu/MM");
        DateTimeFormatter d = DateTimeFormatter.ofPattern("uuuu/dd/MM");
        DateTimeFormatter c = DateTimeFormatter.ofPattern("MM/d/uuuu");
        List<DateTimeFormatter> formats = new ArrayList<>();
        formats.add(f);
        formats.add(d);
        formats.add(c);

        while (flagDate) {
            System.out.println("Enter date: ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            String date = bf.readLine();
            formats.stream().forEach(dateTimeFormatter -> {
                        try {
                            jfl.getCompanies().stream().filter(company ->
                                    company.getEgrulDate().isAfter(LocalDate.parse(date, dateTimeFormatter))).forEach(company ->
                                    System.out.println("fullName: " + company.getNameFull() + " date: " + company.getEgrulDate())
                            );
                            flagDate = false;
                        } catch (Exception e) {}
                    }
            );
            if (flagDate){
                System.out.println("Формат указан неверно!\nДоступные форматы:");
                formats.stream().forEach(dateTimeFormatter ->
                        System.out.println(dateTimeFormatter.toString())
                );
            }
        }

        List<String> courses = new ArrayList<>();
        courses.add("EU");
        courses.add("USD");
        courses.add("RUB");
        boolean flagCourse = true;

        while (flagCourse) {
            System.out.println("Enter course: ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            String enteredCourse = bf.readLine();
            if (courses.stream().filter(course -> course.equals(enteredCourse)).count() == 0) {
                System.out.println("Курс указан неверно!\nДоступные курсы:");
                courses.stream().forEach(course ->
                        System.out.println(course)
                );
            } else {
                courses.stream().filter(course -> course.equals(enteredCourse)).forEach(course ->
                        jfl.getCompanies().stream().forEach(company ->
                                company.getSecurities().stream().filter(security ->
                                        security.getCurrency().getCode().equals(enteredCourse)).forEach(security -> {
                                            System.out.println("id = " + security.getId() + " code = " + security.getCode());
                                        }
                                )
                        )
                );
                flagCourse = false;
            }
        }
    }
}