package tk.project.exceptionhandler.goodsstorage.exceptions;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ApiError {

    private final String exceptionName;

    private final String message;

    private final Instant time;

    private final String className;
}
