package snail.springboot3jwt.auth.annotation;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PasswordConstraintValidatorTest2MethodByNested {

    private PasswordConstraintValidator validator = new PasswordConstraintValidator();
    @Nested
    class PasswordValidator{
        @Test
        void isValid_shouldReturnTrue_whenPasswordStrong(){
            assertTrue(isValid("AlaMaKota123-+"));
           // assertFalse(isValid("AlaMaKota123")); error
        }
    }

    private boolean isValid(String value) {
        return validator.isValid(value, null);
    }
}
