package com.me.starttracker.Utils;

import org.bukkit.entity.EntityType;

public class EntityUtil {

    public static boolean ValidEntity(String mobName) {
        EntityType type = null;

        try{
            type = EntityType.valueOf(mobName);
        }catch(IllegalArgumentException exp){
            return false;
        }

        return true;
    }
}
