package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.DateValidator;
import christmas.validator.InputValidator;

public class InputView {
    InputValidator inputValidator;
    DateValidator dateValidator;

    public InputView() {
        inputValidator = new InputValidator();
        dateValidator = new DateValidator();
    }

    public String readUserInput() {
        return Console.readLine();
    }
    public int readDate() {
        final int MONTH = 12;
        System.out.println(MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = readUserInput();

        while (!inputValidator.isValidInput(input) || !dateValidator.isValidDate(input)) {
            input = Console.readLine();
        }

        return Integer.parseInt(input);
    }

    public String readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = readUserInput();

        while(!inputValidator.isValidInput(input)) {
            input = Console.readLine();
        }
        return input;
    }
}
