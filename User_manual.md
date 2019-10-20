# To-Do List

## Usage

### Starting the application:

When the user starts the app the following menu is printed:

```
~~~~~~~~~~~~~~~~~~~~~~~
Welcome to ToDoList App
~~~~~~~~~~~~~~~~~~~~~~~

You have X tasks todo and Y tasks are done!

Pick an option:
(1) Show Task List
(2) Add New Task
(3) Edit Task
(4) Save changes and Quit

Press 1, 2, 3 or 4
```
Where X shows the number of tasks to be done and Y shows the number of done tasks.

### The list of tasks

When option 1 in the main menu is chosen, a menu for task list will appear:
###### Note that the menu will not be shown in case no tasks were previously added

```
1
Your to-do list is currently empty
Please, press any key to return to the menu :)
```
or

```
1
*************************
(1) Show all tasks
(2) Sort tasks by date
(3) Sort tasks by project
(4) Return to menu
Press 1, 2, 3 or 4
*************************
```

Later the user can choose whether they want to see the unsorted list of tasks pressing 1

```
1
Task: 'cheese', due date: '2020-12-12', project: 'SHOPPING', status: DONE
Task: 'laundry', due date: '2019-10-20', project: 'ERRANDS', status: PENDING
Task: 'dentist', due date: '2020-08-10', project: 'APPOINTMENTS', status: PENDING
Task: 'coffee', due date: '2019-12-12', project: 'SHOPPING', status: PENDING
```
Or the list sorted by date pressing 2

```
2
Task: 'laundry', due date: '2019-10-20', project: 'ERRANDS', status: PENDING
Task: 'coffee', due date: '2019-12-12', project: 'SHOPPING', status: PENDING
Task: 'dentist', due date: '2020-08-10', project: 'APPOINTMENTS', status: PENDING
Task: 'cheese', due date: '2020-12-12', project: 'SHOPPING', status: DONE
```
Or the list sorted by project pressing 3

```
3
Task: 'dentist', due date: '2020-08-10', project: 'APPOINTMENTS', status: PENDING
Task: 'laundry', due date: '2019-10-20', project: 'ERRANDS', status: PENDING
Task: 'cheese', due date: '2020-12-12', project: 'SHOPPING', status: DONE
Task: 'coffee', due date: '2019-12-12', project: 'SHOPPING', status: PENDING
```

### Adding a new task

When option 2 in the main menu is chosen, the user can add a new task into the list:
```
2
Add a task
```
Add the date to the task in yyyy-MM-dd format:
```
Add a date yyyy-MM-dd
```
And either choose a project from the list by typing in its number: 
```
Choose a project
(1) ERRANDS
(2) SHOPPING
(3) APPOINTMENTS
(4) OTHER
```
Or choose another title for their project by typing in its name: 
```
Or enter another name for your project
```

When all 3 fields are filled, the task will be displayed with a "pending" status set as default:

```
Task: 'call mom', due date: '2019-11-11', project: 'FAMILY', status: PENDING
```

### Editing and removing tasks

When option 3 in the main menu is chosen, the user can edit or remove their tasks.
First, the list of tasks will be printed in a list with the task number.
Then, the user will choose the number of task they want to edit or remove: 
```
Choose the number of the task you want to edit or remove
```
When the task is chosen, the following menu will appear: 
```
3
Task: 'dentist', due date: '2020-08-10', project: 'APPOINTMENTS', status: PENDING
^^^^^^^^^^^^^^^^^^^^^^^^^
(1) Edit task name
(2) Edit due date
(3) Change the project
(4) Mark task as done
(5) Remove task
(6) Cancel
^^^^^^^^^^^^^^^^^^^^^^^^^
```
The user will choose which part of the task they want to edit
```
4
The task is DONE now, don't forget to save changes at the end
```
or remove the task
```
5
Task: 'dentist', due date: '2020-08-10', project: 'APPOINTMENTS', status: PENDING has been removed
```

### Saving the changes and quitting the app

All the changes are saved when the user quits the application typing in 4 in the main menu
