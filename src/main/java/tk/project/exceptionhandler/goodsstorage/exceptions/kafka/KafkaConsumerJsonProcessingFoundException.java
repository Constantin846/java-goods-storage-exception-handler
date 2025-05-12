package tk.project.exceptionhandler.goodsstorage.exceptions.kafka;

public class KafkaConsumerJsonProcessingFoundException extends RuntimeException {
    public KafkaConsumerJsonProcessingFoundException(final String message) {
        super(message);
    }
}
