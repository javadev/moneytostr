/*
 * $Id$
 *
 * Copyright 2012 Valentyn Kolesnikov
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String result;
            if (value.endsWith("%")) {
                summ = Double.valueOf(value.replace("%", ""));
                result = moneyToStrTxt.percentToStr(summ, moneyToStrTxt.getLanguage());
                jTextArea5.setText("");
                jTextArea6.setText("");
                jTextArea4.setText("");
            } else {
                summ = Double.valueOf(value);
                result = moneyToStrTxt.convert(summ);
                double[] pdvValue = new double[] { 10, 18, 20, 22 };
                Double nds = Math.round((summ - (summ / (1 + pdvValue[jComboBox5.getSelectedIndex()] / 100))) * 100) / 100D;
                java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(java.util.Locale.FRANCE);
                java.text.DecimalFormat df = (java.text.DecimalFormat) nf;
                df.applyPattern(",##0.00");
                String ndsFormatted = nf.format(nds);
                jTextArea5.setText(result + ", " + moneyToStrTxt.getMessages().get("pdv")[0] + ndsFormatted + " " + moneyToStrTxt.getRubShortUnit());
                jTextArea6.setText(result + ", " + moneyToStrTxt.getMessages().get("pdv")[0] + moneyToStrTxt.convert(nds));
                jTextArea4.setText(moneyToStrNum.convert(summ));
            }
        jTextArea1.setText(result);
        jTextArea7.setText(result.substring(0, 1).toUpperCase() + result.substring(1));
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

    public static class HistoryComboBox extends javax.swing.JComboBox<String> {
        public HistoryComboBox() {
            setEditable(true);
            addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent actionevent) {
                    Object obj = getSelectedItem();
                    if (obj != null && actionevent.getActionCommand().equals("comboBoxEdited")) {
                        addToList(obj.toString());
                    }
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
            index5 = "1";
        }
        jComboBox1.setSelectedIndex(Integer.valueOf(index1));
        jComboBox2.setSelectedIndex(Integer.valueOf(index2));
        jComboBox3.setSelectedIndex(Integer.valueOf(index3));
        jComboBox4.setSelectedIndex(Integer.valueOf(index4));
        jComboBox5.setSelectedIndex(Integer.valueOf(index5));
        setupMoneyToStrVariables();
        generateResult();
        setLocation(Integer.valueOf(x), Integer.valueOf(y));
        setSize(new java.awt.Dimension(Integer.valueOf(width), Integer.valueOf(height)));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MoneyToStr");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setMaximumSize(new java.awt.Dimension(610, 444));
        jPanel2.setPreferredSize(new java.awt.Dimension(662, 447));

        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane7.setViewportView(jTextArea7);

        jTabbedPane3.addTab("С заглавной буквы:", jScrollPane7);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jTabbedPane1.addTab("Результат:", jScrollPane3);

        jLabel2.setText("Введите сумму цифрами:");

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jTabbedPane2.addTab("Копейки цифрами:", jScrollPane4);

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jTabbedPane4.addTab("С НДС:", jScrollPane5);

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);

        jTabbedPane5.addTab("С НДС прописью:", jScrollPane6);

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
        jButton4.setToolTipText("Скопировать в буфер");
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
        jButton5.setToolTipText("Скопировать в буфер");
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
        jButton6.setToolTipText("Скопировать в буфер");
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
        jButton8.setToolTipText("Скопировать в буфер");
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
        jButton9.setToolTipText("Скопировать в буфер");
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
                        .add(jTextField1, 0, 382, Short.MAX_VALUE))
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

        jTabbedPane6.addTab("Конвертор", jPanel2);

        jLabel1.setText("Язык");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Русский", "Украинский", "Английсикй" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Валюта");

        jLabel4.setText("Копейки");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RUR", "UAH", "USD" }));
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

        jLabel5.setText("Копировать в буфер");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "не копировать", "Результат", "С заглавной буквы", "С НДС", "С НДС прописью", "Копейки цифрами" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel6.setText("НДС");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10%", "18%", "20%", "22%" }));
        jComboBox5.setSelectedIndex(1);
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel6))
                .add(29, 29, 29)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jComboBox5, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jComboBox2, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jComboBox3, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jComboBox4, 0, 404, Short.MAX_VALUE)
                    .add(jComboBox1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
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
                .addContainerGap(478, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Настройки", jPanel1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
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

    private void setupMoneyToStrVariables() {
        moneyToStrTxt = new MoneyToStr(MoneyToStr.Currency.values()[jComboBox2.getSelectedIndex()],
                MoneyToStr.Language.values()[jComboBox1.getSelectedIndex()],
                MoneyToStr.Pennies.values()[jComboBox3.getSelectedIndex()]);
        moneyToStrNum = new MoneyToStr(MoneyToStr.Currency.values()[jComboBox2.getSelectedIndex()],
                MoneyToStr.Language.values()[jComboBox1.getSelectedIndex()],
                MoneyToStr.Pennies.NUMBER);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JComboBox jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
