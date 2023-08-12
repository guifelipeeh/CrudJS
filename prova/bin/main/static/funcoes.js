
function receberArq() {
  const fileInput = document.getElementById('Arquivo');
  const file = fileInput.files[0];

  if (!file) {
    alert('Selecione um arquivo para enviar.');
    return;
  }

  const url = 'http://localhost:8080/uploadFile'; 
  const formData = new FormData();
  formData.append('file', file);

  fetch(url, {
    method: 'POST',
    body: formData
  })
  .then(response => response.text())
  .then(result => {
	 console.log(result);
    const statusDiv = document.getElementById('mensagemErro');
    statusDiv.textContent = `Arquivo enviado com sucesso! Resposta do servidor: ${result}`;
    mostrarProdutor();
  })
  .catch(error => {
    console.error('Erro ao enviar o arquivo:', error);
  
  });
}

function mostrarProdutor() {
	const apiUrl = 'http://localhost:8080/produtores';
  fetch(apiUrl)
    .then(response => {
      if (!response.ok) {
        throw new Error(`Erro na requisição: ${response.status} ${response.statusText}`);
      }
      return response.json(); // Parseia a resposta como JSON
    })
    .then(data => {
      // Iterando sobre os itens do array de produtores
      $(".estilo-linha").remove()
      data.forEach(item => {
	  $("#linhas").append("<tr class='estilo-linha'><td>"+item.numeroTransacao+"</td><td>"+item.data+"</td><td>"+item.descricaoProduto+"</td><td>"+item.valor+"</td><td>"+item.nomeVendedor+"</td></tr>")
	  
        console.log(item);
      });  
    })
    .catch(error => {
      console.error('Erro:', error);
    });
// Exemplo de uso da função mostrarProdutor

}
$(document).ready(function() {
   mostrarProdutor()
});