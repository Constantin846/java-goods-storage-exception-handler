package tk.project.exceptionhandler.goodsstorage.exceptions.order;

import lombok.Getter;
import lombok.Setter;

@Getter
public class RequestConfirmOrderToOrchestratorException extends RuntimeException {
    private final Throwable reasonException;

    public RequestConfirmOrderToOrchestratorException(final String message, final Throwable e) {
        super(message);
        reasonException = e;
    }

    public RequestConfirmOrderToOrchestratorException(final String message) {
        super(message);
        this.reasonException = new RuntimeException("Reason exception was not specified");
    }
}
