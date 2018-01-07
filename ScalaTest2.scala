

class SomeClass(x:Int, y:Int) {
	var _x: Int = x
	var _y: Int = y

	def someFunc(): Unit = {
		println("SomeClass.someFunc()")
	}
}

class DerivedClass(x:Int, y:Int, u:Int, v:Int) extends SomeClass( x,y) {
	var _u: Int = u
	var _v: Int = v

	def move(x:Int, y:Int): Unit = {
		_x += x
		_y += y
	}

	def setUV(u:Int, v:Int): Unit = {
		_u = u
		_v = v
	}

	override def someFunc(): Unit = {
		println("DerivedClass.someFunc()")
		super.someFunc()
	}
}



object SingletonTest {
	var singVar: Int = 0
	val singVal: Int = 1
}


abstract class BClass(name: String) {
	var _name: String = name

	def rename(newName:String): Unit
}

class DClass(name: String) extends BClass(name) {
	override def rename(newName:String): Unit = {
		_name = name
	}

	def print = println(_name)
}

object DClass {
	def apply(newName: String): DClass = {
		new DClass(newName)
	}

	def DoShit(): Unit = {
		println("Test")
	}
}



object ScalaTest2 {
	def main(args:Array[String]): Unit = {
		SingletonTest.singVar = 10
		println("Singleton: Var: " + SingletonTest.singVar + " | Val: " + SingletonTest.singVal)

		var dc = new DerivedClass(10,20,30,40)

		dc.move(-10,-10)
		dc.setUV(0,1)
		dc.someFunc()

		println(dc._x + ", " + dc._y+ ", " + dc._u+ ", " + dc._v)

		var derCl = DClass("Bobby")
		derCl.print
		DClass.DoShit()
	}
}
