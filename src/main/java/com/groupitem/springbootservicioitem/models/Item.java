package com.groupitem.springbootservicioitem.models;


//EL ROL DE ESTE MICRO SERVICIO ES GENERAR EL ITEM A PARTIR DEL PRODUCTO DEL OTRO MICROSERVICIO.



public class Item {
	
	//Cada item tiene 1 producto
    private Producto producto;

    private Integer cantidad;
    
    public Item() {}

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
		this.cantidad = cantidad;
	}

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }



    //Método para calcular le importe o total
    public Double getTotal(){
        return producto.getPrecio() * cantidad.doubleValue();
    }


}
