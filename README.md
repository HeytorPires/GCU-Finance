
# GCU Finance
Gestão financeira não é um problema a este projeto, a gestão nunca foi tão facil e simples com apenas o Pouco bem feito, GCU visa Facilidade e usabilidade ao usuario sem deixar nenhuma duvida, dando a voce uma vontade de gerenciar cada vez mais suas movimentações.

 ## Índice 
 - [Sobre](#sobre)
 - [Funcionalidades](#funcionalidades)
 - [Instalação](#instalação) 
 - [Licença](/LICENCE) 


 ## Sobre 
 Este projeto começou como um trabalho de faculdade, com o objetivo de desenvolver um sistema que integra modelagem de banco de dados, JDBC, e arquitetura MVC, além de explorar o conceito de multi-tenant. 

### Histórico do Projeto

1.  **Início do Projeto**: O projeto foi iniciado como parte de um trabalho acadêmico, com foco em criar uma solução bem estruturada e robusta.
    
2.  **Desenvolvimento e Estudo**: Durante o desenvolvimento, foram explorados conceitos avançados, como modelagem de banco de dados, criação e gestão de banco de dados, integração com JDBC, e arquitetura MVC. Além disso, o estudo sobre multi-tenant foi incorporado para garantir a escalabilidade e flexibilidade do sistema.
    
3.  **Entrega e Avaliação**: Apesar de não estar completamente finalizado, o projeto foi entregue e recebeu a nota máxima pela sua abordagem técnica e pela qualidade do trabalho apresentado.
    
4.  **Continuidade do Projeto**: O desejo de aprimorar e expandir o projeto permanece, com planos para continuar o desenvolvimento e implementar funcionalidades adicionais.


### Objetivo
O objetivo do GCU é proporcionar uma visão ampla e simples da gestão financeira do usuário, permitindo acompanhar para onde vai e de onde vem o seu dinheiro. A plataforma facilita a visualização de despesas e receitas mensais, bem como de todas as movimentações financeiras, oferecendo um panorama completo das finanças pessoais.

 ## Funcionalidades 
 Funcionalidade por entidades:
 
 ### Usuario

- Cadastro de Usuario
- Login com credencias do usuario
- Alterar senha, nome e Email do usuario
- Apagar Todos os dados do usuario. 
  
### Despesas

- Cadastro de despesas.
- Listagem de despesas
- Filtro por meses e por anos, com possibilidade de um filtro complexos de data.
- Alterar dados da despesas.
- Apagar despesas. 

### Receitas

- Cadastro de receitas.
- Listagem de receitas
- Filtro por meses e por anos, com possibilidade de um filtro complexos de data.
- Alterar dados da receita.
- Apagar receitas. 

 ### Categorias

- Cadastro de Categorias.
- Listagem de Categorias
- Alterar dados da Categorias.
- Apagar Categorias. 
  

 ## Requisitos 

 #### Mysql Configurado com credenciais padrão:

- Username: root

- Password:1234

- port: localHost:3306

---


- [JDK](https://www.oracle.com/br/java/technologies/downloads/) (Java Develper Kit)

- [NetBeans IDE](https://netbeans.apache.org/front/main/download/nb22/)

- [JDBC](https://dev.mysql.com/downloads/connector/j/) - Plataforma Independente

# Instalação 
  Passos para instalar e configurar o projeto.
 ### Passos 1. Clone o repositório No Netbeans: 
[Como Clonar?](https://duodecimo.github.io/duodecimoMachineLearning/clonarProjetoNetbeansIDE/)
 ```bash 
 git clone https://github.com/seu-usuario/seu-repositorio.git
```
### Passo 2: Vincule o Driver de conexão ao Projeto
Ao  clonar o projeto em sua maquina, voce precisará Baixar e extrair o driver do JDBC na sua maquina, após extrair vá até o Netbeans no Projeto, clique com o botão direito em cima do projeto, e navegue até "Resolve Project Problems...", como no exemplo visual:

![Exemplo Visual](/src/assets/%20Docs//MarkDown-01.png)

### 2.1: Anexar Drive
Em seguida será exibida uma tela com os problemas de conexão, onde voce devera procurar o driver JDBC que foi baixado e extraido na sua maquina, para vincular o driver ao problema, basta clicar no problema e depois em "resolve", e navegue até onde o drive foi extraido, como está sendo mostrado no exemplo:

[Download do vídeo](https://github.com/HeytorPires/GCU-Finance/raw/main/src/assets/%20Docs/MarkDown-03.mp4)



### 2.2: Rodar o Projeto
Após vincular o driver a todos os problemas, o projeto está totalmente apto para ser usado, clique com o botão direito em cima do projeto e em "run": 

![Exemplo visual](/src/assets/%20Docs/MarkDown-03.png)


Pronto o GCU Finance já estará rodando em sua maquina. 
Caso tenha duvidas meu Email para contato:

[Enviar e-mail](mailto:heytor.cacho29@gmail.com)


