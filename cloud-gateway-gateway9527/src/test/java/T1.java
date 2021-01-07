import org.joda.time.DateTimeZone;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class T1 {
    @Test
    public void test1(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
