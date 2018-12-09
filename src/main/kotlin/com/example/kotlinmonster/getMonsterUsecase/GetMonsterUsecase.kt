package com.example.kotlinmonster.getMonsterUsecase

import com.example.kotlinmonster.monster.MonsterRepository

class GetMonsterUsecase(var monsterRepository: MonsterRepository) {
    fun handle(monsterRequest: GetMonsterRequest): GetMonsterResponse {
        return GetMonsterResponse(monsterRepository.getMonster(monsterRequest.id).name)
    }

}
