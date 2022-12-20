# Task-Clevertec
## Технологический стэк проекта
- Java 17
- Gradle 7.5
- Spring Boot 3.0.0
- PostgreSQL
- Spring Data JPA
- Thymeleaf
- Lombok
## Описание проекта
> src/main/java/
>> edu/clevertec/task/  
>>> controller/ - содержит класс для работы с визуальной частью(отправка модели чека на View);
>>>> model - содержит основный модели БД(Product; DiscountCard) и чека(Receipt)</br>
>>>> receipt - пакет, который содержит основную логику для создания чеков</br>
>>>> builder - содержит основную логику создания чека(Pattern Builder)</br>
>>>> converter - преобразует входную строку в модели, необходимые для расчета</br>
>>>> count - осуществляет подсчет суммы чека со скидкой и без(Pattern Decorator)</br>
>>>> exception - содержит исключения, которые могут возникунть при работе приложения</br>
>>>> lines - реализует работы со строками(проверка и парсинг)</br>
>>>> writer - содержит класс для записи чека в файл</br>
>>>
>>> repository - нужен для взаимодействия с таблицами базы данных</br>
>>> service - реализует основную логику сборки чека
>>
>> resources/ - содержит основный конфигурационный файлы для spring(application.properties) и базы данных(data.sql; schema.sql)
>>> templates - содержит файл отображения чека(receipt.html)
## Запуск
1) Изменить путь к файлу сохранения чека в src/main/java/writer/ReceiptWriter
2) Собрать проект с помощью команды gradle build
3) Запустить проект, если используется IDE или перейти в папку build/libs и выполнить команду java -jar taskClevertec-0.0.1-SNAPSHOT.jar
4) Открыть браузер и перейти по адрессу http://localhost:8080/check/строка_с_товарами (http://localhost:8080/check/3-1 4-2 card-4444)
