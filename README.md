# E-commerce-microservices
Simple project about microservices for an e-commerce project

# Run using Docker
Navigate to the root directory
Run `docker compose up -d`

# Run using Kubernetes
Navigate to the kubernetes folder
Run `kubectl apply -R -f .`

# Run locally
Modify the application.properties files to match your local connection credentials
Make sure you have Docker images of Zipkin, Grafana, Prometheus running
Run every service manually
