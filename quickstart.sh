# Start the minikube
echo "starting the minicube"
minikube start

# Move to k8s folder
cd k8s/

# Start the pods
echo "starting the pods"
kubectl apply -f api-deployment.yml
kubectl apply -f db-deployment.yml
kubectl apply -f model-api-deployment.yml
kubectl apply -f java-api-deployment.yml


