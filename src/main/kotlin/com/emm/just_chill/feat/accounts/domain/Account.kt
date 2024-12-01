package com.emm.just_chill.feat.accounts.domain

data class Account(
    val accountId: String,
    val name: String,
    val balance: Double,
    val initialBalance: Double,
    val description: String,
)