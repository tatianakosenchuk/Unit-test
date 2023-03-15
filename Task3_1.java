//  Разбить большой метод под номером 3 и проверить покрытие(должно быть 100%)

package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task3_1 {
    public double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double discountedAmount = 0; 
        if (purchaseAmount >= 0) {
            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            } else {
                throw new ArithmeticException("Скидка должна быть в диапазоне от 0 до 100%");
            }
        } else {
           
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }
        return discountedAmount; 
    }
    
    @Test
    void insufficientCoverageTest() {

        System.out.println(someService.calculatingDiscount(2000.0, 10));

    }

    @Test
    void testNormalDiscount() {
        assertThat(someService.calculatingDiscount(2000.0, 50))
                .isEqualTo(1000); 
    }

    @Test
    void testFullDiscount() {
        assertThat(someService.calculatingDiscount(2000.0, 100))
                .isEqualTo(0); 
    }

    @Test
    void testNoDiscount() {
        assertThat(someService.calculatingDiscount(2000.0, 0))
                .isEqualTo(2000);
    }

    @Test
    void discountMore100ReturnException() {
        assertThatThrownBy(() -> someService.calculatingDiscount(2000.0, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); 
    }

    @Test
    void negativePurchaseDiscountReturnException() {
        assertThatThrownBy(() -> someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); 
    }

    @Test
    void negativePurchaseAmountReturnException() {
        assertThatThrownBy(() -> someService.calculatingDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }
}