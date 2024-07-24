
# GCU Finance
 breve sobre o projeto. O que ele faz, qual problema resolve, etc.
 ## Índice 
 - [Sobre](#sobre)
 - [Funcionalidades](#funcionalidades)
 - [Instalação](#instalação) 
 - [Uso](#uso) 
 - [Licença](#licença) 


 ## Sobre 
 Este projeto começou como um trabalho de faculdade, com o objetivo de desenvolver um sistema que integra modelagem de banco de dados, JDBC, e arquitetura MVC, além de explorar o conceito de multi-tenant. 

### Histórico do Projeto

1.  **Início do Projeto**: O projeto foi iniciado como parte de um trabalho acadêmico, com foco em criar uma solução bem estruturada e robusta.
    
2.  **Desenvolvimento e Estudo**: Durante o desenvolvimento, foram explorados conceitos avançados, como modelagem de banco de dados, criação e gestão de banco de dados, integração com JDBC, e arquitetura MVC. Além disso, o estudo sobre multi-tenant foi incorporado para garantir a escalabilidade e flexibilidade do sistema.
    
3.  **Entrega e Avaliação**: Apesar de não estar completamente finalizado, o projeto foi entregue e recebeu a nota máxima pela sua abordagem técnica e pela qualidade do trabalho apresentado.
    
4.  **Continuidade do Projeto**: O desejo de aprimorar e expandir o projeto permanece, com planos para continuar o desenvolvimento e implementar funcionalidades adicionais.


### Objetivo
O projeto de gestão financeira visa criar uma aplicação robusta que possibilite o controle detalhado das finanças pessoais ou empresariais. A aplicação permitirá aos usuários registrar e categorizar suas receitas e despesas, facilitando o acompanhamento e análise das finanças. Além disso, oferecerá funcionalidades para o planejamento orçamentário, permitindo a criação de orçamentos mensais e anuais, e monitorará o cumprimento desses orçamentos ao longo https://dev.mysql.com/downloads/connector/j/do tempo.

Os usuários poderão gerenciar seus investimentos, acompanhar o rendimento e acessar relatórios de performance para tomar decisões informadas. A aplicação também integrará com bancos, permitindo a importação automática de transações e a conciliação de contas, o que facilita o gerenciamento financeiro e reduz erros.

Com uma interface amigável e relatórios detalhados, o sistema fornecerá insights valiosos sobre a situação financeira, ajudando a identificar áreas de economia e oportunidades de investimento. Para garantir a segurança dos dados, o sistema utilizará criptografia e oferecerá opções de backup automático.

 ## Funcionalidades 
 -Lista das principais funcionalidades do projeto. 
 - O que ele pode fazer e quais problemas ele resolve. - -Quaisquer características ou benefícios adicionais. 
  ## Instalação 
  Passos para instalar e configurar o projeto. 
 ### Requisitos 

 #### Mysql Configurado com credenciais padrão:

- Username: root

- Password:1234

- port: localHost:3306

---


- [JDK](https://www.oracle.com/br/java/technologies/downloads/) (Java Develper Kit)

- [NetBeans IDE](https://netbeans.apache.org/front/main/download/nb22/)

- [JDBC](https://dev.mysql.com/downloads/connector/j/) - Plataforma Independente

 ### Passos 1. Clone o repositório No Netbeans: 
[Como Clonar?](https://duodecimo.github.io/duodecimoMachineLearning/clonarProjetoNetbeansIDE/)
 ```bash 
 git clone https://github.com/seu-usuario/seu-repositorio.git
```
### Passo 2: Vincule o Driver de conexão ao 
Ao  clonar o projeto em sua maquina, voce precisará Baixar e extrair o driver do JDBC na sua maquina, após extrair vá até o Netbeans no Projeto, clique com o botão direito em cima do projeto, e navegue até "Resolve Project Problems...", como no exemplo visual:

![Exemplo Visual](/src/assets/%20Docs//MarkDown-01.png)

### 2.1 
Em seguida será exibida uma tela com os problemas de conexão, onde voce devera procurar o driver JDBC que foi baixado e extraido na sua maquina, para vincular o driver ao problema, basta clicar no problema e depois em "resolve", e navegue até onde o drive foi extraido, como está sendo mostrado no exemplo:

<video width="320" height="240" controls>
  <source src="/src/assets/Docs/MarkDown-03.mp4" type="video/mp4">
  Seu navegador não suporta o elemento de vídeo.
</video>

### 2.3
Após vincular o driver a todos os problemas, o projeto está totalmente apto para ser usado, clique com o botão direito em cima do projeto e em "run": 

![Exemplo visual](/src/assets/%20Docs/MarkDown-03.png)

