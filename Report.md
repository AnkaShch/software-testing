## Сравнение Cypress и Playwright
### Cypress

Плюсы:
- простой UI
- сам записывает видео и скрины (для ошибочных тестов)
Минусы:
- нельзя запустить через jest

### Playwright

Плюсы:
- простой UI
- можно выбрать браузер и устройство для тестирования
- запускается через jest
Минусы:
- излишний синтаксис

Мне больше понравился playwright, потому более интуитивно понятные команды.

Мое приложение не выводит надписи об удачной/неудачной попытке залогиниться (в разработке), из-за чего осложняется Unit и component тестирование авторизации. Визуальное е2e тестирование позволяет увидеть, что авторизация по какой-то причине не удалась и мы остались на странице с ней.