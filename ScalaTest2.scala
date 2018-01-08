

// Fucking with scala OO features
// No functional to see here, move along

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

	def testInt(anInt:Int): String = anInt match {
		case 0 => "Zero"
		case 1 => "One"
		case 2 => "Two"
		case _ => "Something else"
	}
}

object DClass {
	def apply(newName: String): DClass = {
		new DClass(newName)
	}

	def DoShit(): Unit = {
		println("Test")
	}
}



abstract class Vehicle {
	def printDesc: Unit

}

abstract class WheeledVehicle(wheelAmount: Int) {
	val _wheelAmt: Int = wheelAmount
}

abstract class LeggedVehicle(legAmount: Int) {
	val _legAmt: Int = legAmount
}

class Bicycle extends WheeledVehicle(wheelAmount=2) {
	def printDesc = println("Bicycle with " + _wheelAmt + " wheels.")
}

class MotorCycle extends WheeledVehicle(2) {
	def printDesc = println("Fill in")
}

class Car extends WheeledVehicle(4) {
	def printDesc = println("Fill in")
}

class Horse extends LeggedVehicle(4) {
	def printDesc = println("Fill in")
}

class Ostrich extends LeggedVehicle(2) {
	def printDesc = println("Fill in")
}



abstract class Notification

case class Email(senderEmail:String, subject:String, body:String) extends Notification
case class Text(senderPhone:String, message:String) extends Notification
case class IM(username:String, message:String) extends Notification
case class OtherNotif(from:String, message:String) extends Notification


object ScalaTest2 {
	def showNotification(notif:Notification): String = {
		notif match {
			case Email(sender, subject, _) =>
				s"You got an email from $sender.  Mubject: $subject"
			case Text(phone, message) =>
				s"You got a text from $phone. Message: $message"
			case IM(username, message) =>
				s"IM from $username: $message"
			case somethingElse =>
				s"Unknown Notification Type."
		}
	}

	def main(args:Array[String]): Unit = {
		/*SingletonTest.singVar = 10
		println("Singleton: Var: " + SingletonTest.singVar + " | Val: " + SingletonTest.singVal)

		var dc = new DerivedClass(10,20,30,40)

		dc.move(-10,-10)
		dc.setUV(0,1)
		dc.someFunc()

		println(dc._x + ", " + dc._y + ", " + dc._u+ ", " + dc._v)

		var derCl = DClass("NOYB")
		derCl.print
		DClass.DoShit()

		println( derCl.testInt(3) )*/

		val roadBike = new Bicycle
		val sportBike = new MotorCycle

		roadBike.printDesc


		val someEmail = Email("secretagent@gmail.com", "The files", "are in the computer")
		val someText = Text("867-5309", "Jenny, I got your number")
		val someIM = IM("yoMomma", "dinner is done!")
		val otherNotification = OtherNotif("some guy", "bro")

		println(showNotification(someEmail))
		println(showNotification(someText))
		println(showNotification(someIM))
		println(showNotification(otherNotification))

	}
}
