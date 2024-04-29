## How to use
```bash
mvn clean && mvn install -DskipTests
```
```bash
mvn spring-boot:run
```
 Aqui tem as configurações de porta do seu local host que pode ser editado para a API !
![Change Port](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/ce047a50-8d4c-4c63-9900-8de11bbc573d)

Temos uma API CRUD básica
![Create](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/5b97bcc1-ee02-4ce3-9982-ae5bb3e0e4b0)
![Read](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/90e6310a-3a47-4537-8e3d-95df31994503)
![Update](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/01b9ced1-a75b-4e0c-9492-fb69220e3944)
![Delete](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/001a5291-ba83-4694-940a-0afc1a73153f)




## About me
Em busca de um sonho!

Sempre fui sonhador, já quis ser astronauta, jogador de futebol e mais tarde sendo um pouco mais realista programador. Desde muito novo gosto de programar, quando eu tinha 13 anos criei sozinho meu servidor de um jogo que eu gostava muito, que era Tibia. Eu e meus primos administramos esse servidor por um tempo, mas como meus recursos eram limitados acabei abandonando o projeto, não tinha como melhorar minha máquina e nessa época ainda não existia o milagre da nuvem.
O tempo passou e acabei me afastando um pouco da programação, mas sempre acompanhando de perto o mercado tecnológico. Entrei no ramo da representação têxtil, foi uma época legal, viajei muito, conheci muitos lugares e pessoas. Aprendi a negociar e a vender, o ramo aos poucos foi entrando em declínio, as vendas já não eram mais boas como antigamente, até que em 21 de Fevereiro de 2023 chegou a minha filha, a pequena Serena,  trazendo uma tempestade de amor para minha vida.Tomei a decisão de seguir meu sonho, afinal como iria falar para ela perseguir seus sonhos sem ir atrás do meu? 

Hoje estou me preparando para enfrentar qualquer desafio. Quando você vira pai suas forças dobram, você começa a crer numa melhora do mundo como um todo e tirar forças que você achava que nem existiam para encarar os problemas. A vida é muito mais bela, meus dias são muito mais bonitos e cansativos também, nem tudo são flores, mas não existe prazer melhor no mundo que chegar em casa após um dia corrido e ver aquele sorriso com poucos dentinhos. Hoje me sinto privilegiado em acompanhar seus primeiros passos suas primeiras palavras, ela é a coisa mais linda que já aconteceu na minha vida e agradeço todos os dias.

E à você caríssimo leitor eu só queria deixar uma mensagem, insista, persista e nunca desista !

## SQL Querys
* Quantidade de funcionários por gênero
![GroupByGender](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/bb3ef579-3a86-409a-8192-4f36bc2b89c9)
* Quantidade de funcionários distintos por gênero e ano de nascimento
![GroupByGenderAndBirthYear](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/539d5bc0-d60d-4e5d-856d-8822ab0466c1)
* Quantidade de funcionários distintos por gênero, ano de nascimento e data de contratação
![GroupByGenderBirthYearAndHiredYear](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/affa98ba-55cf-4d07-975d-5fa5d123c081)
* Média, min e max dos salários por gênero
![AvgMinMax](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/d932b930-535a-4b3a-a209-4ddf0c482deb)

## Análise Grafana
### Login Graph
![LoginGraph](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/ec925258-8a29-45fb-a034-eb27e9014a6e)

Nesse gráfico temos uma métrica de usuários logados no site por minuto nos últimos 20 minutos.
### Memory/CPU
![MemoryAndCPU](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/fe9f2527-f994-47c8-aaff-fffc58d17757)

Aqui temos um gráfico do uso de memória e CPU, está indicando que o sistema não está sobrecarregado, não passando dos 20% da capacidade.
### Memory, Google Hits, Support Calls and Sing ups
![Memory, Google Hits, Support Calls and Sing ups](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/1fbc2d5c-7d68-4c7c-877e-c7893f442766)

**Memory:** Aqui está mostrando a quantidade de memória utilizada está em uma quantidade bem baixa e sem sobrecargas pro sistema
**Google Hits:** Aqui se trata de uma métrica de aparições do site no Google <br>
**Support Calls:** Aqui é o número de pessoas que fazem chamadas pro suporte no aplicação <br>
**Sign Ups:** Quantidade de pessoas que saíram da aplicação

### Server Request
![ServerRequests](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/c32bc56c-9c98-42b3-8ab7-2e464a4b3490)

Aqui é o número de requisições no site, o servidor provavelmente possuem um load balancer para equilibrar a carga e assim não sobrecarregar, prevenindo erros.

### Google Series Hits
![Google Series Hits](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/140951b1-edb8-4262-83c6-ee874abb25c3)

Esse gráfico mostra o número de vezes em que a pesquisa no Google chegou mais perto de corresponder com o site, a série A mostra as vezes que o site apareceu em primeiros nas pesquisas, a series B quando ficou um pouco a baixo dos primeiros resultados da pesquisa e assim por diante.

### Client Side Full Page Load
![Client Side Full Page Load](https://github.com/devRenatoRodrigues/digiage-project/assets/115325126/c203de04-2e74-4d24-82e8-a05ca487da59)

Nesse gráfico podemos ver o tempo que demora para a página carregar no lado do cliente, o tempo de carregamento está um pouco elevado para a maioria dos usuários, da pra melhorar esse tempo. 

