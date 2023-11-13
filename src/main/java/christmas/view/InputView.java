package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.DateValidator;
import christmas.validator.InputValidator;

public class InputView {
    InputValidator inputValidator = new InputValidator();
    DateValidator dateValidator = new DateValidator();
    public int readDate() {
        final int MONTH = 12;
        System.out.println(MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();

        while (!inputValidator.isValidInput(input) || !dateValidator.isValidDate(input)) {
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }
}
