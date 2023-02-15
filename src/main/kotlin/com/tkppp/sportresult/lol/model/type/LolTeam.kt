package com.tkppp.sportresult.lol.model.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class LolTeam(@JsonValue val fullName: String, val shortName: String) {
    T1("T1", "T1"), GEN("젠지", "젠지"),
    DK("Dplus KIA", "디플러스"), DRX("DRX", "DRX"),
    LSB("리브 샌드박스", "리브샌박"), KT("kt 롤스터", "KT"),
    HLE("한화생명e스포츠", "한화생명"), KDF("광동 프릭스", "광동"),
    NS("농심 레드포스", "농심"), BRO("브리온", "브리온"),
    TBD("TBD", "TBD");

    companion object {
        @JvmStatic
        @JsonCreator
        fun set(team: String) = values().find { it.fullName == team }
    }
}