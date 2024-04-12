package com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GeneralLedger {

    private Long entryId;
    private Double amount;
    private LocalDate accountDate;

}
