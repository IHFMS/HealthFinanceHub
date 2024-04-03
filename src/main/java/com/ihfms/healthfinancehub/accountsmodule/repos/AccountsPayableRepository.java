package com.ihfms.healthfinancehub.accountsmodule.repos;

import com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel.AccountPayable;
import org.springframework.data.repository.CrudRepository;

public interface AccountPayableRepository extends CrudRepository<AccountPayable, Long> {
    // Additional methods for specific queries if needed
}