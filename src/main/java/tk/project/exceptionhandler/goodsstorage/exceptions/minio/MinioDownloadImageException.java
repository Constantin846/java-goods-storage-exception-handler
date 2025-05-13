package tk.project.exceptionhandler.goodsstorage.exceptions.minio;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MinioDownloadImageException extends RuntimeException {
    private final Throwable reasonException;

    public MinioDownloadImageException(final String message, final Throwable source) {
        super(message);
        reasonException = source;
    }

    public MinioDownloadImageException(final String message) {
        super(message);
        this.reasonException = new RuntimeException("Reason exception was not specified");
    }
}
