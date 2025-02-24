import model.Employee

// Abstraction - trừu tượng
abstract class BaseEmployee(val employee: Employee) {
    abstract fun calculateSalary(): Double

    open fun showInfo() {
        println("Nhân viên: ${employee.name} - ID: ${employee.id}")
    }
}

// Inheritance - kế thừa
class OfficeEmployee(employee: Employee, private val monthlySalary: Double) : BaseEmployee(employee) {
    override fun calculateSalary(): Double = monthlySalary
}

// Polymorphism - đa hình
class TechnicalEmployee(employee: Employee, private val hourlyRate: Double, private val hoursWorked: Int) : BaseEmployee(employee) {
    override fun calculateSalary(): Double = hourlyRate * hoursWorked

    override fun showInfo() {
        super.showInfo()
        println("Giờ làm việc: $hoursWorked giờ")
    }
}

// Encapsulation - đóng  goi
class EmployeeManager {
    private val employees = mutableListOf<BaseEmployee>()

    fun addEmployee(employee: BaseEmployee) {
        employees.add(employee)
    }

    fun showAllEmployees() {
        for (emp in employees) {
            emp.showInfo()
            println("Lương: ${emp.calculateSalary()} VND\n")
        }
    }
}

fun main() {
    val employee1 = Employee(100,"Nguyễn Phương Mai")
    val employee2 = Employee(101, "Trần Lan Chi")

    val officeEmp = OfficeEmployee(employee1, 3000.0)
    val techEmp = TechnicalEmployee(employee2, 20.0, 160)

    val manager = EmployeeManager()
    manager.addEmployee(officeEmp)
    manager.addEmployee(techEmp)

    manager.showAllEmployees()
}