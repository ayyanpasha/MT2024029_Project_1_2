-- Insert initial data into the 'domains' table
INSERT IGNORE INTO domains (domain_id, program, batch, capacity, qualification) VALUES
    (1,'B.Tech', '2020-2024', 120, '12th Grade with PCM'),
    (2,'M.Tech', '2022-2024', 60, 'B.Tech in relevant discipline'),
    (3,'MBA', '2023-2025', 50, 'Bachelors degree in any discipline'),
    (4,'PhD', '2021-2026', 30, 'Masters degree in relevant field');

-- Insert initial data into the 'specialization' table
INSERT IGNORE INTO specialization (specialization_id, code, name, description, years, credits_required) VALUES
    (1,'CS-DS', 'Data Science', 'Specialization in Data Science with machine learning and AI', 2, 50),
    (2,'CS-VLSI', 'VLSI Design', 'Specialization in VLSI Design for Electronics Engineering', 2, 48),
    (3,'ME-PS', 'Product Design and Development', 'Specialization in Product Design for Mechanical Engineering', 2, 45),
    (4,'EE-Power', 'Power Systems', 'Specialization in Power Systems Engineering for Electrical Engineering', 2, 50);

-- Insert initial data into the 'placement' table
INSERT IGNORE INTO placement (id, organization, profile, description, intake, minimum_grade) VALUES
    (1,'Microsoft', 'Software Engineer', 'Develop and maintain software systems', 20, 8.5),
    (2,'Google', 'Data Scientist', 'Analyze large data sets and develop machine learning models', 15, 9.0),
    (3,'Tesla', 'Mechanical Engineer', 'Design and develop mechanical components for electric vehicles', 10, 8.0),
    (4,'Amazon', 'Operations Manager', 'Manage and streamline operations in supply chain', 25, 7.5);

-- Insert initial data into the 'students' table
-- Link students to a domain, specialization, and placement
INSERT IGNORE INTO students (student_id, roll_number, first_name, last_name, email, photograph_path, cgpa, total_credits, graduation_year, domain_id, specialization_id, placement_id, password) VALUES
    (1,'CS2024001', 'John', 'Doe', 'johndoe@example.com', '/images/johndoe.jpg', 8.5, 120, 2024, 1, 1, 1, 'hashed_password_1'),
    (2,'ME2024002', 'Jane', 'Smith', 'janesmith@example.com', '/images/janesmith.jpg', 8.0, 110, 2024, 2, 3, 3, 'hashed_password_2'),
    (3,'EE2024003', 'Robert', 'Johnson', 'robertjohnson@example.com', '/images/robertjohnson.jpg', 9.0, 130, 2024, 3, 4, 2, 'hashed_password_3'),
    (4,'CS2024004', 'Emily', 'Davis', 'emilydavis@example.com', '/images/emilydavis.jpg', 8.2, 115, 2024, 1, 2, 4, 'hashed_password_4'),
    (5,'ME2024005', 'David', 'Wilson', 'davidwilson@example.com', '/images/davidwilson.jpg', 7.8, 125, 2024, 2, 3, 3, 'hashed_password_5');