package tk.project.exceptionhandler.goodsstorage.exceptions;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import tk.project.exceptionhandler.goodsstorage.exceptions.customer.LoginExistsException;
import tk.project.exceptionhandler.goodsstorage.exceptions.customer.RequestFindAccountNumberException;
import tk.project.exceptionhandler.goodsstorage.exceptions.customer.RequestFindInnException;
import tk.project.exceptionhandler.goodsstorage.exceptions.kafka.EventHandlerNotFoundException;
import tk.project.exceptionhandler.goodsstorage.exceptions.kafka.KafkaConsumerJsonProcessingFoundException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderNotAccessException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusAlreadyCancelledException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusAlreadyRejectedException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusNotCreateException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusNotProcessingException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.RequestConfirmOrderToOrchestratorException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ArticleExistsException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.OperationNotDefinedByStringException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductCountNotEnoughException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductNotAvailableException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductSpecificationException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductsNotFoundByIdsException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.image.MinioDownloadImageException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.image.MinioUploadImageException;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
public class ErrorHandler {
    private static final int ZERO = 0;
    private static final String INTERNAL_SERVER_ERROR = "Internal server error";
    private static final String DELIMITER = "; ";

    @PostConstruct
    public void init() {
        log.info("ErrorHandler initialized");
    }

    @ExceptionHandler(ArticleExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerArticleExistsException(final ArticleExistsException e) {
        String message = Optional.ofNullable(e.getExistedProductId())
                .map(id -> e.getMessage() + " And product id: " + id)
                .orElseGet(e::getMessage);

        return createApiError(e, message);
    }

    @ExceptionHandler(LoginExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerLoginExistsException(final LoginExistsException e) {
        String message = Optional.ofNullable(e.getExistedCustomerId())
                .map(id -> e.getMessage() + " And customer id: " + id)
                .orElseGet(e::getMessage);

        return createApiError(e, message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handlerValidException(final MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        Set<String> messages = new HashSet<>();

        for (FieldError fieldError : fieldErrors) {
            String message = fieldError != null ? fieldError.getDefaultMessage() : INTERNAL_SERVER_ERROR;
            message = message != null ? message : INTERNAL_SERVER_ERROR;
            messages.add(message);
        }
        String message = String.join(DELIMITER, messages);

        return createApiError(e, message);
    }

    @ExceptionHandler(EventHandlerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handlerEventHandlerNotFoundException(final EventHandlerNotFoundException e) {
        return createApiError(e);
    }

    @ExceptionHandler(KafkaConsumerJsonProcessingFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handlerKafkaConsumerJsonProcessingFoundException(final KafkaConsumerJsonProcessingFoundException e) {
        return createApiError(e);
    }

    @ExceptionHandler(OperationNotDefinedByStringException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handlerOperationNotDefinedBySymbolException(final OperationNotDefinedByStringException e) {
        return createApiError(e);
    }

    @ExceptionHandler(ProductSpecificationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handlerProductSpecificationException(final ProductSpecificationException e) {
        return createApiError(e);
    }

    @ExceptionHandler(ProductsNotFoundByIdsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handlerProductsNotFoundByIdsException(final ProductsNotFoundByIdsException e) {
        return createApiError(e);
    }

    @ExceptionHandler(ProductCountNotEnoughException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerProductNotEnoughException(final ProductCountNotEnoughException e) {
        return createApiError(e);
    }

    @ExceptionHandler(ProductNotAvailableException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerProductNotAvailableException(final ProductNotAvailableException e) {
        return createApiError(e);
    }

    @ExceptionHandler(OrderStatusNotCreateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerOrderStatusNotCreateException(final OrderStatusNotCreateException e) {
        return createApiError(e);
    }

    @ExceptionHandler(OrderStatusNotProcessingException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerOrderStatusNotProcessingException(final OrderStatusNotProcessingException e) {
        return createApiError(e);
    }

    @ExceptionHandler(OrderStatusAlreadyCancelledException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerOrderStatusAlreadyCancelledException(final OrderStatusAlreadyCancelledException e) {
        return createApiError(e);
    }

    @ExceptionHandler(OrderStatusAlreadyRejectedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handlerOrderStatusAlreadyRejectedException(final OrderStatusAlreadyRejectedException e) {
        return createApiError(e);
    }

    @ExceptionHandler(OrderNotAccessException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ApiError> handlerOrderNotAccessException(final OrderNotAccessException e) {
        return createApiError(e);
    }

    @ExceptionHandler(RequestFindAccountNumberException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handlerRequestFindAccountNumberException(final RequestFindAccountNumberException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message);
    }

    @ExceptionHandler(RequestConfirmOrderToOrchestratorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handlerRequestConfirmOrderToOrchestratorException(final RequestConfirmOrderToOrchestratorException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message);
    }

    @ExceptionHandler(RequestFindInnException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handlerRequestFindInnException(final RequestFindInnException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message);
    }

    @ExceptionHandler(MinioDownloadImageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handlerMinioDownloadImageException(final MinioDownloadImageException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message);
    }

    @ExceptionHandler(MinioUploadImageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handlerMinioUploadImageException(final MinioUploadImageException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handlerEntityNotFoundException(final EntityNotFoundException e) {
        return createApiError(e);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handlerThrowable(final Throwable e) {
        String message = INTERNAL_SERVER_ERROR;
        log.warn(message, e);
        return createApiError(e, message);
    }

    private ResponseEntity<ApiError> createApiError(final Throwable e) {
        return createApiError(e, e.getMessage());
    }

    private ResponseEntity<ApiError> createApiError(final Throwable e, final String message) {
        ApiError apiError = new ApiError(e.getClass().getSimpleName(), message,
                Instant.now(), e.getStackTrace()[ZERO].getFileName());
        return ResponseEntity.ofNullable(apiError);
    }
}