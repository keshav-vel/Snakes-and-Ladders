package app.src.main.logger;

public class TerminalLogger implements Logger {
    public void log(String message) {
        System.out.println(message);
    }
}