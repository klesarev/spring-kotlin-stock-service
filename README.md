# spring-kotlin-stock-service
Base Stocks service (Moex) with SpringBoot 2.6

## Error Codes
### Ответ от сервера
Ответ при ошибке возвращает обычный 202 код, и имеет структуру 
```json
{
  "localizedMessage": "Invocation failureonds.... ",
  "errorMessage": "Error Parsing XML data",
  "code": 1
}
```
- localizedMessage - стек-трейс ошибки
- errorMessage - описание ошибки
- code - код ошибки

### Список кодов с ошибками
| Код ошибки | Описание ошибки            | Статус код |
|:-----------|:---------------------------|:-----------|
| 1          | Ошибка парсинга xml данных | 202        |
| ---        | ---                        | 202        |
| ---        | ---                        | 202        |

...