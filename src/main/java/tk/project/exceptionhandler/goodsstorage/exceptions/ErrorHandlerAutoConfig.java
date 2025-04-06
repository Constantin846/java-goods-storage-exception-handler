package tk.project.exceptionhandler.goodsstorage.exceptions;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Configuration
@ConditionalOnExpression("${exception-handler.goods-storage.enabled:true}")
public class ErrorHandlerAutoConfig {

    @RestControllerAdvice
    private class ErrorHandlerWrapper extends ErrorHandler {
    }
}
