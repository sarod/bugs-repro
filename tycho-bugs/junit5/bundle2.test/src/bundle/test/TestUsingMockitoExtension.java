package bundle.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class TestUsingMockitoExtension {

    @Mock
    private Object myMock;

    @Test
    void myTest() {
        System.out.println(myMock);
    }
}
