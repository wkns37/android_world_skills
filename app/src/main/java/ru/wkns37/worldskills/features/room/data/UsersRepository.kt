package ru.wkns37.worldskills.features.room.data

import ru.wkns37.worldskills.features.room.presentation.UserUi

interface UsersRepository {

    suspend fun initialize()

    suspend fun getUsers(): List<UserUi>

    class Room(private val userDao: UserDao) : UsersRepository {

        override suspend fun initialize() {
            userDao.insert(User(1, "Bob", 22))
            userDao.insert(User(2, "Alice", 18))
            userDao.insert(User(3, "Charlie", 25))
            userDao.insert(User(4, "Eve", 28))
        }

        override suspend fun getUsers(): List<UserUi> {
            val users = userDao.getUsers()
            return users.map { UserUi.Base(it.id, it.name, it.age) }
        }
    }

    class Local : UsersRepository {

        override suspend fun initialize() = Unit

        override suspend fun getUsers() = listOf(
            UserUi.Base(1, "Bob", 22),
            UserUi.Base(2, "Alice", 18)
        )
    }
}