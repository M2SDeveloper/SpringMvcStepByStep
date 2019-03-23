Step To Add project in GitHub

```
1. $ git init
Initialized empty Git repository in D:/MyDevelopment/SpringMvcStepByStepApp/.git/

2.
$ git remote add origin https://github.com/M2SDeveloper/SpringMvcStepByStep.git
or
$ git remote set-url origin https://github.com/M2SDeveloper/SpringMvcStepByStep.git

3.$ git branch

4. $ git status
On branch master

5.$ git add src/

6.git commit -m "First commit for the project"

7. $ git remote -v
origin  https://github.com/M2SDeveloper/SpringMvcStepByStep.git (fetch)
origin  https://github.com/M2SDeveloper/SpringMvcStepByStep.git (push)

8. $ git push --force origin master

9. touch .gitignore

10. vim .gitignore
target
.settings
.classpath
.project
*.class

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.ear

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

````
