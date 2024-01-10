package com.mx.gapsi.proveedores.controller;

import com.mx.gapsi.proveedores.dto.ProveedoresDTO;
import com.mx.gapsi.proveedores.dto.Response;
import com.mx.gapsi.proveedores.entity.proveedores;
import com.mx.gapsi.proveedores.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;


    @GetMapping("/proveedores/welcome")
    public String welcome(){
        String messageWelcome = "Bienvenido Candidato 01";
            return messageWelcome;
    }


    @GetMapping("/proveedores/version")
    public String version(){
        String messageVersion = "Versión 0.0.1";
        return messageVersion;
    }


    @GetMapping("/proveedores/getAll")
    public List<proveedores> getAllProveedor() throws Exception{
            return proveedoresService.getAllProveedor();
    }


    @PostMapping("/proveedores/save")
    public Response saveProveedor(@RequestBody ProveedoresDTO proveedoresDTO) throws Exception{
        try{
            return proveedoresService.saveProveedor(proveedoresDTO);
        } catch (Exception e){
            return new Response(500, "Error Interno del Servidor");
        }
    }




    @DeleteMapping("/proveedores/eliminarProveedor/{nombre}")
    public Response eliminarProveedorByNombre(@PathVariable("nombre") String nombre) throws Exception{
        try {
            return proveedoresService.eliminarProveedorByNombre(nombre);
        } catch (Exception e) {
            return new Response(500, "Error al eliminar el alumno");
        }
    }





}
