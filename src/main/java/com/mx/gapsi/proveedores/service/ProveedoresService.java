package com.mx.gapsi.proveedores.service;

import com.mx.gapsi.proveedores.dto.ProveedoresDTO;
import com.mx.gapsi.proveedores.dto.Response;
import com.mx.gapsi.proveedores.entity.proveedores;
import java.util.List;

public interface ProveedoresService {

    List<proveedores> getAllProveedor();

    Response saveProveedor(ProveedoresDTO proveedoresDTO);

    Response eliminarProveedorByNombre(String nombre);


}
