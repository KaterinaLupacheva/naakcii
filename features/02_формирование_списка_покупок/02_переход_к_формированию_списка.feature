#language: ru
Функция: Переход к формированию списка покупок
  Как покупатель ищущий экономию
  Я хочу перейти к формированию списка покупок
  Чтобы добавить в него необходимые мне акционные товары

  Сценарий:
    Допустим я на странице "Сервис экономии - naakcii.by"
    Если я нажимаю на кнопку "Перейти к товарам"
    То должна открыться страница "Формирование списка покупок – naakcii.by"
    И в адресной строке браузера должен отобразиться адрес "http://178.124.206.54/form-shopping-list/"
    # Должно быть: И в адресной строке браузера должен отобразиться адрес "http://naakcii.by/form-shopping-list/
    И должен отобразиться фильтр "Торговые сети"
    И на фильтре "Торговые сети" должен отобразиться текст "Выбраны торговые сети: все"
    И должно отобразиться поле "Поиск товаров"
    И на панели "Список категорий" должны отобразиться следующие категории с соответствующими статусами:
      | категория                 | статус      |
      | Молочные продукты, яйца   | выбрана     |
      | Хлебобулочные изделия     | не выбрана  |
      | Овощи и фрукты            | не выбрана  |
      | Мясо и колбасные изделия  | не выбрана  |
      | Напитки, кофе, чай, соки  | не выбрана  |
      | Бакалея                   | не выбрана  |
      | Рыба и морепродукты       | не выбрана  |
    И на панели "Список подкатегорий" должны отобразиться следующие подкатегории с соответствующими статусами:
      | подкатегория          | статус  |
      | Все                   | выбрана |
      | Кисломолочные изделия | выбрана |
      | Масло                 | выбрана |
      | Молоко                | выбрана |
      | Мороженое             | выбрана |
      | Сметана               | выбрана |
      | Сыр                   | выбрана |
      | Творожные продукты    | выбрана |
      | Яйцо                  | выбрана |
    И на панели "Список акционных товаров" должны отобразиться карточки следующих товаров:
      | акционный_товар                                                                         | торговая_сеть |
      | Био сметана "Простоквашино" 15% 350гр                                                   | Белмаркет     |
      | Йогурт "Оптималь" Персик, Чернослив-злаки, Черника-Малина 2% жирность 350гр             | Белмаркет     |
      | Йогурт питьевой "Теос" 300г                                                             | Соседи        |
      | Йогурт Савушкин 2%, 120г                                                                | Виталюр       |
      | Кефир "Берёзка" 1,5% 950г                                                               | Соседи        |
      | Кефир "Минская Марка" 1.5% 900гр.                                                       | Белмаркет     |
      | Кефир "Стары Менск" 3,6%, 950г                                                          | Евроопт       |
      | Коктейль йогуртный Даниссимо Danone, Кокос/Шок.,/Капучино/Клубнич. морожен., 5,2%, 260г | Корона        |
      | Масло "Крестьянское", сл/слив., несол., 72,5%, 180 г.                                   | Рублёвский    |
    И должна отобразиться панель "Список покупок"
    И на панели "Список покупок" должен отобразиться следующий текст:
      """
      Ваш список покупок пока пуст.

      Чтобы добавить в него подходящие акционные товары,
      используйте кнопку «Добавить» на соответствующих карточках товаров.

      Чтобы поменять количество товара, используйте кнопки «+» и «-».
      """
