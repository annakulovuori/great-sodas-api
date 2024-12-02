FROM ubuntu:latest
LABEL authors="annak"

ENTRYPOINT ["top", "-b"]