package tk.project.exceptionhandler.goodsstorage.exceptions;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tk.project.exceptionhandler.goodsstorage.exceptions.customer.LoginExistsException;
import tk.project.exceptionhandler.goodsstorage.exceptions.customer.RequestFindAccountNumberException;
import tk.project.exceptionhandler.goodsstorage.exceptions.customer.RequestFindInnException;
import tk.project.exceptionhandler.goodsstorage.exceptions.kafka.EventHandlerNotFoundException;
import tk.project.exceptionhandler.goodsstorage.exceptions.kafka.KafkaConsumerJsonProcessingFoundException;
import tk.project.exceptionhandler.goodsstorage.exceptions.minio.MinioDownloadImageException;
import tk.project.exceptionhandler.goodsstorage.exceptions.minio.MinioUploadImageException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderNotAccessException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusAlreadyCancelledException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusAlreadyRejectedException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusNotCreatedException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.OrderStatusNotProcessingException;
import tk.project.exceptionhandler.goodsstorage.exceptions.order.RequestConfirmOrderToOrchestratorException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ArticleExistsException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.OperationNotDefinedByStringException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductCountNotEnoughException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductNotAvailableException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductSpecificationException;
import tk.project.exceptionhandler.goodsstorage.exceptions.product.ProductsNotFoundByIdsException;

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
    public ResponseEntity<ApiError> handlerArticleExistsException(final ArticleExistsException e) {
        String message = Optional.ofNullable(e.getExistedProductId())
                .map(id -> e.getMessage() + " And product id: " + id)
                .orElseGet(e::getMessage);

        return createApiError(e, message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(LoginExistsException.class)
    public ResponseEntity<ApiError> handlerLoginExistsException(final LoginExistsException e) {
        String message = Optional.ofNullable(e.getExistedCustomerId())
                .map(id -> e.getMessage() + " And customer id: " + id)
                .orElseGet(e::getMessage);

        return createApiError(e, message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handlerValidException(final MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        Set<String> messages = new HashSet<>();

        for (FieldError fieldError : fieldErrors) {
            String message = fieldError != null ? fieldError.getDefaultMessage() : INTERNAL_SERVER_ERROR;
            message = message != null ? message : INTERNAL_SERVER_ERROR;
            messages.add(message);
        }
        String message = String.join(DELIMITER, messages);

        return createApiError(e, message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EventHandlerNotFoundException.class)
    public ResponseEntity<ApiError> handlerEventHandlerNotFoundException(final EventHandlerNotFoundException e) {
        return createApiError(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(KafkaConsumerJsonProcessingFoundException.class)
    public ResponseEntity<ApiError> handlerKafkaConsumerJsonProcessingFoundException(final KafkaConsumerJsonProcessingFoundException e) {
        return createApiError(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OperationNotDefinedByStringException.class)
    public ResponseEntity<ApiError> handlerOperationNotDefinedBySymbolException(final OperationNotDefinedByStringException e) {
        return createApiError(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductSpecificationException.class)
    public ResponseEntity<ApiError> handlerProductSpecificationException(final ProductSpecificationException e) {
        return createApiError(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductsNotFoundByIdsException.class)
    public ResponseEntity<ApiError> handlerProductsNotFoundByIdsException(final ProductsNotFoundByIdsException e) {
        return createApiError(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductCountNotEnoughException.class)
    public ResponseEntity<ApiError> handlerProductNotEnoughException(final ProductCountNotEnoughException e) {
        return createApiError(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<ApiError> handlerProductNotAvailableException(final ProductNotAvailableException e) {
        return createApiError(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OrderStatusNotCreatedException.class)
    public ResponseEntity<ApiError> handlerOrderStatusNotCreateException(final OrderStatusNotCreatedException e) {
        return createApiError(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OrderStatusNotProcessingException.class)
    public ResponseEntity<ApiError> handlerOrderStatusNotProcessingException(final OrderStatusNotProcessingException e) {
        return createApiError(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OrderStatusAlreadyCancelledException.class)
    public ResponseEntity<ApiError> handlerOrderStatusAlreadyCancelledException(final OrderStatusAlreadyCancelledException e) {
        return createApiError(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OrderStatusAlreadyRejectedException.class)
    public ResponseEntity<ApiError> handlerOrderStatusAlreadyRejectedException(final OrderStatusAlreadyRejectedException e) {
        return createApiError(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OrderNotAccessException.class)
    public ResponseEntity<ApiError> handlerOrderNotAccessException(final OrderNotAccessException e) {
        return createApiError(e, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RequestFindAccountNumberException.class)
    public ResponseEntity<ApiError> handlerRequestFindAccountNumberException(final RequestFindAccountNumberException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestConfirmOrderToOrchestratorException.class)
    public ResponseEntity<ApiError> handlerRequestConfirmOrderToOrchestratorException(final RequestConfirmOrderToOrchestratorException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestFindInnException.class)
    public ResponseEntity<ApiError> handlerRequestFindInnException(final RequestFindInnException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MinioDownloadImageException.class)
    public ResponseEntity<ApiError> handlerMinioDownloadImageException(final MinioDownloadImageException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MinioUploadImageException.class)
    public ResponseEntity<ApiError> handlerMinioUploadImageException(final MinioUploadImageException e) {
        String message = String.join(DELIMITER, e.getMessage(), e.getReasonException().getMessage());
        return createApiError(e, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handlerEntityNotFoundException(final EntityNotFoundException e) {
        return createApiError(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handlerThrowable(final Throwable e) {
        String message = INTERNAL_SERVER_ERROR;
        log.warn(message, e);
        return createApiError(e, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiError> createApiError(final Throwable e, final HttpStatus status) {
        return createApiError(e, e.getMessage(), status);
    }

    private ResponseEntity<ApiError> createApiError(final Throwable e, final String message, final HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(
                        ApiError.builder()
                                .exceptionName(e.getClass().getSimpleName())
                                .message(message)
                                .time(Instant.now())
                                .className(e.getStackTrace()[ZERO].getFileName())
                                .build()
                );
    }
}