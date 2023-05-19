package com.devedroy.wordroom

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDataBase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}