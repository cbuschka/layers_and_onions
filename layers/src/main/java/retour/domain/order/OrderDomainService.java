package retour.domain.order;

import org.springframework.stereotype.Service;

@Service
public class OrderDomainService {
    public Order getOrder(String orderNumber) {
        return new Order(orderNumber, "supplierNo", "customerNo", 1235L);
    }
}
