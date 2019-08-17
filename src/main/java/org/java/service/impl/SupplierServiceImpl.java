package org.java.service.impl;

import org.java.dao.SupplierMapper;
import org.java.entity.CustomerOrder;
import org.java.entity.Supplier;
import org.java.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;
    @Override
    public List<Supplier> getList(int page, int rows) {
        int start = (page-1)*rows;
        return supplierMapper.getList(0,4);
    }

    @Override
    public int getCount() {
        return supplierMapper.getCount();
    }
    @Transactional
    @Override
    public void add(Supplier f) {
        supplierMapper.insert(f);
    }


}