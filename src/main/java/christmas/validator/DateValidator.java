package christmas.validator;


import static christmas.enums.ErrorMessage.NOT_VALID_DATE_ERROR;

public class DateValidator {
    public boolean isValidDate(String input) {
        try {
            if(!isNumber(input)) {
                throw new IllegalArgumentException(NOT_VALID_DATE_ERROR.getMessage());
            }
            if(!isDate(Integer.parseInt(input))) {
                throw new IllegalArgumentException(NOT_VALID_DATE_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean isNumber(String input) {
        return input.matches("[0-9]+");
    }
    private boolean isDate(int date) {
        final int MIN_DATE = 1;
        final int MAX_DATE = 31;

        if(date >= MIN_DATE && date <= MAX_DATE) {
            return true;
        }
        return false;
    }
}
