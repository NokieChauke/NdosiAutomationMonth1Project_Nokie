package Steps;

import Pages.InvoicePage;

public class InvoiceSteps {

    private InvoicePage invoicePage;

    public InvoiceSteps(InvoicePage invoicePage) {
        this.invoicePage = invoicePage;
    }

    public void verifyInvoice() {
        invoicePage.purchaseSuccessToastDisplayed();
        invoicePage.clickViewInvoice();
        invoicePage.invoiceHistoryPanelDisplayed();
        invoicePage.clickViewInvoiceDetails();
        invoicePage.invoiceDetailsDisplayed();
    }
}
