import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {



//    @Test
//    void convertDateTrue() {
//    App app = new App();
//    assertEquals("2020-12-12", app.convertDate("2020-12-12"));
//    }

    @Test
    void convertDateFalse() {
        App app = new App();

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
    void convertIndexToInt() {
    }
}