// com.ihfms.healthfinancehub.accountsmodule.repositories.AccountRepository
package com.ihfms.healthfinancehub.accountsmodule.repos;

import com.ihfms.healthfinancehub.accountsmodule.models.accountsmodel.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    // Additional methods for specific queries if needed
}
