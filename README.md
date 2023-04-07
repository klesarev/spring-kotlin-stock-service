# spring-kotlin-stock-service
Base Stocks service (Moex) with SpringBoot 2.6

### Endpoints

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
