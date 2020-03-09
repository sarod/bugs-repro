package bundle.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class TestUsingMockitoExtension {

    @org.mockito.Mock
    private Object myMock;


    @Test
    void myTest() {
        org.junit.jupiter.api.Assertions.assertNotNull(myMock);
    }
}
