/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.logic;

/**
 *
 * @author staszek
 */
public class CanNotLoginUserException extends Exception {

    public CanNotLoginUserException() {
    }

    public CanNotLoginUserException(String text) {
        super(text);
    }

}
