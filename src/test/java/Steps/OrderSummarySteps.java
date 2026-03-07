package Steps;

import Pages.OrderSummaryPage;

public class OrderSummarySteps {

    private OrderSummaryPage orderSummaryPage;

    public OrderSummarySteps(OrderSummaryPage orderSummaryPage) {
        this.orderSummaryPage = orderSummaryPage;
    }

    public void completeOrderSummary() {
        orderSummaryPage.orderSummaryDisplayed();
        orderSummaryPage.selectExpressShipping();
        orderSummaryPage.shippingValueApplied();
        orderSummaryPage.selectWarrantyOption();
        orderSummaryPage.warrantyValueApplied();
        orderSummaryPage.enterDiscountCode();
        orderSummaryPage.applyDiscountCode();
        orderSummaryPage.discountCodeApplied();
        orderSummaryPage.confirmPurchase();
    }
}
