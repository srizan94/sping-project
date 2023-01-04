package com.cereal.shine.utils;

public class Key {

    private String code;

    private String reason;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Key{" +
                "code='" + code + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
