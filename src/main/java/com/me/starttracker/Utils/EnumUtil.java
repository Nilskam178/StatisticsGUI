package com.me.starttracker.Utils;

import com.me.starttracker.Stats.StatType;

public class EnumUtil {
    public static boolean validEnum(String str) {
        for (StatType value : StatType.values()) {
            if (value.name().equalsIgnoreCase(str))
                return true;
        }
        return false;
    }
}
