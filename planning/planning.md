# Como falhar com qualidade de software na IDWall



## Introdução

Esse texto foi criado utilizando uma técnica de pensamento lateral que funciona da seguinte maneira: ao invés de atacar o problema diretamente, pensamos em como garantir que o problema não seja solucionado. Após ter as condições necessárias para o problema continuar.
Cada subtítulo daqui em diante é uma maneira de garantir a falha de qualidade. O primeiro parágrafo descreve melhor o item e os parágrafos a seguir descrevem como combater esse problema.

## Garantir que qualidade é trabalho apenas do setor de qualidade

Qualidade como responsabilidade única do setor Quality Assurance (QA) leva a alguns problemas conhecidos. Cultura de QA versus desenvolvedores. Transferências de culpa para QA e outras situações diversas. 
Para combater esse problema é necessário a criação de um cultura de qualidade dentro de todos os níveis da empresa. Todos os níveis precisam ser cobertos pois sempre os níveis superiores estão refletidos nos níveis inferiores. Se uma pessoa no cargo de chefia diz que testes são desnecessários então seus colaboradores têm um aval para desconsiderar tais boas práticas.
Deve ser claro que qualquer falta de qualidade leva a um prejuízo financeiro real. E esse dinheiro impacta na vida da empresa e de seus funcionários. A empresa perde tempo investindo em retrabalho ao invés de investir entregas novos valores.

## Não esclarecer para os novatos como a qualidade deve ser levada a sério

Pessoas novatas na empresa possuem background diversos. Backgrounds que podem incluir uma cultura de testes a qual existia um setor de testes isolado. Ou o novato devem estar tendo seu primeiro emprego com carteira assinada. 
Todos devem estar na mesma página desde o inicio. É interessante apresentar esses conceitos já no processo de onboarding dos recém contratados. A apresentação pode ser feita através de videos ou leituras de artigos preparados.

## Escrever testes não descartáveis

Como todo código fonte o código de testes requerem esforço e tempo para serem escritos. Como todo código fonte precisam de boas práticas para evitar crescimento orgânico. Também recebem impactos diretos quando mudanças ocorrem no System Under Test (SUT). Tais impactos se traduzem em retrabalhos que impactam na entrega de valor.
Testes devem ser escritos de maneira descartáveis. Devem estar prontos para serem jogados fora a qualquer momento, sem remossos. Utilização de ferramentas que possibilitem o capture and replay dos testes de maneira automatizada reduzem o impacto de reescrita de testes.

## Qualidade não ser tratada como parte do processo de desenvolvimento

Testes quando não são considerados parte do desenvolvimento não são levados em conta na hora das estimativas. Levando a momentos surpresas nos finais das entregas. Não ser levado em conta desde o começo pode levar a oportunidades desperdiçadas de resolver erros logo no começo do desenvolvimento.
Os testes devem ser escritos para estar presentes sempre que necessários. Seja no servidor de integração contínua seja no controle de versão para serem baixados pelos desenvolvedores. Nesse último caso é interessante a possibilidade dos testes residirem dentro do mesmo repositório do SUT.
Em outro aspecto qualidade deve estar entranhada dentro do desenvolvimento em si. Questões sobre SOLID, Design Patterns e etc devem ser o dia a dia dos desenvolvedores. Tais técnicas fazem o software ser mais robusto de maneira que novas funcionalidades não quebrem as antigas. 
Utilização de análise estática de código para evitar problemas de programação. Tal objetivo pode ser conseguido através de linters, regras de análise de código já utilizadas em outras empresas de referência, assim como criação de regras da casa.

## Tentar colocar de uma vez 100% de cobertura 

Cem por cento de cobertura é um número invejável que poucas empresas possuem. E transformações foram necessárias para atingir esse objetivo. Tais transformações não foram implementadas da noite para o dia. 
“Toda grande caminhada começa com apenas um passo”, disse Mao Tsé Tung. O objetivo é automatizar e ganhar expertise sobre o desafios que aparecerão durante o processo. Assim como a cada novo projeto de software desafios novos aparecem o mesmo ocorre a cada projeto de automação.
Existem duas abordagem para decidir os primeiros passos. A regra 80/20 ou análise de risco. Na regra 80/20 será escolhido os 20% dos casos de uso que possuem 80% da importacia, freqüência de uso e etc. Na análise de risco um estudo será feito calculando os risco dos casos de usos e depois priorizar quais não podem conter erros.
O que importa é que após decidir o primeiro passos os outros sejam planejados adequadamente e estejam alocados no cronograma. A ideia é entregar as automações que entreguem mais valor primeiramente.

## Não ter uma boa prática para controle de bugs

Bugs são uma verdade em desenvolvimento de software. Não controlar os bugs pode acarretar em perca de tempo em correção de bugs de baixo valor para os clientes.  Bugs mal documentados podem ser um desperdício de tempo para as partes envolvidas na resolução do problemas.
Bugs precisam passar por classificação e análise de risco. Classificar envolve dizer se o bug é de usabilidade, segurança, funcionalidade e etc. Analisar o risco é calcular o impacto e a probabilidade do bug de maneira que facilite a tomada de decisão para saber a importância do bug.
Bugs são comunicações e devem ser bem documentados para facilitar o trabalho das partes. Quem for resolver o problema deve conseguir reproduzir o bug a partir do bug reporting do mesmo. Por isso a clareza é importante.


## Não monitorar o ambiente de produção a procura de bugs

Ambiente de produção é uma fera diferente do ambiente controlado de testes. Neste último o SUT é executado em um ambiente super controlado sem concorrência de disco, rede ou banco de dados.
Com testes automatizados e software de monitoramento é possível executar testes periódicos em produção para saber a saúde do mesmo e identificar bottlenecks antes mesmo que os clientes notem. Isso pode ser alcançado através de uma conta de teste rodando em ambiente de produção.
Logs podem ser analisados para encontrar exceções inesperadas em tempo de execução já disparando relatórios para as partes envolvidas. 
Além das métricas já conhecidas, métricas internas do sistema podem ser criadas para avaliar a saúde do mesmo. Um threshold por métrica é definido para alertar as equipes caso o mesmo seja ultrapassado. Exemplos de métricas: throughput de upload de arquivos,  relatórios gerados por minutos e etc.

