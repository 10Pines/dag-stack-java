package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

public class AssertionsExtension {
    static <T extends Throwable> void assertThrowsWithDescription(Class<T> expectedType, Executable lambdaToTry, String errorDescription) {
        var exception = Assertions.assertThrows(expectedType, lambdaToTry, "Another exception expected");
        Assertions.assertEquals(errorDescription, exception.getMessage());
    }
}