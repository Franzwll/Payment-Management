-- Drop tables if they exist (in reverse order of dependencies)
DROP TABLE IF EXISTS audit_logs;
DROP TABLE IF EXISTS payment_details;
DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS fee_structures;
DROP TABLE IF EXISTS fee_types;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS users;

-- Create tables
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'cashier') NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE students (
    student_id VARCHAR(20) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    program VARCHAR(100) NOT NULL,
    section VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    contact_number VARCHAR(20),
    enrollment_date DATE NOT NULL,
    status ENUM('active', 'inactive') DEFAULT 'active'
);

CREATE TABLE fee_types (
    fee_type_id INT PRIMARY KEY AUTO_INCREMENT,
    fee_name VARCHAR(100) NOT NULL,
    description TEXT,
    is_active BOOLEAN DEFAULT true,
    created_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);

CREATE TABLE fee_structures (
    structure_id INT PRIMARY KEY AUTO_INCREMENT,
    program VARCHAR(100) NOT NULL,
    section VARCHAR(20) NOT NULL,
    fee_type_id INT,
    amount DECIMAL(10,2) NOT NULL,
    academic_year VARCHAR(9) NOT NULL,
    semester ENUM('FIRST', 'SECOND', 'SUMMER') NOT NULL,
    created_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (fee_type_id) REFERENCES fee_types(fee_type_id),
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);

CREATE TABLE payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id VARCHAR(20),
    fee_type_id INT,
    amount DECIMAL(10,2) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_method ENUM('CASH', 'GCASH') NOT NULL,
    status ENUM('pending', 'completed', 'cancelled') DEFAULT 'pending',
    processed_by INT,
    receipt_number VARCHAR(20) UNIQUE,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (fee_type_id) REFERENCES fee_types(fee_type_id),
    FOREIGN KEY (processed_by) REFERENCES users(user_id)
);

CREATE TABLE payment_details (
    detail_id INT PRIMARY KEY AUTO_INCREMENT,
    payment_id INT,
    fee_structure_id INT,
    amount DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (payment_id) REFERENCES payments(payment_id),
    FOREIGN KEY (fee_structure_id) REFERENCES fee_structures(structure_id)
);

CREATE TABLE audit_logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    action VARCHAR(100) NOT NULL,
    description TEXT,
    ip_address VARCHAR(45),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Insert data in correct order

-- 1. Insert Users
INSERT INTO users (username, password, role, first_name, last_name, email) VALUES
('admin1', 'hashed_password_1', 'admin', 'John', 'Smith', 'john.smith@university.edu'),
('admin2', 'hashed_password_2', 'admin', 'Sarah', 'Johnson', 'sarah.j@university.edu'),
('cashier1', 'hashed_password_3', 'cashier', 'Michael', 'Brown', 'michael.b@university.edu'),
('cashier2', 'hashed_password_4', 'cashier', 'Emily', 'Davis', 'emily.d@university.edu');

-- 2. Insert Students
INSERT INTO students (student_id, first_name, last_name, program, section, email, contact_number, enrollment_date) VALUES
('2023-0001', 'Juan', 'Dela Cruz', 'BS Computer Science', 'BSCS 12001', 'juan.dc@student.edu', '09123456789', '2023-06-01'),
('2023-0002', 'Maria', 'Santos', 'BS Information Technology', 'BSIT 12001', 'maria.s@student.edu', '09234567890', '2023-06-01'),
('2023-0003', 'James', 'Wilson', 'BS Computer Science', 'BSCS 12001', 'james.w@student.edu', '09345678901', '2023-06-01'),
('2023-0004', 'Sophia', 'Lee', 'BS Information Technology', 'BSIT 12001', 'sophia.l@student.edu', '09456789012', '2023-06-01'),
('2023-0005', 'Robert', 'Garcia', 'BS Computer Science', 'BSCS 12002', 'robert.g@student.edu', '09567890123', '2023-06-01');

-- 3. Insert Fee Types
INSERT INTO fee_types (fee_name, description, created_by) VALUES
('Tuition Fee', 'Regular tuition fee per unit', 1),
('Laboratory Fee', 'Fee for computer laboratory usage', 1),
('Library Fee', 'Annual library membership fee', 1),
('Registration Fee', 'Semester registration fee', 1),
('Miscellaneous Fee', 'Other school fees', 1);

-- 4. Insert Fee Structures
INSERT INTO fee_structures (program, section, fee_type_id, amount, academic_year, semester, created_by) VALUES
-- BS Computer Science Fees
('BS Computer Science', 'BSCS 12001', 1, 1500.00, '2023-2024', 'FIRST', 1),
('BS Computer Science', 'BSCS 12001', 2, 500.00, '2023-2024', 'FIRST', 1),
('BS Computer Science', 'BSCS 12001', 3, 200.00, '2023-2024', 'FIRST', 1),
('BS Computer Science', 'BSCS 12001', 4, 100.00, '2023-2024', 'FIRST', 1),
('BS Computer Science', 'BSCS 12001', 5, 300.00, '2023-2024', 'FIRST', 1),
-- BS Information Technology Fees
('BS Information Technology', 'BSIT 12001', 1, 1500.00, '2023-2024', 'FIRST', 1),
('BS Information Technology', 'BSIT 12001', 2, 500.00, '2023-2024', 'FIRST', 1),
('BS Information Technology', 'BSIT 12001', 3, 200.00, '2023-2024', 'FIRST', 1),
('BS Information Technology', 'BSIT 12001', 4, 100.00, '2023-2024', 'FIRST', 1),
('BS Information Technology', 'BSIT 12001', 5, 300.00, '2023-2024', 'FIRST', 1);

-- 5. Insert Payments
INSERT INTO payments (student_id, fee_type_id, amount, payment_method, status, processed_by, receipt_number) VALUES
('2023-0001', 1, 1500.00, 'CASH', 'completed', 3, 'REC-2023-0001'),
('2023-0001', 2, 500.00, 'CASH', 'completed', 3, 'REC-2023-0002'),
('2023-0002', 1, 1500.00, 'GCASH', 'completed', 4, 'REC-2023-0003'),
('2023-0003', 1, 1500.00, 'CASH', 'pending', 3, 'REC-2023-0004'),
('2023-0004', 1, 1500.00, 'GCASH', 'completed', 4, 'REC-2023-0005');

-- 6. Insert Payment Details
INSERT INTO payment_details (payment_id, fee_structure_id, amount) VALUES
(1, 1, 1500.00),
(2, 2, 500.00),
(3, 6, 1500.00),
(4, 1, 1500.00),
(5, 6, 1500.00);

-- 7. Insert Audit Logs
INSERT INTO audit_logs (user_id, action, description, ip_address) VALUES
(1, 'CREATE_FEE_TYPE', 'Created new fee type: Tuition Fee', '192.168.1.1'),
(1, 'UPDATE_FEE_STRUCTURE', 'Updated fee structure for BSCS 12001', '192.168.1.1'),
(3, 'PROCESS_PAYMENT', 'Processed payment for student 2023-0001', '192.168.1.2'),
(4, 'PROCESS_PAYMENT', 'Processed payment for student 2023-0002', '192.168.1.3'),
(2, 'CREATE_USER', 'Created new cashier account', '192.168.1.1');