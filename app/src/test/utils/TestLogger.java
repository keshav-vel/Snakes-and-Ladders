package app.src.test.utils;

import app.src.main.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class TestLogger implements Logger {

    List<String> logs = new ArrayList<>();

    @Override
    public void log(String message) {
        logs.add(message);
    }

    public String messageAt(int index) {
        return logs.get(index);
    }

    public int size() {
        return logs.size();
    }
}
