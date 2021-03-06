/*
 * This file is generated by jOOQ.
 */
package com.invillia.acme.jooq;


import com.invillia.acme.jooq.tables.Payment;
import com.invillia.acme.jooq.tables.PaymentStatus;

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

    public static final Index PAYMENT_FK_PAYMENT_ORDER = Indexes0.PAYMENT_FK_PAYMENT_ORDER;
    public static final Index PAYMENT_FK_PAYMENT_PAYMENT_STATUS = Indexes0.PAYMENT_FK_PAYMENT_PAYMENT_STATUS;
    public static final Index PAYMENT_PRIMARY = Indexes0.PAYMENT_PRIMARY;
    public static final Index PAYMENT_STATUS_PRIMARY = Indexes0.PAYMENT_STATUS_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PAYMENT_FK_PAYMENT_ORDER = Internal.createIndex("fk_payment_order", Payment.PAYMENT, new OrderField[] { Payment.PAYMENT.ID_ORDER }, false);
        public static Index PAYMENT_FK_PAYMENT_PAYMENT_STATUS = Internal.createIndex("fk_payment_payment_status", Payment.PAYMENT, new OrderField[] { Payment.PAYMENT.ID_PAYMENT_STATUS }, false);
        public static Index PAYMENT_PRIMARY = Internal.createIndex("PRIMARY", Payment.PAYMENT, new OrderField[] { Payment.PAYMENT.ID }, true);
        public static Index PAYMENT_STATUS_PRIMARY = Internal.createIndex("PRIMARY", PaymentStatus.PAYMENT_STATUS, new OrderField[] { PaymentStatus.PAYMENT_STATUS.ID }, true);
    }
}
