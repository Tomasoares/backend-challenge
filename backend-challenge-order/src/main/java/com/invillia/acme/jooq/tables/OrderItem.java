/*
 * This file is generated by jOOQ.
 */
package com.invillia.acme.jooq.tables;


import com.invillia.acme.jooq.Acme;
import com.invillia.acme.jooq.Indexes;
import com.invillia.acme.jooq.Keys;
import com.invillia.acme.jooq.tables.records.OrderItemRecord;

import java.math.BigDecimal;
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
public class OrderItem extends TableImpl<OrderItemRecord> {

    private static final long serialVersionUID = -57972158;

    /**
     * The reference instance of <code>acme.order_item</code>
     */
    public static final OrderItem ORDER_ITEM = new OrderItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderItemRecord> getRecordType() {
        return OrderItemRecord.class;
    }

    /**
     * The column <code>acme.order_item.id</code>.
     */
    public final TableField<OrderItemRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>acme.order_item.unitPrice</code>.
     */
    public final TableField<OrderItemRecord, BigDecimal> UNITPRICE = createField("unitPrice", org.jooq.impl.SQLDataType.DECIMAL(10, 2), this, "");

    /**
     * The column <code>acme.order_item.quantity</code>.
     */
    public final TableField<OrderItemRecord, Integer> QUANTITY = createField("quantity", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>acme.order_item.refunded</code>.
     */
    public final TableField<OrderItemRecord, Boolean> REFUNDED = createField("refunded", org.jooq.impl.SQLDataType.BIT, this, "");

    /**
     * The column <code>acme.order_item.id_order</code>.
     */
    public final TableField<OrderItemRecord, Integer> ID_ORDER = createField("id_order", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>acme.order_item.description</code>.
     */
    public final TableField<OrderItemRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * Create a <code>acme.order_item</code> table reference
     */
    public OrderItem() {
        this(DSL.name("order_item"), null);
    }

    /**
     * Create an aliased <code>acme.order_item</code> table reference
     */
    public OrderItem(String alias) {
        this(DSL.name(alias), ORDER_ITEM);
    }

    /**
     * Create an aliased <code>acme.order_item</code> table reference
     */
    public OrderItem(Name alias) {
        this(alias, ORDER_ITEM);
    }

    private OrderItem(Name alias, Table<OrderItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderItem(Name alias, Table<OrderItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> OrderItem(Table<O> child, ForeignKey<O, OrderItemRecord> key) {
        super(child, key, ORDER_ITEM);
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
        return Arrays.<Index>asList(Indexes.ORDER_ITEM_FK_ORDER_ITEM_ORDER, Indexes.ORDER_ITEM_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<OrderItemRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ORDER_ITEM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OrderItemRecord> getPrimaryKey() {
        return Keys.KEY_ORDER_ITEM_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OrderItemRecord>> getKeys() {
        return Arrays.<UniqueKey<OrderItemRecord>>asList(Keys.KEY_ORDER_ITEM_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<OrderItemRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<OrderItemRecord, ?>>asList(Keys.ORDER_ITEM_IBFK_1);
    }

    public Order order() {
        return new Order(this, Keys.ORDER_ITEM_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderItem as(String alias) {
        return new OrderItem(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderItem as(Name alias) {
        return new OrderItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderItem rename(String name) {
        return new OrderItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderItem rename(Name name) {
        return new OrderItem(name, null);
    }
}
