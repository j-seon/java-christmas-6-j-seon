package christmas.enums;

public enum ErrorMessage {
    NOT_VALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    IS_EMPTY_REGISTRY_ERROR("[ERROR] 응답이 존재하지 않습니다. 질문에 맞는 대답을 입력해주세요."),
    HAS_SPACE_ERROR("[ERROR] 글자에 공백이 포함되지 않도록 다시 입력해주세요."),
    ;


    private String message;
    ErrorMessage (String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}