import numpy as np
import pandas as pd


# create emty dataframe

df = pd.DataFrame()
print(f'{df} empty dataframe')
print()

# create dataframe from list

data = [1,2,3,4,5,6,7,8,9,10]
df = pd.DataFrame(data)
print(f'{df} dataframe from list')
print()

# create dataframe using 2D array
data = np.random.randint(1, 10, size=(2, 3))
df = pd.DataFrame(data,columns=['A', 'B', 'C'],index=['row1', 'row2'])
print(f'{df} dataframe from 2D array')
print()

# create dataframe using Dictionary
data = {'A': [1, 2, 3], 'B': [4, 5, 6], 'C': [7, 8, 9]}
df = pd.DataFrame(data)
print(f'{df} dataframe from dictionary')
print()

data = {'Name': ['John', 'Alice', 'Bob', 'Eve', 'Charlie'],
        'Age': [25, 30, 22, 35, 28],
        'Gender': ['Male', 'Female', 'Male', 'Female', 'Male'],
        'Salary': [50000, 55000, 40000, 70000, 48000]}
df = pd.DataFrame(data)
print(f'{df} dataframe from dictionary')
print()
print(df.index,'index')  # Accessing the index
print()
print(df.columns,'columns')  # Accessing the columns
print()
print(df.values,'values')  # Accessing the values
print()
print(df.dtypes,'dtypes')  # Accessing the data types
print()
print(df.shape,'shape')  # Accessing the shape of the DataFrame
print()



data = [[1,2,3,4,5],[1,3,5,7,9],[2,4,6,8,10]]
df = pd.DataFrame(data,columns=['A', 'B', 'C', 'D', 'E'],index=['row1', 'row2', 'row3'])
print(df)

num = df.loc['row2', 'C']
print(num)
print()


num = df.loc[:'row2', 'C'].head()
print(num)
print()

num = df.iloc[:2, 3].head()
print(num)
print()

num = df.iloc[:2, 3].tail()
print(num)

num = df.iloc[:2, 3].shape
print(num)

subset = df.loc[:'row3', ['A', 'B']]
print(subset)

print()

data = {'Name': ['John', 'Alice', 'Bob', 'Eve', 'Charlie'], 
        'Age': [25, 30, 22, 35, 28], 
        'Gender': ['Male', 'Female', 'Male', 'Female', 'Male'], 
        'Salary': [50000, 55000, 40000, 70000, 48000]}

df = pd.DataFrame(data)
# Display the entire DataFrame
print(df)
print()

age_column = df['Age']
print(age_column)
print()

# Access the first three rows and the 'Name' and 'Age' columns
subset = df.loc[0:2, ['Name', 'Age']]
print(subset)
print()

# Access rows where 'Age' is greater than 25
filtered_data = df[df['Age'] > 25]
print(filtered_data)
print()

filtered_data = df[(df['Age'] > 25) & ( df['Salary'] > 50000)]
print(filtered_data)
print()

# Access the 'Salary' of the row with label 2
salary_at_index_2 = df.at[2, 'Salary']
print(salary_at_index_2)
print()
# Access the 'Salary' of the row with index 2
salary_at_index_2 = df.iat[2, 3]
print(salary_at_index_2)
print()


