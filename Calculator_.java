import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Calculator_ {
    private Calculator calculator;

    @Before
    public void setUp(){
        calculator= new Calculator();
    }
    @Test
    public void given_empty_string_should_return_0(){
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    public void given_a_number_should_return_it() {
        assertThat(calculator.add("4")).isEqualTo(4);
    }

    @Test
    public void given_a_set_of_numbers_separated_by_coma_should_return_sum_of_them() {
        assertThat(calculator.add("3,4")).isEqualTo(7);
    }

    @Test
    public void given_a_set_of_numbers_separated_by_coma_or_newLine_should_return_sum_of_them() {
        assertThat(calculator.add("1\n2,3")).isEqualTo(6);
    }
    @Test
    public void given_a_set_of_numbers_bad_separated_by_coma_and_newLine_should_return_sum_of_numbers() {
        assertThat(calculator.add("\n,1")).isEqualTo(1);
    }


    private static class Calculator{

        private static final String separator = "[,|\n]";

        public int add(String str){
            if( str.isEmpty() ) return 0;
            return stream(tokenize(str)).filter(s->!s.isEmpty()).mapToInt(Integer::parseInt).sum();
        }

        private String[] tokenize(String str) {
            return str.split(separator);
        }
    }

}

