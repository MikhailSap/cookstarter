###### “CookStarter”

```
Сервис для подачи удаленных заявок на приготовление блюд в организациях общепита — кафе, рестораны, пиццерии. 
Везде где необходимо ожидать приготовления заказа.
```
```
Цель сервиса — экономия времени клиента на ожидание приготовления заказа. 
Для тех кто не любит ждать приготовления пищи и общаться с персоналом заведения.
```

Примеры:
```
1. Компания деловых людей отправляются провести переговоры в ресторан, по дороге делают заказ, по приезду подают блюда.

2. Отправить заказ в пеццерию по дороге домой на вынос. Проходя мимо забирать заказ.
```


Сервис можно разделить на две части:
```
1. Сторона клиента — веб сайт, мобильное приложение.

2. Сторона общепита — веб сайт, мобильное приложение.
```

Типовой сценарий:
```
1.Клиент заходит в систему под своим аккаунтом 
2.Находит ресторан 
3.Выбирает блюда, устанавливает количество, подтверждает заказ 
4.На стороне ресторана приходит заказ 
5.Менеджер ресторана передает заказ на кухню
```


Модули системы (реализованы):


1. Пользовательское веб приложение.
```
```

2. Пользовательское Android приложение.
```
https://play.google.com/store/apps/details?id=ru.anatomica.cookstarter
```

3. Веб приложение для рестарана.
```
```

4. Сервис для регистрации и аунтентификации пользователей.
```
https://cookstarter-users-service.herokuapp.com
```

5. Сервис для изображений.
```
https://picture-service.herokuapp.com
```

6. Сервис для данных ресторанов (описание, меню и тд).
```
https://cookstarter-restaurant-service.herokuapp.com
```

7. Сервис для данных о заказе.
```
https://cs-order-service.herokuapp.com
```

API сервисов:
```
service_path/swagger-ui.html
```

Общий файл с API:
```
https://github.com/MikhailSap/cookstarter/blob/master/documentation/all%20services%20API.md
```
