package step2.domain;

import step2.exception.MoneyException;
import step2.exception.NotEnoughMoney;

import java.util.Objects;

public class Money {
    private static final int BASE_PRICE = 1000;
    private static final int ZERO = 0;
    private final long amount;

    public Money(long price) {
        validMoneyOrElseThrow(price);

        this.amount = price;
    }

    public Money() {
        this(ZERO);
    }

    public Money addMoney(Money otherMoney) {
        return new Money(this.amount + otherMoney.amount);
    }

    public WinningRate calculatePercent(Money otherMoney) {
        return new WinningRate(this.amount / (float)otherMoney.amount);
    }

    public Ticket purchasedTicket() {
        enoughMoneyOrElseThrow();

        return new Ticket(this.amount / BASE_PRICE);
    }

    private void enoughMoneyOrElseThrow() {
        if (this.amount < BASE_PRICE) {
            throw new NotEnoughMoney();
        }
    }

    private void validMoneyOrElseThrow(long price) {
        if (price < ZERO) {
            throw new MoneyException(MoneyException.ErrorCode.MONEY_NOT_ZERO);
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
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

}
