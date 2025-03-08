package com.emm.justchill.features.share.infra

import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable

abstract class BasePersist<T> : Persistable<T> {

    @Transient
    protected var shouldInsert: Boolean = false

    fun markNew() {
        shouldInsert = true
    }

    override fun isNew(): Boolean = shouldInsert
}