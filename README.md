# Simulador de Sistema de Arquivos com Journaling

## Integrantes

- Lucas Araripe
- Thiago Holanda

---

# Introdução

O gerenciamento de arquivos é uma das funções fundamentais dos sistemas operacionais. Um sistema de arquivos é responsável por organizar, armazenar e controlar o acesso aos dados armazenados em dispositivos de armazenamento.

Este projeto consiste no desenvolvimento de um simulador de sistema de arquivos utilizando Java, permitindo a execução de operações básicas de manipulação de arquivos e diretórios.

Além disso, foi implementado um mecanismo de Journaling para registrar as operações realizadas e demonstrar como sistemas reais mantêm a integridade dos dados.

---

# Objetivo

Desenvolver um simulador de sistema de arquivos em Java capaz de executar operações básicas de gerenciamento de arquivos e diretórios, utilizando o conceito de Journaling para registrar todas as operações executadas.

---

# Parte 1 – Sistema de Arquivos e Journaling

## O que é um Sistema de Arquivos?

Um sistema de arquivos é a estrutura utilizada pelo sistema operacional para armazenar, organizar e recuperar informações em dispositivos de armazenamento.

Ele permite:

- Criar arquivos;
- Apagar arquivos;
- Renomear arquivos;
- Criar diretórios;
- Organizar informações hierarquicamente.

## O que é Journaling?

Journaling é uma técnica utilizada por sistemas de arquivos modernos para registrar operações em um log antes ou durante sua execução.

O objetivo é garantir maior integridade dos dados e permitir recuperação em caso de falhas inesperadas.

### Tipos de Journaling

#### Write-Ahead Logging (WAL)

Primeiro registra a operação no log e depois executa a alteração.

#### Log Structured

As operações são armazenadas continuamente em uma estrutura de log.

#### Metadata Journaling

Somente alterações na estrutura do sistema de arquivos são registradas.

---

# Parte 2 – Arquitetura do Simulador

## Estruturas de Dados Utilizadas

O projeto foi dividido em cinco classes principais:

### SimFile

Representa um arquivo.

### Directory

Representa um diretório contendo arquivos e outros diretórios.

### FileSystemSimulator

Implementa as operações do sistema de arquivos.

### Journal

Responsável pelo registro das operações realizadas.

### Main

Classe principal utilizada para testar o simulador.

---

# Implementação do Journaling

Cada operação executada é registrada automaticamente no arquivo:

text journal.log 

Exemplo:

text [CREATE_DIR] Diretório criado: documentos [CREATE_FILE] Arquivo criado: arquivo1.txt [COPY_FILE] arquivo1.txt -> copia_arquivo1.txt 

---

# Parte 3 – Implementação em Java

## Operações Implementadas

### Diretórios

- Criar diretório
- Apagar diretório
- Renomear diretório

### Arquivos

- Criar arquivo
- Copiar arquivo
- Apagar arquivo
- Renomear arquivo

### Listagem

- Listar conteúdo do diretório

### Journaling

- Registrar todas as operações realizadas

---

# Parte 4 – Instalação e Funcionamento

## Requisitos

- Java JDK 8 ou superior
- IDE Java (IntelliJ, Eclipse ou VS Code)

## Execução

Compilar:

bash javac src/*.java 

Executar:

bash java -cp src Main 

Durante a execução será criado automaticamente o arquivo:

text journal.log 

que armazenará o histórico das operações realizadas.

---

# Exemplo de Journaling Gerado

text 2026-05-28T20:14:16.601438 - [CREATE_DIR] Diretório criado: documentos 2026-05-28T20:14:16.606316 - [CREATE_DIR] Diretório criado: imagens 2026-05-28T20:14:16.606607 - [CREATE_FILE] Arquivo criado: arquivo1.txt 2026-05-28T20:14:16.606716 - [CREATE_FILE] Arquivo criado: arquivo2.txt 2026-05-28T20:14:16.606905 - [COPY_FILE] arquivo1.txt -> copia_arquivo1.txt 2026-05-28T20:14:16.607037 - [RENAME_FILE] arquivo2.txt -> arquivo_renomeado.txt 2026-05-28T20:14:16.607175 - [RENAME_DIR] imagens -> fotos 2026-05-28T20:14:16.607379 - [LIST_DIR] Listagem do diretório root 2026-05-28T20:14:16.607839 - [DELETE_FILE] Arquivo apagado: copia_arquivo1.txt 2026-05-28T20:14:16.608075 - [DELETE_DIR] Diretório apagado: fotos 2026-05-28T20:14:16.608210 - [LIST_DIR] Listagem do diretório root 

---

# Resultados Esperados

O simulador permite compreender de forma prática o funcionamento básico de um sistema de arquivos e a importância do Journaling na manutenção da integridade das informações.

---

# Link do GitHub
https://github.com/luksbzerra/FileSystemSimulator/