
export JAVA_HOME=path/to/17
mci-ts

sudo docker buildx build --platform linux/amd64 -t rest4test .
sudo docker tag rest4test susisacr.azurecr.io/integration/rest4test:1.1
sudo docker push susisacr.azurecr.io/integration/rest4test:1.1

kubectl create deployment rest4test --image=susisacr.azurecr.io/integration/rest2jmsgateway:1.1
kubectl expose deployment rest4test --type=ClusterIP --port=8080 --target-port=8080

Patch to Distribute in different AZs
kubectl patch deployment rest4test --type='json' -p='[{"op": "add", "path": "/spec/template/spec/topologySpreadConstraints", "value": [{"maxSkew": 1, "topologyKey": "kubernetes.io/hostname", "whenUnsatisfiable": "DoNotSchedule", "labelSelector": {"matchLabels": {"app": "rest4test"}}}]}]'
