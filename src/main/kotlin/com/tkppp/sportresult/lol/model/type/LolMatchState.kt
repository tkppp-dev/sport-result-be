package com.tkppp.sportresult.lol.model.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class LolMatchState(@JsonValue val value: String) {
    BEFORE_MATCH("예정"), AFTER_MATCH("종료"), SET1("1세트"),
    SET2("2세트"), SET3("3세트"), SET4("4세트"), SET5("5세트");

    companion object {
        @JvmStatic
        @JsonCreator
        fun set(state: String) = values().find{ it.value == state }
    }
}