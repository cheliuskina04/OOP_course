import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    public void empty_string(){
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void one_number(){
        assertEquals(11, StringCalculator.add("11"));
    }
    @Test
    public void two_number(){
        assertEquals(3, StringCalculator.add("1,2"));
    }
    @Test
    public void tree_number(){
        assertEquals(-1, StringCalculator.add("1,2,3"));
    }
    @Test
    public void two_delimiters(){
        assertEquals(-1, StringCalculator.add("1,,2"));
    }
    @Test
    public void start_delimiters(){
        assertEquals(-1, StringCalculator.add(",1,2"));
    }
}

