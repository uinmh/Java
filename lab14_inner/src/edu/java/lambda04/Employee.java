package edu.java.lambda04;

public class Employee { // 직원

    private Integer empId;//사번
    private String name; //이름
    private String job; // 직무
    private String dept; // 부서
    private Integer salary; // 급여
    
    public Employee() {}

    public Employee(Integer empId, String name, String job, String dept, Integer salary) {
        this.empId = empId;
        this.name = name;
        this.job = job;
        this.dept = dept;
        this.salary = salary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

//    @Override
//    public String toString() {
//        return "Employee [empId=" + empId + ", name=" + name + ", job=" + job + ", dept=" + dept + ", salary=" + salary
//                + "]";
//    }
    
    @Override
        public String toString() {
            return String.format("Employee(empId=%d,name=%s,job=%s,dept=%s,salary=%d)",
                    empId,name,job,dept,salary);
        }
}
