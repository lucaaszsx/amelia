const modal = document.getElementById('modal');
const form = document.querySelector('.modal-form');
const btnReceita = document.getElementById('receita');
const btnMais = document.getElementById('mais');
const btnCancelar = document.getElementById('cancelar');
const btnConfirmar = document.getElementById('confirmar');
const nomeGasto = document.getElementById('nomeGasto');
const dataGasto = document.getElementById('dataGasto');
const valorGasto = document.getElementById('valorGasto');
const gastos = document.getElementById('gastos');

// Vetor com dados sobre os gastos que foram criados pelo usuário
const listaGastos = [];

// Evento de clique no botão de definir receita
btnReceita.addEventListener('click', () => {
    // Lógica para definir a receita...
});

// Evento de clique no botão de adicionar gasto
btnMais.addEventListener('click', () => {
    modal.classList.remove('hidden'); // mostra o modal para criar o gasto
});

// Evento de clique no botão de cancelar a criação de um gasto
btnCancelar.addEventListener('click', () => {
    modal.classList.add('hidden'); // esconde o modal de criar o gasto
});

// Evento de clique no botão de confirmar criação de um gasto
form.addEventListener('submit', (evento) => {
    evento.preventDefault(); // definir o comportamento padrão do formulário de atualizar a página
    
    const nome = nomeGasto.value;
    const data = dataGasto.value;
    const valor = valorGasto.value;
    
    // Adiciona um objeto com dados do gasto criado no vetor de lista de gastos
    listaGastos.push({ nome: nome, data: data, valor: valor });
    
    // Limpa os dados do formulário
    form.reset();
    
    // Esconde o modal
    modal.classList.add('hidden');
    
    // Chama a função que renderiza os gastos da lista na tela
    renderizarGastos();
    
    // Chama a função que faz a atualização dos valores nos campos "Previsto", "Efetivado" e "Saldo"
    atualizarCampos(); // é necessário implementar a lógica da função
});

/**
 * Atualiza os campos de "Previsto", "Efetivado" e "Saldo"
 * com base nos dados da lista de gastos.
 * 
 * @returns {void}
 */
function atualizarCampos() {
    // Seleciona os inputs que mostram os valores no rodapé da página
    const saldoPrevisto = document.getElementById('previsto');
    const saldoEfetivado = document.getElementById('efetivado');
    const saldoRestante = document.getElementById('saldo');

    // Aqui você pode obter o valor da receita definida pelo usuário.
    // ...

    // Cria uma variável para somar todos os valores da lista de gastos
    // Cada item da listaGastos é um objeto com a propriedade "valor"

    // Percorre todos os itens da listaGastos e soma os valores
    // Obs.: usar um for-loop p/ fazer isso

    // Depois de somar, atribua o total ao campo "Efetivado"

    // Calcule o "Saldo" subtraindo os gastos da receita (Previsto - Efetivado)

    // Atualize os campos de input na tela com os valores calculados
    // saldoPrevisto.value = ...
    // saldoEfetivado.value = ...
    // saldoRestante.value = ...
}

/**
 * Renderiza a lista de gastos na tela
 * 
 * @returns {void}
 */
function renderizarGastos() {
    // Limpa os gastos que estão na lista atualmente para depois poder redefinir 
    gastos.innerHTML = '';
    
    // Percorre a lista de gastos para poder inserir dentro do HTML
    for (let i = 0; i < listaGastos.length; i++) {
        // O gasto é um objeto com as propriedadws "nome", "data" e "valor" => { nome: String, data: String, valor: Number }
        const gasto = listaGastos[i]; // acessa o elemento atual da lista de gastos
        
        // Adiciona à estrutura HTML o elemento "li" com informações do gasto (nome, data e valor)
        gastos.innerHTML += `
            <li class="gasto">
                <div class="info">
                    <strong class="nome">${gasto.nome}</strong>
                    <span class="data">${gasto.data}</span>
                </div>
                <span class="valor">R$ ${gasto.valor}</span>
            </li>
        `;
    }
}