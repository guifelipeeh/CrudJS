function enviarFormulario(event) {
    event.preventDefault();

    const formulario = new FormData();
    const nome = document.querySelector('input[name="nome"]').value;
    const arquivo = document.querySelector('input[name="arquivo"]').files[0];

    formulario.append('nome', nome);
    formulario.append('arquivo', arquivo);

    fetch('{"/produtores', {
        method: 'POST',
        body: formulario
    })
    .then(response => response.json())
    .then(data => {
        console.log('Resposta do servidor:', data);
    })
    .catch(error => {
        console.error('Erro ao enviar o formulário:', error);
    });
}