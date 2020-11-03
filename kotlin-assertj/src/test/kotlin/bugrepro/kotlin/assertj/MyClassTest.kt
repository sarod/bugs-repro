package bugrepro.kotlin.assertj

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MyClassTest {
    class MyClass {
        fun someFunction(): String {
            return "Result"
        }
    }

    @Test
    fun testSomeFunctionWithAssertjExtracting() {
        val classUnderTest = MyClass()

        // Using Kotlin 1.3.10 this test passes fine because
        //  it resolves extracting to org.assertj.core.api.AbstractObjectAssert.extracting(java.util.function.Function<? super ACTUAL,? extends java.lang.Object>)
        // Using Kotlin 1.4.x this test fails because
        //  it resolves extracting to org.assertj.core.api.ObjectAssert.extracting(Function<? super ACTUAL, Object>... extractors)
        assertThat(classUnderTest).extracting(MyClass::someFunction)
                .isNotNull().isEqualTo("Result")
    }

}
