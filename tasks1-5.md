## `Необходимо организовать систему учета для питомника, в котором живут домашние и вьючные животные.`

### 1. Используя команду cat, в терминале операционной системы Linux создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными (заполнив файл лошадьми, верблюдами и ослами), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).

cat > pets.txt

Cats
Dogs
Hamsters

cat > packanimals

horses
camels
donkeys

cat pets packanimals > animals

ls

mv animals.txt humanfriends.txt

ls

### 2. Создать директорию, переместить файл туда.

mkdir newdir

mv humanfriends.txt newdir/

ls

### 3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb

cd Загрузки
sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb

sudo apt-get update

Устанавливаем mysql-server:

sudo apt-get install mysql-server

Проверяем результат установки:

systemctl status mysql

### 4. Установить и удалить deb-пакет с помощью dpkg.

Скачиваем пакет для установки:

wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j_8.0.32-1ubuntu22.04_all.deb

Устанавливаем пакет mysql-connector-j_8.0.32-1ubuntu22.04_all.deb:

sudo dpkg - i mysql-connector-j_8.0.32-1ubuntu22.04_all.deb

Удаляем пакет и сопутствующие пакеты:

sudo dpkg -r mysql-connector-j

sudo apt-get autoremove


### 5. Выложить историю команд в терминале ubuntu.

history
