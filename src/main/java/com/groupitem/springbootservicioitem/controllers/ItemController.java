package com.groupitem.springbootservicioitem.controllers;


import com.groupitem.springbootservicioitem.models.Item;
import com.groupitem.springbootservicioitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    //@Qualifier("serviceFeign")
    @Qualifier("serviceRestTemplate")
    private ItemService itemService;

    @GetMapping("/listar") //Mapeamos la ruta listar, del microservicio item.
    public List<Item> listar(){
        return itemService.findAll();
    }

    //El enpoint con 2 paramtros,
    // /ver/{id}/cantidad/{cantidad}" -> /ver y /cantidad -> seria estática, {id} {cantidad} -> dinámica
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    //recibe 2 argumentos, comunicandose con el servicio producto por APIREST
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return  itemService.findById(id, cantidad);
    }



}
