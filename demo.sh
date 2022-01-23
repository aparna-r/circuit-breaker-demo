#!/bin/bash
# Accepts 1 parameter which can have following values
# fail
#     if fail is passed, makes fail calls to order-service
# slow
#     if slow is passed, makes slow calls to order-service
# nothing is passed, makes default calls to order-service


for i in {1..10}
do
  curl -s -o /dev/null -w "%{http_code}" -X POST -H "Content-Type: application/json" -d'{"item": "t-shirt","price": "10","requester": "aparna","provider": "Adidas"}' http://localhost:20000/orders?type="$1"
  echo ""
done
