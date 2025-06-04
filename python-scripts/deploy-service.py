import os
import sys
import subprocess

service_name = sys.argv[1]
build_id = sys.argv[2]

# Update image tag in deployment
subprocess.run([
    "sed", "-i", 
    f"s|jfrog.acme.io/docker-local/{service_name}:.*|jfrog.acme.io/docker-local/{service_name}:{build_id}|g",
    f"src/k8s/{service_name}-deployment.yaml"
])

# Apply Kubernetes config
subprocess.run(["kubectl", "apply", "-f", f"src/k8s/{service_name}-deployment.yaml"])
subprocess.run(["kubectl", "rollout", "restart", f"deployment/{service_name}"])
