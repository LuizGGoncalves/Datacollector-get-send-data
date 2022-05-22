# DataCollector

<img src="https://programathor.com.br/blog/wp-content/uploads/2018/08/api-768x768.png" alt="exemplo imagem">

>Projeto com objetivo de criar duas Apis a primeira [Datacollector-get-send-data](https://github.com/LuizGGoncalves/Datacollector-get-send-data)  responsavel por coletar dados de uma Api externa e enviar
> para a segunda Api [Datacollector-store-data-api](https://github.com/LuizGGoncalves/Datacollector-store-data-api) para que sejam armazenados e depois acessados.


### Criado Utilizando
* SpringBoot
* jackson
* Junit5
* Mockito

## Fluxo de Funcionamento

### Fazendo a requisiçao.
+ Realiza a requisiçao GET no client(AlphaVantage)
+ Utiliza o jackson para adequar as informaçoes conforme o model.

### Enviando informaçoes
+ Utilizando jackson para adequar o model aos padroes da Api que sera enviado.
+ Com base no model é enviado um POST para a api [Datacollector-store-data-api](https://github.com/LuizGGoncalves/Datacollector-store-data-api)
+ Recebimento do status.