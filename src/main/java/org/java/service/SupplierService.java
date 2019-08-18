package org.java.service;

import org.java.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getList(int page, int rows);

    public int getCount();

    public void add(Supplier e);

    public int delSupplier(String supplierId);
    public void updateSupplier(Supplier e);
}
