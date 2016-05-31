package com.niekenerik;

import com.niekenerik.interfaces.IWritter;

/**
 * Created by niek on 31-5-2016.
 */
public class LineWritter implements IWritter {
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
