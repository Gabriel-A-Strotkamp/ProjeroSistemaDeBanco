Projeto: Sistema de Banco Digital Simplificado

Este projeto é um sistema de banco digital desenvolvido em Java com JPA (Hibernate) e Swing, focado em simular operações bancárias essenciais.
Ele permite que clientes realizem saques, depósitos e consultem seus saldos, enquanto gerentes têm controle total sobre o cadastro de clientes 
e o gerenciamento de contas. O sistema possui um robusto controle de acesso, garantindo que as funcionalidades e os dados de cadastro sejam 
acessíveis apenas ao tipo de usuário (cliente ou gerente) logado. A arquitetura utiliza a estratégia de herança JOINED no JPA, onde as entidades
Clientes e Funcionarios herdam de uma superclasse Pessoas, otimizando a modelagem e persistência de dados no PostgreSQL.
