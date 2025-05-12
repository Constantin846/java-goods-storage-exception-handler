package tk.project.exceptionhandler.goodsstorage.exceptions.customer;

import tk.project.exceptionhandler.goodsstorage.exceptions.EntityNotFoundException;

public class CustomerNotFoundException extends EntityNotFoundException {
    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
