package com.groupitem.springbootservicioitem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//LA CLASE CONFIGURACIÓN DE SPRING ES QUE NOS PERMITE CREAR OBJETOS (COMPONENTES) DE SPRING, BEANS
@Configuration
public class AppConfig {

    @Bean("clienteRest")
    //RestTemplate -> Es un cliente HTTP para trabajar con APIREST, para poder acceder a recursos que estan en otros microservicios
    //El objeto que se retorna, se guarda en el Bean
    public RestTemplate registrarRestTemplate(){

        return new RestTemplate();

    }


}
