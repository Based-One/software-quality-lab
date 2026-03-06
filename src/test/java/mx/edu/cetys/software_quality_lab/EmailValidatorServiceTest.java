package mx.edu.cetys.software_quality_lab;

import mx.edu.cetys.software_quality_lab_validators.EmailValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorServiceTest {
    private static int testCount = 0;
    private static final Logger LOGGER  = LogManager.getLogger(EmailValidatorServiceTest.class) ;

    EmailValidatorService emailValidator;
    int count = 0;

    @BeforeAll
    static void beforeAll(){

        LOGGER.info("Starting tests initiating");
        LOGGER.info("BeforeAll executed");
    }

    @BeforeEach
    void setUp(TestInfo testInfo){
        testCount++;
        LOGGER.info("BeforeEach executed");
        LOGGER.info("Initiating Test");
        emailValidator = new EmailValidatorService();
        LOGGER.info("emailValidator initialised");
        LOGGER.info("Test Number {} Test Name: {}", testCount,testInfo.getDisplayName());
    }

    @Test
    void shouldReturnFalse_WhenEmailIsNull(){

        assertFalse(emailValidator.isValid(null));
    }

    @Test
    void shouldReturnFalse_WhenEmailIsEmpty(){
        LOGGER.info("Test Number: {}",count++);
        assertFalse(emailValidator.isValid(""));
    }
    @DisplayName("This test gave me problems")
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
    @AfterEach
     void afterEach(){
        LOGGER.info("AfterEach executed");
        LOGGER.info("Finishing test");
    }
    @AfterAll
    static void afterAll(){
        LOGGER.info("AfterAll executed");
        LOGGER.info("Finishing Tests");
    }









}