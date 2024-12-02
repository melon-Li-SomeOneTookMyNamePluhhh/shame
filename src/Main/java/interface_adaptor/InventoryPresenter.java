package interface_adaptor;

import User_case.InventoryOutputBoundary;

public class InventoryPresenter implements InventoryOutputBoundary {
    @Override
    public void presentAddItem(String message) {
        System.out.println(message);
    }

    @Override
    public void presentRemoveItem(String message) {
        System.out.println(message);
    }
}