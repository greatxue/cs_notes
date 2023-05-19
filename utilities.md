# Notes for Utilities
- - -
author: Kevin Shuey  
title: Notes for Utilities  
date: 2023-05-02
- - -
**Coverage:**  

[1. Markdown](#1)   
[2. shell](#2)  
[3. git](#3)  
[4. vim](#4)  
[5. LaTeX](#5)  

## <span id='1'>1. Markdown</span>   
### 1.1 Basic Grammar 

#### 1.1.1 **Topics**
The topic is marked by &ensp;`#`&ensp;, with smaller fonts as numbers of # increase.
```markdown
# 1st topic
## 2nd topic
### 3rd topic
```


#### 1.1.2 **Fonts**
The font-types are marked by either &ensp;`*`&ensp; or&ensp; `_`&ensp; .
* Shortcuts:   
  **Bold**: &ensp;cmd+B &ensp;&ensp;&ensp;
  *Italics*: &ensp;cmd+I
```markdown
*This is Italics*        
_This is Italics_

**This is Bold**         
__This is Bold__

***This is Bold-italics***
___This is Bold-italics___
```


#### 1.1.3 **Newline**
There are many ways in mdarkdown to start a new line:
* Double space after a sentence.
* Spare a blank line between sentences.
* Add a &ensp;`<br/>`&ensp; in between.


#### 1.1.4 **Quote**
Quote is realized with symbol &ensp; `>`&ensp;.  
* The space after is optional.
* Newline is allowed in the quote, and a blank line is needed to end the quote.
* Mutiple use of symbols is allowed.

Example:
> This is a quote.
>> This is a quote of quote.
>>> This is a quote of quote of quote.


#### 1.1.5 **Link**
Link could be presented in the specific form.
```markdown
[Name of Link](Site of Link)
<Site of Link>
```
Example: &ensp;[URL of Google HK.](https://www.google.com.hk/) 


#### 1.1.6 **Pictures**
Pictures could be presented in the specific form.
* cmd+V is also available for pictures.
```markdown
![Description optional, butbrackets mandatory](Picture address, local or URL)
```


#### 1.1.7 **Lists**
Lists could be divided into ordered and unordered lists.
* Ordered lists could be realized using&ensp; `*`&ensp;,&ensp;`+`&ensp;,&ensp;`-`&ensp;, followed by a space.
* Unordered lists could be realized using&ensp; `1.`&ensp;, &ensp;`2.`&ensp;, also followed by a space.
* To control the level of lists, using tab.  

Example: 
* List 1
* List 2
  * List 2.1
    * List 2.1.1
  * List 2.2 
* List 3


#### 1.1.8 **Dividing Line**
Dividing line could be presented in the specific form.
* Remember to spare a blank line before division.
```markdown

---
***
- - - 
* * *
```
Example: 

___


#### 1.1.9 **Deleting Line**
Deleting line could be presented in the specific form.
```markdown
~~Text deleted~
```
Example: &ensp;~~Deleted~~


#### 1.1.10 **Underline**
Underline could be presented in the specific form.
```markdown
<u>Text underlined</u>
```
Example: &ensp; <u>Text underlined</u>


#### 1.1.11 **Code Block**
Code block could be presented in two ways.
* Include in ` if only in one line.
* Triple ` for a block of codes.


#### 1.1.12 **Form**
Forms use `|` to seperate different units, and use `-` to seperate heading and other lines.
* `:-` : &ensp;Left align heading and units.
* `-:` : &ensp;Right align heading and units.
* `:-:` : Centre heading and units.
```markdown
|Items    |Price  |Number |
|-------  |-----: |:-----:|
|PC       |\$1600 |5      |
|Mobile   |\$12   |12     |
|Cable    |\$1    |234    |
```
Example:  
|Items     |Price   |Number |
|-------   |-----:  |:-----:|
|PC        |\$1600  |5      |
|Mobile    |\$12    |12     |
|Cable     |\$1     |234    |


#### 1.1.13 **Footnote**
Footnotes could be presented in the specific form.
```markdown
A man's dignity[^1] depends not upon his wealth but upon his character[^2].
[^1]: The state or quality of being worthy of honour or respect.
[^2]: The mental and moral qualities distinctive to an individual.
```


#### 1.1.14 **Anchor**
Anchor could be utilized for a catalog.  
```markdown
* <span id='jump'>Jump here</span>  
* Then use [Jump here](#jump)
```
Example: 
* <span id='jump'> -> Jump here.</span>  
*  Then use [Jump here](#jump).


#### 1.1.15 **Recovery**
Reserved symbols could be recovered using `\` beforehand.


### 1.2 Premium Usage

#### 1.2.1 **To-do list**
To-do list could be presented in the specific form.
```markdown
- [ ] Task 1
- [ ] Task 2
- [x] Task 3
```
Example:
- [ ] Task 1
- [ ] Task 2
- [x] Task 3


#### 1.2.2 **Formula**
To-do list could be presented in the specific form.
```markdown
$$E=mc^2$$
```
Example:  
$$E=mc^2$$


#### 1.2.3 **More about diagrams**
Diagrams could be presented for some version of markdown as well.


#### 1.2.4 **Support for `HTML`**
Markdown supports original html grammar.  
Example 1:
<table>
    <tr>
        <th rowspan="2">STAFF</th>
        <th>MON</th>
        <th>TUE</th>
        <th>WED</th>
    </tr>
    <tr>
        <td>Sam</td>
        <td>Jack</td>
        <td>Rose</td>
    </tr>
</table>

```markdown
<table>
    <tr>
        <th rowspan="2">STAFF</th>
        <th>MON</th>
        <th>TUE</th>
        <th>WED</th>
    </tr>
    <tr>
        <td>Sam</td>
        <td>Jack</td>
        <td>Rose</td>
    </tr>
</table>
```
Example 2:   
<font face="Arial" color=#00ffff size=4>Markdown is useful!</font>
```markdown
<font face="Arial" color=#00ffff size=4>Markdown is useful!</font>
```
---


### 1.3 **Reference**
1. [**CSDN:** Step-by-step guide to using Markdown](https://blog.csdn.net/qq_40818172/article/details/126260661?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522168275687516800184134815%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=168275687516800184134815&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-2-126260661-null-null.142^v86^wechat,239^v2^insert_chatgpt&utm_term=markdown&spm=1018.2226.3001.4187)




## <span id='2'>2. shell</span> 

### 2.1 Useful commands
* change the current working directory to a new directory  
`cd *document*`
* change directory to the current, aka. do nothing  
`cd .`
* change directory to one parent directory above  
`cd ..` 
* list the contents of the current directory  
`ls`
* list all contents, with timestamps and file permissions  
`ls -l`
* print the current working directory  
`pwd`
* create a new directory  
`mkdir *folder*`
* remove a file or directory  
`rm *myfile.txt*`
* remove the entire directory recursively
`rm -r *dir1*`
* copy a file or directory  
`cp myfile.txt myfolder/`
* move or rename a file or directory  
`mv *oldfile.txt* *newfile.txt*`
* create an empty file  
`touch *test.java*`
* display the contents of a file  
`cat *displayfile.py*`
* search for a pattern in a file  
`grep *word-to-search* *rangefile.txt*`
* change the permissions of a file or directory  
`chmod u+rw myfile.txt` &ensp;#to make it readable and writable by the owner
* display a message or the value of a variable  
`echo "Hello world"`
* transfer data from or to a server  
`curl *URL*`
### 2.2 Reminders
* UNIX can complete file names and directory names with `tab` completion.
* To retype the same recent-used instruction, press `up` until the correct one is seen.
* To show all hidden directories and files: (reverse with `FALSE`)
  ```shell
  $ defaults write com.apple.finder AppleShowAllFiles TRUE  
  $ killall Finder
  ```
### 2.3 Reference
(null)





## <span id='3'>3. git</span> 

### 3.1 Terms
Here are some basic terms used in git operations:
* Directory -> Folder
* Terminal / Command Line
* CLI -> Command Line Interface
* cd -> Change Directory
* Repository -> the folder where the project is kept


### 3.2 git Concepts
Here are some basic concepts of git operations:
* clone -> to bring in a reposity elsewhere
* add -> track files and changes in git
* commit -> save files in git
* push -> upload git commits to remote repo
* pull -> download git from remote repo to local machine


### 3.3 Case Tutorial
Here is a practical case for git operations:  

**Case 1:**

* Create a new folder and create new files inside:   

  ```shell 
   $ mkdir git
   $ cd git 
   $ touch test.py index.html
  ```

* Initialize git：   
  `git init`

* Add stage changes:  
  `git add .` or &ensp; `git add test.py`

* Save by committing changes:  
  `git commit -m "message" -m "description"`

* Check git status anytime by:
  
  `git status` 

**Case 2:**  

* Now try to make some changes to the file:

  ```shell
  $ rm index.html
  $ touch app.js
  $ ls
  $ git add . 
  $ commit -m "delete and add"
  ```
* All the records could be tracked with all hash-codes by:  

   ```shell
   $ git log
   $ git checkout *hash-code* 
   ```

* Then get back to history versions by:  

  ```shell
  $ git reset -hard *hash-code*
  $ git merge master
  ```

* Now log on **Github**, create a new repository, copy its `SSH`.  

* Back to local, set remote git by:

   `git remote add origin *SSH*`

* Search for local branch, while most of the time it should be `main` or `master`:

  `git branch`

* Now local file could be pushed to **Github** by:

  `git push -u origin master`

  Beware that `-u` is a shortcut for later use of `git push`.

**Case 3:**

* Start a new branch by:

   `git branch -b feature`

* Only for test:
  ```shell
  $ git branch
  $ touch test2.java
  $ git log
  ```

* Now new branch could be pushed live like:  
  `git push origin feature`

* Back to Github,  a pull request could on found on **Github**, and you choose to merge or not to merge.

  Anyway, it could be synchronized like:
  `git pull origin master`

* Or  choose to merge at local like:

  `git merge master`

* Before that, any difference between the versions could be found as:

  `git diff master`

**Case 4:**

Start by cloning from **Github** like:  
  `git clone https://github.com/greatxue/greatxue.github.io.git`   


### 3.4 Key Commands
Here are key commads introduced above:

* `git init  `    # initialize project to use git

* `git add .`    # add all changes to be saved

* `git add *filename*`    # add single file to be saved

* `git commit -m "message"`    # savechanges with message

* `git push origin master`    # push changes to Github master

* `git push origin new-branch`    # push changes to Github new-branch

* `git pull origin master`    # pull changes from Github master

* `git checkout -b new-branch`     # create a new branch

* `git status`    # check status of changes

* `git log`    # see all previous saved changes

* `git checkout *commit hash*`    # travel back to old commit


### 3.5 Reference

1. [**Youtube:** Git Tutorial For Dummies](https://www.youtube.com/watch?v=mJ-qvsxPHpY&t=1s)





## <span id='4'>4. vim</span> 

### 4.1 Quick start
**vim** could be accessed by entering &ensp;`vim *file*`&ensp; in the terminal. It could be divided into three modes, which are:
* Command mode
* Insert mode
* Last line mode


#### 4.1.1  **Command mode**
vim is at command mode when the user starts vi/vim.  
In this state, keystrokes are recognized by Vim as commands:
* `i` -> Switch to insert mode to input characters.
* `x` -> Delete the character under the cursor.
* `:` -> Switch to last line mode to enter a command on the last line.


#### 4.1.2 **Insert mode**
Pressing "i" in command mode enters insert mode. In insert mode, you can use the following keys:
* **(Shift) Character keys** -> input characters
* **ENTER** -> start a new line
* **BACK SPACE** -> delete the character before the cursor
* **DEL** -> delete the character after the cursor
* **Arrow keys** -> move the cursor within the text
e cursor changes to a vertical line/underscore
* **ESC** -> exit insert mode and switch to command mode


#### 4.1.3 **Last line mode**
Pressing ":" (colon) in command mode enters last line mode. 
* `:q` -> Quit the program
* `:w` -> Save the file


### 4.2 More commands
* **Multiple-file arrangement**

  ```shell
  vim *file1* *file2*
  :ls   # list all vim-opened files
  :b2   # show the second file
  :bn   # last file
  :bp   # next file
  vim -On *f1* *f2* filen  # left-right spilit screen
  vim -on *f1* *f2* filen  # top-down split screen
  ```

  Also availble with:

  `cmd` + `w` + **`s `** / **`v`**  -> top-down / left-right split

  `:sp newfile` / `:vsp newfile`-> t-d / l-r current with new file

  `cmd` + `w` + **`h`** / **`l`** /  **`k`** / **`j`** -> move cursor to left / right / up / down 

  `cmd` + `w` + **`H`** / **`L`** /  **`K`** / **`J`** -> move split to left / right / up / down 

  `cmd` + `w` + **`c `** /  **`q `** -> quit vim

* **Quit & save commands**

  ```shell
  :w   # save, not quit
  :w!   # force save, not quit
  :w *file*   # save change to file
  :q!   # quit, not save
  :qa!  # quit all, not save
  :wq  # quit & save
  :x   #quit & save
  :e *file*   # open another file
  :e!   # abandon change
  :saveas *file*   # save as
  
  
  
  ```
* 
  
  
  

  ### 4.3 Reference
  1. [**Zhihu:** Proficient in Vim](https://zhuanlan.zhihu.com/p/68111471?utm_id=0)
  2. [**RUNOOB:** Linux vi/vim](https://www.runoob.com/linux/linux-vim.html)






## <span id='5'>5. LaTeX</span>  

