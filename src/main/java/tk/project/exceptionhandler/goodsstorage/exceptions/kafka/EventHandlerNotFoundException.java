package tk.project.exceptionhandler.goodsstorage.exceptions.kafka;

public class EventHandlerNotFoundException extends RuntimeException {
    public EventHandlerNotFoundException(String message) {
        super(message);
    }
}
