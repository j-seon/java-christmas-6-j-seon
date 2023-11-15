package christmas.Service;

import java.text.DecimalFormat;

public class FormatService {

    public String addThousandSeparator(int money) {
        // 천 단위로 쉼표를 추가할 포맷 생성
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedMoney = decimalFormat.format(money);

        return formattedMoney;
    }
}
