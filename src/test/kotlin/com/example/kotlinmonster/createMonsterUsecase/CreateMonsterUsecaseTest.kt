package com.example.kotlinmonster.createMonsterUsecase

import com.example.kotlinmonster.monster.Monster
import com.example.kotlinmonster.monster.MonsterRepositoryInMem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CreateMonsterUsecaseTest {

    @Test
    internal fun shouldCreateMonster() {

        var monsterRepositoryInMem = MonsterRepositoryInMem()
        val monster = Monster("2", "Spilios")
        var createMonsterUseCase = CreateMonsterUsecase(monsterRepositoryInMem)
        val createMonsterRequest = CreateMonsterRequest(monster.id, monster.name)
        Assertions.assertEquals(monster.id, createMonsterUseCase.handle(createMonsterRequest).id)

    }
}