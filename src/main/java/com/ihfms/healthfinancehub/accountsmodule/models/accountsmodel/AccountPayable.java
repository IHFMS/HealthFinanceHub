package com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel;

import lombok.Data;
import java.sql.Date;

@Data
public class AccountPayable {

    private Long payableId;
    private Double amount;
    private Date payableDate;
    private Status status;

}
