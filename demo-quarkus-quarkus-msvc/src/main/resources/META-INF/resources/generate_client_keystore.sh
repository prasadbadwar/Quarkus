keytool -genkey \
        -storepass client_password \
        -keyalg RSA \
        -keysize 2048 \
        -dname "CN=client" \
        -alias client \
        -ext "san=dns:localhost" \
        -keystore client-keystore.p12
        