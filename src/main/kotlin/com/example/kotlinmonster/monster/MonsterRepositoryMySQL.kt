package com.example.kotlinmonster.monster

import org.springframework.jdbc.core.JdbcTemplate


class MonsterRepositoryMySQL(private val jdbcTemplate: JdbcTemplate) : MonsterRepository {

    override fun addMonster(monster: Monster): String {

        val sql = "INSERT INTO monsterDB.monster(id,name) VALUES ('${monster.id}', '${monster.name}')"
        println("############## $sql")
        jdbcTemplate.update(sql)

        return monster.id
    }

    override fun getMonster(id: String): Monster {
        return Monster("1","manolis")
    }
}