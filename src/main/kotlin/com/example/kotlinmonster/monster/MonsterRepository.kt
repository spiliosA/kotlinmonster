package com.example.kotlinmonster.monster

interface MonsterRepository {
    fun addMonster(monster:Monster):String
    fun getMonster(id:String): Monster
}