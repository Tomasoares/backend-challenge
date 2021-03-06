/*
 * This file is generated by jOOQ.
 */
package com.invillia.acme.jooq;


import com.invillia.acme.jooq.tables.Order;
import com.invillia.acme.jooq.tables.OrderItem;
import com.invillia.acme.jooq.tables.OrderStatus;
import com.invillia.acme.jooq.tables.records.OrderItemRecord;
import com.invillia.acme.jooq.tables.records.OrderRecord;
import com.invillia.acme.jooq.tables.records.OrderStatusRecord;

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

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<OrderRecord> KEY_ORDER_PRIMARY = UniqueKeys0.KEY_ORDER_PRIMARY;
    public static final UniqueKey<OrderItemRecord> KEY_ORDER_ITEM_PRIMARY = UniqueKeys0.KEY_ORDER_ITEM_PRIMARY;
    public static final UniqueKey<OrderStatusRecord> KEY_ORDER_STATUS_PRIMARY = UniqueKeys0.KEY_ORDER_STATUS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<OrderRecord, OrderStatusRecord> ORDER_IBFK_1 = ForeignKeys0.ORDER_IBFK_1;
    public static final ForeignKey<OrderItemRecord, OrderRecord> ORDER_ITEM_IBFK_1 = ForeignKeys0.ORDER_ITEM_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<OrderRecord, Integer> IDENTITY_ORDER = Internal.createIdentity(Order.ORDER, Order.ORDER.ID);
        public static Identity<OrderItemRecord, Integer> IDENTITY_ORDER_ITEM = Internal.createIdentity(OrderItem.ORDER_ITEM, OrderItem.ORDER_ITEM.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<OrderRecord> KEY_ORDER_PRIMARY = Internal.createUniqueKey(Order.ORDER, "KEY_order_PRIMARY", Order.ORDER.ID);
        public static final UniqueKey<OrderItemRecord> KEY_ORDER_ITEM_PRIMARY = Internal.createUniqueKey(OrderItem.ORDER_ITEM, "KEY_order_item_PRIMARY", OrderItem.ORDER_ITEM.ID);
        public static final UniqueKey<OrderStatusRecord> KEY_ORDER_STATUS_PRIMARY = Internal.createUniqueKey(OrderStatus.ORDER_STATUS, "KEY_order_status_PRIMARY", OrderStatus.ORDER_STATUS.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<OrderRecord, OrderStatusRecord> ORDER_IBFK_1 = Internal.createForeignKey(com.invillia.acme.jooq.Keys.KEY_ORDER_STATUS_PRIMARY, Order.ORDER, "order_ibfk_1", Order.ORDER.ID_ORDER_STATUS);
        public static final ForeignKey<OrderItemRecord, OrderRecord> ORDER_ITEM_IBFK_1 = Internal.createForeignKey(com.invillia.acme.jooq.Keys.KEY_ORDER_PRIMARY, OrderItem.ORDER_ITEM, "order_item_ibfk_1", OrderItem.ORDER_ITEM.ID_ORDER);
    }
}
