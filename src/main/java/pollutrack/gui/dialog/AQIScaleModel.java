package pollutrack.gui.dialog;

import javax.swing.table.*;

public class AQIScaleModel extends AbstractTableModel {

    private final String[] columnNames = {
            "Qualitative Name", "PM2.5", "PM10", "NO2", "O3"
    };

    private final String[][] values = {
            {"Good", "0-15", "0-25", "0-50", "0-60"},
            {"Moderate", "15-30", "25-50", "50-100", "60-120"},
            {"Unhealthy", "30-55", "50-90", "100-200", "120-180"},
            {"V-Unhealthy", "55-110", "90-180", "200-400", "180-240"},
            {"Hazardous", ">110", ">180", ">400", ">240"}
    };

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return values[rowIndex][columnIndex];
    }
}
