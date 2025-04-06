package tk.project.exceptionhandler.goodsstorage.exceptions.product;

import tk.project.exceptionhandler.goodsstorage.exceptions.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
