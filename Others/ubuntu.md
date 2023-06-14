# Notes for Ubuntu_Linux
- - -
author: Kevin Shuey    
title: Notes for Ubuntu_Linux  
date: 2023-05-08  
- - -

**Coverage:**  

[1. Commands](#1) 


## <span id='1'>1. Commands</span>  

### 1.1 Basic Commands  

* `cd` -- change directory  
  ```shell
  cd *dir*
  cd      # back home/
  cd .
  cd ..
  ```

* `mkdir` -- make directory  
  ```shell
  mkdir *para* *dir*
  mkdir -p "home/abc/def/"
  mkdir ab cd ef
  ```

* `rmdir` -- remove empty directory  
  
* `pwd` -- show current directory  
  
* `ls`/`dir` -- list dir and files
  ```shell
  ls *para* *file*
  ls -a     # list hidden files, even starting with '.'
  ls -d
  ls -h     # show file size
  ls -l     # show size and authority
  ls -R     # show all dir of dir
  ls -X     # list with extension
  ```

* `cat` -- output a file
  ```shell
  cat *para* *file*
  cat -b    # only show line number for non-empty line
  cat -E    # display '$' at the end of each line
  cat -n    # show line number for all
  ```

* `head`/`tail` -- display first/last 10 lines
  ```shell
  head *para* *file*
  head -c N     # show n bytes before/after
  head -n N     # show n lines before/after
  ```

* `mv` -- move a file / rename a file
  ```shell
  mv *para* *source-file* *target dir/file*
  mv -b         # make a copy if name-repeating
  mv -f         # force move with coverage (default)
  mv -i         # move with asking
  mv -f         # move with asking
  mv -u         # move if new/null

* `cp` 

