package pax.logging.memory.leak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassUsingNonStaticSlf4JLogger {


    private final Logger logger = LoggerFactory.getLogger(getClass());


    public void method() {
        logger.debug("I will never be called");
    }
}
