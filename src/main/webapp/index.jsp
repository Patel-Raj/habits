<html>
	<body>
		<h1>Welcome to Habit tracker !!</h1>
		<br>
		<br>
		<hr> <hr>
		<h2>Create a new Habit!!</h2>
		<form action="addHabit" method = "post">
		 Habit Name : <input type="text" name="habit_name" placeholder="Enter Habit"><br><br>
		 Start Date : <input type="date" name="habit_start_date" placeholder="Enter Date"><br><br>
		<input type="submit"> <input type="Reset">
		</form>
		<hr> <hr>
		
		<hr> <hr>
		
		
		<form action="addHabitRecord" method = "get">
		 
		<input type="submit" value = "Click here to add a record">
		</form>
		<hr> <hr>
		
		<hr> <hr>
		
		<form action="viewProgress" method = "get">
		 
		<input type="submit" value = "Click here to track progress">
		</form>
		<hr> <hr>
	</body>
</html>
