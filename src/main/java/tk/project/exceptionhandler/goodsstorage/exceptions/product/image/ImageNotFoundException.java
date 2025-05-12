package tk.project.exceptionhandler.goodsstorage.exceptions.product.image;

import tk.project.exceptionhandler.goodsstorage.exceptions.EntityNotFoundException;

public class ImageNotFoundException extends EntityNotFoundException {
    public ImageNotFoundException(final String message) {
        super(message);
    }
}
