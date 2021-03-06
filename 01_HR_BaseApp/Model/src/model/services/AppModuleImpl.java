package model.services;


import model.services.common.AppModule;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 18 21:47:06 CET 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }
    
    public void insertSelectedRows(){
        ViewObject departmentsVO = this.getDepartmentsVO1();
        RowSetIterator rsi = departmentsVO.createRowSetIterator("new");
        
        Row[] rows = rsi.getFilteredRows("Selection", true);
        if(rows.length>0){
            for (Row row : rows){
                String departmentId = row.getAttribute("DepartmentId").toString();
                String departmentName = row.getAttribute("DepartmentName").toString();
                this.insertRow(departmentId, departmentName);
                row.removeAndRetain();
                //row.setAttribute("Selection", false);
            }
        }
      
      rsi.closeRowSetIterator();  
        
    }
    
    private void insertRow(String id, String departmentName){
        ViewObjectImpl departmentsTest = this.getDepartmentsTestVO1();
        Row newRow = departmentsTest.createRow();
        newRow.setAttribute("DepartmentId", id);
        newRow.setAttribute("DepartmentName", departmentName);
        departmentsTest.insertRow(newRow);
        getDBTransaction().commit();
    }
    

    /**
     * Container's getter for EmployeesVO1.
     * @return EmployeesVO1
     */
    public ViewObjectImpl getEmployeesVO1() {
        return (ViewObjectImpl) findViewObject("EmployeesVO1");
    }

    /**
     * Container's getter for EmployeesVO2.
     * @return EmployeesVO2
     */
    public ViewObjectImpl getEmployeesVO2() {
        return (ViewObjectImpl) findViewObject("EmployeesVO2");
    }

    /**
     * Container's getter for DepartmentsVO1.
     * @return DepartmentsVO1
     */
    public ViewObjectImpl getDepartmentsVO1() {
        return (ViewObjectImpl) findViewObject("DepartmentsVO1");
    }

    /**
     * Container's getter for EmployeesVO3.
     * @return EmployeesVO3
     */
    public ViewObjectImpl getEmployeesVO3() {
        return (ViewObjectImpl) findViewObject("EmployeesVO3");
    }

    /**
     * Container's getter for EmployeesVO4.
     * @return EmployeesVO4
     */
    public ViewObjectImpl getEmployeesVO4() {
        return (ViewObjectImpl) findViewObject("EmployeesVO4");
    }

    /**
     * Container's getter for DepartmentsVO2.
     * @return DepartmentsVO2
     */
    public ViewObjectImpl getDepartmentsVO2() {
        return (ViewObjectImpl) findViewObject("DepartmentsVO2");
    }

    /**
     * Container's getter for DepartmentsTestVO1.
     * @return DepartmentsTestVO1
     */
    public ViewObjectImpl getDepartmentsTestVO1() {
        return (ViewObjectImpl) findViewObject("DepartmentsTestVO1");
    }

    /**
     * Container's getter for EmpManagerFkLink1.
     * @return EmpManagerFkLink1
     */
    public ViewLinkImpl getEmpManagerFkLink1() {
        return (ViewLinkImpl) findViewLink("EmpManagerFkLink1");
    }

    /**
     * Container's getter for EmpDeptFkLink.
     * @return EmpDeptFkLink
     */
    public ViewLinkImpl getEmpDeptFkLink() {
        return (ViewLinkImpl) findViewLink("EmpDeptFkLink");
    }

    /**
     * Container's getter for DeptMgrFkLink.
     * @return DeptMgrFkLink
     */
    public ViewLinkImpl getDeptMgrFkLink() {
        return (ViewLinkImpl) findViewLink("DeptMgrFkLink");
    }
}

