package com.SAD.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class InventarioReportService {

    private String reportPath;

    public String generateReport() {
        try {
            File file = ResourceUtils.getFile("classpath:Inventario.jasper");
            reportPath = file.getParent();
            // Carga el reporte
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            // Añade paramáteros (pero para este caso no hay)
            Map<String, Object> parameters = new HashMap<>();
            //Instanciar la conexión
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Supermercado_SAD?usetimezone=true&serverTimezone=UTC", "administrador", "Password!");
            // Llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            // Exporta a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Inventario.pdf");
            return reportPath + "\\Inventario.pdf";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
