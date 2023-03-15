// Нужно покрыть тестами метод на 100%
// Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false)
package seminars.third.coverage;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3_2 {

    public static boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    void checkOdd() {
        CalculateEvenOdd c = new CalculateEvenOdd();
        assertThat(c.evenOddNumber(1)).isEqualTo(false);
        assertThat(c.evenOddNumber(1347)).isEqualTo(false);
    }

    @Test
    void checkEven() {
        CalculateEvenOdd c = new CalculateEvenOdd();
        assertThat(c.evenOddNumber(2)).isEqualTo(true);
        assertThat(c.evenOddNumber(3424)).isEqualTo(true);
    }

    @Test
    void checkZero() {
        CalculateEvenOdd c = new CalculateEvenOdd();
        assertThat(c.evenOddNumber(0)).isEqualTo(true);
    }
}