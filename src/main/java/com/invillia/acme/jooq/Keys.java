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
import com.invillia.acme.jooq.tables.records.OrderItemRecord;
import com.invillia.acme.jooq.tables.records.OrderItemStatusRecord;
import com.invillia.acme.jooq.tables.records.OrderRecord;
import com.invillia.acme.jooq.tables.records.OrderStatusRecord;
import com.invillia.acme.jooq.tables.records.PaymentRecord;
import com.invillia.acme.jooq.tables.records.PaymentStatusRecord;
import com.invillia.acme.jooq.tables.records.StoreRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>acme</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<OrderRecord, Integer> IDENTITY_ORDER = Identities0.IDENTITY_ORDER;
    public static final Identity<OrderItemRecord, Integer> IDENTITY_ORDER_ITEM = Identities0.IDENTITY_ORDER_ITEM;
    public static final Identity<StoreRecord, Integer> IDENTITY_STORE = Identities0.IDENTITY_STORE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<OrderRecord> KEY_ORDER_PRIMARY = UniqueKeys0.KEY_ORDER_PRIMARY;
    public static final UniqueKey<OrderItemRecord> KEY_ORDER_ITEM_PRIMARY = UniqueKeys0.KEY_ORDER_ITEM_PRIMARY;
    public static final UniqueKey<OrderItemStatusRecord> KEY_ORDER_ITEM_STATUS_PRIMARY = UniqueKeys0.KEY_ORDER_ITEM_STATUS_PRIMARY;
    public static final UniqueKey<OrderStatusRecord> KEY_ORDER_STATUS_PRIMARY = UniqueKeys0.KEY_ORDER_STATUS_PRIMARY;
    public static final UniqueKey<PaymentRecord> KEY_PAYMENT_PRIMARY = UniqueKeys0.KEY_PAYMENT_PRIMARY;
    public static final UniqueKey<PaymentStatusRecord> KEY_PAYMENT_STATUS_PRIMARY = UniqueKeys0.KEY_PAYMENT_STATUS_PRIMARY;
    public static final UniqueKey<StoreRecord> KEY_STORE_PRIMARY = UniqueKeys0.KEY_STORE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<OrderRecord, OrderStatusRecord> ORDER_IBFK_1 = ForeignKeys0.ORDER_IBFK_1;
    public static final ForeignKey<OrderRecord, StoreRecord> ORDER_IBFK_2 = ForeignKeys0.ORDER_IBFK_2;
    public static final ForeignKey<OrderItemRecord, OrderItemStatusRecord> ORDER_ITEM_IBFK_1 = ForeignKeys0.ORDER_ITEM_IBFK_1;
    public static final ForeignKey<OrderItemRecord, StoreRecord> ORDER_ITEM_IBFK_2 = ForeignKeys0.ORDER_ITEM_IBFK_2;
    public static final ForeignKey<PaymentRecord, PaymentRecord> PAYMENT_IBFK_1 = ForeignKeys0.PAYMENT_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<OrderRecord, Integer> IDENTITY_ORDER = Internal.createIdentity(Order.ORDER, Order.ORDER.ID);
        public static Identity<OrderItemRecord, Integer> IDENTITY_ORDER_ITEM = Internal.createIdentity(OrderItem.ORDER_ITEM, OrderItem.ORDER_ITEM.ID);
        public static Identity<StoreRecord, Integer> IDENTITY_STORE = Internal.createIdentity(Store.STORE, Store.STORE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<OrderRecord> KEY_ORDER_PRIMARY = Internal.createUniqueKey(Order.ORDER, "KEY_order_PRIMARY", Order.ORDER.ID);
        public static final UniqueKey<OrderItemRecord> KEY_ORDER_ITEM_PRIMARY = Internal.createUniqueKey(OrderItem.ORDER_ITEM, "KEY_order_item_PRIMARY", OrderItem.ORDER_ITEM.ID);
        public static final UniqueKey<OrderItemStatusRecord> KEY_ORDER_ITEM_STATUS_PRIMARY = Internal.createUniqueKey(OrderItemStatus.ORDER_ITEM_STATUS, "KEY_order_item_status_PRIMARY", OrderItemStatus.ORDER_ITEM_STATUS.ID);
        public static final UniqueKey<OrderStatusRecord> KEY_ORDER_STATUS_PRIMARY = Internal.createUniqueKey(OrderStatus.ORDER_STATUS, "KEY_order_status_PRIMARY", OrderStatus.ORDER_STATUS.ID);
        public static final UniqueKey<PaymentRecord> KEY_PAYMENT_PRIMARY = Internal.createUniqueKey(Payment.PAYMENT, "KEY_payment_PRIMARY", Payment.PAYMENT.ID);
        public static final UniqueKey<PaymentStatusRecord> KEY_PAYMENT_STATUS_PRIMARY = Internal.createUniqueKey(PaymentStatus.PAYMENT_STATUS, "KEY_payment_status_PRIMARY", PaymentStatus.PAYMENT_STATUS.ID);
        public static final UniqueKey<StoreRecord> KEY_STORE_PRIMARY = Internal.createUniqueKey(Store.STORE, "KEY_store_PRIMARY", Store.STORE.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<OrderRecord, OrderStatusRecord> ORDER_IBFK_1 = Internal.createForeignKey(com.invillia.acme.jooq.Keys.KEY_ORDER_STATUS_PRIMARY, Order.ORDER, "order_ibfk_1", Order.ORDER.ID_ORDER_STATUS);
        public static final ForeignKey<OrderRecord, StoreRecord> ORDER_IBFK_2 = Internal.createForeignKey(com.invillia.acme.jooq.Keys.KEY_STORE_PRIMARY, Order.ORDER, "order_ibfk_2", Order.ORDER.ID_STORE);
        public static final ForeignKey<OrderItemRecord, OrderItemStatusRecord> ORDER_ITEM_IBFK_1 = Internal.createForeignKey(com.invillia.acme.jooq.Keys.KEY_ORDER_ITEM_STATUS_PRIMARY, OrderItem.ORDER_ITEM, "order_item_ibfk_1", OrderItem.ORDER_ITEM.ID_ORDER_ITEM_STATUS);
        public static final ForeignKey<OrderItemRecord, StoreRecord> ORDER_ITEM_IBFK_2 = Internal.createForeignKey(com.invillia.acme.jooq.Keys.KEY_STORE_PRIMARY, OrderItem.ORDER_ITEM, "order_item_ibfk_2", OrderItem.ORDER_ITEM.ID_ORDER);
        public static final ForeignKey<PaymentRecord, PaymentRecord> PAYMENT_IBFK_1 = Internal.createForeignKey(com.invillia.acme.jooq.Keys.KEY_PAYMENT_PRIMARY, Payment.PAYMENT, "payment_ibfk_1", Payment.PAYMENT.ID_PAYMENT_STATUS);
    }
}