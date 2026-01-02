import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.FileReader;
public class Employee{
  private int employeeId;
  private String name;
  private String department;
  private String email;
  private int leaveBalance = 20; //annual leave balance in days 
  //constructor
 public Employee(int employeeId, String name, String department, String email){
   this.employeeId = employeeId;
   this.name = name;
   this.department = department;
   this.email = email;
 }
  //methods will be added here
  //getter menthod 
  public int getLeaveBalance(){
    return leaveBalance;
  }
  //setter methhod with validation
  public void setLeaveBalance(int leaveBalance){
    if(leaveBalance >= 0){
      this.leaveBalance = leaveBalance;
    }else{
      System.out.println("Leave balance be negative.");
    }
  }

  private ArrayList<LeaveRequest> leaveHistory = new ArrayList<>();
  public void addLeaveRequest(LeaveRequest request){
    leaveHistory.add(request);
  }
  public ArrayList<Leaverequest> getLeaveHistory(){
    return leaveHistory;
  }
  public LeaveRequest getLeaveRequestById(int requestId){
    for(LeaveRequest request : leaveHistory){
      if(request.getRequestId() == requestId){
        return request;
      }
    }
    return null; //request not found
}
}
public class LeaveRequest{
  private requestId;
  private Employee employee;
  private String startDate;
  private String endDate;
  private String status; //approved, pending, denied
  private String reason;
  public LeaveRequest(int requestId, Employee employee, String startDate, String endDate, String status, String reason){
    this.requestId = requestId;
    this.employee = employee;
    this.startDate = startDate;
    this.endDate = endDate;
    this.status = status;
    this.reason = reason;
  }
  //methods will be added here
  public boolean processRequest(){
    System.out.Println("Processing generic leave request....");
    return true;
  }
  private ArrayList<StatusChange> statusHistory = new ArrayList<>();
  //inner class to track status change
  public class StatusChange{
    private String oldStatus;
    private String newStatus;
    private String changeDate;
    private String changedBy;

    public StatusChange(String oldStatus , String newStatus, String changeDate, String changedBy){
      this.oldStatus = oldStatus;
      this.newStatus = newStatus;
      this.changeDate = changeDate;
      this.changedBy = changedBy;
    }

    //getters for the fields
}

  //Method to change status and record the change 
  public void changeStatus(String newStatus, String changedBy){
    String oldStatus = this.status;
    this.status = newStatus;

    //create a new status change record
    StatusChange change = new StatusChange(oldStatus, newStatus, getCurrentDate(), changedBy();
    statusHistory.add(change);
  }
}
public class SickLeaveRequest extends LeaveRequest{
  private boolean medicalCertificateProvided;
  public SickLeaveRequest(int requestId, Employee employee, String startDate, String endDate, boolean medicalcertificateProvided){
    super(requestId, employee, startDate, endDate, "Sick Leave");
    this.medicalCertificateProvided = medicalCertificateProvided;

    @override 
      public boolean processRequest(){
      if(!medicalCertificateProvided && getDuration() > 2 {
        System.out.println("Sick leave longer than 2 days requires medical certificate");
        return false;
      }
      System.out.println("Processing sick leave request.....");
      return true;
    }
  }
  public boolean isMedicalCertificateProvided(){
    return medicalCertificateProvided;
  }
  //interface
  public interface Approvable{
    boolean approve(String approveName);
    boolean deny(String approveName, String reason);
  }
  //abstract class
  public abstract class LeaveRequest implements Approvable{
    //common fields and methods

    //abstract menthod that subclasses must implement
    public abstract int calculateLeaveDays();
  }
  public class LeaveTrackingSystem{
    //other fields and method 
    private HashSet<String> departmentWithPendingRequests = new HashSet<>();
    
    public void updateDepartmentWithPeningRequests(){
      departmentWithPendingRequests.clear();

      for(LeaveRequest request : allLeaveRequests){
        if(request.getStatus().equals("Pending")){
          departmentWithPendingRequests.add(request.getEmployee().getDepartment());
        }
      }
      private HasMap<Integer, Employee> employeeDirectory = new HashMap<>();
      public void addEmployee(Employee employee){
        employeeDirectory.put(employee.getEmployeeId(), employee);
        }
    public Employee getEmployeeById(int employeeId){
      return employeeDirectory.get(employeeId);
    }
    public boolean removeEmployee(int employeeId){
      if(employeeDirectory.containKey(employeeId)){
        employeeDirectory.remove(employeeId);
        return true;
      }
      return false;
    }
  }
    //maps for quick lookup
    private HashMap<Integer, Employee> employeeId = new HashMap<>();
    private HashMap<Integer, LeaveRequest> requestById = new HashMap<>();

    //lists for orderd access
    private ArrayList<LeaveRequest> allRequests new ArrayList<>();

    //sets for unique collections
    private HashSet<String> leaveTypes = new HashSet<>();
    // queues for processing 
    private Queue<LeaveRequest> pendingApprovals = new LinkedList<>();
    //methods to manage these collections
}
    
    public boolean hashPendingRequests(String department){
      return departmentWithPendingRequests.contains(department);
    }
  }
public class LeaveApprovalSystem{
   private Queue<LeaveRequest> pendingRequests = new LinkedList<>();
    
    public void addPendingRequest(LeaveRequest request) {
        pendingRequests.add(request);
    }
    
    public LeaveRequest getNextPendingRequest() {
        return pendingRequests.poll(); // Retrieves and removes the head
    }
    
    public int getPendingRequestCount() {
        return pendingRequests.size();
    }
    
    public boolean hasPendingRequests() {
        return !pendingRequests.isEmpty();
    }
}
  
  

