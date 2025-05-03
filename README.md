# Лабораторная работа №1 - Docker
Лаба **уже поднята** на личной тачке [тыкни на меня](http://77.90.33.48:8080). Можно сразу перейти к [тестированию endpoint'ов](#test) 

Или поднять проект локально и выполнить [тестирование](#test)
## Установка
1. Склонируйте проект
```git clone https://github.com/dzhager3354/docker-lab1.git```

3. Перейдите в склоненную папку
```cd docker-lab1```

4. Запустите билд композа
```docker-compose --env-file app.env build```

`app.env` нужен для удобного конфигурирования открытого порта приложения.

Измените параметр `PORT` в `app.env` для открытия приложения на другом порту.

6. Запуск получившегося образа
```docker-compose up```

## <a id="test">Тестирование приложения </a>
Приложение представляет собой todo-list. 
Формат хранимого объекта:
```json
{
  "id": 0,
  "name": "",
  "description": "",
  "deadline": "2025-05-03"
}
```
Поле `name` является **обязательным** и неуникальным

### API
- GET: /todos
  
  Возвращает список всех дел
  
  Принимаемые параметры: нет

  Curl: ```curl http://77.90.33.48:8080/todos```


- GET: /todo?id=
  
  Возвращает дело по id
  
  Принимаемые параметры: `id дела, число`

  Curl: ```curl http://77.90.33.48:8080/todo?id=```

  
- POST: /todo
  
  Создаёт объект и возвращает его с id
  
  Принимаемые параметры: `todo`
  ```json
  {
    "name": "",
    "description": "",
    "deadline": ""
  }
  ```

  Curl: ```curl --header "Content-Type:application/json" --request POST --data '{"name":"hello world", "description": "hi", "deadline": null}' http://77.90.33.48:8080/todo```

- DELETE: /todo?id=

  Удаляет объект по id

  Принимаемые параметры: `id дела, число`

  Curl: ```curl --request DELETE http://77.90.33.48:8080/todo?id=```

  

