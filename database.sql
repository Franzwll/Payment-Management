-- Create database
CREATE DATABASE payment_management;
USE payment_management;

-- Admin table
CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Cashier table
CREATE TABLE cashier (
    cashier_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Student table
CREATE TABLE student (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_number VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    program VARCHAR(100) NOT NULL,
    section VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    contact_number VARCHAR(20),
    current_balance DECIMAL(10,2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Fee type table
CREATE TABLE fee_type (
    fee_type_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Payment table
CREATE TABLE payment (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    cashier_id INT NOT NULL,
    fee_type_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_method ENUM('CASH', 'GCASH') NOT NULL,
    semester VARCHAR(20) NOT NULL,
    other_details TEXT,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (cashier_id) REFERENCES cashier(cashier_id),
    FOREIGN KEY (fee_type_id) REFERENCES fee_type(fee_type_id)
);

-- Receipt table
CREATE TABLE receipt (
    receipt_id INT PRIMARY KEY AUTO_INCREMENT,
    payment_id INT NOT NULL,
    receipt_number VARCHAR(20) UNIQUE NOT NULL,
    generated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (payment_id) REFERENCES payment(payment_id)
);

-- Insert default admin
INSERT INTO admin (username, password, name) 
VALUES ('admin', '$2a$10$X7UrH5QxX5QxX5QxX5QxX.5QxX5QxX5QxX5QxX5QxX5QxX5QxX5Qx', 'System Administrator');

-- Insert detailed fee types
INSERT INTO fee_type (name, description) VALUES 
('TUITION', 'Regular tuition fee per unit'),
('MISCELLANEOUS', 'General miscellaneous fees including student services'),
('LABORATORY', 'Laboratory fees for practical courses'),
('LIBRARY', 'Library membership and resource fees'),
('ATHLETICS', 'Athletic and sports facility fees'),
('MEDICAL', 'Medical and dental service fees'),
('ID_CARD', 'Student ID card and replacement fees'),
('REGISTRATION', 'Registration and enrollment fees'),
('DEVELOPMENT', 'School development and improvement fees'),
('COMPUTER', 'Computer laboratory and technology fees'),
('RESEARCH', 'Research and thesis fees'),
('GRADUATION', 'Graduation and commencement fees'),
('LATE_PAYMENT', 'Late payment penalty fees'),
('RETURNED_CHECK', 'Returned check processing fees'),
('OTHERS', 'Other miscellaneous fees not categorized above'); 