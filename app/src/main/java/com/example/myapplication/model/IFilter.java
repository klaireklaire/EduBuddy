package com.example.myapplication.model;

import java.util.HashSet;

/**
 * An interface specifying the operations of a filter object.
 *
 * @author Klaire Pham & Khanh Le
 * @version 2022.03.03
 */

public interface IFilter {

    /**
     * Return a new set of users that only contains users that match the filters' conditions
     * @param users - the User set being filtered
     * @return a new set of users
     */
    HashSet<User> filter(HashSet<User> users);

}
