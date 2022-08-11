docker network create logindb
docker container run --name logindb --network logindb -e MYSQL_ROOT_PASSWORD=root -d mysql:8
docker cp scripts/login.sql logindb:/login.sql
docker exec logindb /bin/bash "mysql -u root -proot < /login.sql"
docker exec logindb rm /login.sql