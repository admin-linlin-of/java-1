import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author linlin
 * @create 2022-05-13 17:13
 */
public class DateTimeTest {
    @Test
    public void testExer() throws ParseException{
        String birth = "2020-09-08";
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = s1.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
}
