![superalogo](https://user-images.githubusercontent.com/80921933/168400494-46bfa545-764e-494c-aa71-7ea101a09923.png)
# Teste técnico - Supera 

>Status: Concluído ✔️

## Tecnologias usadas:

+ Java
+ Spring Boot
+ Spring Data JPA
+ Hibernate
+ H2

## Como rodar a aplicação?

+ 1- Clone o projeto para o diretório desejado
+ 2- Abra um terminal (git bash, de preferência) na raiz do projeto
+ 3- Execute os seguintes comandos:

```
mvn clean install
mvn clean package
```

+ 4- Acesse os endpoints da aplicação, via `localhost:8080/{endpointDesejado}`

## Endpoints disponíveis

<table>
  <tr>
    <th>Verbo HTTP</th>
    <th>Ação</th>
    <th>URL</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>Lista todas as transferências</td>
    <td>localhost:8080/transferencias/all</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>Lista todas as transferências de uma determinada conta</td>
    <td>localhost:8080/transferencias/[contaId]</td>
  </tr>
  <tr>
    <td>GET (com <b>@RequestBody</b>)</td>
    <td>Lista as transferências filtradas</td>
    <td>localhost:8080/transferencias</td>
  </tr>
</table>

Optei pela utilização do <b>@RequestBody</b> para a realização da filtragem. A classe responsável pela mesma é a FiltroRequestDTO, que aceita as seguintes chaves:

+ <b>dataInicio</b> <br>
+ <b>dataFim</b><br>
+ <b>nomeOperador</b><br> 

Para as chaves <b>dataInicio</b> e <b>dataFim</b>, temos os seguintes formatos disponíveis: <b>dd-MM-yyyy</b> ou <b>dd-MM-yyyy hh:mm:ss</b> (sendo o hh:mm:ss opcional). Além disso, como requisito do projeto, o filtro datado só poderá ser aplicado quando ambas as datas forem informadas.

Abaixo, seguem exemplos de uso correto da ferramenta de filtragem:

A) Filtro listando todas as transferências entre as datas <b>01/03/2021</b> e <b>01/04/2021</b> do usuário <b>Ronnyscley</b><br>
![filtro1](https://user-images.githubusercontent.com/80921933/168403139-0775094c-5b04-4db0-b59e-189cfa2c2d6b.png)


B) Filtro listando todas as transferências entre às <b>01:50:10</b> do dia <b>01/03/2021</b> até às <b>00:00:00</b> do dia <b>01/04/2021</b>
![filtro2](https://user-images.githubusercontent.com/80921933/168403259-a6c1dd98-86aa-4fdf-a3e9-b185faeaf5e4.png)

C) Filtro listando todas as transferências entre às <b>6 e 7 da manhã</b> do dia <b>01/05/2022</b> do usuário <b>Beltrano</b><br>
![filtro3](https://user-images.githubusercontent.com/80921933/168403614-068df3e4-5fdb-4280-b778-143bbebe31a4.png)

D) Filtro listando todas as transferências do usuário <b>Fulano</b><br>
![filtro4](https://user-images.githubusercontent.com/80921933/168403784-df07d3b2-74a8-46c0-bbc8-14b71d1b7b39.png)









## Features

+ <b>Exceções personalizadas:</b> O código foi programado para lançar exceções descritivas, que auxiliam o programador a encontrar a origem do problema. Alguns exemplos do uso de exceções personalizadas são:

A) <br>



B) <br>




## Melhorias

+ Implementar endpoint para buscar todas as possíveis rotas;
+ Implementar testes de Controller;
+ Consumir a API com uma interface web. 
