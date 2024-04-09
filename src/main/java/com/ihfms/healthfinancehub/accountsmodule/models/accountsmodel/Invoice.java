package com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel;


import lombok.Data;

@Data
     public class Invoice {
     String id;
     Boolean isPaid;
     String  patientId;
     int amount;
}
