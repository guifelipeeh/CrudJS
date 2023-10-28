const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const UserModel = require('../models/UserModel');

class AuthService {
    generateToken(user) {
        try {
            const payload = {
                userId: user.id,
                login: user.login,
                role: user.role,
            };

            // Gere o token com uma chave secreta e defina a expiração (por exemplo, 1 hora)
            const token = jwt.sign(payload, 'sua-chave-secreta', { expiresIn: '1h' });

            return token;
        } catch (error) {
            console.error('Erro ao gerar o token:', error);
            return null; // Retorne null em caso de erro
        }
    }

    async login(userLogin, password) {
        try {
            // Busque o usuário no banco de dados com base no login
            const user = await UserModel.getUserByLogin(userLogin);

            if (!user) {
                return { success: false, message: 'Usuário não encontrado' };
            }

            // Verifique a senha
            const isPasswordValid = await bcrypt.compare(password, user.password);

            if (isPasswordValid) {
                // Se a senha estiver correta, gere um token
                const token = this.generateToken(user);
                return { success: true, token };
            } else {
                return { success: false, message: 'Senha incorreta' };
            }
        } catch (error) {
            console.error('Erro ao autenticar o usuário:', error);
            return { success: false, message: 'Erro interno do servidor' };
        }
    }
}

module.exports = new AuthService();
