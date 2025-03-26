package tk.project.exceptionhandler.goodsstorage.exceptions.product.image;

import tk.project.exceptionhandler.goodsstorage.exceptions.EntityNotFoundException;

public class ImageNotFoundException extends EntityNotFoundException {
    public ImageNotFoundException(String message) {
        super(message);
    }
}
