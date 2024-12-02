package interface_adaptor;

import User_case.InventoryUseCase.InventoryOutputBoundaryInterface;

public class InventoryPresenterInterface implements InventoryOutputBoundaryInterface {
    @Override
    public void presentAddItem(String message) {
        System.out.println(message);
    }

    @Override
    public void presentRemoveItem(String message) {
        System.out.println(message);
    }
}