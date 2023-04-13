# spring-kotlin-stock-service
Base Stocks service (Moex) with SpringBoot 2.6 without Flux

### Build

Сначала собираем проект при помощи команды ( **_.jar_** файл будет в папке _build/libs_ )
```shell
./gradlew clean build
```
Затем собираем в docker образ командой
( предварительно нужно [скачать docker](https://www.docker.com/products/docker-desktop/) и установить)
```shell
docker build -t spring-boot-docker:0.0.1 .  
```
Затем запускаем на 8005 порту (вторая команда присваивает имя контейнеру)
```shell
docker run -p 8005:8005 spring-boot-docker:0.0.1
docker run -p 8005:8005 --name=springmoexapp spring-boot-docker:0.0.1
```
Остановить можно командой (после stop имя конейнера)
```shell
docker stop springmoexapp  
```

### Docker bash (optional)
- `docker-compose --version` - версия установленного docker-compose
- `docker start my_container` - стартуем контейнер по имени
- `docker container ls` - список запущенных контейнеров
- `dive <your-image-tag>` - смотрим что расположено по слоям в докере (утилита dive)

документация по коммандам лежит тут - https://docs.docker.com/engine/reference/commandline/start/  
скачать dive можно тут - https://github.com/wagoodman/dive

### Endpoints

#### /alive
Возвращает объект ErrorDTO с `error code: 0` если наше приложение работает

#### /bonds/getBondsByTickers 
Получить список облигаций по тикерам, в POST запросе передаем массив tickers c тикерами
интересующих облигаций. 
```json
{
  "tickers": [
    "tickerCode"
  ]
}
```
tickerCode - название, код тикера, например - RU000A0JS4Z7 (ВЭБ.РФ)
#### /bonds/getAllBonds
GET запрос - получаем список всех облигаций

#### /bonds/getCorporateBonds
GET запрос - получаем список всех корпоративных облигаций  

#### /bonds/getGovBonds
GET запрос - получаем список всех государственных облигаций

### Response Codes
Любой ответ, будь то ошибка или нет возвращает код 200.

#### Normal Response
Обычный ответ (корректный) включает в себя массив stocks с облигациями и объект error, в котором
указаны: сообщение об ошибке и ее код. 
```json
{
  "stocks": [
    {
      "ticker": "RU000A0JS4Z7",
      "figi": "RU000A0JS4Z7",
      "name": "ВЭБ.РФ 21",
      "type": "Bond",
      "currency": "RUB",
      "source": "MOEX"
    }
  ],
  "error": {
    "errorMessage": "no error",
    "errorCode": 0
  }
}
```
#### Error Response
Ответ при ошибке возвращает обычный 200 код, и имеет структуру 
```json
{
  "errorMessage": "Error Parsing XML data",
  "errorCode": 1
}
```
- errorMessage - описание ошибки
- errorCode - код ошибки

### Список кодов с ошибками
| Код ошибки | Сообщение              | Описание                   |
|:-----------|:-----------------------|:---------------------------|
| 0          | no error               | Ошибки нет                 |
| 1          | Error Parsing XML data | Ошибка парсинга xml данных |
| ---        | ---                    | ---                        |

...
