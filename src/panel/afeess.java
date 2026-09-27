package panel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class afeess extends javax.swing.JPanel {
    private Connection conn;

    public afeess() {
        initComponents();
        connectToDatabase();
    }
    
    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spay", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection error: " + e.getMessage());
        }
    }
    
    private void fetchAmount() {
        String feeType = (String) jComboBox8.getSelectedItem();
        String specificType = (String) jComboBox9.getSelectedItem();
        String year = (String) jComboBox7.getSelectedItem();
        String semester = (String) jComboBox5.getSelectedItem();
        
        if (feeType == null || feeType.equals("\t") || year == null || year.equals("\t") || semester == null || semester.equals("\t")) {
            jTextField2.setText("0.00");
            return;
        }
        
        try {
            String sql = "SELECT Tamount FROM type WHERE Tname = ? AND (Tothers = ? OR (? IS NULL AND Tothers IS NULL)) AND Syear = ? AND Ssemester = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, feeType);
            pstmt.setString(2, specificType);
            pstmt.setString(3, specificType);
            
            // Convert year selection to number
            int yearNum = 0;
            if (year.equals("All")) {
                yearNum = 0;
            } else {
                yearNum = Integer.parseInt(year.split(" ")[0].replaceAll("[^0-9]", ""));
            }
            pstmt.setInt(4, yearNum);
            
            // Convert semester selection to format in database
            String semesterDB = semester.equals("ALL") ? "ALL" : semester;
            pstmt.setString(5, semesterDB);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                jTextField2.setText(String.format("%.2f", rs.getDouble("Tamount")));
            } else {
                jTextField2.setText("0.00");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching amount: " + e.getMessage());
            jTextField2.setText("0.00");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(620, 480));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("COURSE :");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 86, -1));

        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 219, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("SPECIFIC TYPE");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 109, 20));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t", "Tuition Fee", "Miscellaneous", "Uniform", "Id", "School Reports", "Books", "Events" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });
        add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 218, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("VALUE :");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 89, -1));

        jButton9.setText("UPDATE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("YEAR :");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 87, 20));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 219, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t", "All", "1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 220, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ALL", "1ST", "2ND", "3RD" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 219, -1));
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("SEMESTER :");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("TYPE OF FEE :");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 107, 20));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t", "All", "BS in Business Administration (BSBA)", "BS in Accountancy (BSA)", "BS in Management Accounting", "BS in Entrepreneurship", "BS in Office Administration", "BS in Information Technology (BSIT)", "BS in Computer Science (BSCS)", "BS in Information Systems (BSIS)", "BS in Computer Engineering (BSCpE)", "BS in Nursing (BSN)", "BS in Pharmacy", "BS in Medical Technology (BSMT) / Medical Laboratory Science", "BS in Physical Therapy (BSPT)", "BS in Radiologic Technology", "Doctor of Medicine (MD) (post-grad)", "BS in Civil Engineering (BSCE)", "BS in Mechanical Engineering (BSME)", "BS in Electrical Engineering (BSEE)", "BS in Electronics Engineering (BSECE)", "BS in Industrial Engineering (BSIE)", "Bachelor of Elementary Education (BEEd)", "Bachelor of Secondary Education (BSEd)", "Bachelor of Early Childhood Education", "Bachelor of Physical Education", "BA in Political Science", "Bachelor of Laws / Juris Doctor (JD) (post-grad)", "BA in Psychology / BS in Psychology", "BA in Sociology / Anthropology", "BS in Criminology", "BA in Communication / Broadcasting", "BA in Journalism", "BA in Multimedia Arts", "BS in Architecture", "BA in Fine Arts", "BS in Biology", "BS in Chemistry", "BS in Environmental Science", "BS in Mathematics", "BS in Physics", "BS in Hospitality Management / Hotel & Restaurant Management", "BS in Tourism Management", "BS in Travel Management", "BS in Cruise Line Operations", "BS in Agriculture", "BS in Agricultural Engineering", "BS in Fisheries", "BS in Forestry", "BS in Public Administration", "BA in Development Studies", "BS in Community Development" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 221, -1));

        jLabel18.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 255));
        jLabel18.setText("Manage Fees");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 210, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Aurora Heights Academy ");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("456 Starlight Avenue, Barangay Luna, Neo City, Metro Manila, Philippines  ");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 96, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/purple-anime.gif"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 540, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        fetchAmount();
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        String selectedCountry = (String) jComboBox8.getSelectedItem();
        String select = (String) jComboBox7.getSelectedItem();

        // If Books is selected in jComboBox8, update jComboBox9 based on course
        if (selectedCountry != null && selectedCountry.equals("Books")) {
            String course = (String) jComboBox6.getSelectedItem();

            // Hide initially
            jComboBox9.hide();
            jLabel25.hide();
            jComboBox9.removeAllItems();

            if (course != null && !course.equals("All") && !course.equals("\t")) {
                if (course.contains("Business") || course.contains("Management") || course.contains("Accountancy") || course.contains("Entrepreneurship") || course.contains("Office Administration")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Principles of Marketing");
                    jComboBox9.addItem("Management: A Global Perspective");
                    jComboBox9.addItem("Financial Management");
                    jComboBox9.addItem("Human Resource Management");
                    jComboBox9.addItem("Strategic Management");
                    jComboBox9.addItem("Managerial Accounting");
                    jComboBox9.addItem("Business Ethics");
                    jComboBox9.addItem("Business Law and the Legal Environment");
                } else if (course.contains("Information Technology") || course.contains("Computer") || course.contains("Information Systems")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Introduction to Computing");
                    jComboBox9.addItem("Programming Logic and Design");
                    jComboBox9.addItem("Data Structures and Algorithms");
                    jComboBox9.addItem("Database System Concepts");
                    jComboBox9.addItem("Operating System Concepts");
                    jComboBox9.addItem("Computer Networking");
                    jComboBox9.addItem("Web Development");
                } else if (course.contains("Nursing") || course.contains("Pharmacy") || course.contains("Medical") || course.contains("Physical Therapy") || course.contains("Radiologic")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Fundamentals of Nursing");
                    jComboBox9.addItem("Medical-Surgical Nursing");
                    jComboBox9.addItem("Pharmacology");
                    jComboBox9.addItem("Anatomy and Physiology");
                    jComboBox9.addItem("Microbiology");
                    jComboBox9.addItem("Nursing Research");
                } else if (course.contains("Engineering")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Engineering Mechanics");
                    jComboBox9.addItem("Strength of Materials");
                    jComboBox9.addItem("Thermodynamics");
                    jComboBox9.addItem("Fluid Mechanics");
                    jComboBox9.addItem("Engineering Mathematics");
                    jComboBox9.addItem("Electrical Engineering Principles");
                    jComboBox9.addItem("Control Systems Engineering");
                } else if (course.contains("Education")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Foundations of Education");
                    jComboBox9.addItem("The Teaching Profession");
                    jComboBox9.addItem("Child and Adolescent Development");
                    jComboBox9.addItem("Facilitating Learner-Centered Teaching");
                    jComboBox9.addItem("Assessment of Student Learning");
                    jComboBox9.addItem("Curriculum Development");
                    jComboBox9.addItem("Technology for Teaching and Learning");
                } else if (course.contains("Political") || course.contains("Laws") || course.contains("Psychology") || course.contains("Sociology") || course.contains("Criminology")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Introduction to Political Science");
                    jComboBox9.addItem("The Philippine Constitution");
                    jComboBox9.addItem("Introduction to Psychology");
                    jComboBox9.addItem("Abnormal Psychology");
                    jComboBox9.addItem("Theories of Personality");
                    jComboBox9.addItem("Criminology");
                    jComboBox9.addItem("Philippine Criminal Law");
                } else if (course.contains("Communication") || course.contains("Journalism") || course.contains("Multimedia") || course.contains("Arts")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Introduction to Mass Communication");
                    jComboBox9.addItem("The Elements of Journalism");
                    jComboBox9.addItem("Broadcasting and Cable");
                    jComboBox9.addItem("Visual Communication");
                    jComboBox9.addItem("Art Appreciation");
                    jComboBox9.addItem("Multimedia Foundations");
                } else if (course.contains("Biology") || course.contains("Chemistry") || course.contains("Physics") || course.contains("Environmental") || course.contains("Mathematics")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("General Biology");
                    jComboBox9.addItem("General Chemistry");
                    jComboBox9.addItem("Physics for Scientists");
                    jComboBox9.addItem("College Algebra");
                    jComboBox9.addItem("Environmental Science");
                } else if (course.contains("Hospitality") || course.contains("Tourism") || course.contains("Travel") || course.contains("Cruise")) {
                    jLabel25.show();
                    jComboBox9.show();
                    jComboBox9.addItem("Introduction to Hospitality");
                    jComboBox9.addItem("Tourism Principles and Practices");
                    jComboBox9.addItem("Food and Beverage Service");
                    jComboBox9.addItem("Front Office Operations");
                    jComboBox9.addItem("Housekeeping Management");
                }
            }
        }

        jComboBox9.revalidate();
        jComboBox9.repaint();
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String feeType = (String) jComboBox8.getSelectedItem();
        String specificType = (String) jComboBox9.getSelectedItem();
        String year = (String) jComboBox7.getSelectedItem();
        String semester = (String) jComboBox5.getSelectedItem();
        String amount = jTextField2.getText();
        
        if (feeType == null || feeType.equals("\t") || year == null || year.equals("\t") || 
            semester == null || semester.equals("\t") || amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields");
            return;
        }
        
        try {
            // Convert semester selection to format in database
            String[] semesters;
            if (semester.equals("ALL")) {
                semesters = new String[]{"1ST", "2ND", "3RD"};
            } else {
                semesters = new String[]{semester};
            }
            
            // Convert year selection to numbers
            int[] years;
            if (year.equals("All")) {
                years = new int[]{1, 2, 3, 4, 5};
            } else {
                years = new int[]{Integer.parseInt(year.split(" ")[0].replaceAll("[^0-9]", ""))};
            }
            
            // Check if any records exist
            boolean anyExists = false;
            for (int yearNum : years) {
                for (String semesterDB : semesters) {
                    String checkSql = "SELECT COUNT(*) FROM type WHERE Tname = ? AND (Tothers = ? OR (? IS NULL AND Tothers IS NULL)) AND Syear = ? AND Ssemester = ?";
                    PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                    checkStmt.setString(1, feeType);
                    checkStmt.setString(2, specificType);
                    checkStmt.setString(3, specificType);
                    checkStmt.setInt(4, yearNum);
                    checkStmt.setString(5, semesterDB);
                    
                    ResultSet rs = checkStmt.executeQuery();
                    rs.next();
                    if (rs.getInt(1) > 0) {
                        anyExists = true;
                        break;
                    }
                }
                if (anyExists) break;
            }
            
            if (anyExists) {
                // Update existing records
                for (int yearNum : years) {
                    for (String semesterDB : semesters) {
                        String updateSql = "UPDATE type SET Tamount = ? WHERE Tname = ? AND (Tothers = ? OR (? IS NULL AND Tothers IS NULL)) AND Syear = ? AND Ssemester = ?";
                        PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                        updateStmt.setDouble(1, Double.parseDouble(amount));
                        updateStmt.setString(2, feeType);
                        updateStmt.setString(3, specificType);
                        updateStmt.setString(4, specificType);
                        updateStmt.setInt(5, yearNum);
                        updateStmt.setString(6, semesterDB);
                        updateStmt.executeUpdate();
                    }
                }
            } else {
                // Insert new records
                for (int yearNum : years) {
                    for (String semesterDB : semesters) {
                        String insertSql = "INSERT INTO type (Tname, Tothers, Tamount, Syear, Ssemester) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                        insertStmt.setString(1, feeType);
                        insertStmt.setString(2, specificType);
                        insertStmt.setDouble(3, Double.parseDouble(amount));
                        insertStmt.setInt(4, yearNum);
                        insertStmt.setString(5, semesterDB);
                        insertStmt.executeUpdate();
                    }
                }
            }
            
            JOptionPane.showMessageDialog(this, "Fee amount updated successfully!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating amount: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        String selectedCountry = (String) jComboBox7.getSelectedItem();
        String combo4 = (String) jComboBox8.getSelectedItem();
        String course = (String) jComboBox6.getSelectedItem();

        // Hide initially
        jComboBox9.hide();
        jLabel25.hide();
        jComboBox8.removeAllItems();

        if (selectedCountry != null && selectedCountry.equalsIgnoreCase("All")) {
            jLabel25.hide();
            jComboBox9.hide();
            jComboBox8.addItem("Select Fee Type");
            jComboBox8.addItem("Tuition Fee");
            jComboBox8.addItem("Miscellaneous");
            jComboBox8.addItem("School Reports");
            jComboBox8.addItem("Events");

            // Add Books if course is not All
            if (course != null && !course.equals("All") && !course.equals("\t")) {
                jComboBox8.addItem("Books");
            }

            // Only check combo4 if it's not null
            if (combo4 != null) {
                if (combo4.equals("Events")) {
                    jComboBox9.setVisible(true);
                    jLabel25.setVisible(true);
                    jComboBox9.addItem("Sports Fest");
                    jComboBox9.addItem("Stage Play");
                } else if (combo4.equals("School Reports")) {
                    jComboBox9.removeAllItems();
                    jComboBox9.setVisible(true);
                    jLabel25.setVisible(true);
                    jComboBox9.addItem("COR");
                    jComboBox9.addItem("COG");
                    jComboBox9.addItem("SOA");
                    jComboBox9.addItem("FORM 137");
                    jComboBox9.addItem("FORM 138");
                }
            }
        } else {
            jLabel25.hide();
            jComboBox9.hide();
            jComboBox8.addItem("Select Fee Type");
            jComboBox8.addItem("Tuition Fee");
            jComboBox8.addItem("Miscellaneous");
            jComboBox8.addItem("Id");
            jComboBox8.addItem("School Reports");
            jComboBox8.addItem("Books");
            jComboBox8.addItem("Events");
            jComboBox8.addItem("Uniform");
        }

        jComboBox9.revalidate();
        jComboBox9.repaint();
        fetchAmount();
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        String selectedCountry = (String) jComboBox8.getSelectedItem();

        // Return if no item is selected or default item is selected
        if (selectedCountry == null || selectedCountry.equals("Select Fee Type")) {
            return;
        }

        // Hide initially
        jComboBox9.hide();
        jLabel25.hide();
        jComboBox9.removeAllItems();

        if (selectedCountry.equalsIgnoreCase("Tuition Fee") || selectedCountry.equalsIgnoreCase("Miscellaneous")) {
            jLabel25.hide();
            jComboBox9.hide();
        }
        else if (selectedCountry.equals("Uniform")) {
            jLabel25.show();
            jComboBox9.show();
            jComboBox9.addItem("PE Uniform S");
            jComboBox9.addItem("PE Uniform M");
            jComboBox9.addItem("PE Uniform L");
            jComboBox9.addItem("NSTP Uniform");
            jComboBox9.addItem("NSTP Uniform S");
            jComboBox9.addItem("NSTP Uniform M");
            jComboBox9.addItem("NSTP Uniform L");
            jComboBox9.addItem("Academic Uniform S");
            jComboBox9.addItem("Academic Uniform M");
            jComboBox9.addItem("Academic Uniform L");
        }
        else if (selectedCountry.equals("Id")) {
            jLabel25.show();
            jComboBox9.show();
            jComboBox9.addItem("ID Lace");
            jComboBox9.addItem("Whole Id");
        }
        else if (selectedCountry.equals("School Reports")) {
            jLabel25.show();
            jComboBox9.show();
            jComboBox9.addItem("COR");
            jComboBox9.addItem("COG");
            jComboBox9.addItem("SOA");
            jComboBox9.addItem("TOR");
            jComboBox9.addItem("REPORT CARD");
            jComboBox9.addItem("FORM 137");
            jComboBox9.addItem("FORM 138");
        }
        else if (selectedCountry.equals("Books")) {
            // Trigger jComboBox6ActionPerformed to update jComboBox9 based on selected course
            jComboBox6ActionPerformed(evt);
        }
        else if (selectedCountry.equals("Events")) {
            jLabel25.show();
            jComboBox9.show();
            jComboBox9.addItem("First Tour");
            jComboBox9.addItem("Second Tour");
            jComboBox9.addItem("Third Tour");
            jComboBox9.addItem("Fourth Tour");
            jComboBox9.addItem("Fifth Tour");
            jComboBox9.addItem("Sports Fest");
            jComboBox9.addItem("Stage Play");
        }

        jComboBox9.revalidate();
        jComboBox9.repaint();
        fetchAmount();
    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        fetchAmount();
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
