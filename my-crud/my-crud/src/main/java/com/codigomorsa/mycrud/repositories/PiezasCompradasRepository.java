package com.codigomorsa.mycrud.repositories;

import com.codigomorsa.mycrud.model.Cliente;
import com.codigomorsa.mycrud.model.Pieza;
import com.codigomorsa.mycrud.model.Piezas_Compradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PiezasCompradasRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private PiezaRepository piezaRepository;

    private final PiezasCMapper mapper = new PiezasCMapper();

   // private final RowMapper<Pieza> Pmapper = new PiezaRepository.PiezaMapper();


    //private final SimpleJdbcInsert insert;

    private static class PiezaMapper implements RowMapper<Pieza> {
        @Override
        public Pieza mapRow(ResultSet sr, int rowNum) throws SQLException {

            String codigo = sr.getString("codigo");
            String descripcion = sr.getNString("descripcion");
            int costo = sr.getInt("costo");


            return new Pieza(codigo, descripcion, costo);


        }
    }

    public PiezasCompradasRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        //this.insert = new SimpleJdbcInsert(dataSource).withTableName("celebridad").usingGeneratedKeyColumns("id");
    }

    public List<Piezas_Compradas> getAllPiezasC(){
        String sql = "select * from piezas_compradas";
        return jdbcTemplate.query(sql, mapper);
    }

  /*  public long createPiezasCompradasCatalogo(Piezas_Compradas newPiezasC) {
        String sql = "INSERT INTO piezas_compradas (codigo, cantidad, costo_total, codigo_pieza, servicio) " +
                "VALUES (:codigo, :cantidad, :costo_total, :codigo_pieza, :servicio)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("codigo", newPiezasC.getCodigo());
        parameters.put("cantidad", newPiezasC.getCantidad());
        parameters.put("costo_total", newPiezasC.getCosto_total());
        parameters.put("codigo_pieza", newPiezasC.getCodigo_pieza());
        parameters.put("servicio", newPiezasC.getServicio());

        return jdbcTemplate.update(sql, parameters);
    } */

    public long createPiezasCompradas(Piezas_Compradas newPiezasC) {
        String sql = "INSERT INTO piezas_compradas (codigo, cantidad, costo_total, codigo_pieza, servicio) " +
                "VALUES (:codigo, :cantidad, :costo_total, :codigo_pieza, :servicio)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("codigo", newPiezasC.getCodigo());
        parameters.put("cantidad", newPiezasC.getCantidad());
        parameters.put("costo_total", newPiezasC.getCosto_total());
        parameters.put("codigo_pieza", newPiezasC.getCodigo_pieza());
        parameters.put("servicio", newPiezasC.getServicio());

        return jdbcTemplate.update(sql, parameters);
    }

    public ResponseEntity<String> createPiezasCompradas2(Piezas_Compradas newPiezasC) {
        String sql = "INSERT INTO piezas_compradas (codigo, cantidad, costo_total, codigo_pieza, servicio) " +
                "VALUES (:codigo, :cantidad, :costo_total, :codigo_pieza, :servicio)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("codigo", newPiezasC.getCodigo());
        parameters.put("cantidad", newPiezasC.getCantidad());
        parameters.put("costo_total", newPiezasC.getCosto_total());
        parameters.put("codigo_pieza", newPiezasC.getCodigo_pieza());
        parameters.put("servicio", newPiezasC.getServicio());

        try {
            // Validar que el código de pieza existe
            if (!piezaRepository.existsByCodigo(newPiezasC.getCodigo_pieza())) {
                throw new RuntimeException("El código de pieza no existe");
            }

            jdbcTemplate.update(sql, parameters);
            return new ResponseEntity<>("Piezas compradas creadas exitosamente", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            e.printStackTrace(); // Imprime la excepción en la consola
            return new ResponseEntity<>("El código de pieza no existe", HttpStatus.BAD_REQUEST);
        }
    }

    private static class PiezasCMapper implements RowMapper<Piezas_Compradas> {
        @Override
        public Piezas_Compradas mapRow(ResultSet sr, int rowNum) throws SQLException {

            long id = sr.getInt("id");
            String codigo = sr.getNString("codigo");
            int cantidad = sr.getInt("cantidad");
            int costoTotal = sr.getInt("costo_total");
            String codigo_pieza = sr.getString("codigo_pieza");
            int servicio = sr.getInt("servicio");
            return new Piezas_Compradas(id, codigo, cantidad, costoTotal, codigo_pieza, servicio);


        }
    }

}
