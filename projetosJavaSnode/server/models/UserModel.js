const db = require('../../config/dbConfig');

class UserModel {
    async createUser(user) {
        try {
            const query = 'INSERT INTO users (login, password) VALUES (?, ?)';
            const result = await db.query(query, [user.login, user.password]);

            if (result.affectedRows === 1) {
                return { success: true, message: 'Usuário criado com sucesso' };
            } else {
                return { success: false, message: 'Falha ao criar o usuário' };
            }
        } catch (error) {
            console.error('Erro ao criar usuário:', error);
            return { success: false, message: 'Erro interno do servidor' };
        }
    }

    async getUserById(userId) {
        try {
            const query = 'SELECT * FROM users WHERE id = ?';
            const result = await db.query(query, [userId]);

            if (result.length === 1) {
                const user = result[0];
                // Remova o campo de senha antes de retornar o usuário (por questões de segurança)
                delete user.password;
                return { success: true, user };
            } else {
                return { success: false, message: 'Usuário não encontrado' };
            }
        } catch (error) {
            console.error('Erro ao buscar usuário por ID:', error);
            return { success: false, message: 'Erro interno do servidor' };
        }
    }

    async getUserByLogin(userLogin) {
        try {
            const query = 'SELECT * FROM users WHERE login = ?';
            const result = await db.query(query, [userLogin]);

            if (result.length === 1) {
                const user = result[0];
                // Remova o campo de senha antes de retornar o usuário (por questões de segurança)
                delete user.password;
                return { success: true, user };
            } else {
                return { success: false, message: 'Usuário não encontrado' };
            }
        } catch (error) {
            console.error('Erro ao buscar usuário por login:', error);
            return { success: false, message: 'Erro interno do servidor' };
        }
    }
}

module.exports = new UserModel();
