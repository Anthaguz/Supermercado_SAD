package com.SAD.controller;

import com.SAD.dao.UsuarioDao;
import com.SAD.domain.Carrito;
import com.SAD.domain.CarritoDetalle;
import com.SAD.domain.Producto;
import com.SAD.domain.Usuario;
import com.SAD.service.CarritoDetalleService;
import com.SAD.service.CarritoReportService;
import com.SAD.service.CarritoService;
import com.SAD.service.ProductoService;
import com.SAD.service.UsuarioService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarritoController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private CarritoDetalleService carritoDetalleService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CarritoReportService carritoReportService;

    @GetMapping("/carrito/agregar/{idProducto}")
    public String agregar(Producto producto, HttpSession session) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        String user = usuarioService.getCurrentUser(principal);
        Usuario user2 = usuarioDao.findByUsername(user);
        Carrito carrito = carritoService.getCarritoCliente(user2.getIdUsuario());
        producto = productoService.getProducto(producto);
        CarritoDetalle carritoDetalle = carritoDetalleService.getCarritoDetalle(carrito.getIdCarrito(), producto);
        if (carritoDetalle != null) {
            carritoDetalle.setCantidad(carritoDetalle.getCantidad() + 1);
        } else {
            carritoDetalle = new CarritoDetalle(carrito.getIdCarrito(), producto.getPrecio(), 1, producto);
        }
        carritoDetalleService.save(carritoDetalle);
        return "redirect:/";
    }

    @GetMapping("/carrito/listado")
    public String listado(Model model, Producto producto, HttpSession session) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        String user = usuarioService.getCurrentUser(principal);
        Usuario user2 = usuarioDao.findByUsername(user);
        Carrito carrito = carritoService.getCarritoCliente(user2.getIdUsuario());
        Long idCarrito = carrito.getIdCarrito();
        List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(idCarrito);
        int cantidadProductosCarrito = carritoDetalles.size();
        var montoTotal = 0;
        var montoImpuestos = 0.0;
        for (var c : carritoDetalles) {
            montoTotal += c.getCantidad() * c.getPrecio();
        }
        montoImpuestos = montoTotal * 0.15;
        model.addAttribute("carritoDetalles", carritoDetalles);
        model.addAttribute("cantidadProductosCarrito", cantidadProductosCarrito);
        model.addAttribute("montoImpuestos", montoImpuestos);
        model.addAttribute("montoTotal", montoTotal);
        return "/carrito/listado";
    }

    @GetMapping(value = "/carrito/Factura", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(carritoReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/detalle/eliminar/{idDetalle}")
    public String eliminarDetalle(CarritoDetalle carritoDetalle) {
        carritoDetalleService.delete(carritoDetalle);
        return "redirect:/carrito/listado";
    }
}
