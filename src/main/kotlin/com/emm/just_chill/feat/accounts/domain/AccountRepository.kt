package com.emm.just_chill.feat.accounts.domain

interface AccountRepository {

    fun all(): List<Account>

    fun insert(account: Account): Account

    fun delete(accountId: String)

    fun findBy(accountId: String): List<Account>

    fun update(account: Account): Account

    fun updateBalance(accountId: String, balance: Double): Account
}