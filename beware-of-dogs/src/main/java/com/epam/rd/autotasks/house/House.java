package com.epam.rd.autotasks.house;

import java.util.ArrayList;
import java.util.List;

public class House<Type> {

    private final List<Type> residents = new ArrayList<>();

    public void enter(Type resident) {
        residents.add(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}
