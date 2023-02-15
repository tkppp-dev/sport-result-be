package com.tkppp.sportresult.kbo.model.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class KboMatchState(@JsonValue val state: String) {
    UP_1("1회초"), DOWN_1("1회말"), UP_2("2회초"), DOWN_2("2회말"),
    UP_3("3회초"), DOWN_3("3회말"), UP_4("4회초"), DOWN_4("4회말"),
    UP_5("5회초"), DOWN_5("5회말"), UP_6("6회초"), DOWN_6("6회말"),
    UP_7("7회초"), DOWN_7("7회말"), UP_8("8회초"), DOWN_8("8회말"),
    UP_9("9회초"), DOWN_9("9회말"), UP_10("10회초"), DOWN_10("10회말"),
    UP_11("11회초"), DOWN_11("11회말"), UP_12("12회초"), DOWN_12("12회말"),
    BEFORE("경기전"), END("종료"), CANCELED("경기취소");

    companion object {
        @JvmStatic
        @JsonCreator
        fun set(progress: String) = values().find{ it.state == progress }
    }
}