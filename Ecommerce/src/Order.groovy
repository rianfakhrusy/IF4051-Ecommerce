/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Husni
 */
import groovy.transform.Canonical

@Canonical
class Order {
    List<Tuple<Product, Integer>> items = []
    Date date
    String orderStatus, orderType, address
    Shipment shipment
}

