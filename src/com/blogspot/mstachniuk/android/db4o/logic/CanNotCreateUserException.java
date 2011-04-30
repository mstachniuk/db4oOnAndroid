/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.logic;

/**
 *
 * @author staszek
 */
public class CanNotCreateUserException extends Exception {

    public CanNotCreateUserException() {
    }

    public CanNotCreateUserException(String text) {
        super(text);
    }

}
