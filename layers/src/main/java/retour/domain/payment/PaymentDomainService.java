package retour.domain.payment;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PaymentDomainService {

    private final AtomicInteger seq = new AtomicInteger(10);

    public boolean isCustomerCharged(String orderNumber) {
        return false;
    }

    public String generateReceiptNumber() {
        return String.valueOf(seq.getAndIncrement());
    }
}
