package servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MaxIdRowMapperImpl implements RowMapper<Integer>{

	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return null;
	}

}
