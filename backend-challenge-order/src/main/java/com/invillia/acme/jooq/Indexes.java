/*
 * This file is generated by jOOQ.
 */
package com.invillia.acme.jooq;


import com.invillia.acme.jooq.tables.Order;
import com.invillia.acme.jooq.tables.OrderItem;
import com.invillia.acme.jooq.tables.OrderStatus;

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
    public static final Index ORDER_ITEM_PRIMARY = Indexes0.ORDER_ITEM_PRIMARY;
    public static final Index ORDER_STATUS_PRIMARY = Indexes0.ORDER_STATUS_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ORDER_FK_ORDER_ORDER_STATUS = Internal.createIndex("fk_order_order_status", Order.ORDER, new OrderField[] { Order.ORDER.ID_ORDER_STATUS }, false);
        public static Index ORDER_FK_ORDER_STORE = Internal.createIndex("fk_order_store", Order.ORDER, new OrderField[] { Order.ORDER.ID_STORE }, false);
        public static Index ORDER_PRIMARY = Internal.createIndex("PRIMARY", Order.ORDER, new OrderField[] { Order.ORDER.ID }, true);
        public static Index ORDER_ITEM_FK_ORDER_ITEM_ORDER = Internal.createIndex("fk_order_item_order", OrderItem.ORDER_ITEM, new OrderField[] { OrderItem.ORDER_ITEM.ID_ORDER }, false);
        public static Index ORDER_ITEM_PRIMARY = Internal.createIndex("PRIMARY", OrderItem.ORDER_ITEM, new OrderField[] { OrderItem.ORDER_ITEM.ID }, true);
        public static Index ORDER_STATUS_PRIMARY = Internal.createIndex("PRIMARY", OrderStatus.ORDER_STATUS, new OrderField[] { OrderStatus.ORDER_STATUS.ID }, true);
    }
}
