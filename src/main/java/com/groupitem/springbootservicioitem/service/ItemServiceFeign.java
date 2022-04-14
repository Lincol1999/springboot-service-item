package com.groupitem.springbootservicioitem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.groupitem.springbootservicioitem.clientes.ProductoClienteRest;
import com.groupitem.springbootservicioitem.models.Item;


@Service("serviceFeign")
//@Primary //Para indicar cual servicio usaremos para consumir la API-Productos
public class ItemServiceFeign implements ItemService {
	
	//Inyectamos ProductoClienteRest
	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	} 

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}
