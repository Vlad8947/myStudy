# Java 9: модули.

Модули представляют собой пакеты, которые можно подключать к другим модулям, как зависимости.

Для обозначения нового модуля в корне создается файл _module-info.java_, в котором прописывается имя данного модуля. 

Рассмотрим пример подключения модуля _summodule_ к _modules_:

1) В конфиг файле (_module-info.java_) экспортируемого модуля (_summodule_) прописываем слово _exports_, после которого пишем имя модуля 
для внедрения (описанное в его конфиг файле). Таким образом мы описали, что данный модуль будет экспортирован в 
другой модуль.

2) В конфиг файле модуля для импорта (_modules_) пропишем _requires_ и имя импортируемого модуля (_summodule_).

Готово! Теперь классы одного модуля можно использовать в другом.