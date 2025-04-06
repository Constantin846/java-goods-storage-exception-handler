package tk.project.exceptionhandler.goodsstorage.exceptions.product.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinioDownloadImageException extends RuntimeException {
    private Throwable reasonException;

    public MinioDownloadImageException(String message, Throwable source) {
        super(message);
        reasonException = source;
    }

    public MinioDownloadImageException(String message) {
        super(message);
    }
}
