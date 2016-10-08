ScalaBF
======

What is this?
-------------

It's just a simple functional [Brainfuck](https://en.wikipedia.org/wiki/Brainfuck) interpreter in scala.

I just wanted to see what setting up an SBT project was like.


Is there anything interesting going on here?
--------------------------------------------

Probably not, but it does allow you to use binary BF functions with (almost) no boilerplate right inside scala.

```
import BF._, BF.BFOps._

val sum = (12)("[->+<]>")(8) // => 20
```

So if you were looking for an easy way to integrate BF with scala, here you go!