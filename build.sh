#!/bin/bash

docker build -t registry.gitlab.com/adaumir-testes/pamcary/ws-pamcary-client:0.0.1 .

docker push registry.gitlab.com/adaumir-testes/pamcary/ws-pamcary-client:0.0.1


