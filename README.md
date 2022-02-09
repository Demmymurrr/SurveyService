# Survey REST API service 
Сервис предоставляюший API для работы с опросами на уровне пользователя и админинстратора

В проекте задействованы технологии:
1) Integration Spring MVC with Hibernate
2) Spring Security
3) Spring RESTfull
4) БД MySQL и обращение к ней через HQL
5) Stream API
6) lombok-Annotations
7) сборка приложения с помощью Maven
8) развертка с помощью Docker




# Docker
for test

docker build -t japp . </br>
docker run --rm -it --net bridge -p 8080:8080 japp
