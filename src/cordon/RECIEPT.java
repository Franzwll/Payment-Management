/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package recipt;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RECIEPT extends javax.swing.JFrame {

    /**
     * Creates new form RECIEPT
     */
    public RECIEPT() {
        initComponents();
        Connect();
    }
   
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
      private void Connect (){
          
          
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spay","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RECIEPT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RECIEPT.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtf_student_id = new javax.swing.JTextField();
        jbtn_search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtxtf_tuition = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtf_miscellaneous = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtarea_soa = new javax.swing.JTextArea();
        jbtn_generate = new javax.swing.JButton();
        jbtn_soa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtxtf_student_name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("STATEMENT OF ACCOUNT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("STUDENT ID : ");

        jbtn_search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtn_search.setText("SEARCH");
        jbtn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_searchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("TUITION : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("MISCELLANEOUS : ");

        jtxtarea_soa.setColumns(20);
        jtxtarea_soa.setRows(5);
        jScrollPane1.setViewportView(jtxtarea_soa);

        jbtn_generate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtn_generate.setText("GENERATE ");
        jbtn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_generateActionPerformed(evt);
            }
        });

        jbtn_soa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtn_soa.setText("SOA");
        jbtn_soa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_soaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("STUDENT FULL NAME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(56, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                                .addComponent(jtxtf_miscellaneous, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jbtn_soa))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtxtf_tuition, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                    .addComponent(jtxtf_student_id)
                                    .addComponent(jtxtf_student_name))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jbtn_search))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbtn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtf_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtxtf_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtxtf_tuition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtn_generate)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtf_miscellaneous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_soa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_searchActionPerformed
       
        try {
            String id = jtxtf_student_id.getText();
            
            // First get student name
            ps = con.prepareStatement("SELECT * FROM students WHERE Sid = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            if(rs.next() == true) {
                String studentName = rs.getString("Sname");
                jtxtf_student_name.setText(studentName);
                
                // Get tuition fee amount
                ps = con.prepareStatement("SELECT Tamount FROM type WHERE Tname = 'Tuition Fee' LIMIT 1");
                rs = ps.executeQuery();
                if(rs.next()) {
                    jtxtf_tuition.setText(rs.getString("Tamount"));
                }
                
                // Get miscellaneous fee amount
                ps = con.prepareStatement("SELECT Tamount FROM type WHERE Tname = 'Miscellaneous' LIMIT 1");
                rs = ps.executeQuery();
                if(rs.next()) {
                    jtxtf_miscellaneous.setText(rs.getString("Tamount"));
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "No record found!");
                jtxtf_student_name.setText("");
                jtxtf_tuition.setText("");
                jtxtf_miscellaneous.setText("");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RECIEPT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtn_searchActionPerformed

    private void jbtn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_generateActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String formattedDate = formatter.format(date);
        
        // Calculate total amount
        double tuition = Double.parseDouble(jtxtf_tuition.getText().trim());
        double misc = Double.parseDouble(jtxtf_miscellaneous.getText().trim());
        double total = tuition + misc;
        
        jtxtarea_soa.setText("");  // Clear previous content
        jtxtarea_soa.append("\n");
        jtxtarea_soa.append("\t╔══════════════════════════════════════════════════╗\n");
        jtxtarea_soa.append("\t║                STATEMENT OF ACCOUNT              ║\n");
        jtxtarea_soa.append("\t╚══════════════════════════════════════════════════╝\n\n");
        jtxtarea_soa.append("\tDate Issued: " + formattedDate + "\n");
        jtxtarea_soa.append("\tStudent ID : " + jtxtf_student_id.getText() + "\n");
        jtxtarea_soa.append("\t──────────────────────────────────────────────────\n");
        jtxtarea_soa.append("\tStudent Name: " + jtxtf_student_name.getText() + "\n");
        jtxtarea_soa.append("\t──────────────────────────────────────────────────\n\n");
        jtxtarea_soa.append("\tFEE BREAKDOWN:\n");
        jtxtarea_soa.append("\t──────────────────────────────────────────────────\n");
        jtxtarea_soa.append(String.format("\tTuition Fee     : PHP %,.2f\n", tuition));
        jtxtarea_soa.append(String.format("\tMiscellaneous   : PHP %,.2f\n", misc));
        jtxtarea_soa.append("\t──────────────────────────────────────────────────\n");
        jtxtarea_soa.append(String.format("\tTOTAL AMOUNT    : PHP %,.2f\n", total));
        jtxtarea_soa.append("\t──────────────────────────────────────────────────\n\n");
        jtxtarea_soa.append("\tNote: This is an official statement of account.\n");
        jtxtarea_soa.append("\tPlease keep this document for your records.\n\n");
        jtxtarea_soa.append("\t──────────────────────────────────────────────────\n");
        jtxtarea_soa.append("\tPrepared by: ____________________\n");
        jtxtarea_soa.append("\tDate: ____________________\n");
        
    }//GEN-LAST:event_jbtn_generateActionPerformed

    private void jbtn_soaActionPerformed(java.awt.event.ActionEvent evt) {
        generateAndPrintReceiptPDF();
    }

    // Add this method to generate and print the receipt as PDF
    private void generateAndPrintReceiptPDF() {
        try {
            com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
            String fileName = "receipt_" + System.currentTimeMillis() + ".pdf";
            File pdfFile = new File(System.getProperty("java.io.tmpdir"), fileName);
            PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            document.open();

            // Header: School info
            com.itextpdf.text.Font schoolFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            com.itextpdf.text.Font subFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            com.itextpdf.text.Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            com.itextpdf.text.Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 10);

            Paragraph school = new Paragraph("Aurora Heights Academy", schoolFont);
            school.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(school);

            Paragraph address = new Paragraph("456 Starlight Avenue, Barangay Luna, Neo City, Metro Manila, Philippines", subFont);
            address.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(address);

            Paragraph receiptTitle = new Paragraph("STATEMENT OF ACCOUNT", boldFont);
            receiptTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            receiptTitle.setSpacingAfter(10);
            document.add(receiptTitle);

            // Receipt number
            String receiptNo = String.valueOf(System.currentTimeMillis()).substring(6);
            Paragraph receiptNoPara = new Paragraph("No. " + receiptNo, boldFont);
            receiptNoPara.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
            document.add(receiptNoPara);

            // Student info
            Paragraph studentInfo = new Paragraph(
                "STUDENT ID: " + jtxtf_student_id.getText() + "\n" +
                "NAME: " + jtxtf_student_name.getText(),
                normalFont
            );
            studentInfo.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            studentInfo.setSpacingAfter(5);
            document.add(studentInfo);

            // Amount in words and figures
            double tuition = Double.parseDouble(jtxtf_tuition.getText().trim());
            double misc = Double.parseDouble(jtxtf_miscellaneous.getText().trim());
            double total = tuition + misc;
            String amountInWords = convertNumberToWords((long) total).toUpperCase() + " PESOS ONLY";

            Paragraph amtPaid = new Paragraph("AMOUNT PAID: " + amountInWords, normalFont);
            amtPaid.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            document.add(amtPaid);

            Paragraph amtFig = new Paragraph("AMOUNT IN FIGURE: ₱" + String.format("%,.2f", total), normalFont);
            amtFig.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            document.add(amtFig);

            Paragraph datePara = new Paragraph("DATE: " + new SimpleDateFormat("MM/dd/yyyy").format(new Date()), normalFont);
            datePara.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            datePara.setSpacingAfter(10);
            document.add(datePara);

            // Table for fees
            PdfPTable feeTable = new PdfPTable(3);
            feeTable.setWidthPercentage(100);
            feeTable.setSpacingBefore(10);
            feeTable.setWidths(new int[]{50, 25, 25});

            // Add headers
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("PARTICULARS", boldFont));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            feeTable.addCell(cell);

            cell = new PdfPCell(new Phrase("SOURCE/TYPE", boldFont));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            feeTable.addCell(cell);

            cell = new PdfPCell(new Phrase("AMOUNT", boldFont));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            feeTable.addCell(cell);

            // Add fee rows
            feeTable.addCell("TUITION FEE");
            feeTable.addCell("CASH");
            feeTable.addCell(String.format("₱%,.2f", tuition));

            feeTable.addCell("MISCELLANEOUS FEE");
            feeTable.addCell("CASH");
            feeTable.addCell(String.format("₱%,.2f", misc));

            document.add(feeTable);

            // Summary table
            PdfPTable summaryTable = new PdfPTable(2);
            summaryTable.setWidthPercentage(100);
            summaryTable.setSpacingBefore(10);
            summaryTable.setWidths(new int[]{70, 30});

            summaryTable.addCell(new Phrase("Total", boldFont));
            summaryTable.addCell(new Phrase(String.format("₱%,.2f", total), normalFont));
            summaryTable.addCell(new Phrase("Less: Discount", boldFont));
            summaryTable.addCell(new Phrase("₱0.00", normalFont));
            summaryTable.addCell(new Phrase("TOTAL DUE", boldFont));
            summaryTable.addCell(new Phrase(String.format("₱%,.2f", total), normalFont));

            document.add(summaryTable);

            // Signature and validation
            Paragraph cashierAndNote = new Paragraph(
                "\n\n_____________________________\nCASHIER\nVALID ONLY IF COUNTER-SIGNED BY CASHIER",
                normalFont
            );
            cashierAndNote.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cashierAndNote.setSpacingBefore(20);
            document.add(cashierAndNote);

            document.close();

            // Modified PDF handling code
            if (Desktop.isDesktopSupported()) {
                try {
                    // First try to open the PDF file
                    Desktop.getDesktop().open(pdfFile);
                    
                    // Show the file location
                    JOptionPane.showMessageDialog(this, 
                        "PDF has been generated and opened.\nLocation: " + pdfFile.getAbsolutePath() +
                        "\n\nPlease use your PDF viewer's print function to print the document.",
                        "PDF Generated",
                        JOptionPane.INFORMATION_MESSAGE);
                        
                } catch (Exception e) {
                    // If opening fails, show the file location
                    JOptionPane.showMessageDialog(this,
                        "PDF has been generated but couldn't be opened automatically.\n" +
                        "Please find the PDF at: " + pdfFile.getAbsolutePath(),
                        "PDF Location",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "PDF has been generated at:\n" + pdfFile.getAbsolutePath(),
                    "PDF Location",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error generating PDF: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper method to convert numbers to words
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private String convertNumberToWords(long n) {
        if (n < 20) return units[(int)n];
        if (n < 100) return tens[(int)n/10] + ((n%10!=0)? "-" + units[(int)n%10] : "");
        if (n < 1000) return units[(int)n/100] + " Hundred" + ((n%100!=0)? " " + convertNumberToWords(n%100) : "");
        if (n < 1000000) return convertNumberToWords(n/1000) + " Thousand" + ((n%1000!=0)? " " + convertNumberToWords(n%1000) : "");
        if (n < 1000000000) return convertNumberToWords(n/1000000) + " Million" + ((n%1000000!=0)? " " + convertNumberToWords(n%1000000) : "");
        return String.valueOf(n);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RECIEPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RECIEPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RECIEPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RECIEPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RECIEPT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_generate;
    private javax.swing.JButton jbtn_search;
    private javax.swing.JButton jbtn_soa;
    private javax.swing.JTextArea jtxtarea_soa;
    private javax.swing.JTextField jtxtf_miscellaneous;
    private javax.swing.JTextField jtxtf_student_id;
    private javax.swing.JTextField jtxtf_student_name;
    private javax.swing.JTextField jtxtf_tuition;
    // End of variables declaration//GEN-END:variables
}
