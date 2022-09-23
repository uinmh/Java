package edu.java.lambda04;

public class Employee { // 직원

    private Integer empId;//사번
    private String name; //이름
    private String job; // 직무
    private String dept; // 부서
    private Integer salary; // 급여
    
    public Employee() {}

    /**
     * @param empId
     * @param name
     * @param job
     * @param dept
     * @param salary
     */
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

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", job=" + job + ", dept=" + dept + ", salary=" + salary
                + "]";
    }

}
