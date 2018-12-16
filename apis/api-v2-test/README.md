#Fluxo de trabalho

A primeira interação com a api foi através de testes exploratórios feitos via postman e linha de comando. Nesse ponto já conseguir gerar um report de bugs que foi enviando juntamente com o link desse repositório. 
Após isso utilizei java, maven, junit e rest assured para programação dos cenários de testes propostos.

#Rodar Testes

<code>
bash teste.sh $API_KEY $CPF $DATA_NASCIMENTO $NOME
</code>

Onde o primeiro valor deve ser de uma API_KEY válida os valores restantes precisam serão utilizados para o caso de teste 'Desconhecido'
