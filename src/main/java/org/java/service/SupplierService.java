package org.java.service;

import org.java.entity.CustomerOrder;
import org.java.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getList(int page, int rows);

    public int getCount();

    public void add(Supplier f);
}
