ALTER TABLE tb_despesa
    ADD data_atualizacao TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE tb_despesa
    ADD data_criacao TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE tb_despesa
    ALTER COLUMN valor_original TYPE DECIMAL USING (valor_original::DECIMAL);

ALTER TABLE tb_despesa
    ALTER COLUMN valor_total TYPE DECIMAL USING (valor_total::DECIMAL);