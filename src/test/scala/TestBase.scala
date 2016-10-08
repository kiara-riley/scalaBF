package test

import org.scalatest.{ FlatSpec, Matchers }
import org.scalatest.prop.PropertyChecks

class TestBase extends FlatSpec with Matchers with PropertyChecks
