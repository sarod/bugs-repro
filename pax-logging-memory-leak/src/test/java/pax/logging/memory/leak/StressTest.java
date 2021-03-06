/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pax.logging.memory.leak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StressTest {
    @Test
    void createLotsOfLoggers() {
        assertDoesNotThrow(
                () -> {
                    for (int i = 0; i < 5_000_000; i++) {
                        new ClassUsingNonStaticSlf4JLogger();
                        if (i % 10_000 == 0) {
                            System.out.println("It " + i);
                        }
                    }
                }
        );

    }
}
