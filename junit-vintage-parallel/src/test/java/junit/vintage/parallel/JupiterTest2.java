/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package junit.vintage.parallel;

import org.junit.jupiter.api.Test;

class JupiterTest2 {
    
    @Test void slowTest1() throws InterruptedException {
        SimulateSlow.simulateSlow();
    }

    @Test void slowTest2() throws InterruptedException {
        SimulateSlow.simulateSlow();
    }
}
