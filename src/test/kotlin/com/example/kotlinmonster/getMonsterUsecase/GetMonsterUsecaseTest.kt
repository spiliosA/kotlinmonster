package com.example.kotlinmonster.getMonsterUsecase

import com.example.kotlinmonster.createMonsterUsecase.CreateMonsterRequest
import com.example.kotlinmonster.createMonsterUsecase.CreateMonsterUsecase
import com.example.kotlinmonster.monster.Monster
import com.example.kotlinmonster.monster.MonsterRepositoryInMem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetMonsterUsecaseTest {

    @Test
    internal fun shouldGetMonster() {
        val monster = Monster("123","Spilios")

        val monsterRepositoryInMem = MonsterRepositoryInMem()
        var createMonsterUseCase = CreateMonsterUsecase(monsterRepositoryInMem)
        val createMonsterRequest = CreateMonsterRequest(monster.id, monster.name)
        createMonsterUseCase.handle(createMonsterRequest)

        val getMonsterRequest = GetMonsterRequest(monster.id)
        val getMonsterUsecase = GetMonsterUsecase(monsterRepositoryInMem)
        Assertions.assertEquals(monster.name, getMonsterUsecase.handle(getMonsterRequest).name)
    }
}