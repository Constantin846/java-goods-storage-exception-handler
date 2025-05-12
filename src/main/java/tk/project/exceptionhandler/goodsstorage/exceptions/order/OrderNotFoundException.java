package tk.project.exceptionhandler.goodsstorage.exceptions.order;

import tk.project.exceptionhandler.goodsstorage.exceptions.EntityNotFoundException;

public class OrderNotFoundException extends EntityNotFoundException {
    public OrderNotFoundException(final String message) {
        super(message);
    }
}
