# RecommenderBackend

This is a backend project as an extension for my Clustering-Based-SVDpp algorithm. In this project I implement my knowledge in code packaging, API development, micro services, containerization, container orchestration and CI/CD

To quickly start with the kuberenetes:

```bash
git clone ...
cd repo
sh quickstart
```

To get the urls:

wait until all the pods are created and runnning

to check:

```bash
kubectl get pods
```

in seperate windows:

```bash
minikube service api-serivce --url
```

```bash
minikube service model-api-serivce --url
```
