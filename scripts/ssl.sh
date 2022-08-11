mkdir /ssl
cd /ssl || exit
openssl genrsa -des3 -passout pass:x -out server.pass.key 2048 && \
    openssl rsa -passin pass:x -in server.pass.key -out server.key && \
    rm server.pass.key && \
    openssl req -new -key server.key -out server.csr \
        -subj "/C=US/ST=LOL/L=No/O=Jimmy/OU=IT Department/CN=login.com" && \
    openssl x509 -req -days 365 -in server.csr -signkey server.key -out server.crt
keytool -genkeypair -noprompt -alias login -keyalg RSA -keysize 2048 -storetype PKCS12 \
-keystore login.pk12 -validity 365 -storepass password -keypass password \
-dname "CN=login.com, OU=ID, O=Jimmy, L=Columbia, S=SC, C=US"