package com.SAD.controller;

import com.SAD.dao.UsuarioDao;
import com.SAD.domain.Carrito;
import com.SAD.domain.CarritoDetalle;
import com.SAD.domain.Producto;
import com.SAD.domain.Usuario;
import com.SAD.service.CarritoDetalleService;
import com.SAD.service.CarritoService;
import com.SAD.service.ProductoService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CarritoService carritoService;
    @Autowired
    private CarritoDetalleService carritoDetalleService;
    @Autowired
    private UsuarioDao usuarioDao;

    @GetMapping("/")
    public String inicio(Model model,HttpServletRequest request) {
        // Obtener el usuario llegado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }
        // Validar si es usuario de un cliente
        boolean esCliente = false;
        if (user.getAuthorities().size() == 1) {
            for (var rol : user.getAuthorities()) {
                if (rol.getAuthority().equals("ROLE_USER")) {
                    esCliente = true;
                }
            }
        }
        if (esCliente) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            Carrito carrito = carritoService.getCarritoCliente(usuario.cliente.getIdCliente());
            request.getSession().setAttribute("idCliente", usuario.cliente.getIdCliente());
            request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
            // Consultar los items
            List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
            int cantidadProductosCarrito = carritoDetalles.size();
            model.addAttribute("cantidadProductosCarrito", cantidadProductosCarrito);
        }
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        model.addAttribute("esCliente", esCliente);
        return "index";
    }
}
