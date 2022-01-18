package servlets.dao;

import servlets.pojo.Habit;

public interface HabitDao {
	public void insert(Habit habit);
	public int getMaxId();
}
