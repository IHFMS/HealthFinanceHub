package com.ihfms.healthfinancehub.accountsmodule.repos;

import com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel.AccountReceivable;
import org.springframework.data.repository.CrudRepository;

public interface AccountReceivableRepository extends CrudRepository<AccountReceivable, Long> {
    // Additional methods for specific queries if needed
}