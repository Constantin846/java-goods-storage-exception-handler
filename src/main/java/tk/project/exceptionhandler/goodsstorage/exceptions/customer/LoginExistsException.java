package tk.project.exceptionhandler.goodsstorage.exceptions.customer;

import lombok.Getter;

@Getter
public class LoginExistsException extends RuntimeException {
    private final Long existedCustomerId;

    public LoginExistsException(final String message, final Long existedCustomerId) {
        super(message);
        this.existedCustomerId = existedCustomerId;
    }
}
