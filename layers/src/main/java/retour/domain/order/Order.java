package retour.domain.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order {
    public final String orderNumber;
    public final String supplierNo;
    public final String customerNo;
    public final long amountEurCents;
}
