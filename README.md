Ajustes para Uso Local - Proyecto Biblioteca
Requisitos Previos

    Java JDK 8 o superior instalado

    PostgreSQL instalado y en ejecución

    Maven instalado (para manejo de dependencias)

Configuración de la Base de Datos

    Crear la base de datos:
    sql

CREATE DATABASE biblioteca_db;

Configurar credenciales: (opcional, si deseas cambiar las predeterminadas)
sql

    CREATE USER postgres WITH PASSWORD '1234';
    GRANT ALL PRIVILEGES ON DATABASE biblioteca_db TO postgres;

Configuración del Proyecto
Archivos de configuración

    application.properties (src/main/resources/application.properties)

spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_db
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

persistence.xml (src/main/resources/META-INF/persistence.xml)
xml

    <persistence-unit name="bibliotecaPU">
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/biblioteca_db"/>
            <property name="javax.persistence.jdbc.user" value="postgres"/>
            <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="javax.persistence.jdbc.password" value="1234"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>

Instalación y Ejecución

    Clonar el repositorio (si aplica)
    bash

git clone [url-del-repositorio]
cd [nombre-del-proyecto]

Construir el proyecto con Maven
bash

mvn clean install

Ejecutar la aplicación
bash

    mvn spring-boot:run

    o ejecutar la clase principal desde tu IDE

Acceso a la Aplicación

La aplicación debería estar disponible en:

http://localhost:8080

Solución de Problemas

Si encuentras problemas de conexión:

    Verifica que PostgreSQL esté en ejecución

    Confirma que las credenciales en los archivos de configuración sean correctas

    Asegúrate que el puerto 5432 esté accesible para conexiones locales

Personalización

Puedes cambiar los valores de usuario, contraseña y nombre de la base de datos modificando los archivos de configuración mencionados anteriormente.
