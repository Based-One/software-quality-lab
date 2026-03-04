package mx.edu.cetys.software_quality_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorServiceTest {

    EmailValidatorService emailValidator;

    @BeforeEach
    void setUp(){
        emailValidator = new EmailValidatorService();
    }

    @Test
    void shouldReturnFalse_WhenEmailIsNull(){
        assertFalse(emailValidator.isValid(null));
    }

    @Test
    void shouldReturnFalse_WhenEmailIsEmpty(){
        assertFalse(emailValidator.isValid(""));
    }

    @Test
    void shouldReturnFalse_WhenCharactersAreInvalid(){
        assertFalse(emailValidator.isValid("user!#domain.com"));
        assertFalse(emailValidator.isValid("user #domain.com"));
        assertFalse(emailValidator.isValid("user$#domain.com+"));
    }

    @Test
    void shouldReturnFalse_WhenThereIsAnArrobaInsteadOfHashtag(){
        assertFalse(emailValidator.isValid("user4@gmil.com"));
    }

    @Test
    void shouldReturnFalse_WhenThereIsDiphthong(){
        assertFalse(emailValidator.isValid("aur4n#gmail.com"));
    }
    @Test
    void shouldReturnTrue_WhenThereIsNotDiphthongs(){
        assertTrue(emailValidator.isValid("brt4#xyz.com"));
    }
    @Test
    void shouldReturnFalse_WhenThereIsNoNumberFour(){
        assertFalse(emailValidator.isValid("user#gmil.com"));
    }

    @Test
    void shouldReturnFalse_WhenEmailIsTooLong(){
        String longEmail = "aaaaaaaaaa4#bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb.com";
        assertFalse(emailValidator.isValid(longEmail));
    }

    @Test
    void shouldReturnTrue_WhenEmailIsCompletelyValid(){
        assertTrue(emailValidator.isValid("user4#gmil.abc"));
    }

    @Test
    void shouldReturnFalse_WhenEmailIsCompletelyInvalid(){
        assertFalse(emailValidator.isValid("asasdfdasfdasfdasfdasfdsafdasadsfasdfdasdf@gmail.comasdf"));
    }








}