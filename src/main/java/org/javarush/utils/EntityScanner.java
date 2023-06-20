package org.javarush.utils;

import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Set;

public class EntityScanner {

    public static Set<Class<?>> getEntities(){
        Reflections reflections = new Reflections("org.javarush.entity");
        return reflections.getTypesAnnotatedWith(Entity.class);
    }
}
