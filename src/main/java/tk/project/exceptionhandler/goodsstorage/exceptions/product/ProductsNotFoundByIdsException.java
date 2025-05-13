package tk.project.exceptionhandler.goodsstorage.exceptions.product;

import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class ProductsNotFoundByIdsException extends RuntimeException {
    private final Set<UUID> notFoundProductIds;

    public ProductsNotFoundByIdsException(final String message, final Collection<UUID> notFoundProductIds) {
        super(message);
        this.notFoundProductIds = new HashSet<>(notFoundProductIds);
    }
}
