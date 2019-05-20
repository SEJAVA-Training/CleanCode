package com.trainging.reports.common;

public interface Report<K> {

    String generateReport(K key);
}
