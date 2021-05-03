FROM adoptopenjdk:11-jre-hotspot

EXPOSE 8085

# Install vim
RUN apt-get update && apt-get install -y vim

# Create user
RUN useradd --create-home product && \
    mkdir -p /home/product/ && \
    mkdir -p /home/product/logs

# Copy file to container
COPY "target/product-service.jar" "/home/product/product-service.jar"
COPY "etc/entrypoint.sh" "/home/product/"

# Edit permissions
RUN chown product:product /home/product/* && \
    chmod 700 /home/product/entrypoint.sh

# Change working dir
WORKDIR /home/product

# Entry point
ENTRYPOINT ./entrypoint.sh
