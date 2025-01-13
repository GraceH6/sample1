FROM alpine:latest

RUN apk update

RUN apk add --no-cache git

RUN apk add vim

RUN apk add curl

CMD ["git","--version"]
