-- Insert initial data into the 'domains' table
INSERT INTO domains (program, batch, capacity, qualification) VALUES
    ('B.Tech', '2020-2024', 120, '12th Grade with PCM'),
    ('M.Tech', '2022-2024', 60, 'B.Tech in relevant discipline'),
    ('MBA', '2023-2025', 50, 'Bachelors degree in any discipline'),
    ('PhD', '2021-2026', 30, 'Masters degree in relevant field');

-- Insert initial data into the 'specialization' table
INSERT INTO specialization (code, name, description, years, credits_required) VALUES
    ('CS-DS', 'Data Science', 'Specialization in Data Science with machine learning and AI', 2, 50),
    ('CS-VLSI', 'VLSI Design', 'Specialization in VLSI Design for Electronics Engineering', 2, 48),
    ('ME-PS', 'Product Design and Development', 'Specialization in Product Design for Mechanical Engineering', 2, 45),
    ('EE-Power', 'Power Systems', 'Specialization in Power Systems Engineering for Electrical Engineering', 2, 50);

-- Insert initial data into the 'placement' table
INSERT INTO placement (organization, profile, description, intake, minimum_grade) VALUES
    ('Microsoft', 'Software Engineer', 'Develop and maintain software systems', 20, 8.5),
    ('Google', 'Data Scientist', 'Analyze large data sets and develop machine learning models', 15, 9.0),
    ('Tesla', 'Mechanical Engineer', 'Design and develop mechanical components for electric vehicles', 10, 8.0),
    ('Amazon', 'Operations Manager', 'Manage and streamline operations in supply chain', 25, 7.5);

-- Insert initial data into the 'students' table
-- Link students to a domain, specialization, and placement
INSERT INTO students (roll_number, first_name, last_name, email, photograph_path, cgpa, total_credits, graduation_year, domain_id, specialization_id, placement_id, password) VALUES
    ('CS2024001', 'John', 'Doe', 'johndoe@example.com', '/images/johndoe.jpg', 8.5, 120, 2024, 1, 1, 1, 'hashed_password_1'),
    ('ME2024002', 'Jane', 'Smith', 'janesmith@example.com', '/images/janesmith.jpg', 8.0, 110, 2024, 2, 3, 3, 'hashed_password_2'),
    ('EE2024003', 'Robert', 'Johnson', 'robertjohnson@example.com', '/images/robertjohnson.jpg', 9.0, 130, 2024, 3, 4, 2, 'hashed_password_3'),
    ('CS2024004', 'Emily', 'Davis', 'emilydavis@example.com', '/images/emilydavis.jpg', 8.2, 115, 2024, 1, 2, 4, 'hashed_password_4'),
    ('ME2024005', 'David', 'Wilson', 'davidwilson@example.com', '/images/davidwilson.jpg', 7.8, 125, 2024, 2, 3, 3, 'hashed_password_5');