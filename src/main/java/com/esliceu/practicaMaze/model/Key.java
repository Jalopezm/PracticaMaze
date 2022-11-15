package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.KeyService;

public class Key extends KeyService implements Item{
    private String name;

    public Key(String name){
        this.name = name;
    }

}
