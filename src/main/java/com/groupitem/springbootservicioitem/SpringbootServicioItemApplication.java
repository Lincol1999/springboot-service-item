package com.groupitem.springbootservicioitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//VIDEO 13: USO DEL OPENFEIGN PARA CONSUMO DE NUESTRA API
@EnableFeignClients //habilita nuestros clientes Feign que tengamos implementa en nuestro proyecto, inyecta en nuestros controladores.
@SpringBootApplication
public class SpringbootServicioItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioItemApplication.class, args);
    }

}
