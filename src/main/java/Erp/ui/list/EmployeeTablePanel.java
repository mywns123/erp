package Erp.ui.list;

import javax.swing.SwingConstants;

import Erp.dto.Employee;
import Erp.service.EmployeeService;
import Erp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class EmployeeTablePanel extends AbstractCustomTablePanel<Employee> {
	private EmployeeService service;
	
	@Override
	public void initList() {
		list = service.showEmpList();		
	}

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1,2,3,5);
		setTableCellAlign(SwingConstants.RIGHT, 4);
		// 컬럼 너비 조정
		setTableCellWidth(100, 250,100,100,100,100);		
	}

	@Override
	public Object[] toArray(Employee t) {
		return new Object[] {
				t.getEmpNo()
				,t.getEmpName()
				,String.format("%s(%d)", t.getTitle().gettName(),t.getTitle().gettNo())
				,t.getManager().getEmpNo()==0 ?"":String.format("%s(%d)", t.getManager().getEmpName(), t.getManager().getEmpNo())
				,String.format("%,d", t.getSalary())
				,String.format("%s(%d)",t.getDept().getDeptName(),t.getDept().getDeptno())				
		};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"사원번호", "사원명", "직책", "직속상사", "급여", "부서"};
	}

	public void setService(EmployeeService service) {
		this.service = service;		
		}

	@Override
	public Employee getItem() {
		int row = table.getSelectedRow();
		int empNo = (int) table.getValueAt(row, 0);
		
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Employee(empNo)));
	}
}
