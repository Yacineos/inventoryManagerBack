package com.yacineDev.demo.Mapper;

import com.yacineDev.demo.module.CommandeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommandeDTOMapper implements RowMapper<CommandeDTO> {
    public CommandeDTO mapRow1(List<?> rs) throws SQLException {
        Long id_produit = (Long) rs.get(0);
        String nom = (String) rs.get(1);
        float prix_unitaire = (float) rs.get(2);
        int qte_produit = (int) rs.get(3);
        float totalValue = (float) rs.get(4);
        return new CommandeDTO(id_produit, nom, prix_unitaire, qte_produit, totalValue);
    }

    @Override
    public CommandeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
