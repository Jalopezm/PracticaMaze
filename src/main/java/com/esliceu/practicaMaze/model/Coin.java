package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.CoinService;

public class Coin extends CoinService implements Item{

    @Override
    public String toString() {
        return "Coin";
    }
}
