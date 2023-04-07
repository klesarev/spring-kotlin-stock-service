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

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.10/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.10/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.10/reference/htmlsingle/#web)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
* [Spring cache abstraction](https://docs.spring.io/spring-boot/docs/2.7.10/reference/htmlsingle/#io.caching)