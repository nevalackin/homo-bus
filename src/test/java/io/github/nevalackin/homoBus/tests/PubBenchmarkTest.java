package io.github.nevalackin.homoBus.tests;

import io.github.nevalackin.homoBus.bus.Bus;
import io.github.nevalackin.homoBus.bus.impl.EventBus;
import io.github.nevalackin.homoBus.annotations.EventLink;
import io.github.nevalackin.homoBus.Listener;
import org.junit.Test;

public final class PubBenchmarkTest {

    private static final Object PLACEHOLDER = new Object();

    @EventLink
    public final Listener<Object> emptyListener = event -> {
    };

    @Test
    public void benchmark() {
        final Bus<Object> bus = new EventBus<>();

        bus.subscribe(this);

        final long preTests = System.currentTimeMillis();

        for (int i = 1_000_000; i > 0; --i) {
            bus.post(PLACEHOLDER);
        }

        final long postTests = System.currentTimeMillis();

        System.out.printf("1,000,000 event calls took %sms\n",
                          postTests - preTests);
    }
}
