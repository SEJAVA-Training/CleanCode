package com.trainging.reports.common;

public interface Collector<P, K> {

    P collect(K key);
}