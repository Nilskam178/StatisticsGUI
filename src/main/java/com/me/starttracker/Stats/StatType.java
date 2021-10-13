package com.me.starttracker.Stats;

public enum StatType {
    MINE("mined"),
    KILL("killed");

    public String statString;

    StatType(String statString) { this.statString = statString; }
}
