<h3>Запуск:</h3>
<ol>
<li>git clone https://github.com/lamsq/clients_manager.git</li>
<li>cp example.env .env</li>
<li>Прописать учетные данные и базу данных в .env</li>
<li>mvn clean install</li>
<li>mvn clean package</li>
<li>docker-compose up --build</li>
</ol>

<h3>Пример запросов:</h3>
<h4>Clients:</h4>
<ul>
<li>GET api/clients - список всех пользователей</li>
<li>POST api/clients - создание записи нового пользователя</li>
<li>GET api/clients/{id} - получение данных пользователя с заданным id</li>
<li>DELETE api/clients/{id} - удаление пользователя с заданным id</li>
<li>PUT api/clients/{id} - изменение данных пользователя с заданным id</li>
</ul>
<h4>Contacts:</h4>
<ul>
<li>POST api/contacts - создание контакта</li>
<li>GET api/contacts - получение списка контактов</li>
<li>DELETE api/contacts/{id} - удаление контакта с заданным id</li>
<li>PUT api/contacts/{id} - изменение данных контакта с заданным id</li>
<li>GET api/contacts/{id} - получение данных контакта с заданным id</li>
</ul>
