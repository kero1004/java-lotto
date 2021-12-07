package step2.domain;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<LottoNumber> lottoTicket;

    public LottoTicket(Set<LottoNumber> lottoTicker) {
        this.lottoTicket = lottoTicker;
    }

    public long containsWinningNumber(Set<LottoNumber> winningNumbers) {
        return winningNumbers.stream()
                .filter(number -> lottoTicket.contains(number))
                .collect(Collectors.counting());
    }

    public long matchedWinningNumber(MatchedNumber matchedNumber) {
        return this.lottoTicket.stream()
                .filter(number -> number.matchedWinningNumber(matchedNumber))
                .count();
    }

    public Set<LottoNumber> lottoTicket() {
        return Collections.unmodifiableSet(lottoTicket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }

}
