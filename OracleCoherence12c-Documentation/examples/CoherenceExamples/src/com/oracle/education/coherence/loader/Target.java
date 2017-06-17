package com.oracle.education.coherence.loader;


import java.util.Map;


public interface Target {
    void beginImport();
    void importItem(Map<String, ?> item);
    void endImport();
}
