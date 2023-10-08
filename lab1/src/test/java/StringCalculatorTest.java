import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    //STEP 1
    @Test
    public void empty_string() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void one_number() {
        assertEquals(11, StringCalculator.add("11"));
    }

    @Test
    public void two_number() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void two_delimiters() {
        assertEquals(-1, StringCalculator.add("1,,2"));
    }

    @Test
    public void start_delimiters() {
        assertEquals(-1, StringCalculator.add(",1,2"));
    }

    //STEP 2
    @Test
    public void tree_number() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    @Test
    public void five_number() {
        assertEquals(404, StringCalculator.add("400,0,1,3"));
    }

    //STEP 3
    @Test
    public void two_number_two_delimeters() {
        assertEquals(-1, StringCalculator.add("1,\n1"));
    }
    @Test
    public void three_number_two_delimeters() {
        assertEquals(10, StringCalculator.add("1\n1,8"));
    }

    //STEP 4
    @Test
    public void my_delimiter() {
        assertEquals(6, StringCalculator.add("//[;]\n1;2;3"));
    }
    @Test
    public void my_delimiter1() {
        assertEquals(11, StringCalculator.add("//[;]\n1,5;4\n1"));
    }
    //STEP 5
    @Test
    public void negative_num() {
        try{
            StringCalculator.add("1,-2\n3");
           fail();
        }catch (RuntimeException ex){
            assertEquals("ERROR: There are negative numbers: [-2]", ex.getMessage());
        }
    }
    @Test
    public void negative_nums() {

        try{
            StringCalculator.add("0,0,5,100,-9,-4,2,-100");
            fail();
        }catch (RuntimeException ex){
            assertEquals("ERROR: There are negative numbers: [-9, -4, -100]", ex.getMessage());
        }
    }

    //STEP 6
    @Test
    public void too_big_nums() {
        assertEquals(1020, StringCalculator.add("5,1001,15,1000"));
    }

    //STEP 7
    @Test
    public void long_delimiter() {
        assertEquals(100, StringCalculator.add("//[***]\n10***80***10"));
    }
    @Test
    public void long_delimiter2() {
        assertEquals(20, StringCalculator.add("//[e]\n1e2,8e1\n8"));
    }

    //STEP 8
    @Test
    public void more_delimiters() {
        assertEquals(100, StringCalculator.add("//[*][/]\n10*80/10"));
    }
    @Test
    public void more_delimiter2() {
        assertEquals(20, StringCalculator.add("//[e][x]\n1e2,8x1\n8"));
    }
    //STEP 9
    @Test
    public void very_more_delimiters() {
        assertEquals(100, StringCalculator.add("//[***][//]\n10***80//10"));
    }
    @Test
    public void very_more_delimiter2() {
        assertEquals(20, StringCalculator.add("//[ee][xxx]\n1ee2,8xxx1\n8"));
    }
//    @Test
//    public void custom_test() {
//        assertEquals(1, StringCalculator.add("1"));
//    }

}

