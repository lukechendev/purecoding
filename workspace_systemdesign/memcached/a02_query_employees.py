import mysql.connector
import datetime

from pymemcache.client.base import Client
from pymemcache import serde

def getEmployeesFromDB():
    print("Retrieving from DB")
    
    cnx = mysql.connector.connect(user='mysqluser1', password='testtest1', 
                                    host='127.0.0.1',
                                    database='employees')

    cursor = cnx.cursor()

    query = ("SELECT first_name, last_name, hire_date FROM employees \
                WHERE hire_date BETWEEN %s AND %s")
                
    hire_start = datetime.date(1999, 1, 1)
    hire_end = datetime.date(1999, 1, 1)

    cursor.execute(query, (hire_start, hire_end))

    # Retrieve the result from DB

    emp_list = []
    for (first_name, last_name, hire_date) in cursor:
        print("{}, {} was hired on {:%d %b %Y}".format(
            last_name, first_name, hire_date))
        emp = [last_name, first_name, hire_date]
        emp_list.append(emp)

    cursor.close()
    cnx.close()

    # Cache with memcached

    memcache = Client(('localhost', 11211), serde=serde.pickle_serde)
    memcache.set(key='query_1999_employees', value=emp_list, expire=5)

    return emp_list

def getEmployeesFromCache():
    print("Retrieving from cache")
    memcache = Client(('localhost', 11211), serde=serde.pickle_serde)
    emp_list = memcache.get('query_1999_employees')
    return emp_list;

'''
Retrieve all employees hired on Jan 01, 1999 from cache.
If not found, retrive from DB and cache for 5 seconds
'''

def main():
    emp_list = getEmployeesFromCache();
    if (emp_list == None):
        print("Not in cache!")
        emp_list = getEmployeesFromDB();
    
    print(emp_list);

if __name__ == "__main__":
    main()

