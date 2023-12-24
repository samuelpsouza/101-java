package dev.ssouza.javamodules.domain.dto;

import java.io.Serializable;
import java.util.Map;

public class RequestData {
    private final Map<String, ? extends Serializable> data;

    public RequestData(final Map<String, ? extends Serializable> data) {
        this.data = data;
    }

    public Map<String, ? extends Serializable> getData() {
        return data;
    }
}
