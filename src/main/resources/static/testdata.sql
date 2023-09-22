INSERT INTO category (title, description)
VALUES ('Elektronika', 'i jej opis'),
       ('Drewno','opis');
INSERT INTO offer (title, description, img_url, price, category_id)
VALUES ('Telewizor', 'Super telewizor o przekątnej 55 cali', 'https://d-art.ppstatic.pl/kadry/k/r/1/36/27/632ac9b5c7a19_o_large.jpg', 1299, 1),
       ('Kino domowe','Wypasione kino domowe firmy Sony, gra tak, że można robić festyn','https://atmosferadzwieku.com/userdata/public/gfx/8339/JBL-Stage-A190-A130-A135C-A100P-Zestaw-Kina-Domowe-Sklep-Atmosfera-Dzwieku-A.png',2500,1),
       ('Stół drewniany','Idealny stół drewniany dla rodziny, 6 krzeseł gratis','https://drewnianeklimaty.pl/wp-content/uploads/2022/09/STOL-TOPOLA-22x1x075h-gr-7cm-6-Copy.jpg',700,2);