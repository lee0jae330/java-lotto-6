package controller;

import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.Price;
import domain.repository.LottoRepository;
import view.InputView;
import view.OutputView;

public class LottoController {

    private Price price;
    private LottoRepository lottoRepository = new LottoRepository();
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public void run() {

    private void createLotto() {
        for(int i=0;i<price.numOfLotto();i++) {
            lottoRepository.save(new Lotto(lottoNumberGenerator.createLottoNumber()));
        }
    }

    private void printNumOfLotto(int number) {
        OutputView.printEmptyLine();
        OutputView.printNumOfLotto(number);
    }

    private void getPriceByUserInput() {
        try {
            int input = InputView.enterPrice();
            price = new Price(input);
        } catch (IllegalArgumentException e) {
            getPriceByUserInput();
        }
    }
}
