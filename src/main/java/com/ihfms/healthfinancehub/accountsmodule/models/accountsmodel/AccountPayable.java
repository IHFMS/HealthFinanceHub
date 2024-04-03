package com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountPayable {

    private Long payableId;
    private Double amount;
    private LocalDate payableDate;
    private Status status;

}
