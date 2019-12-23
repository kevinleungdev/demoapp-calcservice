1. mvn clean package -DskipTests

2. mvn dockerfile:build

3. kubectl apply -f src/main/k8s/app-deployment.yaml

4. kubectl get pod -o wide

5. kubectl get svc -o wide

NAME              TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)   AGE   SELECTOR
demoapp-service   ClusterIP   10.101.213.180   <none>        80/TCP    11s   app=demoapp

6. kubectl get endpoints -o wide demoapp-service

NAME              ENDPOINTS        AGE
demoapp-service   10.1.0.50:9000   89s

7. kubectl apply -f src/main/k8s/app-shell.yaml

8. kubectl attach -it app-shell -c shell

wget http://10.101.213.180/calc/sum?params=1,2,3 -O sum

9. kubectl scale --replicas=2 -f src/main/k8s/app-deployment.yaml

10. kubectl.exe get endpoints demoapp-service

NAME              ENDPOINTS                       AGE
demoapp-service   10.1.0.50:9000,10.1.0.52:9000   51m

11. kubectl attach -it app-shell -c shell

wget http://10.101.213.180/calc/sum?params=1,2,3 -O sum && cat sum

# https://github.com/kubernetes/dns/blob/master/docs/specification.md
# <service>.<ns>.svc.<zone>
wget http://demoapp-service.default.svc.cluster.local/calc/sum?params=1,2,3 -O sum && cat sum

# <service>
wget http://demoapp-service/calc/sum?params=1,2,3 -O sum && cat sum


