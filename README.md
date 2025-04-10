# Proyecto
# Ajustar para uso local

//src/main/resources/applicaction.propeties
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_db 
spring.datasource.username=postgres
spring.datasource.password=1234

//META-INF/persistence.xml
name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/biblioteca_db"
name="javax.persistence.jdbc.user" value="postgres"
name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"
name="javax.persistence.jdbc.password" value="1234"

