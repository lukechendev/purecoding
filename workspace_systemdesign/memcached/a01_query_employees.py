import mysql.connector

cnx = mysql.connector.connect(user='mysqluser1', password='testtest1',
                             host='127.0.0.1',
                             database='employees')

cursor = cnx.cursor()

query = ("select first_name, last_name, hire_date from employees where emp_no in (497689, 497690)")

cursor.execute(query)

for (first_name, last_name, hire_date) in cursor:
	print("{}, {} was hired on {:%d %b %Y}".format(last_name, first_name, hire_date))

cursor.close()
cnx.close()

