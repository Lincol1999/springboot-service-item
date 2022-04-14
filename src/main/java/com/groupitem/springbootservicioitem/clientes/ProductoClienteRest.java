package com.groupitem.springbootservicioitem.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.groupitem.springbootservicioitem.models.Producto;

//VIDEO 13: USO DEL OPENFEIGN PARA CONSUMO DE NUESTRA API

//Donde ponemos el name:  del servicio al que nos vamos a conectar y la url: 
@FeignClient(name = "servicio-productos", url = "localhost:8001" ) //Se define que esta interface es un cliente feign.
public interface ProductoClienteRest {
	
	@GetMapping("/listar") //Se va comunicar con el epoint al listar de ProductoController de servicio-Productos.
	public List<Producto> listar();
	
	
	@GetMapping("ver/{id}")  //Se va comunicar con el epoint al ver/{id} de ProductoController de servicio-Productos.
	public Producto detalle(@PathVariable Long id);

}
