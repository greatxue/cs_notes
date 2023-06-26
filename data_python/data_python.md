# Data analysis with Python
- - -
editor: Kevin Shuey     
title: Data analysis with Python  
date: 2023-06-23    
ref: ucb_Data100   
- - -
**Coverage:**  

[1. Numpy](#1)  
[2. Pandas](#2)     
[3. Data Cleaning](#3)      



## 1. <span id='1'>Numpy</span>

Before the journey, import *numpy* like

```python
import numpy as np
```

### 1.1 Creating Arrays

Here are basic usages:

```python
np.array([[1.,2.], [3.,4.]])
# array([[ 1.,  2.],
#       [ 3.,  4.]])

np.array([x for x in range(5)])
#array([0, 1, 2, 3, 4])
```

To conclude special elements,

```python
np.zeros(5)
np.ones([3,2])
# array([[ 1.,  1.],
#       [ 1.,  1.],
#       [ 1.,  1.]])

np.eye(4)
# array([[ 1.,  0.,  0.,  0.],
#       [ 0.,  1.,  0.,  0.],
#       [ 0.,  0.,  1.,  0.],
#       [ 0.,  0.,  0.,  1.]])
```

To follow special regularities,

```python
np.arange(0, 10, 2)			# np.arange(start, stop, step)
np.linspace(0, 5, 10)		# linspace(start, end, num)
```

To create random ones,

```python
np.random.randn(3,2)									
# 'randn' generates random numbers from a Normal(mean=0, var=1) distribution.
np.random.rand(3,2)
# 'rand' generates random numbers from a Uniform(low=0, high=1) distribution.
np.random.permutation(range(0,10))
# 'permutation' generates a random permutation of a sequence of numbers.
```

There is even a kind of **Jagged Arrays**, which may be tough to use:

```python
A = np.array([[1, 2, 3], [4, 5], [6]])
A[0][1] 																		# 2, difficult to index
```

### 1.2 Indexing

Understand the slice syntax `begin:end:stride` well:

```python 
x[:, 0]
x[0, :]
x[:2, 1:] = 0
x[0::2, :]
```

Boolean indexing could be applied as well, 

```python
A = np.array([[  1.,   2.,   3.],
       				[  4.,   5.,   -999.0],
       				[  7.,   8.,   9.],
       				[ 10.,  -999.0,  -999.0]])

A > 3
A[A > 3]
```

### 1.3 Properties of Arrays

Here are basic properties of arrays:

```python
A.shape
A.dtype																		# e.g. dtype('float64')
np.arange(1,5).dtype

np.array([1,2,3]).astype(float) 					# change type of an array
A = np.arange(1,13).reshape(4,3)					# reshape an array with row ('C') indexing
np.arange(1,13).reshape(4,3, order='F')		# Fortran ordering (column indexing)
A.flatten()																# flat a matrix/higher-demensional array
```

### 1.4 Mathematical Operations

Here are basic mathematical operations:

```python
A * 0.5 + 3
A.sum()
A.mean()

np.isclose				# consider using this when there is float inaccuracy
```

Here are specific calculations for matrices:

+ For basic operations,

  ```python
  A.T
  A.sum(axis=1)			# grouping by col
  A.sum(axis=0)			# grouping by row
  ```

+ Here are some linear-algebra calculations:

  ```python
  A = np.array([[1, 2, 3], [4, 5, 6]])
  b = np.ones(3)
  
  A * b							# element-wise product in numpy
  A.dot(b)
  A @ b							# matrix multiplication
  ```

+ For solving linear systems,

  ```python
  A = np.array([[5, -3], [-9, 2]])
  b = np.array([2,-7])
  
  from numpy.linalg import inv
  inv(A) @ b
  # equivalent to
  from numpy.linalg import solve
  solve(A, b)
  ```

## 2. <span id='2'>Pandas</span>

Before the journey, import *pandas* like

```python
import pandas as pd
```

### 2.1 Reading in DataFrames from Files

There are multiple file-reading tools, resulting in data structures like **DataFrames** and **Series**, in which there are **columns** and **rows**.
```python
elections = pd.read_csv("elections.csv")
```

+ To specify a column as an index,

  ```python
  elections_year_index = pd.read_csv("elections.csv", index_col = "Year")
  # equivalent to
  elections_party_index = elections.set_index("Party")
  ```

+ For most commands, the original "elections" is untouched. To modify,

  ```python
  elections_party_index = elections.set_index("Party", inplace = True)
  ```

+ The column names MUST be unique, or duplicates will be automatically removed.

For simple DataFrames, create a new one by

```python
weird = pd.DataFrame({1:["topdog","botdog"], "1":["topcat","botcat"]})
```

### 2.2 Handy Properties and Utility Functions

Here are methods for basic information:

```python
mottos.head(5)
mottos.tail()				# by default it is last 5 
mottos.size					# e.g. 200
mottos.shape				# e.g. (50, 4)
mottos.describe()
```

Here are methods for individual properties:

```python
mottos.index				# get a direct reference to the index
mottos.index.name		# access individual properties of the index
mottos.columns			# access index of columns
```

Here are other utility functions:

```python
elections.sort_values('%')
elections.sort_values('%', ascending=False)		# sort in reverse order

mottos['Language'].sort_values().head(10)
elections['Party'].value_counts()
mottos['Language'].unique()										# return all unique values as a numpy array
```

### 2.3 Slicing technics

The DataFrame class has an indexing operator `[]` with diverse functions:

+ To slice by columns,

  ```python
  elections["Candidate"].head(6)								# return a Series
  elections[["Candidate"]].head(6)							# return the correspoding DataFrame 
  elections["Candidate"].to_frame()							# alternative for the DataFrame 
  
  elections[["Candidate", "Party"]].head(6)			# return a 2-col DaraFrame
  ```

+ The operator `[]` also accepts numerical slices. To slice by rows,
  ```python
  elections[0:3]		# The slice techinic with [] starts from 0.
  ```

  Remember if a single argument is provided, *pandas* will try to use it as a name.

  ```python
  # elections[0]						
  # This won't work, as pandas is trying to find the column name int '0'.
  # Also be careful string '0' is not the same as int '0'.
  ```

+ Here are technics for filtering the data:

  + `[]` accepts booleans, with rows corresponding to `True` appearing:

    ```python
    elections[[False, False, False, False, False, 
              False, False, True, False, False,
              True, False, False, False, True,
              False, False, False, False, False,
              False, False, True]]
    # the array exactly as long as the number of rows
    ```
    
  + Logical operators `==` could be applied as well:
  
    ```python
    iswin = elections['Result'] == 'win'
    iswin.head(5)			# returns an array
    elections[iswin]
    
    # equivalent to single-line command
    elections[elections['Party'] == 'Independent']
    ```
  
    For multiple requirements,
  
    ```python
    elections[(elections['Result'] == 'win')
              & (elections['%'] < 50)
              & (elections['Party'] == 'Republican')]
    ```

+ To slice by `loc`, basic use includes

  ```python
  elections.loc[[0, 1, 2, 3, 4], ['Candidate','Party', 'Year']]
  elections.loc[0:4, 'Candidate':'Year']		# [rows, cols]
  
  elections.loc[0:4, 'Candidate']
  elections.loc[0:4, ['Candidate']]
  
  elections.loc[0, 'Candidate':'Year']
  elections.loc[[0], 'Candidate':'Year']
  
  elections.loc[[2, 4, 5]]
  elections.loc[[0, 3], ['Candidate', 'Year']]
  ```

  Remember that `loc` is **inconclusive** even for numeric ones!

+ To slice by `iloc`, which is based on numeric slicing like in *Python*,

  ```python
  mottos.iloc[0:3, 0:3]
  ```

### 2.4 GroupBy Technics

**GroupBy a Series by a Series/Multiple Series:**

+ *pandas* has a `SeriesGroupBy` object, consisting of `groups`:

  ```python
  percent_grouped_by_party = df['%'].groupby(df['Party'])
  percent_grouped_by_party.groups
  
  percent_grouped_by_party.mean()			# return a Series
  percent_grouped_by_party.max()
  percent_grouped_by_party.size()
  percent_grouped_by_party.first()
  ```

+ Multiple GroupBy is also OK:

  ```python
  percent_grouped_by_party_and_result = df['%'].groupby([df['Party'], df['Result']])
  party_result_mean = percent_grouped_by_party_and_result.mean()
  
  party_result_mean.index			
  # It follows a 'multilindex', which could be accessed by
  party_result_mean['Republican']
  party_result_mean['Democratic', 'win']
  party_result_mean[:, "loss"]
  ```

+ Iterate the `group` to see what is inside:

  ```python
  from IPython.display import display  # like print, but for complex objects
  
  for name, group in percent_grouped_by_party:
      print('Name:', name)
      print(type(group))
      display(group.head())
      print('\n')
  ```

**GroupBy a DataFrame by a Series/Multiple Series:**

+ *pandas* has a `DataFrameGroupBy` object, consisting of `groups`:

  ```python
  everything_grouped_by_party = df.groupby('Party')
  for n, g in everything_grouped_by_party:
      print('name:', n)
      display(g.head())
  ```
  
+ Here is a real application:

  ```python
  (df.sort_values("%", ascending=False).
      groupby([df['Party'], df['Result']]).
      first())
  ```

### 2.5 Pivot Tables

To adjust rows and cols, try `pivot_table` command:

```python
df_pivot = df.pivot_table(
    index='Party', 				# the rows (turned into index)
    columns='Result', 		# the column values
    values='%', 					# the field(s) to processed in each group
    aggfunc=np.mean, 			# group operation
)
df_pivot.head()
```

### 2.6 Filtering Technics

To custom **Aggregation Functions**,

```python
def average_of_first_and_last(series):
    return (series.iloc[0] + series.iloc[-1])/2
  
percent_grouped_by_party_and_result.agg(average_of_first_and_last)
```

To filter datasets with `groupby` (even over a different dimension), 

```python
everything_grouped_by_candidate = df.groupby('Candidate')
everything_grouped_by_candidate.filter(lambda subframe: subframe["Year"].max() > 2000)
```

To filter with `isin`,

```python
df[(df["Party"] == "Democratic") | (df["Party"] == "Republican")]
# equivalent to
df[df["Party"].isin(["Republican", "Democratic"])]
```

## 3. <span id='3'>Data Cleaning</span>



