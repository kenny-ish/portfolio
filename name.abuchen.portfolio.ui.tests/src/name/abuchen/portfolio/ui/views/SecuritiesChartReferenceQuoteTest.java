package name.abuchen.portfolio.ui.views;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;

import org.junit.Test;

public class SecuritiesChartReferenceQuoteTest
{
    @Test
    public void testPurchasePriceIsUsedIfAvailable()
    {
        double reference = SecuritiesChart.getAxisReferenceQuote(Optional.of(42.5), 100d);

        assertThat(reference, is(42.5));
    }

    @Test
    public void testFirstQuoteIsUsedIfNoPurchasePriceIsAvailable()
    {
        // a security without purchases must fall back to the first quote of
        // the interval instead of keeping the reference of the previously
        // displayed security
        double reference = SecuritiesChart.getAxisReferenceQuote(Optional.empty(), 100d);

        assertThat(reference, is(100d));
    }
}
