package mx.edu.cetys.software_quality_lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class EmailValidatorServiceTest {
    @Test
    void shouldReturnFalse_WhenEmailIsNull()

    {
        //Arrange
        EmailValidatorService emailValidator = new EmailValidatorService();
        var isValid = emailValidator.isValid(null);
        assertFalse(isValid);

    }
    @Test
    void shouldReturnFalse_WhenEmailIsEmpty()
    {
        EmailValidatorService emailValidator = new EmailValidatorService();
        var isValid = emailValidator.isValid("");
        assertFalse(isValid);
    }
}
