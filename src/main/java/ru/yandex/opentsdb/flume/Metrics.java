package ru.yandex.opentsdb.flume;

import com.yammer.metrics.core.MetricsRegistry;
import com.yammer.metrics.reporting.JmxReporter;

public class Metrics {
  public static final MetricsRegistry registry = new MetricsRegistry();
  public static final JmxReporter reporter = new JmxReporter(registry);
  static {
    reporter.start();
  }
}
