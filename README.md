# testDocker
for test

docker build -t japp . </br>
docker run --rm -it --net bridge -p 8080:8080 japp