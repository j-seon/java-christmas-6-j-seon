package christmas.validator;

import static christmas.enums.ErrorMessage.HAS_SPACE_ERROR;
import static christmas.enums.ErrorMessage.IS_EMPTY_REGISTRY_ERROR;

public class InputValidator {

    public boolean isValidInput(String inputStr) {
        try {
            if(isEmptyRegistry(inputStr)) {
                throw new IllegalArgumentException(IS_EMPTY_REGISTRY_ERROR.getMessage());
            }
            if(hasSpace(inputStr)) {
                throw new IllegalArgumentException(HAS_SPACE_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private boolean isEmptyRegistry(String input) {
        if(input.equals("") || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean hasSpace (String inputStr) {
        char[] inputArr = inputStr.toCharArray();
        for (char input: inputArr) {
            if (input == ' ') {
                return true;
            }
        }
        return false;
    }
}
