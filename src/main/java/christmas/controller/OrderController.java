package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void run() {
        outputView.printIntroduction();
        int date = inputView.readDate();

    }
}
