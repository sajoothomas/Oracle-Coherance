package com.oracle.education.coherence.loader;

import java.util.Map;

public interface Source extends Iterable<Map<String, ?>> {
    void beginExport();
    void endExport();
}
