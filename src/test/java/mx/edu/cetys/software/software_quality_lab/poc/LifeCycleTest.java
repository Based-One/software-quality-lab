package mx.edu.cetys.software.software_quality_lab.poc;


import org.apache.juli.logging.Log;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.*;

public class LifeCycleTest {
    private static final Logger LOGGER = LogManager.getLogger(LifeCycleTest.class);
    @BeforeAll
    static void beforeAll(){
        LOGGER.info("Starting Tests beforeAll");
    }
    @BeforeEach
    void beforeEach(){
        LOGGER.info("Starting test");
    }

    @DisplayName("DisplayName Example")
    @Test
    void test1(TestInfo testInfo){
        LOGGER.info("This is a test 1 + Display Name: {}", testInfo.getDisplayName());
    }
    @Test
    void test2(){
        LOGGER.info("This is a test 2");
    }


    @AfterEach
    void afterEach(){
        LOGGER.info("Finishing Test");
    }
    @AfterAll
    static void afterAll(){
        LOGGER.info("Finishing Tests AfterAll");
    }
}
