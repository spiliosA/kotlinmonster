package com.example.kotlinmonster.monster

class MonsterRepositoryInMem : MonsterRepository {
    private var monsterHash = mutableMapOf<String, Monster>()
    override fun addMonster(monster: Monster): String {
        monsterHash.put(monster.id, monster)
        return monster.id
    }

    override fun getMonster(id: String): Monster {
        return monsterHash[id] ?: throw Exception("Monster required")
    }
}
