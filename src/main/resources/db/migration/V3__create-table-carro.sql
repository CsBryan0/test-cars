CREATE TABLE carro(
    id INTEGER NOT NULL PRIMARY KEY IDENTITY,
    timestamp_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modelo_id INTEGER NOT NULL,
    ano INT NOT NULL,
    combustivel VARCHAR(255) NOT NULL,
    num_portas INT NOT NULL,
    cor VARCHAR(50) NOT NULL,
    FOREIGN KEY (modelo_id) REFERENCES modelo(id)
);