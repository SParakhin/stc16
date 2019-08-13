----- Категория.
INSERT INTO public.category (name, pictureurl, parent_category_id)
VALUES ('Игрушки',
        'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.dutchsalvage.com%2Fwp-content%2Fuploads%2F2017%2F02%2FZil-130-USSR-tintoy-dumptruck-10.jpg&f=1',
        null);


----- Товары. Можно запускать как есть, а можно store_id раскидать вручную рандомно.
INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Самосвал для песочницы',
        'Самосвал',
        'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.dutchsalvage.com%2Fwp-content%2Fuploads%2F2017%2F02%2FZil-130-USSR-tintoy-dumptruck-10.jpg&f=1',
        13,
        'Самосвал для песочницы',
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Юные любители собирать сложные модели техники по достоинству оценят этот игровой набор от LEGO Technic.',
        'Конструктор ЛЕГО Техник Скоростной вездеход с ДУ',
        'https://cdn.toy.ru/upload/iblock/576/42095_3.jpg?_cvc=1565378433',
        5999,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Классическая настольная игра "UNO" – отличное семейное развлечение. ',
        'Классическая карточная игра Уно',
        'https://cdn.toy.ru/upload/iblock/1c1/50236600_8634541.jpg?_cvc=1565378433',
        5999,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Лучший в мире актёр, который не оставит равнодушным никого!',
        'Райан Гослинг',
        'http://healingarts.ru/wp-content/uploads/2018/07/big_startfilmru1396646-300x199.jpg',
        100500,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Набор конструктора LEGO Minecraft Пещера зомби состоит из 241 детали. ',
        'Конструктор ЛЕГО Майнкрафт Пещера зомби',
        'https://www.toy.ru/catalog/maynkraft/lego_minecraft_21141_konstruktor_lego_maynkraft_peshchera_zombi/',
        1469,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Робот Lego Mindstorms – не просто игрушка. Это самый настоящий робот, реагирующий на мир вокруг.',
        'Конструктор ЛЕГО Майндстормс EV3',
        'https://cdn.toy.ru/upload/iblock/1ad/724b6ab1_da3d_11e2_9d82_002655824cb631313_3.jpeg?_cvc=1565378433',
        16990,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Моторная лодка выполнена в красном цвете с черными элементами и белыми надписями.',
        'ЛЕГО Техник Моторная лодка',
        'https://cdn.toy.ru/upload/iblock/b05/42089_1.jpg?_cvc=1565378433',
        1200,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('С огромным удовольствием представляем вашему вниманию игровые наборы по новой компьютерной игре Fortnite!',
        'Фортнайт FNT0012 Фигурка Drift с аксессуарами',
        'https://cdn.toy.ru/upload/iblock/e83/61rct4n0aal._sl1500_.jpg?_cvc=1565378433',
        1490,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Бластер Нерф Фортнайт Спрингер от Hasbro представляет собой игровой пистолет из популярной компьютерной игры Fortnite.',
        'Фортнайт Спрингер',
        'https://cdn.toy.ru/upload/iblock/046/1.jpg?_cvc=1565378433',
        1900,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Представляем Perplexus Epic - самый сложный из всех шаров линейки Перплексус! Вспотеют даже шары!',
        'Перплексус Эпик',
        'https://cdn.toy.ru/upload/iblock/d9c/34177_20112.jpg?_cvc=1565378433',
        1900,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Ловкость рук и никакого мошенничества!',
        'Тауэр неустойчивый',
        'https://cdn.toy.ru/upload/iblock/c6e/9f82707e_62c3_11e5_a105_00155d093116a2120_3.jpeg?_cvc=1565378433',
        1200,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);

INSERT INTO public.merchandise (description, "name", pictureurl, price, productdetail, category_id, store_id)
VALUES ('Отважной Нии, замаскированной под Самурая Икс, нужна помощь! Girl power!',
        'Самурай-робот Ниньжаго',
        'https://cdn.toy.ru/upload/iblock/2c4/70665_2.jpg?_cvc=1565378433',
        730,
        null,
        (
            select cat.id
            from public.category as cat
            where cat.name = 'Игрушки'
        ),
        1);
