package retour.domain.supplier;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DebitSupplierRequest {
    public final String receiptNumber;
    public final String supplierNumber;
    public final long amountEurCents;
    public final String orderItemNumber;
}
