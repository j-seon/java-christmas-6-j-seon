package christmas.enums;

public enum ErrorMessage {
    NOT_VALID_DATE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    IS_EMPTY_REGISTRY_ERROR("[ERROR] 응답이 존재하지 않습니다. 질문에 맞는 대답을 입력해주세요."),
    HAS_SPACE_ERROR("[ERROR] 글자에 공백이 포함되지 않도록 다시 입력해주세요."),
    INVALID_ORDER_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    OVER_MAX_ORDER_LIMIT_ERROR("[ERROR] 한 주문당 최대 주문 가능 메뉴 수는 20개 입니다. 다시 입력해 주세요."),
    BEVERAGE_ONLY_ORDER_ERROR("[ERROR] 음료만 주문하는 것은 불가능 합니다. 다른 메뉴도 포함해 다시 입력해 주세요."),
    OVER_MIN_ORDER_AMOUNT_ERROR("[ERROR] 최소 주문 금액은 10,000원 입니다. 다시 입력해 주세요.");


    private String message;
    ErrorMessage (String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}

    /*
  - [ ] **isMenuExistence** : 고객이 메뉴판에 없는 메뉴를 입력 할 경우 `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
  - [ ] **isNotMatchMenuFormat** : 메뉴판의 작성 양식(메뉴-주문개수)이 틀린 경우 `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
  - [ ] **isOverMaxOrderLimit** : 총 주문한 메뉴의 개수가 20개 이상일 경우 `[ERROR] 한 주문당 최대 주문 가능 메뉴 수는 20개 입니다. 다시 입력해 주세요.`
  - [ ] **isOverMinOrderLimit** : 한 메뉴의 주문 개수가 1개 미만일 경우 `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
  - [ ] **isDuplicateMenu** : 중복된 메뉴를 입력할 경우 `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
  - [ ] **isBeverageOnlyOrder** : 음료만 주문할 경우 `[ERROR] 음료만 주문하는 것은은 불가능 합니다. 다른 메뉴도 포함해 다시 입력해 주세요.`
  - [ ] **isOverMinOrderAmount** : 총합 주문 금액의 합이 10,000원 미만일 경우 `[ERROR] 최소 주문 금액은 10,000원 입니다. 다시 입력해 주세요.`
*/