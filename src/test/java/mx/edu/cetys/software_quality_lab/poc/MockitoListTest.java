package mx.edu.cetys.software_quality_lab.poc;

import mx.edu.cetys.software_quality_lab_validators.EmailValidatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoListTest {
    @Mock
    EmailValidatorService emailValidatorServiceMock;
    @Mock
    List<String> mockListString;
  @Test
    void shouldReturnCustomSize_WhenMocked(){
    // Arrange: Is already done for my mockList
      //Define Mocks Behaviour
      when(mockListString.size()).thenReturn(999_999_999).thenReturn(1).thenReturn(67).thenThrow(new RuntimeException()).thenReturn(0);
//      var size = mockListString.size();
      assertEquals(999_999_999,mockListString.size());
      assertEquals(1,mockListString.size());
      assertEquals(67,mockListString.size());
      assertThrows(RuntimeException.class, ()-> mockListString.size());
      assertEquals(0,mockListString.size());
    }

    @Test
    void shouldMockList_GetWithParameters(){
      when(mockListString.get(anyInt()))
              .thenReturn("Hello")
              .thenReturn("World");

        assertEquals("Hello",mockListString.get(0));
        assertEquals("World",mockListString.get(1));
    }
    @Test
    void mockEmailValidator_WithArgumentMatchers(){
      when(emailValidatorServiceMock.isValid(anyString())).thenReturn(true);
      when(emailValidatorServiceMock.isValid(isNull())).thenReturn(false) //isNotNull
              .thenReturn(true);


      assertTrue(emailValidatorServiceMock.isValid("aeiou"));
      assertFalse(emailValidatorServiceMock.isValid(null));
      assertTrue(emailValidatorServiceMock.isValid(null));
      assertTrue(emailValidatorServiceMock.isValid(""));
      assertTrue(emailValidatorServiceMock.isValid("@"));






    }

}
