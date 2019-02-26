/*
 * This file is generated by jOOQ.
 */
package com.invillia.acme.jooq;


import com.invillia.acme.jooq.tables.Order;
import com.invillia.acme.jooq.tables.OrderItem;
import com.invillia.acme.jooq.tables.OrderItemStatus;
import com.invillia.acme.jooq.tables.OrderStatus;
import com.invillia.acme.jooq.tables.Payment;
import com.invillia.acme.jooq.tables.PaymentStatus;
import com.invillia.acme.jooq.tables.Store;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>acme</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ORDER_FK_ORDER_ORDER_STATUS = Indexes0.ORDER_FK_ORDER_ORDER_STATUS;
    public static final Index ORDER_FK_ORDER_STORE = Indexes0.ORDER_FK_ORDER_STORE;
    public static final Index ORDER_PRIMARY = Indexes0.ORDER_PRIMARY;
    public static final Index ORDER_ITEM_FK_ORDER_ITEM_ORDER = Indexes0.ORDER_ITEM_FK_ORDER_ITEM_ORDER;
    public static final Index ORDER_ITEM_FK_ORDER_ITEM_ORDER_ITEM_STATUS = Indexes0.ORDER_ITEM_FK_ORDER_ITEM_ORDER_ITEM_STATUS;
    public static final Index ORDER_ITEM_PRIMARY = Indexes0.ORDER_ITEM_PRIMARY;
    public static final Index ORDER_ITEM_STATUS_PRIMARY = Indexes0.ORDER_ITEM_STATUS_PRIMARY;
    public static final Index ORDER_STATUS_PRIMARY = Indexes0.ORDER_STATUS_PRIMARY;
    public static final Index PAYMENT_FK_PAYMENT_PAYMENT_STATUS = Indexes0.PAYMENT_FK_PAYMENT_PAYMENT_STATUS;
    public static final Index PAYMENT_PRIMARY = Indexes0.PAYMENT_PRIMARY;
    public static final Index PAYMENT_STATUS_PRIMARY = Indexes0.PAYMENT_STATUS_PRIMARY;
    public static final Index STORE_PRIMARY = Indexes0.STORE_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ORDER_FK_ORDER_ORDER_STATUS = Internal.createIndex("fk_order_order_status", Order.ORDER, new OrderField[] { Order.ORDER.ID_ORDER_STATUS }, false);
        public static Index ORDER_FK_ORDER_STORE = Internal.createIndex("fk_order_store", Order.ORDER, new OrderField[] { Order.ORDER.ID_STORE }, false);
        public static Index ORDER_PRIMARY = Internal.createIndex("PRIMARY", Order.ORDER, new OrderField[] { Order.ORDER.ID }, true);
        public static Index ORDER_ITEM_FK_ORDER_ITEM_ORDER = Internal.createIndex("fk_order_item_order", OrderItem.ORDER_ITEM, new OrderField[] { OrderItem.ORDER_ITEM.ID_ORDER }, false);
        public static Index ORDER_ITEM_FK_ORDER_ITEM_ORDER_ITEM_STATUS = Internal.createIndex("fk_order_item_order_item_status", OrderItem.ORDER_ITEM, new OrderField[] { OrderItem.ORDER_ITEM.ID_ORDER_ITEM_STATUS }, false);
        public static Index ORDER_ITEM_PRIMARY = Internal.createIndex("PRIMARY", OrderItem.ORDER_ITEM, new OrderField[] { OrderItem.ORDER_ITEM.ID }, true);
        public static Index ORDER_ITEM_STATUS_PRIMARY = Internal.createIndex("PRIMARY", OrderItemStatus.ORDER_ITEM_STATUS, new OrderField[] { OrderItemStatus.ORDER_ITEM_STATUS.ID }, true);
        public static Index ORDER_STATUS_PRIMARY = Internal.createIndex("PRIMARY", OrderStatus.ORDER_STATUS, new OrderField[] { OrderStatus.ORDER_STATUS.ID }, true);
        public static Index PAYMENT_FK_PAYMENT_PAYMENT_STATUS = Internal.createIndex("fk_payment_payment_status", Payment.PAYMENT, new OrderField[] { Payment.PAYMENT.ID_PAYMENT_STATUS }, false);
        public static Index PAYMENT_PRIMARY = Internal.createIndex("PRIMARY", Payment.PAYMENT, new OrderField[] { Payment.PAYMENT.ID }, true);
        public static Index PAYMENT_STATUS_PRIMARY = Internal.createIndex("PRIMARY", PaymentStatus.PAYMENT_STATUS, new OrderField[] { PaymentStatus.PAYMENT_STATUS.ID }, true);
        public static Index STORE_PRIMARY = Internal.createIndex("PRIMARY", Store.STORE, new OrderField[] { Store.STORE.ID }, true);
    }
}