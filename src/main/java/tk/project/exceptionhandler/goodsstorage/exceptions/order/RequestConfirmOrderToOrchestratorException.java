package tk.project.exceptionhandler.goodsstorage.exceptions.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestConfirmOrderToOrchestratorException extends RuntimeException {
    private Throwable reasonException;

    public RequestConfirmOrderToOrchestratorException(String message, Throwable e) {
        super(message);
        reasonException = e;
    }

    public RequestConfirmOrderToOrchestratorException(String message) {
        super(message);
    }
}
