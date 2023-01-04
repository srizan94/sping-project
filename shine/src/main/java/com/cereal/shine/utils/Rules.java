package com.cereal.shine.utils;

import java.util.List;

public class Rules {

    private List<UEvent> event1;

    private List<UEvent> event2;

    public List<UEvent> getEvent1() {
        return event1;
    }

    public void setEvent1(List<UEvent> event1) {
        this.event1 = event1;
    }

    public List<UEvent> getEvent2() {
        return event2;
    }

    public void setEvent2(List<UEvent> event2) {
        this.event2 = event2;
    }

    @Override
    public String toString() {
        return "Rules{" +
                "event1=" + event1 +
                ", event2=" + event2 +
                '}';
    }
}
