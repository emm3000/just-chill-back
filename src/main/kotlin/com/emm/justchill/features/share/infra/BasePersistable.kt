package com.emm.justchill.features.share.infra

import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable

abstract class BasePersist<T>(@Transient private val baseId: T) : Persistable<T> {

    @Transient
    protected var shouldInsert: Boolean = false

    fun markAsNew() {
        shouldInsert = true
    }

    override fun isNew(): Boolean = shouldInsert

    override fun getId(): T = baseId
}