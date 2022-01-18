package servlets.dao;

import java.util.List;

import servlets.pojo.Habit;

public interface HabitDao {
	public void insert(Habit habit);
	public int getMaxId();
	public List<Habit> getAllTrackedHabits();
}
