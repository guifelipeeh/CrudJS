const mysql = require('mysql2');

const dbConfig = {
    host: '127.0.0.1',
    user: 'root',
    password: '9737',
    database: 'bancodeusuarios',
};

const pool = mysql.createPool(dbConfig);

module.exports = pool.promise();