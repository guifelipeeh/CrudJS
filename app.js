const express = require('express');
const bodyParser = require('body-parser');
const UserController = require('./UserController');

const app = express();
const port = process.env.PORT || 3000;

app.use(bodyParser.json());
app.use('/auth', UserController);

app.listen(port, () => {
    console.log(`Servidor em execução na porta ${port}`);
});