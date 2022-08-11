mvn package
docker image build -t login .
docker container run --network logindb --env-file my-env.txt --name login -p 8080:8080 -d login
docker container logs -f login