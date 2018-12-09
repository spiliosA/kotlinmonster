package com.example.kotlinmonster.createMonsterUsecase

import com.example.kotlinmonster.monster.Monster
import com.example.kotlinmonster.monster.MonsterRepository

class CreateMonsterUsecase(var monsterRepository: MonsterRepository) {
    fun handle(createMonsterRequest: CreateMonsterRequest): CreateMonsterResponse {
        val monster = Monster(createMonsterRequest.id, createMonsterRequest.name)
        return CreateMonsterResponse(monsterRepository.addMonster(monster))
    }

}
