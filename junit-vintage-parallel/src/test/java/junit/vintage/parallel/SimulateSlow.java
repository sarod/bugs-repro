package junit.vintage.parallel;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;

import static com.google.common.io.FileWriteMode.*;

public class SimulateSlow {

    public static void simulateSlow() {



        try {
            StackTraceElement element = Thread.currentThread().getStackTrace()[2];
            CharSink charSink = Files.asCharSink(new File("log.log"), Charsets.UTF_8, APPEND);
            charSink.write(LocalDateTime.now().toString() + " - Starting " + element + "\n");


            // simulate long running test
            Thread.sleep(1000);

            charSink.write(LocalDateTime.now().toString() + " - Ending " + element + "\n");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
