Привет! На связи домашнее задание к уроку 4.1. Продолжение знакомства с SQL.

В этом курсе мы продолжим работать с проектом, который создавали на третьем курсе. А это значит, что наш выдуманный Хогвартс всё еще существует!

В домашнем задании нам предстоит добавить больше функционала в проект путем добавления новых эндпоинтов. Эти эндпоинты будут использовать методы репозиториев, которые, в свою очередь, будут выполнять SQL-выражения из Java. А также настроим пагинацию для аватарок.

Шаг 1. Использование аннотации 
@Query
 для вызова SQL из приложения.

Используйте аннотацию 
@Query
 и добавьте следующий функционал в проект:

Возможность получить количество всех студентов в школе. Эндпоинт должен вернуть число.
Возможность получить средний возраст студентов. Эндпоинт должен вернуть число.
Возможность получать только пять последних студентов. Последние студенты считаются теми, у кого идентификатор больше других.
Шаг 2. Добавление пагинации к аватаркам.

Добавьте пагинацию для репозитория 
AvatarRepository
 и контроллер в 
AvatarTController
, чтобы можно было получать списки аватарок постранично.
