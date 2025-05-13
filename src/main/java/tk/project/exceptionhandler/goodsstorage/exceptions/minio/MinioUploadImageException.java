package tk.project.exceptionhandler.goodsstorage.exceptions.minio;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MinioUploadImageException extends RuntimeException {
    private final Throwable reasonException;

    public MinioUploadImageException(final String message, final Throwable source) {
        super(message);
        reasonException = source;
    }

    public MinioUploadImageException(final String message) {
        super(message);
        this.reasonException = new RuntimeException("Reason exception was not specified");
    }
}
