package org.java.service;

import org.java.entity.Supplier;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/17 15:23
 * @Description: Frighting!!!
 */


public interface SupplierService {

    public List<Supplier> getList(int page, int rows,String searchsupplierId);
    public int getCount();
    public void add(Supplier e);
    public int delSupplier(String supplierId);
    public void updateSupplier(Supplier e);
    public Integer findsupplierCount(String searchsupplierId);
}
