package com.emm.just_chill.feat.accounts.application

import com.emm.just_chill.feat.accounts.domain.Account
import com.emm.just_chill.feat.accounts.domain.AccountRepository

class AccountCreator(private val repository: AccountRepository) {

    fun create(account: Account): Account {
        return repository.insert(account)
    }
}