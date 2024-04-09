package com.ihfms.healthfinancehub.utils;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;

import java.util.ArrayList;
import java.util.List;

public class SecondaryDb{
    private static SecondaryDb instance;

    public List<Invoice> invoiceList;
    private SecondaryDb(){
        invoiceList = new ArrayList<>();
    }

    public static SecondaryDb getInstance() {
        if(instance==null){
            instance=new SecondaryDb();
            instance.invoiceList = new ArrayList<>();
        }

        return instance;
    }
}
