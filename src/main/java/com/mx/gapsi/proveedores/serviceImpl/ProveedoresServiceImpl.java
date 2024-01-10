package com.mx.gapsi.proveedores.serviceImpl;

import com.mx.gapsi.proveedores.dto.ProveedoresDTO;
import com.mx.gapsi.proveedores.dto.Response;
import com.mx.gapsi.proveedores.entity.proveedores;
import com.mx.gapsi.proveedores.repository.ProveedoresRepository;
import com.mx.gapsi.proveedores.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;



    @Override
    public List<proveedores> getAllProveedor() {

            List<proveedores> listDatos = proveedoresRepository.findAll();

        return listDatos;
    }



    @Override
    public Response saveProveedor(ProveedoresDTO proveedoresDTO) {
        Response response = new Response();
        try{
            proveedores existe = proveedoresRepository.findByNombre(proveedoresDTO.getNombre());

            if(existe == null){
                proveedores entity = new proveedores();
                entity.setNombre(proveedoresDTO.getNombre());
                entity.setRazonSocial(proveedoresDTO.getRazonSocial());
                entity.setDireccion(proveedoresDTO.getDireccion());
                proveedoresRepository.save(entity);

                 response.setCode(200);
                 response.setDescripcion("Proveedor agregado correctamente.!");
            }else{
                response.setCode(406);
                response.setDescripcion("Error.!, Existe un Proveedor con el mismo nombre, favor de verificar");
            }

        } catch (Exception e){
            return new Response(500, "Error Interno del Servidor");
        }
        return response;

    }




    @Override
    @Transactional
    public Response eliminarProveedorByNombre(String nombre) {
        Response response = new Response();

        System.out.println("DEL-->" + nombre);

        try{
            proveedoresRepository.deleteByNombre(nombre);
            response.setCode(200);
            response.setDescripcion("Proveedor eliminado correctamente.");

        } catch (Exception e){
            return new Response(500, "Error Interno del Servidor");
        }

        return response;
    }




}
