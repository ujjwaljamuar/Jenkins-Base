def buildApp(){
    echo "building application"
}

def deployApp(){
    echo "deploying application..."
    echo "deploying version ${params.version}"
}

return this 