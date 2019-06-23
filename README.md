**Comando para criar o container:**

sudo docker run -d -p 2012:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_DATABASE=spring_add_app -e MYSQL_USER=app_user -e MYSQL_PASSWORD=test123 mysql:latest
