# conversor-moeda

# 💱 Currency Converter em Java

Este projeto é um **conversor de moedas em tempo real**, desenvolvido em **Java**, que utiliza a API **ExchangeRate** para buscar as taxas de câmbio atualizadas.  

## 🚀 Tecnologias Utilizadas

- **Java 11+**  
  - Utilização das classes `HttpClient` e `HttpRequest` para fazer requisições HTTP modernas e seguras.  
  - A classe `HttpResponse` foi usada para capturar e processar a resposta da API.  

- **Gson (Google JSON)**  
  - Biblioteca utilizada para **converter JSON em objetos Java**.  
  - Simplifica o parsing da resposta da API, que retorna dados em formato JSON.  

- **ExchangeRate API**  
  - Serviço externo usado para obter as taxas de câmbio.  
  - Permite converter entre múltiplas moedas em tempo real.  

## 📌 Funcionalidades

O sistema apresenta um **menu interativo no console**, onde o usuário pode escolher a conversão desejada:

1. **BRL → USD**  
2. **USD → BRL**  
3. **BRL → EUR**  
4. **EUR → BRL**  

Após a escolha, o usuário insere o valor a ser convertido, e o sistema retorna o valor atualizado com base nas taxas obtidas da API.  

## 🛠️ Como Executar

1. **Clonar o repositório**:
   ```bash
   git clone https://github.com/seuusuario/currency-converter-java.git
