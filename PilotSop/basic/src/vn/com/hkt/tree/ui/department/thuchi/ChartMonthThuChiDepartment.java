/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChartMonthThuChiDepartment.java
 *
 * Created on Nov 30, 2011, 4:54:37 AM
 */
package vn.com.hkt.tree.ui.department.thuchi;

import org.openide.util.LookupEvent;
import javax.swing.event.ChangeEvent;
import vn.com.hkt.finance.api.ICalculate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.openide.util.Lookup;
import org.openide.util.LookupListener;
import org.openide.windows.WindowManager;
import vn.com.hkt.bom.operation.dao.OperationBN;
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author longnt
 */
public final class ChartMonthThuChiDepartment extends javax.swing.JPanel implements ActionListener, ChangeListener, LookupListener {

    private Lookup.Result result = null;
    private XYPlot plot;
    private Object item;
    private int month1 = 1;
    private int month2 = 8;
    private int year1 = 2000;
    private int year2 = 2000;
    private Department department;
    private ChartPanel chartPanel;
    private Enterprise enterprise;
    private ICalculate calculate;
    private OperationBN operationBN;
    private JSpinner.DateEditor dateEditor1, dateEditor2;
    private Date date;

    public ChartMonthThuChiDepartment(Enterprise enterprise) {
        this.enterprise = enterprise;
        department = new Department();
        initComponents();

        this.calculate = Lookup.getDefault().lookup(ICalculate.class);
        operationBN = new OperationBN();

        TreeDepartmentThuAllTopComponent tc = (TreeDepartmentThuAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentThuAllTopComponent");
        TreeDepartmentThuChiAllTopComponent tc1 = (TreeDepartmentThuChiAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentThuChiAllTopComponent");
         TreeDepartmentChiAllTopComponent tc2 = (TreeDepartmentChiAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentChiAllTopComponent");
        TreeDepartmentCanBangAllTopComponent tc3 = (TreeDepartmentCanBangAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentCanBangAllTopComponent");
        if(tc.isOpened()){
            result = tc.getLookup().lookupResult(Department.class);
        }
        if(tc1.isOpened()){
            result = tc1.getLookup().lookupResult(Department.class);
        }
         if(tc2.isOpened()){
            result = tc2.getLookup().lookupResult(Department.class);
        }
          if(tc3.isOpened()){
            result = tc3.getLookup().lookupResult(Department.class);
        }
        result.addLookupListener(this);
        resultChanged(new LookupEvent(result));
        buttonXem.addActionListener(this);
        panelChart.setLayout(new GridLayout());

        chartPanel = new ChartPanel(createChart(month1, year1, month2, year2));
        chartPanel.setPreferredSize(new Dimension(1000, 300));
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        panelChart.add(chartPanel);
        setSize(1000, 450);
        setVisible(true);
        date = new Date();
        
    }

    // Create Dataset
    public XYDataset createDataset(int m1, int y1, int m2, int y2) {

        // Create dataset Thu
        TimeSeries series1 = new TimeSeries("Thu", Month.class);
        TimeSeries series2 = new TimeSeries("Chi", Month.class);

        //Department Department = DepartmentBN.
        if (y1 == y2) {
            for (int i = m1; i <= m2; i++) {
                String str = String.valueOf(i) + "/" + String.valueOf(y1);
                series1.add(new Month(i, y1), calculate.calculateImportByMonthOfDepartment(enterprise, department, str));
                series2.add(new Month(i, y1), calculate.calculateExportByMonthOfDepartment(enterprise, department, str));
            }
        }

        if (y1 < y2) {
            for (int i = m1; i <= 12; i++) {
                String str = String.valueOf(i) + "/" + String.valueOf(y1);
                series1.add(new Month(i, y1), calculate.calculateImportByMonthOfDepartment(enterprise, department, str));
                series2.add(new Month(i, y1), calculate.calculateExportByMonthOfDepartment(enterprise, department, str));
            }
            y1++;
            while (y1 < y2) {
                for (int i = 1; i <= 12; i++) {
                    String str = String.valueOf(i) + "/" + String.valueOf(y1);
                    series1.add(new Month(i, y1), calculate.calculateImportByMonthOfDepartment(enterprise, department, str));
                    series2.add(new Month(i, y1), calculate.calculateExportByMonthOfDepartment(enterprise, department, str));
                }
                y1++;
            }
            if (y1 == y2) {
                for (int i = 1; i <= m2; i++) {
                    String str = String.valueOf(i) + "/" + String.valueOf(y1);
                    series1.add(new Month(i, y1), calculate.calculateImportByMonthOfDepartment(enterprise, department, str));
                    series2.add(new Month(i, y1), calculate.calculateExportByMonthOfDepartment(enterprise, department, str));
                }

            }

        }


        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.setXPosition(TimePeriodAnchor.MIDDLE);

        return dataset;
    }

    // Create Chart
    public JFreeChart createChart(int m1, int y1, int m2, int y2) {
        XYDataset data = createDataset(m1, y1, m2, y2);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(" ", "Tháng", "Doanh Thu", data, true, true, false);
        plot = (XYPlot) chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 10.0, 10.0));


        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MM-yy"));
        axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        axis.setTickUnit(new DateTickUnit(DateTickUnitType.MONTH, 1));
        return chart;
    }

    /**
     * @param comboBox
     * @return 
     */
    public Object chooseItem(JComboBox comboBox) {
        item = (Object) comboBox.getSelectedItem();
        return item;
    }

    /**
     * Xu ly su kien nhan button va thiet lap lai dataset
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == buttonXem) {
            month1 = Integer.parseInt(dateEditor1.getFormat().format(spinnerDay1.getValue()).toString().substring(3, 5));
            month2 = Integer.parseInt(dateEditor2.getFormat().format(spinnerDay2.getValue()).toString().substring(3, 5));
            year1 = Integer.parseInt(dateEditor1.getFormat().format(spinnerDay1.getValue()).toString().substring(6, 10));
            year2 = Integer.parseInt(dateEditor2.getFormat().format(spinnerDay2.getValue()).toString().substring(6, 10));
            plot.setDataset(createDataset(month1, year1, month2, year2));

        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.m
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelChart = new javax.swing.JPanel();
        panelDay = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonXem = new javax.swing.JButton();
        spinnerDay1 = new javax.swing.JSpinner();
        spinnerDay2 = new javax.swing.JSpinner();

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1397, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        jLabel2.setText(org.openide.util.NbBundle.getMessage(ChartMonthThuChiDepartment.class, "ChartMonthThuChiDepartment.jLabel2.text")); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(ChartMonthThuChiDepartment.class, "ChartMonthThuChiDepartment.jLabel5.text")); // NOI18N

        buttonXem.setText(org.openide.util.NbBundle.getMessage(ChartMonthThuChiDepartment.class, "ChartMonthThuChiDepartment.buttonXem.text")); // NOI18N

        spinnerDay1.addChangeListener(this);
        DateTimeUtils dateTimeUtils = new DateTimeUtils();
        String d = "";
        int y = dateTimeUtils.getPreYear();
        int day = dateTimeUtils.getCurrentDay();
        int m = dateTimeUtils.getCurrentMonth();
        d = String.valueOf(day) + "/" + String.valueOf(m) + "/" + String.valueOf(y);
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = (Date) formatter.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spinnerDay1.setModel(new javax.swing.SpinnerDateModel(date, null, null, Calendar.YEAR));
        dateEditor1 = new JSpinner.DateEditor(spinnerDay1, "dd/MM/yyyy");

        spinnerDay1.setEditor(dateEditor1);

        spinnerDay2.addChangeListener(this);
        Date date2 = new Date();
        spinnerDay2.setModel(new javax.swing.SpinnerDateModel(date2, null, null, Calendar.YEAR));
        dateEditor2 = new JSpinner.DateEditor(spinnerDay2, "dd/MM/yyyy");
        spinnerDay2.setEditor(dateEditor2);

        javax.swing.GroupLayout panelDayLayout = new javax.swing.GroupLayout(panelDay);
        panelDay.setLayout(panelDayLayout);
        panelDayLayout.setHorizontalGroup(
            panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDayLayout.createSequentialGroup()
                        .addGroup(panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerDay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerDay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonXem))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelDayLayout.setVerticalGroup(
            panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinnerDay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinnerDay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonXem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonXem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel panelDay;
    private javax.swing.JSpinner spinnerDay1;
    private javax.swing.JSpinner spinnerDay2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spinner = (JSpinner) e.getSource();
        if (spinner == spinnerDay1) {
            month1 = Integer.parseInt(dateEditor1.getFormat().format(spinnerDay1.getValue()).toString().substring(3, 5));
            //JOptionPane.showMessageDialog(null, month1);
            year1 = Integer.parseInt(dateEditor1.getFormat().format(spinnerDay1.getValue()).toString().substring(6, 10));
        }
        if (spinner == spinnerDay2) {
            month2 = Integer.parseInt(dateEditor2.getFormat().format(spinnerDay2.getValue()).toString().substring(3, 5));

            year2 = Integer.parseInt(dateEditor2.getFormat().format(spinnerDay2.getValue()).toString().substring(6, 10));
        }
    }

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result r = (Lookup.Result) le.getSource();
        Collection<Department> c1 = r.allInstances();
        if (!c1.isEmpty()) {
            for (Department e : c1) {
                department = e;
                //JOptionPane.showMessageDialog(null, e.getDepartmentName());
            }
        }
    }
}
