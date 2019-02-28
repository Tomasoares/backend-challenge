/*
 * This file is generated by jOOQ.
 */
package com.invillia.acme.jooq.tables;


import com.invillia.acme.jooq.Acme;
import com.invillia.acme.jooq.Indexes;
import com.invillia.acme.jooq.Keys;
import com.invillia.acme.jooq.tables.records.PaymentRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Payment extends TableImpl<PaymentRecord> {

    private static final long serialVersionUID = 936761712;

    /**
     * The reference instance of <code>acme.payment</code>
     */
    public static final Payment PAYMENT = new Payment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PaymentRecord> getRecordType() {
        return PaymentRecord.class;
    }

    /**
     * The column <code>acme.payment.id</code>.
     */
    public final TableField<PaymentRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>acme.payment.credit_card</code>.
     */
    public final TableField<PaymentRecord, String> CREDIT_CARD = createField("credit_card", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>acme.payment.payment_date</code>.
     */
    public final TableField<PaymentRecord, Timestamp> PAYMENT_DATE = createField("payment_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>acme.payment.id_payment_status</code>.
     */
    public final TableField<PaymentRecord, Integer> ID_PAYMENT_STATUS = createField("id_payment_status", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>acme.payment</code> table reference
     */
    public Payment() {
        this(DSL.name("payment"), null);
    }

    /**
     * Create an aliased <code>acme.payment</code> table reference
     */
    public Payment(String alias) {
        this(DSL.name(alias), PAYMENT);
    }

    /**
     * Create an aliased <code>acme.payment</code> table reference
     */
    public Payment(Name alias) {
        this(alias, PAYMENT);
    }

    private Payment(Name alias, Table<PaymentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Payment(Name alias, Table<PaymentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Payment(Table<O> child, ForeignKey<O, PaymentRecord> key) {
        super(child, key, PAYMENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Acme.ACME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PAYMENT_FK_PAYMENT_PAYMENT_STATUS, Indexes.PAYMENT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PaymentRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PAYMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PaymentRecord> getPrimaryKey() {
        return Keys.KEY_PAYMENT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PaymentRecord>> getKeys() {
        return Arrays.<UniqueKey<PaymentRecord>>asList(Keys.KEY_PAYMENT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PaymentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PaymentRecord, ?>>asList(Keys.PAYMENT_IBFK_1);
    }

    public com.invillia.acme.jooq.tables.Payment payment() {
        return new com.invillia.acme.jooq.tables.Payment(this, Keys.PAYMENT_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment as(String alias) {
        return new Payment(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment as(Name alias) {
        return new Payment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Payment rename(String name) {
        return new Payment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Payment rename(Name name) {
        return new Payment(name, null);
    }
}
