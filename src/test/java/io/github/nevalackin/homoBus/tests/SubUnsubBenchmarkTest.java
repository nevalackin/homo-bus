package io.github.nevalackin.homoBus.tests;

import io.github.nevalackin.homoBus.bus.Bus;
import io.github.nevalackin.homoBus.bus.impl.EventBus;
import org.junit.Test;

public final class SubUnsubBenchmarkTest {

    @Test
    public void benchmark() {
        final Bus<Object> bus = new EventBus<>();

        final long preTests = System.currentTimeMillis();

        for (int i = 1_000_000; i > 0; --i) {
            bus.subscribe(this);
            bus.unsubscribe(this);
        }

        final long postTests = System.currentTimeMillis();

        System.out.printf("1,000,000 sub/unsubs took %sms\n",
                          postTests - preTests);
    }
}
