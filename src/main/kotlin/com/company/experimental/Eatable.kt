package com.company.experimental

import com.company.forest.InProgress

interface Eatable {
    @InProgress fun eatableBy(): List<Any> {
        return listOf()
    }
}
