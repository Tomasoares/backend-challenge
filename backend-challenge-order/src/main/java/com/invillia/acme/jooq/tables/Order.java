/*
 * This file is generated by jOOQ.
 */
package com.invillia.acme.jooq.tables;


import com.invillia.acme.jooq.Acme;
import com.invillia.acme.jooq.Indexes;
import com.invillia.acme.jooq.Keys;
import com.invillia.acme.jooq.tables.records.OrderRecord;

import java.sql.Date;
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
public class Order extends TableImpl<OrderRecord> {

    private static final long serialVersionUID = 1306664253;

    /**
     * The reference instance of <code>acme.order</code>
     */
    public static final Order ORDER = new Order();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderRecord> getRecordType() {
        return OrderRecord.class;
    }

    /**
     * The column <code>acme.order.id</code>.
     */
    public final TableField<OrderRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>acme.order.address</code>.
     */
    public final TableField<OrderRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>acme.order.id_order_status</code>.
     */
    public final TableField<OrderRecord, Integer> ID_ORDER_STATUS = createField("id_order_status", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>acme.order.id_store</code>.
     */
    public final TableField<OrderRecord, Integer> ID_STORE = createField("id_store", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>acme.order.confirmation_date</code>.
     */
    public final TableField<OrderRecord, Date> CONFIRMATION_DATE = createField("confirmation_date", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * Create a <code>acme.order</code> table reference
     */
    public Order() {
        this(DSL.name("order"), null);
    }

    /**
     * Create an aliased <code>acme.order</code> table reference
     */
    public Order(String alias) {
        this(DSL.name(alias), ORDER);
    }

    /**
     * Create an aliased <code>acme.order</code> table reference
     */
    public Order(Name alias) {
        this(alias, ORDER);
    }

    private Order(Name alias, Table<OrderRecord> aliased) {
        this(alias, aliased, null);
    }

    private Order(Name alias, Table<OrderRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Order(Table<O> child, ForeignKey<O, OrderRecord> key) {
        super(child, key, ORDER);
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
        return Arrays.<Index>asList(Indexes.ORDER_FK_ORDER_ORDER_STATUS, Indexes.ORDER_FK_ORDER_STORE, Indexes.ORDER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<OrderRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ORDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OrderRecord> getPrimaryKey() {
        return Keys.KEY_ORDER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OrderRecord>> getKeys() {
        return Arrays.<UniqueKey<OrderRecord>>asList(Keys.KEY_ORDER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<OrderRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<OrderRecord, ?>>asList(Keys.ORDER_IBFK_1);
    }

    public OrderStatus orderStatus() {
        return new OrderStatus(this, Keys.ORDER_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order as(String alias) {
        return new Order(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order as(Name alias) {
        return new Order(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Order rename(String name) {
        return new Order(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Order rename(Name name) {
        return new Order(name, null);
    }
}
