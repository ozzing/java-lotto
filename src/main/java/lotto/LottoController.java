package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.global.Message;
import lotto.util.RandomNumberGenerator;

public class LottoController {

    private LottoInput lottoInput = new LottoInput();

    public Integer getUserLottoCount() {
        UserInput userInput = new UserInput();

        Message.GAME_INPUT.print();
        Integer userMoney = userInput.getUserInput();
        return userMoney / 1000;
    }

    public List<Lotto> issueLotto(Integer lottoCount) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        List<Lotto> issuedLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = randomNumberGenerator.generateRandomNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            issuedLotto.add(lotto);
        }

        return issuedLotto;
    }

    public void showIssueResult(List<Lotto> issuedLotto) {
        System.out.print("\n" + issuedLotto.size());
        Message.GAME_ISSUE.print();
        issuedLotto.stream().forEach(lotto -> lotto.print());
        System.out.println();
    }

    public Lotto getLottoInput() {
        Message.LOTTO_INPUT.print();
        List<Integer> lottoNumbers = lottoInput.getLottoInput();
        Lotto lotto = new Lotto(lottoNumbers);
        System.out.println();
        return lotto;
    }

    public Integer getBonusInput() {
        Message.BONUS_INPUT.print();
        Integer bonus = lottoInput.getBonusInput();
        System.out.println();
        return bonus;
    }

}
