# Simplify Path Problem

Given an absolute Unix file path. Create a function that returns the shortest path

```'/'``` is the root directory; the path should always start with it

```'/'``` is also the directory separator

```'//'``` is a valid option and means "change the current directory to the current directory"

```'.'``` is used to mark the current directory;

```'..'``` goes up to the parent directory; if the current directory is root already, '..' does nothing

```
Ex: path = "/a/b/../c/"
f(path) = "/a/c"
```

```
Ex*: path = "/a//c/"
f(path) = "/a/c"
```

```
Ex*: path = "/a/./c/"
f(path) = "/a/c"
```

```
Ex: path = "/opt/brew/./lib/../python//../bin"
f(path) = "/opt/brew/bin"
```
