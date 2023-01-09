package snail.springboot3jwt.auth.annotation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import snail.springboot3jwt.auth.payload.request.RegisterRequest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordConstraintValidatorTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInvalidPassword() {
        RegisterRequest request = new RegisterRequest("Elvis", "Presley", "Elvis.Presley@gmail.com", "ElvisPresley-");

        Set<ConstraintViolation<RegisterRequest>> constraintViolations = validator.validate(request);

        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void testValidPasswords() {
        RegisterRequest request = new RegisterRequest("Elvis", "Presley", "Elvis.Presley@gmail.com", "ElvisPresley0--");

        Set<ConstraintViolation<RegisterRequest>> constraintViolations = validator.validate(request);

        assertEquals(0, constraintViolations.size());
    }

}