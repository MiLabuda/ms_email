package com.wszib.mail.infrastructure.utils;

import java.util.Random;
public final class IdGenerator {
    public static Long generateId() {
        final long MAX_ID = 900_000_000L;
        final long RANGE = MAX_ID + 1;
        Random random = new Random();
        return (long) (random.nextDouble() * RANGE);
    }
}
