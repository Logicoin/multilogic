package org.multibit.controller;

import org.multibit.model.logicoin.WalletBusyListener;

public class SimpleWalletBusyListener implements WalletBusyListener {
    boolean walletBusy = false;

    @Override
    public void walletBusyChange(boolean newWalletIsBusy) {
        walletBusy = newWalletIsBusy;
    }

    boolean isWalletBusy() {
        return walletBusy;
    }
}
