INSERT INTO address (`id`,`address_line_one`,`address_line_two`,`town`,`county`,`postcode`)
VALUES (1, '23', 'holway road', 'Taunton', 'Somerset', 'TA1 2EZ');


INSERT INTO user (`id`, `user_id`, `home_address_id`, `billing_address_id`)
VALUES (1, 1, 1,1);


INSERT INTO LOAN_APPLICATION (`id`, `applicant_id`, `active`, `principal`, `period`, `total`)
VALUES (1,1,1,100.00, 'SEVEN_DAYS', 110.17);