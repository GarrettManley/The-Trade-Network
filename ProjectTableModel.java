import javax.swing.table.AbstractTableModel;

public class ProjectTableModel extends AbstractTableModel {

	private String[] columnNames = {"UserName", "Item", "ItemDescription", "OffersYN"};
	
	private Object[][] data = {
			{"bob","spoon","its a spoon","N"},
			{"steve","knife","a KNOIF","Y"}
	};
	
	public ProjectTableModel(){	
	}
	
	public ProjectTableModel(String[] cNames, Object[][] data){
		columnNames = cNames;
		this.data = data;
	}
	
	public void refresh(String[] cNames, Object[][] data){
		columnNames = cNames;
		this.data = data;
		
		//Notifies all listeners that all cell values in the table's rows may have changed
		fireTableDataChanged();
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}
	
	public String getColumnName(int column){
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	/*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableDataChanged();
    }
	
	/*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
	public Class getColumnClass(int c){
		return getValueAt(0,c).getClass();
	}

}
