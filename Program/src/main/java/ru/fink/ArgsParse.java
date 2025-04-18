package ru.fink;

import java.util.HashMap;
import java.util.Map;

public class ArgsParse {

    private final Map<String, String> argsMap = new HashMap<>();

    public ArgsParse(String[] args) {
        if (args.length % 2 != 0) {
            throw new IllegalArgumentException("Неверное количество аргументов. Ожидается ключ-значение.");
        }

        for (int i = 0; i < args.length; i += 2) {
            argsMap.put(args[i], args[i + 1]);
        }
    }

    public String getRequiredArg(String key) {
        String value = argsMap.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Не указан обязательный параметр: " + key);
        }
        return value;
    }
}
