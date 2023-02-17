package pollutrack.gui.dialog;

import pollutrack.ApplicationConstants;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class AQIScaleDialog extends JDialog {

    private static final Dimension DIALOG_SIZE = new Dimension(359, 142);
    private static final String DIALOG_TITLE = "AQI Scale";

    private final JFrame dialogParent;
    private JScrollPane scrollableTable;

    public AQIScaleDialog(JFrame dialogParent) {
        super(dialogParent, DIALOG_TITLE);
        this.dialogParent = dialogParent;

        configureComponents();
        layoutComponents();
    }

    private void configureComponents() {
        configureDialog();
        configureScrollableTable();
    }

    private void layoutComponents() {
        add(scrollableTable, BorderLayout.CENTER);
    }

    private void configureDialog() {
        setIconImage(ApplicationConstants.APP_ICON);
        setSize(DIALOG_SIZE);

        setResizable(false);
        setLocationRelativeTo(dialogParent);
    }

    private void configureScrollableTable() {
        AQIScaleModel model = new AQIScaleModel();
        JTable table = new JTable(model);

        table.setCellSelectionEnabled(false);
        table.setFocusable(false);

        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        int columnCount = table.getColumnCount();

        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(cellRenderer);

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        for (int columnIndex = 1; columnIndex < columnCount; columnIndex++)
            table.getColumnModel().getColumn(columnIndex).setPreferredWidth(60);

        Dimension tableDimension = table.getPreferredSize();
        table.setPreferredScrollableViewportSize(tableDimension);
        scrollableTable = new JScrollPane(table);
    }
}
