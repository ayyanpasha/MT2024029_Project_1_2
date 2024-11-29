-- Add foreign key constraints to 'students' table

-- Foreign key for domain_id (link to 'domains' table)
ALTER TABLE students
    ADD CONSTRAINT fk_domain FOREIGN KEY (domain_id) REFERENCES domains(domain_id);

-- Foreign key for specialization_id (link to 'specialization' table)
ALTER TABLE students
    ADD CONSTRAINT fk_specialization FOREIGN KEY (specialization_id) REFERENCES specialization(specialization_id);

-- Foreign key for placement_id (link to 'placement' table)
ALTER TABLE students
    ADD CONSTRAINT fk_placement FOREIGN KEY (placement_id) REFERENCES placement(id);
