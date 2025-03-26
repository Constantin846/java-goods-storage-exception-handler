package tk.project.exceptionhandler.goodsstorage.exceptions.product.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinioUploadImageException extends RuntimeException {
    private Throwable reasonException;

    public MinioUploadImageException(String message, Throwable source) {
        super(message);
        reasonException = source;
    }

    public MinioUploadImageException(String message) {
        super(message);
    }
}
