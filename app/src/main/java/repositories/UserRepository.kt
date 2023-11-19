package repositories

import data.User

object UserRepository {

    private val users = mutableListOf<User>()
    var currentUser: User? = null

    init {
        users.add(User(1504L, "BRIAN_BAYARRI", "abc123", "Brian", "Bayarri", 3500000.50, "2022/12/10"))
        users.add(User(2802L, "AHOZ", "lock_password", "Aylen", "Hoz", 200000.50, "2021/01/11"))
        users.add(User(1510L, "Diegote", "@12345", "Diego", "Gonzalez", 120000.0, "2018/04/15"))
        users.add(User(154L, "pepe", "pepe", "pepe", "Gonzalez", 120000.0, "2018/04/15")) //para probar
    }
    fun findUser(nickname: String, password: String): User? {
        //recorre la lista hasta encontrar el nickname
        return users.find { it.nickName == nickname && it.password == password}
    }

    fun enabledUser(nickname: String, password: String): User? {
        return UserRepository.findUser(nickname, password)
        // Aquí debes implementemos la logica para obtener y devolver el usuario
        // Devuelve el usuario si es encontrado, o null si no lo es

    }

    fun findUserById(userLoginId: Long): User? {
        return users.find { it.id == userLoginId }
    }
}