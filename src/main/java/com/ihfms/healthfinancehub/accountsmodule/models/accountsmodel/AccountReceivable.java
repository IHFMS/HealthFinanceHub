package com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountReceivable {

    private Long receivableId;
    private Double amount;
    private LocalDate receivableDate;
    private Status status;

}
