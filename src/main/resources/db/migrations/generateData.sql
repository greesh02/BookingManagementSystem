use bms2;
-- create cities
INSERT INTO city (id, name, created_at, last_modified_at) VALUES
(1, 'Mumbai', CURDATE(), CURDATE()),
(2, 'Delhi', CURDATE(), CURDATE()),
(3, 'Bengaluru', CURDATE(), CURDATE()),
(4, 'Hyderabad', CURDATE(), CURDATE()),
(5, 'Ahmedabad', CURDATE(), CURDATE()),
(6, 'Chennai', CURDATE(), CURDATE()),
(7, 'Kolkata', CURDATE(), CURDATE()),
(8, 'Pune', CURDATE(), CURDATE()),
(9, 'Jaipur', CURDATE(), CURDATE()),
(10, 'Surat', CURDATE(), CURDATE()),
(11, 'Lucknow', CURDATE(), CURDATE()),
(12, 'Kanpur', CURDATE(), CURDATE()),
(13, 'Nagpur', CURDATE(), CURDATE()),
(14, 'Indore', CURDATE(), CURDATE()),
(15, 'Bhopal', CURDATE(), CURDATE()),
(16, 'Visakhapatnam', CURDATE(), CURDATE()),
(17, 'Patna', CURDATE(), CURDATE()),
(18, 'Vadodara', CURDATE(), CURDATE()),
(19, 'Trichy', CURDATE(), CURDATE()),
(20, 'Coimbatore', CURDATE(), CURDATE());

-- create theatres

INSERT INTO theatre (id, name, description, city_id, created_at, last_modified_at) VALUES
-- Mumbai (city_id=1)
(1, 'INOX Mumbai Central', '3rd Floor, CR2 Mall, Nariman Point, Mumbai, Maharashtra', 1, CURDATE(), CURDATE()),
(2, 'PVR Phoenix Marketcity', 'LBS Road, Kurla West, Mumbai, Maharashtra', 1, CURDATE(), CURDATE()),
(3, 'Carnival Cinemas Andheri', 'Linking Road, Andheri West, Mumbai, Maharashtra', 1, CURDATE(), CURDATE()),
(4, 'Cinepolis Mumbai', 'Infinity Mall, Malad West, Mumbai, Maharashtra', 1, CURDATE(), CURDATE()),
(5, 'Fun Cinemas Mumbai', 'R City Mall, Ghatkopar West, Mumbai, Maharashtra', 1, CURDATE(), CURDATE()),

-- New Delhi (city_id=2)
(6, 'PVR Select Citywalk', 'Saket District Centre, New Delhi', 2, CURDATE(), CURDATE()),
(7, 'INOX Ambience Mall', 'Vasant Kunj, New Delhi', 2, CURDATE(), CURDATE()),
(8, 'Carnival Cinemas Connaught Place', 'Janpath, Connaught Place, New Delhi', 2, CURDATE(), CURDATE()),
(9, 'DT Cinemas', 'Janakpuri, New Delhi', 2, CURDATE(), CURDATE()),
(10, 'DT Cinemas Rohini', 'Rohini Sector 3, New Delhi', 2, CURDATE(), CURDATE()),

-- Bengaluru (city_id=3)
(11, 'PVR Forum Mall', 'Forum Mall, Koramangala, Bengaluru, Karnataka', 3, CURDATE(), CURDATE()),
(12, 'INOX Garuda Mall', 'Garuda Mall, MG Road, Bengaluru, Karnataka', 3, CURDATE(), CURDATE()),
(13, 'Carnival Cinemas Bangalore', 'Brigade Road, Bengaluru, Karnataka', 3, CURDATE(), CURDATE()),
(14, 'PVR Orion Mall', 'Orion Mall, Rajajinagar, Bengaluru, Karnataka', 3, CURDATE(), CURDATE()),
(15, 'Cinepolis Bangalore', 'VR Bengaluru Mall, Whitefield, Bengaluru, Karnataka', 3, CURDATE(), CURDATE()),

-- Hyderabad (city_id=4)
(16, 'PVR Hyderabad Central', 'Punjagutta Main Road, Hyderabad, Telangana', 4, CURDATE(), CURDATE()),
(17, 'INOX Hyderabad', 'Gachibowli, Hyderabad, Telangana', 4, CURDATE(), CURDATE()),
(18, 'Carnival Cinemas Hyderabad', 'Kukatpally, Hyderabad, Telangana', 4, CURDATE(), CURDATE()),
(19, 'PVR LB Nagar', 'LB Nagar, Hyderabad, Telangana', 4, CURDATE(), CURDATE()),
(20, 'Cinepolis Hyderabad', 'Hitech City, Hyderabad, Telangana', 4, CURDATE(), CURDATE()),

-- Ahmedabad (city_id=5)
(21, 'Cinepolis Ahmedabad', 'Alpha One Mall, Ahmedabad, Gujarat', 5, CURDATE(), CURDATE()),
(22, 'PVR Ahmedabad', 'C.G. Road, Ahmedabad, Gujarat', 5, CURDATE(), CURDATE()),
(23, 'INOX Ahmedabad', 'Himatnagar Road, Ahmedabad, Gujarat', 5, CURDATE(), CURDATE()),
(24, 'Carnival Cinemas Ahmedabad', 'Paldi, Ahmedabad, Gujarat', 5, CURDATE(), CURDATE()),
(25, 'Cinepolis Drive-in', 'Drive-in Road, Ahmedabad, Gujarat', 5, CURDATE(), CURDATE()),

-- Chennai (city_id=6)
(26, 'Luxe Cinemas', 'Phoenix Marketcity, Velachery, Chennai, Tamil Nadu', 6, CURDATE(), CURDATE()),
(27, 'PVR Chennai', 'Express Avenue Mall, Chennai, Tamil Nadu', 6, CURDATE(), CURDATE()),
(28, 'INOX Chennai', 'Forum Vijaya Mall, Chennai, Tamil Nadu', 6, CURDATE(), CURDATE()),
(29, 'Sathyam Cinemas', 'Royapettah High Road, Chennai, Tamil Nadu', 6, CURDATE(), CURDATE()),
(30, 'Carnival Cinemas Chennai', 'Vadapalani, Chennai, Tamil Nadu', 6, CURDATE(), CURDATE()),

-- Kolkata (city_id=7)
(31, 'INOX Kolkata', 'South City Mall, Kolkata, West Bengal', 7, CURDATE(), CURDATE()),
(32, 'PVR Kolkata', 'Quest Mall, Kolkata, West Bengal', 7, CURDATE(), CURDATE()),
(33, 'Cinepolis Kolkata', 'Mani Square Mall, Kolkata, West Bengal', 7, CURDATE(), CURDATE()),
(34, 'Carnival Cinemas Kolkata', 'New Market, Kolkata, West Bengal', 7, CURDATE(), CURDATE()),
(35, 'Nandan Cinema', 'Film City, Kolkata, West Bengal', 7, CURDATE(), CURDATE()),

-- Pune (city_id=8)
(36, 'INOX Pune', 'Phoenix Marketcity, Pune, Maharashtra', 8, CURDATE(), CURDATE()),
(37, 'PVR Pune', 'Kalyani Nagar, Pune, Maharashtra', 8, CURDATE(), CURDATE()),
(38, 'Carnival Cinemas Pune', 'Camp Area, Pune, Maharashtra', 8, CURDATE(), CURDATE()),
(39, 'Cinepolis Pune', 'Magarpatta City, Pune, Maharashtra', 8, CURDATE(), CURDATE()),
(40, 'PVR Seasons Mall', 'Seasons Mall, Pune, Maharashtra', 8, CURDATE(), CURDATE()),

-- Jaipur (city_id=9)
(41, 'Raj Mandir Cinema', 'C-16, Bhagwan Das Road, Jaipur, Rajasthan', 9, CURDATE(), CURDATE()),
(42, 'INOX Jaipur', 'Malviya Nagar, Jaipur, Rajasthan', 9, CURDATE(), CURDATE()),
(43, 'PVR Jaipur', 'World Trade Park, Jaipur, Rajasthan', 9, CURDATE(), CURDATE()),
(44, 'Carnival Cinemas Jaipur', 'Vaishali Nagar, Jaipur, Rajasthan', 9, CURDATE(), CURDATE()),
(45, 'Cinepolis Jaipur', 'Transport Nagar, Jaipur, Rajasthan', 9, CURDATE(), CURDATE()),

-- Lucknow (city_id=10)
(46, 'INOX Lucknow', 'Hazratganj, Lucknow, Uttar Pradesh', 10, CURDATE(), CURDATE()),
(47, 'PVR Lucknow', 'Aliganj, Lucknow, Uttar Pradesh', 10, CURDATE(), CURDATE()),
(48, 'Carnival Cinemas Lucknow', 'Indira Nagar, Lucknow, Uttar Pradesh', 10, CURDATE(), CURDATE()),
(49, 'Cinepolis Lucknow', 'Gomti Nagar, Lucknow, Uttar Pradesh', 10, CURDATE(), CURDATE()),
(50, 'Wave Cinemas Lucknow', 'Mahanagar, Lucknow, Uttar Pradesh', 10, CURDATE(), CURDATE()),

-- Kanpur (city_id=11)
(51, 'PVR Kanpur', 'Rawatpur, Kanpur, Uttar Pradesh', 11, CURDATE(), CURDATE()),
(52, 'INOX Kanpur', 'Civil Lines, Kanpur, Uttar Pradesh', 11, CURDATE(), CURDATE()),
(53, 'Carnival Cinemas Kanpur', 'Kidwai Nagar, Kanpur, Uttar Pradesh', 11, CURDATE(), CURDATE()),
(54, 'Wave Cinemas Kanpur', 'Kalyanpur, Kanpur, Uttar Pradesh', 11, CURDATE(), CURDATE()),
(55, 'Cinepolis Kanpur', 'Jajmau, Kanpur, Uttar Pradesh', 11, CURDATE(), CURDATE()),

-- Nagpur (city_id=12)
(56, 'BIG Cinemas Nagpur', 'Empress City Mall, Near Railway Station, Nagpur, Maharashtra', 12, CURDATE(), CURDATE()),
(57, 'INOX Nagpur', 'Sitabuldi, Nagpur, Maharashtra', 12, CURDATE(), CURDATE()),
(58, 'PVR Nagpur', 'Central Mall, Nagpur, Maharashtra', 12, CURDATE(), CURDATE()),
(59, 'Carnival Cinemas Nagpur', 'Khamla, Nagpur, Maharashtra', 12, CURDATE(), CURDATE()),
(60, 'Cinepolis Nagpur', 'Mihan SEZ, Nagpur, Maharashtra', 12, CURDATE(), CURDATE()),

-- Indore (city_id=13)
(61, 'PVR Indore', 'MG Road, Indore, Madhya Pradesh', 13, CURDATE(), CURDATE()),
(62, 'INOX Indore', 'Palasia, Indore, Madhya Pradesh', 13, CURDATE(), CURDATE()),
(63, 'Carnival Cinemas Indore', 'Rajwada, Indore, Madhya Pradesh', 13, CURDATE(), CURDATE()),
(64, 'Wave Cinemas Indore', 'Vijay Nagar, Indore, Madhya Pradesh', 13, CURDATE(), CURDATE()),
(65, 'Cinepolis Indore', 'AB Road, Indore, Madhya Pradesh', 13, CURDATE(), CURDATE()),

-- Thiruvananthapuram (city_id=14)
(66, 'INOX Trivandrum', 'MG Road, Thiruvananthapuram, Kerala', 14, CURDATE(), CURDATE()),
(67, 'PVR Trivandrum', 'Vazhuthacaud, Thiruvananthapuram, Kerala', 14, CURDATE(), CURDATE()),
(68, 'Carnival Cinemas Trivandrum', 'Pattom, Thiruvananthapuram, Kerala', 14, CURDATE(), CURDATE()),
(69, 'Cinepolis Trivandrum', 'Sreekariyam, Thiruvananthapuram, Kerala', 14, CURDATE(), CURDATE()),
(70, 'Sreekaryam Cinemas', 'Near Sreekaryam Bus Stand, Thiruvananthapuram, Kerala', 14, CURDATE(), CURDATE()),

-- Surat (city_id=15)
(71, 'PVR Surat', 'Adajan, Surat, Gujarat', 15, CURDATE(), CURDATE()),
(72, 'INOX Surat', 'Varachha Road, Surat, Gujarat', 15, CURDATE(), CURDATE()),
(73, 'Carnival Cinemas Surat', 'Ring Road, Surat, Gujarat', 15, CURDATE(), CURDATE()),
(74, 'Cinepolis Surat', 'City Light, Surat, Gujarat', 15, CURDATE(), CURDATE()),
(75, 'Wave Cinemas Surat', 'Udhana, Surat, Gujarat', 15, CURDATE(), CURDATE()),

-- Vadodara (city_id=16)
(76, 'INOX Vadodara Central', 'Vadodara Central Mall, Alkapuri, Vadodara, Gujarat', 16, CURDATE(), CURDATE()),
(77, 'PVR Vadodara', 'Alkapuri, Vadodara, Gujarat', 16, CURDATE(), CURDATE()),
(78, 'Carnival Cinemas Vadodara', 'Gotri Road, Vadodara, Gujarat', 16, CURDATE(), CURDATE()),
(79, 'Cinepolis Vadodara', 'Fatehgunj, Vadodara, Gujarat', 16, CURDATE(), CURDATE()),
(80, 'Wave Cinemas Vadodara', 'Makarpura, Vadodara, Gujarat', 16, CURDATE(), CURDATE()),

-- Coimbatore (city_id=17)
(81, 'PVR Prozone Mall', 'Prozone Mall, Sivananda Colony, Coimbatore, Tamil Nadu', 17, CURDATE(), CURDATE()),
(82, 'INOX Coimbatore', 'RS Puram, Coimbatore, Tamil Nadu', 17, CURDATE(), CURDATE()),
(83, 'Carnival Cinemas Coimbatore', 'Gandhipuram, Coimbatore, Tamil Nadu', 17, CURDATE(), CURDATE()),
(84, 'Cinepolis Coimbatore', 'Race Course Road, Coimbatore, Tamil Nadu', 17, CURDATE(), CURDATE()),
(85, 'AGS Cinemas', 'Saibaba Colony, Coimbatore, Tamil Nadu', 17, CURDATE(), CURDATE()),

-- Trichy (city_id=19)
(86, 'Carnival Cinemas Trichy', 'Manghalam Towers, Cantonment, Tiruchirappalli, Tamil Nadu', 19, CURDATE(), CURDATE()),
(87, 'Sathya Cinemas Trichy', 'Thillai Nagar Main Road, Tiruchirappalli, Tamil Nadu', 19, CURDATE(), CURDATE()),
(88, 'INOX Trichy', 'Anna Nagar, Tiruchirappalli, Tamil Nadu', 19, CURDATE(), CURDATE()),
(89, 'PVR Trichy', 'Vayalur Road, Tiruchirappalli, Tamil Nadu', 19, CURDATE(), CURDATE()),
(90, 'Cinepolis Trichy', 'Thillai Nagar, Tiruchirappalli, Tamil Nadu', 19, CURDATE(), CURDATE()),

-- Others (city_id=20) - Example Coimbatore (for 20th city in your list)
(91, 'PVR Coimbatore', 'Avinashi Road, Coimbatore, Tamil Nadu', 20, CURDATE(), CURDATE()),
(92, 'INOX Coimbatore East', 'Singaravelan Street, Coimbatore, Tamil Nadu', 20, CURDATE(), CURDATE()),
(93, 'Carnival Cinemas Coimbatore South', 'Trichy Road, Coimbatore, Tamil Nadu', 20, CURDATE(), CURDATE()),
(94, 'Cinepolis Coimbatore West', 'Rathinam Mall, Coimbatore, Tamil Nadu', 20, CURDATE(), CURDATE()),
(95, 'Sathyam Cinemas Coimbatore', 'Race Course Road, Coimbatore, Tamil Nadu', 20, CURDATE(), CURDATE()),
(96, 'LA Maris Cinemas', 'West Boulevard Road, Tiruchirappalli, Tamil Nadu', 19, CURDATE(), CURDATE());

-- screens


INSERT INTO screen (id, name, theatre_id, created_at, last_modified_at) VALUES
(1, 'LA Maris Screen 1', 96, CURDATE(), CURDATE()),
(2, 'LA Maris Screen 2', 96, CURDATE(), CURDATE());
-- screen features
INSERT INTO screen_features (screen_id, features) VALUES
(1, 'DOLBY_ATMOS'),
(1, 'THREE_D'),
(2, 'TWO_D');
-- seat gen
INSERT INTO seat (screen_id, number, seat_type, created_at, last_modified_at) VALUES
-- Screen 1 seats
(1, 'G1', 'GOLD', CURDATE(), CURDATE()),
(1, 'G2', 'GOLD', CURDATE(), CURDATE()),
(1, 'G3', 'GOLD', CURDATE(), CURDATE()),
(1, 'G4', 'GOLD', CURDATE(), CURDATE()),
(1, 'G5', 'GOLD', CURDATE(), CURDATE()),

(1, 'P1', 'PLATINUM', CURDATE(), CURDATE()),
(1, 'P2', 'PLATINUM', CURDATE(), CURDATE()),
(1, 'P3', 'PLATINUM', CURDATE(), CURDATE()),
(1, 'P4', 'PLATINUM', CURDATE(), CURDATE()),
(1, 'P5', 'PLATINUM', CURDATE(), CURDATE()),

(1, 'R1', 'RECLINER', CURDATE(), CURDATE()),
(1, 'R2', 'RECLINER', CURDATE(), CURDATE()),
(1, 'R3', 'RECLINER', CURDATE(), CURDATE()),
(1, 'R4', 'RECLINER', CURDATE(), CURDATE()),
(1, 'R5', 'RECLINER', CURDATE(), CURDATE()),

(1, 'S1', 'SILVER', CURDATE(), CURDATE()),
(1, 'S2', 'SILVER', CURDATE(), CURDATE()),
(1, 'S3', 'SILVER', CURDATE(), CURDATE()),
(1, 'S4', 'SILVER', CURDATE(), CURDATE()),
(1, 'S5', 'SILVER', CURDATE(), CURDATE()),

-- Screen 2 seats
(2, 'G1', 'GOLD', CURDATE(), CURDATE()),
(2, 'G2', 'GOLD', CURDATE(), CURDATE()),
(2, 'G3', 'GOLD', CURDATE(), CURDATE()),
(2, 'G4', 'GOLD', CURDATE(), CURDATE()),
(2, 'G5', 'GOLD', CURDATE(), CURDATE()),

(2, 'P1', 'PLATINUM', CURDATE(), CURDATE()),
(2, 'P2', 'PLATINUM', CURDATE(), CURDATE()),
(2, 'P3', 'PLATINUM', CURDATE(), CURDATE()),
(2, 'P4', 'PLATINUM', CURDATE(), CURDATE()),
(2, 'P5', 'PLATINUM', CURDATE(), CURDATE()),

(2, 'R1', 'RECLINER', CURDATE(), CURDATE()),
(2, 'R2', 'RECLINER', CURDATE(), CURDATE()),
(2, 'R3', 'RECLINER', CURDATE(), CURDATE()),
(2, 'R4', 'RECLINER', CURDATE(), CURDATE()),
(2, 'R5', 'RECLINER', CURDATE(), CURDATE()),

(2, 'S1', 'SILVER', CURDATE(), CURDATE()),
(2, 'S2', 'SILVER', CURDATE(), CURDATE()),
(2, 'S3', 'SILVER', CURDATE(), CURDATE()),
(2, 'S4', 'SILVER', CURDATE(), CURDATE()),
(2, 'S5', 'SILVER', CURDATE(), CURDATE());




-- Movies
INSERT INTO movie (id, created_at, last_modified_at, duration_in_millis, descripion, image_url, name, movie_rating)
VALUES
(1, '2025-05-01', '2025-05-10', 9000000, 'A gripping crime thriller set in Mumbai.', 'https://example.com/images/mumbai_thriller.jpg', 'Mumbai Chronicles', 'UA'),
(2, '2025-04-28', '2025-05-12', 7200000, 'A romantic comedy in Delhi.', 'https://example.com/images/delhi_love.jpg', 'Delhi Diaries', 'U'),
(3, '2025-05-05', '2025-05-14', 8100000, 'Action-packed Telugu blockbuster.', 'https://example.com/images/telugu_action.jpg', 'Thunder Telugu', 'A'),
(4, '2025-04-30', '2025-05-11', 7800000, 'A family drama in Tamil Nadu.', 'https://example.com/images/tamil_family.jpg', 'Heart of Chennai', 'UA'),
(5, '2025-05-02', '2025-05-13', 8400000, 'Mystery thriller from Karnataka.', 'https://example.com/images/kannada_mystery.jpg', 'Bengaluru Shadows', 'UA'),
(6, '2025-04-29', '2025-05-10', 6000000, 'Light-hearted comedy from Hyderabad.', 'https://example.com/images/hyderabad_fun.jpg', 'Hyderabad Hues', 'U'),
(7, '2025-05-04', '2025-05-14', 7200000, 'Bollywood drama with social message.', 'https://example.com/images/bollywood_drama.jpg', 'Voices of Mumbai', 'UA'),
(8, '2025-05-03', '2025-05-13', 7500000, 'Epic historical Tamil movie.', 'https://example.com/images/tamil_epic.jpg', 'Tamil Warriors', 'A'),
(9, '2025-04-27', '2025-05-09', 6900000, 'Romantic Hindi film.', 'https://example.com/images/hindi_romance.jpg', 'Monsoon Love', 'U'),
(10, '2025-05-06', '2025-05-15', 7800000, 'Telugu sci-fi adventure.', 'https://example.com/images/telugu_sci_fi.jpg', 'Galaxy Quest', 'UA');

-- cast
INSERT INTO cast (id, created_at, last_modified_at, description, name, cast_type) VALUES
(1, '2025-01-01', '2025-05-01', 'Lead Actor in Mumbai Chronicles', 'Raj Malhotra', 'ACTOR'),
(2, '2025-01-02', '2025-05-02', 'Director of Mumbai Chronicles', 'Anil Kapoor', 'DIRECTOR'),
(3, '2025-01-03', '2025-05-03', 'Lead Actress in Delhi Diaries', 'Pooja Sharma', 'ACTOR'),
(4, '2025-01-04', '2025-05-04', 'Director of Delhi Diaries', 'Karan Johar', 'DIRECTOR'),
(5, '2025-01-05', '2025-05-05', 'Telugu Actor in Thunder Telugu', 'Chiranjeevi', 'ACTOR'),
(6, '2025-01-06', '2025-05-06', 'Director of Thunder Telugu', 'SS Rajamouli', 'DIRECTOR'),
(7, '2025-01-07', '2025-05-07', 'Actor in Heart of Chennai', 'Vijay', 'ACTOR'),
(8, '2025-01-08', '2025-05-08', 'Director of Heart of Chennai', 'Mani Ratnam', 'DIRECTOR'),
(9, '2025-01-09', '2025-05-09', 'Actor in Bengaluru Shadows', 'Ravi Teja', 'ACTOR'),
(10, '2025-01-10', '2025-05-10', 'Director of Bengaluru Shadows', 'Ramesh Aravind', 'DIRECTOR'),
(11, '2025-01-11', '2025-05-11', 'Actor in Hyderabad Hues', 'Nani', 'ACTOR'),
(12, '2025-01-12', '2025-05-12', 'Director of Hyderabad Hues', 'Trivikram Srinivas', 'DIRECTOR'),
(13, '2025-01-13', '2025-05-13', 'Actor in Voices of Mumbai', 'Ayushmann Khurrana', 'ACTOR'),
(14, '2025-01-14', '2025-05-14', 'Director of Voices of Mumbai', 'Zoya Akhtar', 'DIRECTOR'),
(15, '2025-01-15', '2025-05-15', 'Actor in Tamil Warriors', 'Suriya', 'ACTOR'),
(16, '2025-01-16', '2025-05-16', 'Director of Tamil Warriors', 'Shankar', 'DIRECTOR'),
(17, '2025-01-17', '2025-05-17', 'Actor in Monsoon Love', 'Ranbir Kapoor', 'ACTOR'),
(18, '2025-01-18', '2025-05-18', 'Director of Monsoon Love', 'Imtiaz Ali', 'DIRECTOR'),
(19, '2025-01-19', '2025-05-19', 'Actor in Galaxy Quest', 'Mahesh Babu', 'ACTOR'),
(20, '2025-01-20', '2025-05-20', 'Director of Galaxy Quest', 'Puri Jagannadh', 'DIRECTOR');

-- movie_cast
-- Mumbai Chronicles
INSERT INTO movie_cast (cast_id, movie_id) VALUES (1, 1), (2, 1);

-- Delhi Diaries
INSERT INTO movie_cast (cast_id, movie_id) VALUES (3, 2), (4, 2);

-- Thunder Telugu
INSERT INTO movie_cast (cast_id, movie_id) VALUES (5, 3), (6, 3);

-- Heart of Chennai
INSERT INTO movie_cast (cast_id, movie_id) VALUES (7, 4), (8, 4);

-- Bengaluru Shadows
INSERT INTO movie_cast (cast_id, movie_id) VALUES (9, 5), (10, 5);

-- Hyderabad Hues
INSERT INTO movie_cast (cast_id, movie_id) VALUES (11, 6), (12, 6);

-- Voices of Mumbai
INSERT INTO movie_cast (cast_id, movie_id) VALUES (13, 7), (14, 7);

-- Tamil Warriors
INSERT INTO movie_cast (cast_id, movie_id) VALUES (15, 8), (16, 8);

-- Monsoon Love
INSERT INTO movie_cast (cast_id, movie_id) VALUES (17, 9), (18, 9);

-- Galaxy Quest
INSERT INTO movie_cast (cast_id, movie_id) VALUES (19, 10), (20, 10);

-- movie feature
INSERT INTO movie_features (movie_id, features) VALUES
(1, 'DOLBY_ATMOS'),
(2, 'TWO_D'),
(3, 'THREE_D'),
(4, 'DOLBY_ATMOS'),
(5, 'TWO_D'),
(6, 'THREE_D'),
(7, 'DOLBY_ATMOS'),
(8, 'THREE_D'),
(9, 'TWO_D'),
(10, 'DOLBY_ATMOS');

-- movie languages

INSERT INTO movie_languages (movie_id, languages) VALUES
(1, 'HINDI'),
(2, 'HINDI'),
(3, 'TELEGU'),
(4, 'TAMIL'),
(5, 'HINDI'),
(5, 'ENGLISH'),
(6, 'TELEGU'),
(7, 'HINDI'),
(8, 'TAMIL'),
(9, 'HINDI'),
(10, 'TELEGU');

