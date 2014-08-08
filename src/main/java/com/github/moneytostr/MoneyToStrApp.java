/*
 * $Id$
 *
 * Copyright 2014 Valentyn Kolesnikov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.moneytostr;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * MoneyToStrApp.
 *
 * @author javadev
 * @version $Revision$ $Date$
 */
public class MoneyToStrApp extends javax.swing.JFrame {

    private void generateResult() {
        try {
            String value = jTextField1.getEditor().getItem().toString().replace(",", ".").trim();
            Double summ;
            String result = "";
            if (value.endsWith("%")) {
                summ = Double.valueOf(value.replace("%", ""));
                result = MoneyToStr.percentToStr(summ, moneyToStrTxt.getLanguage());
                jTextArea5.setText("");
                jTextArea6.setText("");
                jTextArea4.setText(MoneyToStr.percentToStr(summ, moneyToStrTxt.getLanguage(), MoneyToStr.Pennies.NUMBER));
            } else {
                if (!value.isEmpty()) {
                    summ = Double.valueOf(value);
                    result = moneyToStrTxt.convert(summ);
                    double[] pdvValue = new double[] { 10, 12, 18, 20, 22, 25 };
                    Double nds = Math.round((summ - (summ / (1 + pdvValue[jComboBox5.getSelectedIndex()] / 100))) * 100) / 100D;
                    java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(java.util.Locale.FRANCE);
                    java.text.DecimalFormat df = (java.text.DecimalFormat) nf;
                    df.applyPattern(",##0.00");
                    String ndsFormatted = nf.format(nds);
                    jTextArea5.setText(result + ", " + moneyToStrTxt.getMessages().get("pdv")[0] + ndsFormatted + " " + moneyToStrTxt.getRubShortUnit());
                    jTextArea6.setText(result + ", " + moneyToStrTxt.getMessages().get("pdv")[0] + moneyToStrTxt.convert(nds));
                    jTextArea4.setText(moneyToStrNum.convert(summ));
                }
            }
        jTextArea1.setText(result);
        if (!result.isEmpty()) {
            jTextArea7.setText(result.substring(0, 1).toUpperCase() + result.substring(1));
        }
        String bufferData = null;
        switch (jComboBox4.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                bufferData = jTextArea1.getText();
                break;
            case 2:
                bufferData = jTextArea7.getText();
                break;
            case 3:
                bufferData = jTextArea5.getText();
                break;
            case 4:
                bufferData = jTextArea6.getText();
                break;
            case 5:
                bufferData = jTextArea4.getText();
                break;
        }
        if (bufferData != null) {
            StringSelection ss = new StringSelection(bufferData);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        }
        } catch (Exception ex) {
            Logger.getLogger(MoneyToStrApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class HistoryComboBox extends javax.swing.JComboBox {
        public HistoryComboBox() {
            setEditable(true);
            addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent actionevent) {
                    Object obj = getSelectedItem();
                    if (obj != null && actionevent.getActionCommand().equals("comboBoxEdited")) {
                        addToList(obj.toString());
                    }
                    MoneyToStrApp.this.generateResult();
                }
            });
        }

        public void addToList(String s) {
            int j = getMaxUrlsLength();
            if (!isValid(s)) {
                removeItem(s);
                return;
            }
            int index;
            for (index = 0; index < getItemCount(); index += 1) {
                if (s.equals(getItemAt(index))) {
                    if (index > 0) {
                        javax.swing.DefaultComboBoxModel dcbm = (javax.swing.DefaultComboBoxModel) getModel();
                        dcbm.insertElementAt(dcbm.getElementAt(index), 0);
                        dcbm.removeElementAt(index + 1);
                        dcbm.setSelectedItem(dcbm.getElementAt(0));
                      }
                      return;
                }
            }
            if (index > j) {
               removeItemAt(index - 1);
            }
            insertItemAt(s, 0);
            getEditor().setItem(s);
            setSelectedItem(s);
        }

        private int getMaxUrlsLength() {
            return 16;
        }

        private boolean isValid(String str) {
            return !str.equals("");
        }
    }

    private MoneyToStr moneyToStrTxt = new MoneyToStr(MoneyToStr.Currency.RUR, MoneyToStr.Language.RUS, MoneyToStr.Pennies.TEXT);
    private MoneyToStr moneyToStrNum = new MoneyToStr(MoneyToStr.Currency.RUR, MoneyToStr.Language.RUS, MoneyToStr.Pennies.NUMBER);
    /** Creates new form */
    public MoneyToStrApp() {
        initComponents();
        XMLDecoder d;
        String x = null;
        String y = null;
        String height = null;
        String width = null;
        String index1 = null;
        String index2 = null;
        String index3 = null;
        String index4 = null;
        String index5 = null;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String index6 = null;
        try {
           d = new XMLDecoder(new BufferedInputStream(new FileInputStream("MoneyToStr.xml")));
           jTextField1.getEditor().setItem((String) d.readObject());
           jTextArea1.setText((String) d.readObject());
           jTextArea7.setText((String) d.readObject());
           jTextArea5.setText((String) d.readObject());
           jTextArea6.setText((String) d.readObject());
           jTextArea4.setText((String) d.readObject());
           x = (String) d.readObject();
           y = (String) d.readObject();
           height = (String) d.readObject();
           width = (String) d.readObject();
           index1 = (String) d.readObject();
           index2 = (String) d.readObject();
           index3 = (String) d.readObject();
           index4 = (String) d.readObject();
           index5 = (String) d.readObject();
           model = (DefaultComboBoxModel) d.readObject();
           index6 = (String) d.readObject();
           d.close();
        } catch (Exception ex) {
            ex.getMessage();
        }

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent winEvt) {
                XMLEncoder e;
                try {
                    e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("MoneyToStr.xml")));
                    e.writeObject(jTextField1.getEditor().getItem());
                    e.writeObject(jTextArea1.getText());
                    e.writeObject(jTextArea7.getText());
                    e.writeObject(jTextArea5.getText());
                    e.writeObject(jTextArea6.getText());
                    e.writeObject(jTextArea4.getText());
                    e.writeObject("" + getLocation().x);
                    e.writeObject("" + getLocation().y);
                    e.writeObject("" + getSize().height);
                    e.writeObject("" + getSize().width);
                    e.writeObject("" + jComboBox1.getSelectedIndex());
                    e.writeObject("" + jComboBox2.getSelectedIndex());
                    e.writeObject("" + jComboBox3.getSelectedIndex());
                    e.writeObject("" + jComboBox4.getSelectedIndex());
                    e.writeObject("" + jComboBox5.getSelectedIndex());
                    e.writeObject(jTextField1.getModel());
                    e.writeObject("" + jComboBox6.getSelectedIndex());
                    e.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MoneyToStrApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        });
        final java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        if (x == null) {
            x = "" + ((screenSize.width - getWidth()) / 2);
        }
        if (y == null) {
            y = "" + ((screenSize.height - getHeight()) / 2);
        }
        if (height == null) {
            height = "" + getPreferredSize().height;
        }
        if (width == null) {
            width = "" + getPreferredSize().width;
        }
        if (index1 == null) {
            index1 = "0";
        }
        if (index2 == null) {
            index2 = "0";
        }
        if (index3 == null) {
            index3 = "0";
        }
        if (index4 == null) {
            index4 = "0";
        }
        if (index5 == null) {
            index5 = "2";
        }
        if (index6 == null) {
            index6 = "0";
        }
        jComboBox1.setSelectedIndex(Integer.valueOf(index1));
        jComboBox2.setSelectedIndex(Integer.valueOf(index2));
        jComboBox3.setSelectedIndex(Integer.valueOf(index3));
        jComboBox4.setSelectedIndex(Integer.valueOf(index4));
        jComboBox5.setSelectedIndex(Integer.valueOf(index5));
        jTextField1.setModel(model);
        setupLanguage(Integer.valueOf(index6));
        jComboBox6.setSelectedIndex(Integer.valueOf(index6));
        setupMoneyToStrVariables();
        generateResult();
        setLocation(Integer.valueOf(x), Integer.valueOf(y));
        setSize(new java.awt.Dimension(Integer.valueOf(width), Integer.valueOf(height)));
        convertStreamToString(jTextPane1, "MoneyToStr.cs");
        convertStreamToString(jTextPane2, "moneytostr.dart");
        convertStreamToString(jTextPane10, "moneytostr.groovy");
        convertStreamToString(jTextPane3, "MoneyToStr.java");
        convertStreamToString(jTextPane4, "moneytostr.js");
        convertStreamToString(jTextPane5, "MoneyToStr.php");
        convertStreamToString(jTextPane6, "MoneyToStr.py");
        convertStreamToString(jTextPane7, "MoneyToStr.rb");
        convertStreamToString(jTextPane8, "MoneyToStr.scala");
        convertStreamToString(jTextPane9, "moneytostr.ts");
    }
    
    private void convertStreamToString(JTextPane jTextPane, String fileName) {
        InputStreamReader is;
        try {
            InputStream ins = MoneyToStrApp.class.getResourceAsStream(fileName);
            if (ins != null) {
                is = new InputStreamReader(ins, "utf8");
                java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
                jTextPane.setText(s.hasNext() ? s.next() : "");
                jTextPane.setCaretPosition(0);
                is.close();
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MoneyToStrApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MoneyToStrApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new HistoryComboBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/github/moneytostr/messages_ru"); // NOI18N
        setTitle(bundle.getString("MONEYTOSTR")); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setMaximumSize(new java.awt.Dimension(610, 444));
        jPanel2.setPreferredSize(new java.awt.Dimension(662, 447));

        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane7.setViewportView(jTextArea7);

        jTabbedPane3.addTab(bundle.getString("fromCapitalLetter"), jScrollPane7); // NOI18N

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jTabbedPane1.addTab(bundle.getString("result"), jScrollPane3); // NOI18N

        jLabel2.setText(bundle.getString("enterTheDigitalAmount")); // NOI18N

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jTabbedPane2.addTab(bundle.getString("penniesByDigits"), jScrollPane4); // NOI18N

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jTabbedPane4.addTab(bundle.getString("withVat"), jScrollPane5); // NOI18N

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);

        jTabbedPane5.addTab(bundle.getString("withVatByString"), jScrollPane6); // NOI18N

        jButton2.setText("*");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(true);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/moneytostr/copy.png"))); // NOI18N
        jButton4.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setFocusable(false);
        jButton4.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/moneytostr/copy.png"))); // NOI18N
        jButton5.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setFocusable(false);
        jButton5.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton5.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton5.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/moneytostr/copy.png"))); // NOI18N
        jButton6.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setFocusable(false);
        jButton6.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton6.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton6.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/moneytostr/copy.png"))); // NOI18N
        jButton8.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setFocusable(false);
        jButton8.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton8.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton8.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/moneytostr/copy.png"))); // NOI18N
        jButton9.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setFocusable(false);
        jButton9.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton9.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton9.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jTabbedPane2)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTabbedPane5)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTabbedPane4)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTabbedPane3)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField1, 0, 414, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTabbedPane1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jButton9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jButton2)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(52, 52, 52)))
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(53, 53, 53)))
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jButton8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(57, 57, 57)))
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jButton9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(58, 58, 58)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab(bundle.getString("converter"), jPanel2); // NOI18N

        jLabel1.setText(bundle.getString("language")); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Русский", "Украинский", "Английсикй" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText(bundle.getString("currency")); // NOI18N

        jLabel4.setText(bundle.getString("pennies")); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RUR", "UAH", "USD", "Custom" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Цифрами", "Прописью" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel5.setText(bundle.getString("toCopyToTheBuffer")); // NOI18N

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "не копировать", "Результат", "С заглавной буквы", "С НДС", "С НДС прописью", "Копейки цифрами" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel6.setText(bundle.getString("vat")); // NOI18N

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10%", "12%", "18%", "20%", "22%", "25%" }));
        jComboBox5.setSelectedIndex(2);
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel7.setText(bundle.getString("interfaceLanguage")); // NOI18N

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Русский", "Украинский" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel12.setText("Дробная часть, два");

        jTextField5.setText("евроцент");

        jLabel10.setText("Целая часть, пять");

        jLabel9.setText("Целая часть, два");

        jTextField3.setText("евро");

        jTextField2.setText("евро");

        jLabel11.setText("Дробная часть, один");

        jLabel8.setText("Целая часть, один");

        jTextField4.setText("евро");

        jLabel13.setText("Дробная часть, пять");

        jTextField7.setText("евроцентов");

        jTextField6.setText("евроцента");

        jLabel14.setText("Целая часть, пол");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        jLabel15.setText("Дробная часть, пол");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel4)
                            .add(jLabel5)
                            .add(jLabel6)
                            .add(jLabel7))
                        .add(29, 29, 29)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jComboBox5, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jComboBox2, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jComboBox3, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jComboBox4, 0, 436, Short.MAX_VALUE)
                            .add(jComboBox1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jComboBox6, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel9)
                            .add(jLabel8)
                            .add(jLabel10)
                            .add(jLabel11)
                            .add(jLabel12)
                            .add(jLabel13)
                            .add(jLabel14)
                            .add(jLabel15))
                        .add(25, 25, 25)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextField7)
                            .add(jTextField6)
                            .add(jTextField5)
                            .add(jTextField4)
                            .add(jTextField2)
                            .add(jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jComboBox8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jComboBox7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBox7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(jTextField6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(jTextField7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel15)
                    .add(jComboBox8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jComboBox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jComboBox4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jComboBox5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jComboBox6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab(bundle.getString("settings"), jPanel1); // NOI18N

        jTabbedPane7.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jScrollPane1.setBorder(null);

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jTabbedPane7.addTab("c#", jScrollPane1);

        jScrollPane2.setBorder(null);

        jTextPane2.setEditable(false);
        jTextPane2.setBorder(null);
        jTextPane2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jTextPane2);

        jTabbedPane7.addTab("dart", jScrollPane2);

        jScrollPane15.setBorder(null);

        jTextPane10.setEditable(false);
        jTextPane10.setBorder(null);
        jTextPane10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane15.setViewportView(jTextPane10);

        jTabbedPane7.addTab("groovy", jScrollPane15);

        jScrollPane8.setBorder(null);

        jTextPane3.setEditable(false);
        jTextPane3.setBorder(null);
        jTextPane3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane8.setViewportView(jTextPane3);

        jTabbedPane7.addTab("java", jScrollPane8);

        jScrollPane9.setBorder(null);

        jTextPane4.setEditable(false);
        jTextPane4.setBorder(null);
        jTextPane4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane9.setViewportView(jTextPane4);

        jTabbedPane7.addTab("js", jScrollPane9);

        jScrollPane10.setBorder(null);

        jTextPane5.setEditable(false);
        jTextPane5.setBorder(null);
        jTextPane5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane10.setViewportView(jTextPane5);

        jTabbedPane7.addTab("php", jScrollPane10);

        jScrollPane11.setBorder(null);

        jTextPane6.setEditable(false);
        jTextPane6.setBorder(null);
        jTextPane6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane11.setViewportView(jTextPane6);

        jTabbedPane7.addTab("python", jScrollPane11);

        jScrollPane12.setBorder(null);

        jTextPane7.setEditable(false);
        jTextPane7.setBorder(null);
        jTextPane7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane12.setViewportView(jTextPane7);

        jTabbedPane7.addTab("ruby", jScrollPane12);

        jScrollPane13.setBorder(null);

        jTextPane8.setEditable(false);
        jTextPane8.setBorder(null);
        jTextPane8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane13.setViewportView(jTextPane8);

        jTabbedPane7.addTab("scala", jScrollPane13);

        jScrollPane14.setBorder(null);

        jTextPane9.setEditable(false);
        jTextPane9.setBorder(null);
        jTextPane9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane14.setViewportView(jTextPane9);

        jTabbedPane7.addTab("typescript", jScrollPane14);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );

        jTabbedPane6.addTab(bundle.getString("sourceCodes"), jPanel3); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 673, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    jTabbedPane6.setSelectedIndex(1);
}//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        Object obj = jTextField1.getSelectedItem();
        if (obj != null && evt.getActionCommand().equals("comboBoxEdited")) {
            generateResult();
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        setupMoneyToStrVariables();
        generateResult();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        setupMoneyToStrVariables();
        generateResult();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        setupMoneyToStrVariables();
        generateResult();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        StringSelection ss = new StringSelection(jTextArea1.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        StringSelection ss = new StringSelection(jTextArea5.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        StringSelection ss = new StringSelection(jTextArea7.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        StringSelection ss = new StringSelection(jTextArea6.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        StringSelection ss = new StringSelection(jTextArea4.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        setupMoneyToStrVariables();
        generateResult();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        setupMoneyToStrVariables();
        generateResult();
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        int selected = ((javax.swing.JComboBox) evt.getSource()).getSelectedIndex();
        setupLanguage(selected);
    }

    private void setupLanguage(int selected) {
        if (selected == 1) {
            java.util.Locale.setDefault(new java.util.Locale("ua"));
        } else {
            java.util.Locale.setDefault(new java.util.Locale("ru"));
        }
        int selectedIndex = jTabbedPane6.getSelectedIndex();
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/github/moneytostr/messages"); // NOI18N
        setTitle(bundle.getString("MONEYTOSTR")); // NOI18N
        jTabbedPane3.addTab(bundle.getString("fromCapitalLetter"), jScrollPane7); // NOI18N
        jTabbedPane1.addTab(bundle.getString("result"), jScrollPane3); // NOI18N
        jLabel2.setText(bundle.getString("enterTheDigitalAmount")); // NOI18N
        jTabbedPane2.addTab(bundle.getString("penniesByDigits"), jScrollPane4); // NOI18N
        jTabbedPane4.addTab(bundle.getString("withVat"), jScrollPane5); // NOI18N
        jTabbedPane5.addTab(bundle.getString("withVatByString"), jScrollPane6); // NOI18N
        jButton4.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton5.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton6.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton8.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jButton9.setToolTipText(bundle.getString("copyToTheBuffer")); // NOI18N
        jTabbedPane6.addTab(bundle.getString("converter"), jPanel2); // NOI18N
        jLabel1.setText(bundle.getString("language")); // NOI18N
        jLabel3.setText(bundle.getString("currency")); // NOI18N
        jLabel4.setText(bundle.getString("pennies")); // NOI18N
        jLabel5.setText(bundle.getString("toCopyToTheBuffer")); // NOI18N
        jLabel6.setText(bundle.getString("vat")); // NOI18N
        jTabbedPane6.addTab(bundle.getString("settings"), jPanel1); // NOI18N
        jTabbedPane6.addTab(bundle.getString("sourceCodes"), jPanel3); // NOI18N
        jLabel7.setText(bundle.getString("interfaceLanguage")); // NOI18N
        jTabbedPane6.setSelectedIndex(selectedIndex);
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void setupMoneyToStrVariables() {
        moneyToStrTxt = new MoneyToStr(MoneyToStr.Currency.values()[jComboBox2.getSelectedIndex()],
                MoneyToStr.Language.values()[jComboBox1.getSelectedIndex()],
                MoneyToStr.Pennies.values()[jComboBox3.getSelectedIndex()]);
        moneyToStrNum = new MoneyToStr(MoneyToStr.Currency.values()[jComboBox2.getSelectedIndex()],
                MoneyToStr.Language.values()[jComboBox1.getSelectedIndex()],
                MoneyToStr.Pennies.NUMBER);
        if (jComboBox2.getSelectedIndex() == 3) {
            String[] names = new String[8];
            names[0] = jTextField2.getText();
            names[1] = jTextField3.getText();
            names[2] = jTextField4.getText();
            names[3] = jComboBox7.getModel().getSelectedItem().toString();
            names[4] = jTextField5.getText();
            names[5] = jTextField6.getText();
            names[6] = jTextField7.getText();
            names[7] = jComboBox8.getModel().getSelectedItem().toString();
            moneyToStrTxt = new MoneyToStr(MoneyToStr.Currency.values()[jComboBox2.getSelectedIndex()],
                MoneyToStr.Language.values()[jComboBox1.getSelectedIndex()],
                MoneyToStr.Pennies.values()[jComboBox3.getSelectedIndex()], names);
            moneyToStrNum = new MoneyToStr(MoneyToStr.Currency.values()[jComboBox2.getSelectedIndex()],
                MoneyToStr.Language.values()[jComboBox1.getSelectedIndex()],
                MoneyToStr.Pennies.NUMBER, names);
        }
        boolean isCustomCurrency = jComboBox2.getSelectedIndex() == 3;
        jTextField2.setEnabled(isCustomCurrency);
        jTextField3.setEnabled(isCustomCurrency);
        jTextField4.setEnabled(isCustomCurrency);
        jComboBox7.setEnabled(isCustomCurrency);
        jTextField5.setEnabled(isCustomCurrency);
        jTextField6.setEnabled(isCustomCurrency);
        jTextField7.setEnabled(isCustomCurrency);
        jComboBox8.setEnabled(isCustomCurrency);
    }

    private static void setLookAndFeel()
        throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        javax.swing.UIManager.LookAndFeelInfo infos[] = UIManager.getInstalledLookAndFeels();
        String firstFoundClass = null;
        for (javax.swing.UIManager.LookAndFeelInfo info : infos) {
            String foundClass = info.getClassName();
            if ("Nimbus".equals(info.getName())) {
                firstFoundClass = foundClass;
                break;
            }
            if (null == firstFoundClass) {
                firstFoundClass = foundClass;
            }
        }

        if(null == firstFoundClass)  {
            throw new IllegalArgumentException("No suitable Swing looks and feels");
        } else {
            UIManager.setLookAndFeel(firstFoundClass);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        setLookAndFeel();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoneyToStrApp().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JComboBox jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    // End of variables declaration//GEN-END:variables
    
}
