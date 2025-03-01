ru text
# Условия домашки
>
 На связи домашнее задание к уроку 4.1. Продолжение знакомства с SQL.

В этом курсе мы продолжим работать с проектом, который создавали на третьем курсе. А это значит, что наш выдуманный Хогвартс всё еще существует!
>

В домашнем задании нам предстоит добавить больше функционала в проект путем добавления новых эндпоинтов. Эти эндпоинты будут использовать методы репозиториев, которые, в свою очередь, будут выполнять SQL-выражения из Java. А также настроим пагинацию для аватарок.

### Шаг 1. Использование аннотации 
@Query

 для вызова SQL из приложения.

Используйте аннотацию 
@Query

 и добавьте следующий функционал в проект:

 - Возможность получить количество всех студентов в школе. Эндпоинт должен вернуть число.
 - Возможность получить средний возраст студентов. Эндпоинт должен вернуть число.
 - Возможность получать только пять последних студентов. Последние студенты считаются теми, у кого идентификатор больше других.
### Шаг 2. Добавление пагинации к аватаркам.

Добавьте пагинацию для репозитория 
AvatarRepository
 и контроллер в 
AvatarTController
, чтобы можно было получать списки аватарок постранично.

eng text
# Homework conditions
>
The homework for lesson 4.1 is in touch. Continuing acquaintance with SQL.

In this course, we will continue to work with the project that we created in our third year. And this means that our fictional Hogwarts still exists!
>

In the homework, we have to add more functionality to the project by adding new endpoints. These endpoints will use repository methods, which, in turn, will execute SQL expressions from Java. We will also set up pagination for avatars.

### Step 1. Using Annotations 
@Query

 to call SQL from the application.

Use an annotation 
@Query

 and add the following functionality to the project:

 - The ability to get the number of all students in the school. The endpoint should return a number.
 - The opportunity to get the average age of students. The endpoint should return a number.
 - The opportunity to receive only the last five students. The last students are considered the ones with the ID above the others.
### Step 2. Adding pagination to avatars.

Add pagination for the repository 
AvatarRepository
 and the controller in 
AvatarTController
, so that you can get lists of avatars page by page.
