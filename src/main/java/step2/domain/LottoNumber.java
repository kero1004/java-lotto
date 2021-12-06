package step2.domain;

import step2.exception.NotValidLottoNumber;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validNumberOrElseThrow(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String winningNumberText) throws NumberFormatException {
        this(Integer.parseInt(winningNumberText));
    }

    private void validNumberOrElseThrow(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new NotValidLottoNumber();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
