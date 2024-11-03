package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    private Validator() {}

    /**
     * 구입 금액의 유효성을 검증합니다.
     *
     * @param amount 구입 금액
     * @throws IllegalArgumentException 유효하지 않은 금액일 경우 예외 발생
     */
    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

    /**
     * 당첨 번호 리스트의 유효성을 검증합니다.
     *
     * @param numbers 당첨 번호 리스트
     * @throws IllegalArgumentException 유효하지 않은 번호가 포함된 경우
     */
    public static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
        }
    }

    /**
     * 보너스 번호의 유효성을 검증합니다.
     *
     * @param number 보너스 번호
     * @throws IllegalArgumentException 보너스 번호가 범위 밖일 경우
     */
    public static void validateBonusNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
        }
    }
}
