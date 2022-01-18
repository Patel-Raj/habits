package servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import servlets.pojo.HabitRecord;

public class HabitRecordRowMapperImpl implements RowMapper<HabitRecord>{

	public HabitRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
		HabitRecord habitRecord = new HabitRecord();
		habitRecord.setHabitRecordId(rs.getInt(1));
		habitRecord.setEffective_Date(rs.getDate(2));
		habitRecord.setHabitId(rs.getInt(3));
		return habitRecord;
	}

}
