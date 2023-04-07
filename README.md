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

### Error Codes
Ответ при ошибке возвращает обычный 202 код, и имеет структуру 
```json
{
  "localizedMessage": "Invocation failureonds.... ",
  "errorMessage": "Error Parsing XML data",
  "errorCode": 1
}
```
- localizedMessage - стек-трейс ошибки
- errorMessage - описание ошибки
- errorCode - код ошибки

### Список кодов с ошибками
| Код ошибки | Описание ошибки            | Статус код |
|:-----------|:---------------------------|:-----------|
| 1          | Ошибка парсинга xml данных | 202        |
| ---        | ---                        | 202        |
| ---        | ---                        | 202        |

...