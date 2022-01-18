package servlets.dao;

import java.util.List;

import servlets.pojo.Habit;
import servlets.pojo.HabitRecord;

public interface HabitRecordDao {
	public void insert(HabitRecord habitRecord);
	public int getMaxId();
	public List<HabitRecord> getHabitRecords(int habitId);
}
