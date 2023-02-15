package com.tkppp.sportresult.kbo.model.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class KboTeam(@JsonValue val fullName: String, val code: String){
    SAMSUNG("삼성", "SS"), KIWOOM("키움", "WO"),
    HANWHA("한화", "HH"), LG("LG", "LG"),
    LOTTE("롯데", "LT"), SSG("SSG", "SK"),
    KIA("KIA", "HT"), DOOSAN("두산", "OB"),
    NC("NC", "NC"), KT("KT", "KT");

    companion object {
        @JvmStatic
        @JsonCreator
        fun set(team: String) = values().find { it.fullName == team }
    }
}