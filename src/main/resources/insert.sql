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
-- Adjusted insert statement for auto-increment field and corrected column name
INSERT IGNORE INTO students
(roll_number, first_name, last_name, email, photograph_path, cgpa, total_credits, graduation_year, domain_id, specialization_id, placement_id, password, role_user)
VALUES
('admin', 'John', 'Doe', 'johndoe@example.com', '/images/johndoe.jpg', 8.5, 120, 2024, 1, 1, 1, '$2a$10$dfSLU0cebGwPOq12qKCWtOFyZyCYc5t7HTj51r9aUcTfUtzTtKGbi', 'admin');

