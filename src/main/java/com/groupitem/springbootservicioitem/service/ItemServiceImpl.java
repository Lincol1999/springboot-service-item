package com.groupitem.springbootservicioitem.service;

import com.groupitem.springbootservicioitem.models.Item;
import com.groupitem.springbootservicioitem.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {

        //Obtenemos el listado de productos
        //getForObject(""->Es una url (String) , lo segundo -> es el tipo del obj que deseamos obtener, en este caso una lista de productos )
        //a traves de clienteRest.getForObject -> obtenemos el objeto, pasamos la ruta el enphoint, y el tipo en el cual lo queremos obtener.
        List<Producto> productos = Arrays.asList( clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));

        //Convertimos la lista en un flujo con stream()
        //usamos map para cambiar cada elemento del flujo
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        //Creamos un map para pasar el id y su valor
        Map<String, String> pathVariables = new HashMap<String, String>();
        //agregamos el nombre del parametro, y el valor convertido a string
        pathVariables.put("id", id.toString());

        Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);

        //producto -> el que obtenemos a traves del servicio Productos y la cantidad que pasamos por argumentos
        return new Item(producto, cantidad);
    }

	
}
