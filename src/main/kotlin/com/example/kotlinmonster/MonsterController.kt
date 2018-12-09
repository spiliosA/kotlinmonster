package com.example.kotlinmonster

import com.example.kotlinmonster.createMonsterUsecase.CreateMonsterRequest
import com.example.kotlinmonster.createMonsterUsecase.CreateMonsterUsecase
import com.example.kotlinmonster.getMonsterUsecase.GetMonsterRequest
import com.example.kotlinmonster.getMonsterUsecase.GetMonsterUsecase
import com.example.kotlinmonster.monster.Monster
import com.example.kotlinmonster.monster.MonsterRepositoryMySQL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@EnableAutoConfiguration
class MonsterController {
    //var monsterRepository = MonsterRepositoryInMem()

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @PostMapping("/create")
    fun createMonster(@RequestBody monster: Monster): String {

        var monsterRepository = MonsterRepositoryMySQL(jdbcTemplate)
        val createMonsterRequest = CreateMonsterRequest(monster.id,monster.name)
        val createMonsterUsecase = CreateMonsterUsecase(monsterRepository)
        return createMonsterUsecase.handle(createMonsterRequest).id

    }

    @GetMapping("/monster/{id}")
    fun getMonster(@PathVariable id: String): String {
        var monsterRepository = MonsterRepositoryMySQL(jdbcTemplate)

        val getMonsterRequest = GetMonsterRequest(id)
        val getMonsterUsecase = GetMonsterUsecase(monsterRepository)
        println("########### GET a monster with ${id}")
        return getMonsterUsecase.handle(getMonsterRequest).name

    }


}