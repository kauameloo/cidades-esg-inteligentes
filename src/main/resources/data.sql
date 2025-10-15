-- Dados iniciais para teste
-- Fixed column name from indice_esg to indice_ESG to match JPA naming
INSERT INTO cidades (nome, estado, populacao, indice_ESG, iniciativas_sustentaveis) VALUES 
('São Paulo', 'SP', 12000000, 8.5, 'Energia solar em prédios públicos, transporte público elétrico'),
('Curitiba', 'PR', 1900000, 9.2, 'Reciclagem avançada, parques urbanos, BRT sustentável'),
('Florianópolis', 'SC', 500000, 8.8, 'Preservação ambiental, energia eólica, ciclovias'),
('Brasília', 'DF', 3000000, 7.5, 'Arquitetura sustentável, gestão de resíduos'),
('Recife', 'PE', 1600000, 7.8, 'Energia solar, revitalização urbana');
