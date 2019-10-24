import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {



    @Test
    void convertDateTrue() {
    String date = "2020-12-12";
    LocalDate convertedDate = LocalDate.parse(date);
    assertEquals(12, convertedDate.getDayOfMonth());
    }


    @Test
    void isValidDateTrue (){
    App app = new App();
    String date = "2020-12-12";
    assertEquals(true, app.isValidDate(date));
    }

    @Test
    void isValidDateFalse (){
    App app = new App();
    String date = "2018-12-12";
    assertNotEquals(true,app.isValidDate(date));

    }
    @Test
    void convertIndexToIntTrue() {
        App app = new App();
        String integer = "10";
        assertEquals(10, (app.convertIndexToInt(integer)+1));
    }

    @Test
    void convertIndexToIntFalse() {
        App app = new App();
        String integer = "o";
        int ex = app.convertIndexToInt(integer);
        assertNotEquals(0, ex );
    }
}