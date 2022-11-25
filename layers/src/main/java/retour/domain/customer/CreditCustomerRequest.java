package retour.domain.customer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreditCustomerRequest {
    public final String receiptNumber;
    public final String customerNumber;
    public final long amountEurCents;
    public final String orderNumber;
}
