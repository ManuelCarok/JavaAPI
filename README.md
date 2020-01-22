# Instrucción Deploy Java Spring Boot Dev

## Requisitos

* Tener instalado Java
* Tener instalado Maven

## Deploy

* Abrir la consola en el directorio del proyecto llamado **TestDesarrolloBack** ejecutar el siguiente comando:

```bash
$ mvn clean install
```

* Se crea una carpeta llamada **target** en ese directorio nuevo se abre la consola se ejecuta el siguiente comando:

```bash
$ java -jar TestDesarrollo-0.0.1-SNAPSHOT.jar
```

* Abrir en el navegador la siguiente URL **http://localhost:8080/api** debe mostrar un mensaje **Bienvenidos a la API**

# Instrucción Deploy Angular Dev

## Requisitos

* Tener instalado Angular CLI
* Descargar librerias NPM

```bash
npm i
```

## Deploy

* Abrir la consola en el directorio del proyecto llamado **TestDesarrolloFront** ejecutar el siguiente comando:

```bash
$ ng serve
```

* Abrir en el navegador la siguiente URL **http://localhost:4200/**
