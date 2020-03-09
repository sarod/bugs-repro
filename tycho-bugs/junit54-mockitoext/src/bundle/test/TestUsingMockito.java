package bundle.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestUsingMockito {

    @org.mockito.Mock
    private Object myMock;

    @BeforeEach
    void initMocks() {
        org.mockito.MockitoAnnotations.initMocks(this);
    }

    @Test
    void myTest() {
        org.junit.jupiter.api.Assertions.assertNotNull(myMock);
    }
}
