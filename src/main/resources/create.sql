-- Create 'domains' table
CREATE TABLE IF NOT EXISTS domains (
                                       domain_id INT PRIMARY KEY AUTO_INCREMENT,   -- Primary key with auto increment
                                       program VARCHAR(100) NOT NULL,              -- Program name (e.g., B.Tech, M.Tech)
    batch VARCHAR(50) NOT NULL,                 -- Batch name (e.g., 2020-2024)
    capacity INT NOT NULL,                      -- Capacity of the domain (number of students)
    qualification VARCHAR(100) NOT NULL         -- Qualification required for admission
    );

-- Create 'specialization' table
CREATE TABLE IF NOT EXISTS specialization (
                                              specialization_id INT PRIMARY KEY AUTO_INCREMENT,  -- Primary key with auto increment
                                              code VARCHAR(50) NOT NULL UNIQUE,                  -- Unique code for the specialization
    name VARCHAR(100) NOT NULL,                        -- Name of the specialization (e.g., Data Science, VLSI)
    description TEXT,                                  -- Description of the specialization
    years INT NOT NULL,                                -- Duration of the specialization in years
    credits_required INT NOT NULL                      -- Number of credits required to complete the specialization
    );

-- Create 'placement' table
CREATE TABLE IF NOT EXISTS placement (
                                         id INT PRIMARY KEY AUTO_INCREMENT,               -- Primary key with auto increment
                                         organization VARCHAR(200) NOT NULL,              -- Organization offering the placement (e.g., Microsoft)
    profile VARCHAR(100) NOT NULL,                   -- Profile offered (e.g., Software Engineer, Data Analyst)
    description TEXT,                                -- Description of the placement profile
    intake INT NOT NULL,                             -- Number of positions available
    minimum_grade DECIMAL(3, 2) NOT NULL             -- Minimum grade required for placement eligibility
    );

-- Create 'students' table without foreign key constraints
CREATE TABLE IF NOT EXISTS students (
                                        student_id INT PRIMARY KEY AUTO_INCREMENT,      -- Primary key with auto increment
                                        roll_number VARCHAR(20) NOT NULL UNIQUE,        -- Unique roll number
    first_name VARCHAR(100) NOT NULL,               -- First name of the student
    last_name VARCHAR(100) NOT NULL,                -- Last name of the student
    email VARCHAR(100) NOT NULL UNIQUE,             -- Unique email for the student
    photograph_path VARCHAR(255),                   -- Path to the photograph of the student
    cgpa DECIMAL(3, 2),                             -- CGPA with 2 decimal precision
    total_credits INT,                              -- Total credits the student has earned
    graduation_year INT,                            -- Year of graduation
    domain_id INT,                                  -- Foreign key for domain (to be added later)
    specialization_id INT,                          -- Foreign key for specialization (to be added later)
    placement_id INT,                               -- Foreign key for placement (to be added later)
    password VARCHAR(255) NOT NULL,                 -- Password field (hashed)
    role_user VARCHAR(255)                         -- admin role
    );
