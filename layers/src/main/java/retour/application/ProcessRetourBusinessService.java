package retour.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retour.domain.customer.CreditCustomerDomainService;
import retour.domain.customer.CreditCustomerRequest;
import retour.domain.order.Order;
import retour.domain.order.OrderDomainService;
import retour.domain.payment.PaymentDomainService;
import retour.domain.supplier.DebitSupplierDomainService;
import retour.domain.supplier.DebitSupplierRequest;

@Service
public class ProcessRetourBusinessService {
    @Autowired
    private CreditCustomerDomainService creditCustomerDomainService;
    @Autowired
    private DebitSupplierDomainService debitSupplierDomainService;
    @Autowired
    private OrderDomainService orderDomainService;
    @Autowired
    private PaymentDomainService paymentDomainService;

    public ProcessRetoureResponse process(ProcessRetoureRequest request) {
        Order order = this.orderDomainService.getOrder(request.orderNumber);

        String receiptNumber = paymentDomainService.generateReceiptNumber();
        if (paymentDomainService.isCustomerCharged(order.orderNumber)) {
            refundCustomer(order, receiptNumber);
        }

        chargeSupplier(order, receiptNumber);

        return new ProcessRetoureResponse(receiptNumber);
    }

    private void chargeSupplier(Order order, String receiptNumber) {
        this.debitSupplierDomainService.debitSupplier(new DebitSupplierRequest(receiptNumber, order.supplierNo, order.amountEurCents, order.orderNumber));
    }

    private void refundCustomer(Order order, String receiptNumber) {
        this.creditCustomerDomainService.creditCustomer(new CreditCustomerRequest(receiptNumber, order.customerNo, order.amountEurCents, order.orderNumber));
    }
}
